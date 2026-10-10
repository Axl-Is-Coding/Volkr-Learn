package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.base.t;
import com.google.common.base.u;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.grpc.NameResolver;
import io.grpc.ResolvedServerInfo;
import io.grpc.Status;
import io.grpc.TransportManager;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.TransportSet;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class ManagedChannelImpl extends ManagedChannel implements WithLogId {
    static final long IDLE_TIMEOUT_MILLIS_DISABLE = -1;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    private final Executor executor;
    private IdleModeTimer idleModeTimer;
    private ScheduledFuture<?> idleModeTimerFuture;
    private final long idleTimeoutMillis;
    private final Channel interceptorChannel;
    private LoadBalancer<ClientTransport> loadBalancer;
    private final LoadBalancer.Factory loadBalancerFactory;
    private NameResolver nameResolver;
    private final NameResolver.Factory nameResolverFactory;
    private final Attributes nameResolverParams;
    private ScheduledExecutorService scheduledExecutor;
    private boolean shutdown;
    private boolean shutdownNowed;
    private final u<t> stopwatchSupplier;
    private final String target;
    private boolean terminated;
    private final SharedResourceHolder.Resource<ScheduledExecutorService> timerService;
    private final ClientTransportFactory transportFactory;
    private final String userAgent;
    private final boolean usingSharedExecutor;
    private static final Logger log = Logger.getLogger(ManagedChannelImpl.class.getName());
    static final Pattern URI_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
    private static final ClientTransport SHUTDOWN_TRANSPORT = new FailingClientTransport(Status.UNAVAILABLE.withDescription("Channel is shutdown"));
    static final ClientTransport IDLE_MODE_TRANSPORT = new FailingClientTransport(Status.INTERNAL.withDescription("Channel is in idle mode"));
    private final Object lock = new Object();
    private final Map<EquivalentAddressGroup, TransportSet> transports = new HashMap();
    private final HashSet<TransportSet> decommissionedTransports = new HashSet<>();
    private final HashSet<DelayedClientTransport> delayedTransports = new HashSet<>();
    final InUseStateAggregator<Object> inUseStateAggregator = new InUseStateAggregator<Object>() { // from class: io.grpc.internal.ManagedChannelImpl.1
        @Override // io.grpc.internal.InUseStateAggregator
        Object getLock() {
            return ManagedChannelImpl.this.lock;
        }

        @Override // io.grpc.internal.InUseStateAggregator
        void handleInUse() {
            ManagedChannelImpl.this.exitIdleMode();
        }

        @Override // io.grpc.internal.InUseStateAggregator
        void handleNotInUse() {
            if (ManagedChannelImpl.this.shutdown) {
                return;
            }
            ManagedChannelImpl.this.rescheduleIdleTimer();
        }
    };
    private final HashSet<OobTransportProviderImpl> oobTransports = new HashSet<>();
    private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider() { // from class: io.grpc.internal.ManagedChannelImpl.2
        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public ClientTransport get(CallOptions callOptions) {
            LoadBalancer<ClientTransport> loadBalancerExitIdleMode = ManagedChannelImpl.this.exitIdleMode();
            return loadBalancerExitIdleMode == null ? ManagedChannelImpl.SHUTDOWN_TRANSPORT : loadBalancerExitIdleMode.pickTransport(callOptions.getAffinity());
        }
    };
    final TransportManager<ClientTransport> tm = new TransportManager<ClientTransport>() { // from class: io.grpc.internal.ManagedChannelImpl.3
        @Override // io.grpc.TransportManager
        public TransportManager.InterimTransport<ClientTransport> createInterimTransport() {
            return ManagedChannelImpl.this.new InterimTransportImpl();
        }

        @Override // io.grpc.TransportManager
        public TransportManager.OobTransportProvider<ClientTransport> createOobTransportProvider(EquivalentAddressGroup equivalentAddressGroup, String str) {
            return ManagedChannelImpl.this.new OobTransportProviderImpl(equivalentAddressGroup, str);
        }

        @Override // io.grpc.TransportManager
        public void updateRetainedTransports(Collection<EquivalentAddressGroup> collection) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.TransportManager
        public ClientTransport createFailingTransport(Status status) {
            return new FailingClientTransport(status);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.TransportManager
        public ClientTransport getTransport(final EquivalentAddressGroup equivalentAddressGroup) {
            m.a(equivalentAddressGroup, "addressGroup");
            synchronized (ManagedChannelImpl.this.lock) {
                if (ManagedChannelImpl.this.shutdown) {
                    return ManagedChannelImpl.SHUTDOWN_TRANSPORT;
                }
                if (ManagedChannelImpl.this.loadBalancer == null) {
                    return ManagedChannelImpl.IDLE_MODE_TRANSPORT;
                }
                TransportSet transportSet = (TransportSet) ManagedChannelImpl.this.transports.get(equivalentAddressGroup);
                if (transportSet == null) {
                    transportSet = new TransportSet(equivalentAddressGroup, ManagedChannelImpl.this.authority(), ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.loadBalancer, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.scheduledExecutor, ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.executor, new TransportSet.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.3.1
                        @Override // io.grpc.internal.TransportSet.Callback
                        public void onAllAddressesFailed() {
                            ManagedChannelImpl.this.nameResolver.refresh();
                        }

                        @Override // io.grpc.internal.TransportSet.Callback
                        public void onConnectionClosedByServer(Status status) {
                            ManagedChannelImpl.this.nameResolver.refresh();
                        }

                        @Override // io.grpc.internal.TransportSet.Callback
                        public void onInUse(TransportSet transportSet2) {
                            ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(transportSet2, true);
                        }

                        @Override // io.grpc.internal.TransportSet.Callback
                        public void onNotInUse(TransportSet transportSet2) {
                            ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(transportSet2, false);
                        }

                        @Override // io.grpc.internal.TransportSet.Callback
                        public void onTerminated(TransportSet transportSet2) {
                            synchronized (ManagedChannelImpl.this.lock) {
                                ManagedChannelImpl.this.transports.remove(equivalentAddressGroup);
                                ManagedChannelImpl.this.decommissionedTransports.remove(transportSet2);
                                ManagedChannelImpl.this.maybeTerminateChannel();
                            }
                        }
                    });
                    if (ManagedChannelImpl.log.isLoggable(Level.FINE)) {
                        ManagedChannelImpl.log.log(Level.FINE, "[{0}] {1} created for {2}", new Object[]{ManagedChannelImpl.this.getLogId(), transportSet.getLogId(), equivalentAddressGroup});
                    }
                    ManagedChannelImpl.this.transports.put(equivalentAddressGroup, transportSet);
                }
                return transportSet.obtainActiveTransport();
            }
        }

        @Override // io.grpc.TransportManager
        public Channel makeChannel(ClientTransport clientTransport) {
            return new SingleTransportChannel(clientTransport, ManagedChannelImpl.this.executor, ManagedChannelImpl.this.scheduledExecutor, ManagedChannelImpl.this.authority());
        }
    };

    private class IdleModeTimer implements Runnable {
        boolean cancelled;

        private IdleModeTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            synchronized (ManagedChannelImpl.this.lock) {
                if (this.cancelled) {
                    return;
                }
                LoadBalancer loadBalancer = ManagedChannelImpl.this.loadBalancer;
                ManagedChannelImpl.this.loadBalancer = null;
                NameResolver nameResolver = ManagedChannelImpl.this.nameResolver;
                ManagedChannelImpl.this.nameResolver = ManagedChannelImpl.getNameResolver(ManagedChannelImpl.this.target, ManagedChannelImpl.this.nameResolverFactory, ManagedChannelImpl.this.nameResolverParams);
                arrayList.addAll(ManagedChannelImpl.this.transports.values());
                ManagedChannelImpl.this.transports.clear();
                ManagedChannelImpl.this.decommissionedTransports.addAll(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((TransportSet) it.next()).shutdown();
                }
                loadBalancer.shutdown();
                nameResolver.shutdown();
            }
        }
    }

    private class InterimTransportImpl implements TransportManager.InterimTransport<ClientTransport> {
        private boolean closed;
        private final DelayedClientTransport delayedTransport;

        InterimTransportImpl() {
            boolean z;
            this.delayedTransport = new DelayedClientTransport(ManagedChannelImpl.this.executor);
            this.delayedTransport.start(new ManagedClientTransport.Listener() { // from class: io.grpc.internal.ManagedChannelImpl.InterimTransportImpl.1
                @Override // io.grpc.internal.ManagedClientTransport.Listener
                public void transportInUse(boolean z2) {
                    InterimTransportImpl interimTransportImpl = InterimTransportImpl.this;
                    ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(interimTransportImpl.delayedTransport, z2);
                }

                @Override // io.grpc.internal.ManagedClientTransport.Listener
                public void transportReady() {
                }

                @Override // io.grpc.internal.ManagedClientTransport.Listener
                public void transportShutdown(Status status) {
                }

                @Override // io.grpc.internal.ManagedClientTransport.Listener
                public void transportTerminated() {
                    synchronized (ManagedChannelImpl.this.lock) {
                        ManagedChannelImpl.this.delayedTransports.remove(InterimTransportImpl.this.delayedTransport);
                        ManagedChannelImpl.this.maybeTerminateChannel();
                    }
                    InterimTransportImpl interimTransportImpl = InterimTransportImpl.this;
                    ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(interimTransportImpl.delayedTransport, false);
                }
            });
            synchronized (ManagedChannelImpl.this.lock) {
                ManagedChannelImpl.this.delayedTransports.add(this.delayedTransport);
                z = ManagedChannelImpl.this.shutdown;
            }
            if (z) {
                this.delayedTransport.setTransport(ManagedChannelImpl.SHUTDOWN_TRANSPORT);
                this.delayedTransport.shutdown();
            }
        }

        @Override // io.grpc.TransportManager.InterimTransport
        public void closeWithError(Status status) {
            this.delayedTransport.shutdownNow(status);
        }

        @Override // io.grpc.TransportManager.InterimTransport
        public void closeWithRealTransports(u<ClientTransport> uVar) {
            this.delayedTransport.setTransportSupplier(uVar);
            this.delayedTransport.shutdown();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.TransportManager.InterimTransport
        public ClientTransport transport() {
            m.b(!this.closed, "already closed");
            return this.delayedTransport;
        }
    }

    private class NameResolverListenerImpl implements NameResolver.Listener {
        final LoadBalancer<ClientTransport> balancer;

        NameResolverListenerImpl(LoadBalancer<ClientTransport> loadBalancer) {
            this.balancer = loadBalancer;
        }

        @Override // io.grpc.NameResolver.Listener
        public void onError(Status status) {
            m.a(!status.isOk(), "the error status must not be OK");
            this.balancer.handleNameResolutionError(status);
        }

        @Override // io.grpc.NameResolver.Listener
        public void onUpdate(List<? extends List<ResolvedServerInfo>> list, Attributes attributes) {
            if (ManagedChannelImpl.serversAreEmpty(list)) {
                onError(Status.UNAVAILABLE.withDescription("NameResolver returned an empty list"));
                return;
            }
            try {
                this.balancer.handleResolvedAddresses(list, attributes);
            } catch (Throwable th) {
                this.balancer.handleNameResolutionError(Status.INTERNAL.withCause(th).withDescription("Thrown from handleResolvedAddresses(): " + th));
            }
        }
    }

    private class OobTransportProviderImpl implements TransportManager.OobTransportProvider<ClientTransport> {
        private final ClientTransport transport;
        private final TransportSet transportSet;

        OobTransportProviderImpl(EquivalentAddressGroup equivalentAddressGroup, String str) {
            synchronized (ManagedChannelImpl.this.lock) {
                if (ManagedChannelImpl.this.shutdown) {
                    this.transportSet = null;
                    this.transport = ManagedChannelImpl.SHUTDOWN_TRANSPORT;
                } else if (ManagedChannelImpl.this.loadBalancer == null) {
                    this.transportSet = null;
                    this.transport = ManagedChannelImpl.IDLE_MODE_TRANSPORT;
                } else {
                    this.transport = null;
                    this.transportSet = new TransportSet(equivalentAddressGroup, str, ManagedChannelImpl.this.userAgent, ManagedChannelImpl.this.loadBalancer, ManagedChannelImpl.this.backoffPolicyProvider, ManagedChannelImpl.this.transportFactory, ManagedChannelImpl.this.scheduledExecutor, ManagedChannelImpl.this.stopwatchSupplier, ManagedChannelImpl.this.executor, new TransportSet.Callback() { // from class: io.grpc.internal.ManagedChannelImpl.OobTransportProviderImpl.1
                        @Override // io.grpc.internal.TransportSet.Callback
                        public void onTerminated(TransportSet transportSet) {
                            synchronized (ManagedChannelImpl.this.lock) {
                                ManagedChannelImpl.this.oobTransports.remove(OobTransportProviderImpl.this);
                                ManagedChannelImpl.this.maybeTerminateChannel();
                            }
                        }
                    });
                    ManagedChannelImpl.this.oobTransports.add(this);
                }
            }
        }

        @Override // io.grpc.TransportManager.OobTransportProvider
        public void close() {
            TransportSet transportSet = this.transportSet;
            if (transportSet != null) {
                transportSet.shutdown();
            }
        }

        void shutdownNow(Status status) {
            TransportSet transportSet = this.transportSet;
            if (transportSet != null) {
                transportSet.shutdownNow(status);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.TransportManager.OobTransportProvider
        public ClientTransport get() {
            ClientTransport clientTransport = this.transport;
            return clientTransport != null ? clientTransport : this.transportSet.obtainActiveTransport();
        }
    }

    private class RealChannel extends Channel {
        private RealChannel() {
        }

        @Override // io.grpc.Channel
        public String authority() {
            String serviceAuthority = ManagedChannelImpl.this.nameResolver.getServiceAuthority();
            m.a(serviceAuthority, "authority");
            return serviceAuthority;
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            Executor executor = callOptions.getExecutor();
            if (executor == null) {
                executor = ManagedChannelImpl.this.executor;
            }
            return new ClientCallImpl(methodDescriptor, executor, callOptions, ManagedChannelImpl.this.transportProvider, ManagedChannelImpl.this.scheduledExecutor).setDecompressorRegistry(ManagedChannelImpl.this.decompressorRegistry).setCompressorRegistry(ManagedChannelImpl.this.compressorRegistry);
        }
    }

    ManagedChannelImpl(String str, BackoffPolicy.Provider provider, NameResolver.Factory factory, Attributes attributes, LoadBalancer.Factory factory2, ClientTransportFactory clientTransportFactory, DecompressorRegistry decompressorRegistry, CompressorRegistry compressorRegistry, SharedResourceHolder.Resource<ScheduledExecutorService> resource, u<t> uVar, long j, Executor executor, String str2, List<ClientInterceptor> list) {
        m.a(str, "target");
        this.target = str;
        m.a(factory, "nameResolverFactory");
        this.nameResolverFactory = factory;
        m.a(attributes, "nameResolverParams");
        this.nameResolverParams = attributes;
        this.nameResolver = getNameResolver(str, factory, attributes);
        m.a(factory2, "loadBalancerFactory");
        this.loadBalancerFactory = factory2;
        if (executor == null) {
            this.usingSharedExecutor = true;
            this.executor = (Executor) SharedResourceHolder.get(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
        } else {
            this.usingSharedExecutor = false;
            this.executor = executor;
        }
        this.backoffPolicyProvider = provider;
        this.transportFactory = new CallCredentialsApplyingTransportFactory(clientTransportFactory, this.executor);
        this.interceptorChannel = ClientInterceptors.intercept(new RealChannel(), list);
        this.timerService = resource;
        this.scheduledExecutor = (ScheduledExecutorService) SharedResourceHolder.get(resource);
        m.a(uVar, "stopwatchSupplier");
        this.stopwatchSupplier = uVar;
        m.a(j > 0 || j == -1, "invalid idleTimeoutMillis %s", Long.valueOf(j));
        this.idleTimeoutMillis = j;
        this.decompressorRegistry = decompressorRegistry;
        this.compressorRegistry = compressorRegistry;
        this.userAgent = str2;
        if (log.isLoggable(Level.INFO)) {
            log.log(Level.INFO, "[{0}] Created with target {1}", new Object[]{getLogId(), str});
        }
    }

    private void cancelIdleTimer() {
        ScheduledFuture<?> scheduledFuture = this.idleModeTimerFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.idleModeTimer.cancelled = true;
            this.idleModeTimerFuture = null;
            this.idleModeTimer = null;
        }
    }

    static NameResolver getNameResolver(String str, NameResolver.Factory factory, Attributes attributes) {
        URI uri;
        NameResolver nameResolverNewNameResolver;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e2) {
            sb.append(e2.getMessage());
            uri = null;
        }
        if (uri != null && (nameResolverNewNameResolver = factory.newNameResolver(uri, attributes)) != null) {
            return nameResolverNewNameResolver;
        }
        String str2 = "";
        if (!URI_PATTERN.matcher(str).matches()) {
            try {
                NameResolver nameResolverNewNameResolver2 = factory.newNameResolver(new URI(factory.getDefaultScheme(), "", "/" + str, null), attributes);
                if (nameResolverNewNameResolver2 != null) {
                    return nameResolverNewNameResolver2;
                }
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        }
        objArr[1] = str2;
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeTerminateChannel() {
        if (!this.terminated && this.shutdown && this.transports.isEmpty() && this.decommissionedTransports.isEmpty() && this.delayedTransports.isEmpty() && this.oobTransports.isEmpty()) {
            if (log.isLoggable(Level.INFO)) {
                log.log(Level.INFO, "[{0}] Terminated", getLogId());
            }
            this.terminated = true;
            this.lock.notifyAll();
            if (this.usingSharedExecutor) {
                SharedResourceHolder.release(GrpcUtil.SHARED_CHANNEL_EXECUTOR, (ExecutorService) this.executor);
            }
            this.transportFactory.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rescheduleIdleTimer() {
        if (this.idleTimeoutMillis == -1) {
            return;
        }
        cancelIdleTimer();
        this.idleModeTimer = new IdleModeTimer();
        this.idleModeTimerFuture = this.scheduledExecutor.schedule(new LogExceptionRunnable(this.idleModeTimer), this.idleTimeoutMillis, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean serversAreEmpty(List<? extends List<ResolvedServerInfo>> list) {
        Iterator<? extends List<ResolvedServerInfo>> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.interceptorChannel.authority();
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        synchronized (this.lock) {
            long jNanoTime = System.nanoTime() + timeUnit.toNanos(j);
            while (!this.terminated) {
                long jNanoTime2 = jNanoTime - System.nanoTime();
                if (jNanoTime2 <= 0) {
                    break;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, jNanoTime2);
            }
            z = this.terminated;
        }
        return z;
    }

    LoadBalancer<ClientTransport> exitIdleMode() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return null;
            }
            if (this.inUseStateAggregator.isInUse()) {
                cancelIdleTimer();
            } else {
                rescheduleIdleTimer();
            }
            if (this.loadBalancer != null) {
                return this.loadBalancer;
            }
            final LoadBalancer<ClientTransport> loadBalancerNewLoadBalancer = this.loadBalancerFactory.newLoadBalancer(this.nameResolver.getServiceAuthority(), this.tm);
            this.loadBalancer = loadBalancerNewLoadBalancer;
            final NameResolver nameResolver = this.nameResolver;
            this.scheduledExecutor.execute(new Runnable() { // from class: io.grpc.internal.ManagedChannelImpl.1NameResolverStartTask
                @Override // java.lang.Runnable
                public void run() {
                    nameResolver.start(ManagedChannelImpl.this.new NameResolverListenerImpl(loadBalancerNewLoadBalancer));
                }
            });
            return loadBalancerNewLoadBalancer;
        }
    }

    @Override // io.grpc.internal.WithLogId
    public String getLogId() {
        return GrpcUtil.getLogId(this);
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown;
        }
        return z;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        boolean z;
        synchronized (this.lock) {
            z = this.terminated;
        }
        return z;
    }

    @Override // io.grpc.Channel
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
        return this.interceptorChannel.newCall(methodDescriptor, callOptions);
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdown() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        synchronized (this.lock) {
            if (this.shutdown) {
                return this;
            }
            this.shutdown = true;
            this.scheduledExecutor = (ScheduledExecutorService) SharedResourceHolder.release(this.timerService, this.scheduledExecutor);
            maybeTerminateChannel();
            if (!this.terminated) {
                arrayList.addAll(this.transports.values());
                arrayList2.addAll(this.delayedTransports);
                arrayList3.addAll(this.oobTransports);
            }
            LoadBalancer<ClientTransport> loadBalancer = this.loadBalancer;
            NameResolver nameResolver = this.nameResolver;
            cancelIdleTimer();
            if (loadBalancer != null) {
                loadBalancer.shutdown();
            }
            nameResolver.shutdown();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TransportSet) it.next()).shutdown();
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((DelayedClientTransport) it2.next()).shutdown();
            }
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ((OobTransportProviderImpl) it3.next()).close();
            }
            if (log.isLoggable(Level.FINE)) {
                log.log(Level.FINE, "[{0}] Shutting down", getLogId());
            }
            return this;
        }
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannelImpl shutdownNow() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        synchronized (this.lock) {
            if (this.shutdownNowed) {
                return this;
            }
            this.shutdownNowed = true;
            shutdown();
            synchronized (this.lock) {
                arrayList = new ArrayList(this.transports.values());
                arrayList2 = new ArrayList(this.delayedTransports);
                arrayList3 = new ArrayList(this.oobTransports);
            }
            if (log.isLoggable(Level.FINE)) {
                log.log(Level.FINE, "[{0}] Shutting down now", getLogId());
            }
            Status statusWithDescription = Status.UNAVAILABLE.withDescription("Channel shutdownNow invoked");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TransportSet) it.next()).shutdownNow(statusWithDescription);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((DelayedClientTransport) it2.next()).shutdownNow(statusWithDescription);
            }
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ((OobTransportProviderImpl) it3.next()).shutdownNow(statusWithDescription);
            }
            return this;
        }
    }
}
