package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.m;
import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.ResolvedServerInfo;
import io.grpc.Status;
import io.grpc.internal.SharedResourceHolder;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class DnsNameResolver extends NameResolver {
    private final String authority;
    private ExecutorService executor;
    private final SharedResourceHolder.Resource<ExecutorService> executorResource;
    private final String host;
    private NameResolver.Listener listener;
    private final int port;
    private final Runnable resolutionRunnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DnsNameResolver.this) {
                if (DnsNameResolver.this.resolutionTask != null) {
                    DnsNameResolver.this.resolutionTask.cancel(false);
                    DnsNameResolver.this.resolutionTask = null;
                }
                if (DnsNameResolver.this.shutdown) {
                    return;
                }
                NameResolver.Listener listener = DnsNameResolver.this.listener;
                DnsNameResolver.this.resolving = true;
                try {
                    try {
                        InetAddress[] allByName = DnsNameResolver.this.getAllByName(DnsNameResolver.this.host);
                        ArrayList arrayList = new ArrayList(allByName.length);
                        for (InetAddress inetAddress : allByName) {
                            arrayList.add(new ResolvedServerInfo(new InetSocketAddress(inetAddress, DnsNameResolver.this.port), Attributes.EMPTY));
                        }
                        listener.onUpdate(Collections.singletonList(arrayList), Attributes.EMPTY);
                        synchronized (DnsNameResolver.this) {
                            DnsNameResolver.this.resolving = false;
                        }
                    } catch (UnknownHostException e2) {
                        synchronized (DnsNameResolver.this) {
                            if (DnsNameResolver.this.shutdown) {
                                synchronized (DnsNameResolver.this) {
                                    DnsNameResolver.this.resolving = false;
                                    return;
                                }
                            }
                            DnsNameResolver.this.resolutionTask = DnsNameResolver.this.timerService.schedule(new LogExceptionRunnable(DnsNameResolver.this.resolutionRunnableOnExecutor), 1L, TimeUnit.MINUTES);
                            listener.onError(Status.UNAVAILABLE.withCause(e2));
                            synchronized (DnsNameResolver.this) {
                                DnsNameResolver.this.resolving = false;
                            }
                        }
                    }
                } catch (Throwable th) {
                    synchronized (DnsNameResolver.this) {
                        DnsNameResolver.this.resolving = false;
                        throw th;
                    }
                }
            }
        }
    };
    private final Runnable resolutionRunnableOnExecutor = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DnsNameResolver.this) {
                if (!DnsNameResolver.this.shutdown) {
                    DnsNameResolver.this.executor.execute(DnsNameResolver.this.resolutionRunnable);
                }
            }
        }
    };
    private ScheduledFuture<?> resolutionTask;
    private boolean resolving;
    private boolean shutdown;
    private ScheduledExecutorService timerService;
    private final SharedResourceHolder.Resource<ScheduledExecutorService> timerServiceResource;

    DnsNameResolver(String str, String str2, Attributes attributes, SharedResourceHolder.Resource<ScheduledExecutorService> resource, SharedResourceHolder.Resource<ExecutorService> resource2) {
        this.timerServiceResource = resource;
        this.executorResource = resource2;
        URI uriCreate = URI.create("//" + str2);
        String authority = uriCreate.getAuthority();
        m.a(authority, "nameUri (%s) doesn't have an authority", uriCreate);
        this.authority = authority;
        String host = uriCreate.getHost();
        m.a(host, "host");
        this.host = host;
        if (uriCreate.getPort() != -1) {
            this.port = uriCreate.getPort();
            return;
        }
        Integer num = (Integer) attributes.get(NameResolver.Factory.PARAMS_DEFAULT_PORT);
        if (num != null) {
            this.port = num.intValue();
            return;
        }
        throw new IllegalArgumentException("name '" + str2 + "' doesn't contain a port, and default port is not set in params");
    }

    private void resolve() {
        if (this.resolving || this.shutdown) {
            return;
        }
        this.executor.execute(this.resolutionRunnable);
    }

    InetAddress[] getAllByName(String str) throws UnknownHostException {
        return InetAddress.getAllByName(str);
    }

    final int getPort() {
        return this.port;
    }

    @Override // io.grpc.NameResolver
    public final String getServiceAuthority() {
        return this.authority;
    }

    @Override // io.grpc.NameResolver
    public final synchronized void refresh() {
        m.b(this.listener != null, "not started");
        resolve();
    }

    @Override // io.grpc.NameResolver
    public final synchronized void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        if (this.resolutionTask != null) {
            this.resolutionTask.cancel(false);
        }
        if (this.timerService != null) {
            this.timerService = (ScheduledExecutorService) SharedResourceHolder.release(this.timerServiceResource, this.timerService);
        }
        if (this.executor != null) {
            this.executor = (ExecutorService) SharedResourceHolder.release(this.executorResource, this.executor);
        }
    }

    @Override // io.grpc.NameResolver
    public final synchronized void start(NameResolver.Listener listener) {
        m.b(this.listener == null, "already started");
        this.timerService = (ScheduledExecutorService) SharedResourceHolder.get(this.timerServiceResource);
        this.executor = (ExecutorService) SharedResourceHolder.get(this.executorResource);
        m.a(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener;
        resolve();
    }
}
