package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.base.t;
import com.google.common.base.u;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import io.grpc.internal.BackoffPolicy;
import io.grpc.internal.ManagedClientTransport;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
final class TransportSet implements WithLogId {
    private volatile ManagedClientTransport activeTransport;
    private final EquivalentAddressGroup addressGroup;
    private final Executor appExecutor;
    private final String authority;
    private final BackoffPolicy.Provider backoffPolicyProvider;
    private final Callback callback;
    private final t connectingTimer;
    private final LoadBalancer<ClientTransport> loadBalancer;
    private int nextAddressIndex;
    private ConnectionClientTransport pendingTransport;
    private BackoffPolicy reconnectPolicy;
    private ScheduledFuture<?> reconnectTask;
    private final ScheduledExecutorService scheduledExecutor;
    private boolean shutdown;
    private final ClientTransportFactory transportFactory;
    private final String userAgent;
    private static final Logger log = Logger.getLogger(TransportSet.class.getName());
    private static final ClientTransport SHUTDOWN_TRANSPORT = new FailingClientTransport(Status.UNAVAILABLE.withDescription("TransportSet is shutdown"));
    private final Object lock = new Object();
    private final Collection<ManagedClientTransport> transports = new ArrayList();
    private final InUseStateAggregator<ManagedClientTransport> inUseStateAggregator = new InUseStateAggregator<ManagedClientTransport>() { // from class: io.grpc.internal.TransportSet.1
        @Override // io.grpc.internal.InUseStateAggregator
        Object getLock() {
            return TransportSet.this.lock;
        }

        @Override // io.grpc.internal.InUseStateAggregator
        void handleInUse() {
            TransportSet.this.callback.onInUse(TransportSet.this);
        }

        @Override // io.grpc.internal.InUseStateAggregator
        void handleNotInUse() {
            TransportSet.this.callback.onNotInUse(TransportSet.this);
        }
    };

    private class BaseTransportListener implements ManagedClientTransport.Listener {
        protected final ManagedClientTransport transport;

        public BaseTransportListener(ManagedClientTransport managedClientTransport) {
            this.transport = managedClientTransport;
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportInUse(boolean z) {
            TransportSet.this.inUseStateAggregator.updateObjectInUse(this.transport, z);
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(Status status) {
        }

        @Override // io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            boolean z = false;
            TransportSet.this.inUseStateAggregator.updateObjectInUse(this.transport, false);
            synchronized (TransportSet.this.lock) {
                TransportSet.this.transports.remove(this.transport);
                if (TransportSet.this.shutdown && TransportSet.this.transports.isEmpty()) {
                    if (TransportSet.log.isLoggable(Level.FINE)) {
                        TransportSet.log.log(Level.FINE, "[{0}] Terminated", TransportSet.this.getLogId());
                    }
                    z = true;
                    TransportSet.this.cancelReconnectTask();
                }
            }
            if (z) {
                TransportSet.this.callback.onTerminated(TransportSet.this);
            }
        }
    }

    static abstract class Callback {
        Callback() {
        }

        public void onAllAddressesFailed() {
        }

        public void onConnectionClosedByServer(Status status) {
        }

        public void onInUse(TransportSet transportSet) {
        }

        public void onNotInUse(TransportSet transportSet) {
        }

        public void onTerminated(TransportSet transportSet) {
        }
    }

    private class TransportListener extends BaseTransportListener {
        private final SocketAddress address;
        private final DelayedClientTransport delayedTransport;

        public TransportListener(ManagedClientTransport managedClientTransport, DelayedClientTransport delayedClientTransport, SocketAddress socketAddress) {
            super(managedClientTransport);
            this.address = socketAddress;
            this.delayedTransport = delayedClientTransport;
        }

        @Override // io.grpc.internal.TransportSet.BaseTransportListener, io.grpc.internal.ManagedClientTransport.Listener
        public void transportReady() {
            boolean z;
            boolean z2 = true;
            if (TransportSet.log.isLoggable(Level.FINE)) {
                TransportSet.log.log(Level.FINE, "[{0}] {1} for {2} is ready", new Object[]{TransportSet.this.getLogId(), this.transport.getLogId(), this.address});
            }
            super.transportReady();
            synchronized (TransportSet.this.lock) {
                z = TransportSet.this.shutdown;
                TransportSet.this.reconnectPolicy = null;
                TransportSet.this.nextAddressIndex = 0;
                if (TransportSet.this.shutdown) {
                    if (TransportSet.this.activeTransport != null) {
                        z2 = false;
                    }
                    m.b(z2, "Unexpected non-null activeTransport");
                } else if (TransportSet.this.activeTransport == this.delayedTransport) {
                    if (TransportSet.this.pendingTransport != this.transport) {
                        z2 = false;
                    }
                    m.b(z2, "transport mismatch");
                    TransportSet.this.activeTransport = this.transport;
                    TransportSet.this.pendingTransport = null;
                }
            }
            this.delayedTransport.setTransport(this.transport);
            this.delayedTransport.shutdown();
            if (z) {
                this.transport.shutdown();
            }
            TransportSet.this.loadBalancer.handleTransportReady(TransportSet.this.addressGroup);
        }

        @Override // io.grpc.internal.TransportSet.BaseTransportListener, io.grpc.internal.ManagedClientTransport.Listener
        public void transportShutdown(Status status) {
            Runnable runnableScheduleBackoff;
            boolean z;
            boolean z2 = false;
            if (TransportSet.log.isLoggable(Level.FINE)) {
                TransportSet.log.log(Level.FINE, "[{0}] {1} for {2} is being shutdown with status {3}", new Object[]{TransportSet.this.getLogId(), this.transport.getLogId(), this.address, status});
            }
            super.transportShutdown(status);
            synchronized (TransportSet.this.lock) {
                runnableScheduleBackoff = null;
                if (TransportSet.this.activeTransport != this.transport) {
                    if (TransportSet.this.activeTransport != this.delayedTransport) {
                        z = false;
                    } else if (TransportSet.this.nextAddressIndex == 0) {
                        runnableScheduleBackoff = TransportSet.this.scheduleBackoff(this.delayedTransport, status);
                        z = false;
                        z2 = true;
                    } else {
                        TransportSet.this.startNewTransport(this.delayedTransport);
                        z = false;
                    }
                }
                TransportSet.this.activeTransport = null;
                z = true ^ TransportSet.this.shutdown;
            }
            if (runnableScheduleBackoff != null) {
                runnableScheduleBackoff.run();
            }
            TransportSet.this.loadBalancer.handleTransportShutdown(TransportSet.this.addressGroup, status);
            if (z2) {
                TransportSet.this.callback.onAllAddressesFailed();
            }
            if (z) {
                TransportSet.this.callback.onConnectionClosedByServer(status);
            }
        }

        @Override // io.grpc.internal.TransportSet.BaseTransportListener, io.grpc.internal.ManagedClientTransport.Listener
        public void transportTerminated() {
            if (TransportSet.log.isLoggable(Level.FINE)) {
                TransportSet.log.log(Level.FINE, "[{0}] {1} for {2} is terminated", new Object[]{TransportSet.this.getLogId(), this.transport.getLogId(), this.address});
            }
            super.transportTerminated();
            m.b(TransportSet.this.activeTransport != this.transport, "activeTransport still points to the delayedTransport. Seems transportShutdown() was not called.");
        }
    }

    TransportSet(EquivalentAddressGroup equivalentAddressGroup, String str, String str2, LoadBalancer<ClientTransport> loadBalancer, BackoffPolicy.Provider provider, ClientTransportFactory clientTransportFactory, ScheduledExecutorService scheduledExecutorService, u<t> uVar, Executor executor, Callback callback) {
        m.a(equivalentAddressGroup, "addressGroup");
        this.addressGroup = equivalentAddressGroup;
        this.authority = str;
        this.userAgent = str2;
        this.loadBalancer = loadBalancer;
        this.backoffPolicyProvider = provider;
        this.transportFactory = clientTransportFactory;
        this.scheduledExecutor = scheduledExecutorService;
        this.connectingTimer = uVar.get();
        this.appExecutor = executor;
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelReconnectTask() {
        ScheduledFuture<?> scheduledFuture = this.reconnectTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.reconnectTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable scheduleBackoff(final DelayedClientTransport delayedClientTransport, final Status status) {
        m.b(this.reconnectTask == null, "previous reconnectTask is not done");
        if (this.reconnectPolicy == null) {
            this.reconnectPolicy = this.backoffPolicyProvider.get();
        }
        long jNextBackoffMillis = this.reconnectPolicy.nextBackoffMillis() - this.connectingTimer.a(TimeUnit.MILLISECONDS);
        if (log.isLoggable(Level.FINE)) {
            log.log(Level.FINE, "[{0}] Scheduling backoff for {1} ms", new Object[]{getLogId(), Long.valueOf(jNextBackoffMillis)});
        }
        this.reconnectTask = this.scheduledExecutor.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.TransportSet.1EndOfCurrentBackoff
            @Override // java.lang.Runnable
            public void run() {
                try {
                    delayedClientTransport.endBackoff();
                    boolean z = false;
                    synchronized (TransportSet.this.lock) {
                        TransportSet.this.reconnectTask = null;
                        if (delayedClientTransport.hasPendingStreams()) {
                            TransportSet.this.startNewTransport(delayedClientTransport);
                        } else {
                            TransportSet.this.activeTransport = null;
                            z = true;
                        }
                    }
                    if (z) {
                        delayedClientTransport.setTransportSupplier(new u<ClientTransport>() { // from class: io.grpc.internal.TransportSet.1EndOfCurrentBackoff.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.google.common.base.u
                            public ClientTransport get() {
                                return TransportSet.this.obtainActiveTransport();
                            }
                        });
                        delayedClientTransport.shutdown();
                    }
                } catch (Throwable th) {
                    TransportSet.log.log(Level.WARNING, "Exception handling end of backoff", th);
                }
            }
        }), jNextBackoffMillis, TimeUnit.MILLISECONDS);
        return new Runnable() { // from class: io.grpc.internal.TransportSet.2
            @Override // java.lang.Runnable
            public void run() {
                delayedClientTransport.startBackoff(status);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNewTransport(DelayedClientTransport delayedClientTransport) {
        m.b(this.reconnectTask == null, "Should have no reconnectTask scheduled");
        if (this.nextAddressIndex == 0) {
            t tVar = this.connectingTimer;
            tVar.b();
            tVar.c();
        }
        List<SocketAddress> addresses = this.addressGroup.getAddresses();
        int i = this.nextAddressIndex;
        this.nextAddressIndex = i + 1;
        SocketAddress socketAddress = addresses.get(i);
        if (this.nextAddressIndex >= addresses.size()) {
            this.nextAddressIndex = 0;
        }
        ConnectionClientTransport connectionClientTransportNewClientTransport = this.transportFactory.newClientTransport(socketAddress, this.authority, this.userAgent);
        if (log.isLoggable(Level.FINE)) {
            log.log(Level.FINE, "[{0}] Created {1} for {2}", new Object[]{getLogId(), connectionClientTransportNewClientTransport.getLogId(), socketAddress});
        }
        this.pendingTransport = connectionClientTransportNewClientTransport;
        this.transports.add(connectionClientTransportNewClientTransport);
        connectionClientTransportNewClientTransport.start(new TransportListener(connectionClientTransportNewClientTransport, delayedClientTransport, socketAddress));
    }

    @Override // io.grpc.internal.WithLogId
    public String getLogId() {
        return GrpcUtil.getLogId(this);
    }

    final ClientTransport obtainActiveTransport() {
        ManagedClientTransport managedClientTransport = this.activeTransport;
        if (managedClientTransport != null) {
            return managedClientTransport;
        }
        synchronized (this.lock) {
            if (this.activeTransport == null) {
                if (this.shutdown) {
                    return SHUTDOWN_TRANSPORT;
                }
                DelayedClientTransport delayedClientTransport = new DelayedClientTransport(this.appExecutor);
                this.transports.add(delayedClientTransport);
                delayedClientTransport.start(new BaseTransportListener(delayedClientTransport));
                this.activeTransport = delayedClientTransport;
                startNewTransport(delayedClientTransport);
            }
            return this.activeTransport;
        }
    }

    final void shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return;
            }
            boolean z = true;
            this.shutdown = true;
            ManagedClientTransport managedClientTransport = this.activeTransport;
            ConnectionClientTransport connectionClientTransport = this.pendingTransport;
            this.activeTransport = null;
            if (this.transports.isEmpty()) {
                m.b(this.reconnectTask == null, "Should have no reconnectTask scheduled");
            } else {
                z = false;
            }
            if (managedClientTransport != null) {
                managedClientTransport.shutdown();
            }
            if (connectionClientTransport != null) {
                connectionClientTransport.shutdown();
            }
            if (z) {
                this.callback.onTerminated(this);
            }
        }
    }

    void shutdownNow(Status status) {
        ArrayList arrayList;
        shutdown();
        synchronized (this.lock) {
            arrayList = new ArrayList(this.transports);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ManagedClientTransport) it.next()).shutdownNow(status);
        }
    }
}
