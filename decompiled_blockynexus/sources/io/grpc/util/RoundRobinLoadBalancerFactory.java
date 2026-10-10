package io.grpc.util;

import com.google.common.base.u;
import io.grpc.Attributes;
import io.grpc.LoadBalancer;
import io.grpc.ResolvedServerInfo;
import io.grpc.Status;
import io.grpc.TransportManager;
import io.grpc.internal.RoundRobinServerList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class RoundRobinLoadBalancerFactory extends LoadBalancer.Factory {
    private static final RoundRobinLoadBalancerFactory instance = new RoundRobinLoadBalancerFactory();

    private static class RoundRobinLoadBalancer<T> extends LoadBalancer<T> {
        private static final Status SHUTDOWN_STATUS = Status.UNAVAILABLE.augmentDescription("RoundRobinLoadBalancer has shut down");
        private RoundRobinServerList<T> addresses;
        private boolean closed;
        private TransportManager.InterimTransport<T> interimTransport;
        private final Object lock;
        private Status nameResolutionError;
        private final TransportManager<T> tm;

        @Override // io.grpc.LoadBalancer
        public void handleNameResolutionError(Status status) {
            synchronized (this.lock) {
                if (this.closed) {
                    return;
                }
                Status statusAugmentDescription = status.augmentDescription("Name resolution failed");
                TransportManager.InterimTransport<T> interimTransport = this.interimTransport;
                this.interimTransport = null;
                this.nameResolutionError = statusAugmentDescription;
                if (interimTransport != null) {
                    interimTransport.closeWithError(statusAugmentDescription);
                }
            }
        }

        @Override // io.grpc.LoadBalancer
        public void handleResolvedAddresses(List<? extends List<ResolvedServerInfo>> list, Attributes attributes) {
            synchronized (this.lock) {
                if (this.closed) {
                    return;
                }
                RoundRobinServerList.Builder builder = new RoundRobinServerList.Builder(this.tm);
                for (List<ResolvedServerInfo> list2 : list) {
                    if (!list2.isEmpty()) {
                        ArrayList arrayList = new ArrayList(list2.size());
                        Iterator<ResolvedServerInfo> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getAddress());
                        }
                        builder.addList(arrayList);
                    }
                }
                this.addresses = builder.build();
                final RoundRobinServerList<T> roundRobinServerList = this.addresses;
                this.nameResolutionError = null;
                TransportManager.InterimTransport<T> interimTransport = this.interimTransport;
                this.interimTransport = null;
                if (interimTransport != null) {
                    interimTransport.closeWithRealTransports(new u<T>() { // from class: io.grpc.util.RoundRobinLoadBalancerFactory.RoundRobinLoadBalancer.1
                        @Override // com.google.common.base.u
                        public T get() {
                            return (T) roundRobinServerList.getTransportForNextServer();
                        }
                    });
                }
            }
        }

        @Override // io.grpc.LoadBalancer
        public T pickTransport(Attributes attributes) {
            synchronized (this.lock) {
                if (this.closed) {
                    return this.tm.createFailingTransport(SHUTDOWN_STATUS);
                }
                if (this.addresses != null) {
                    return this.addresses.getTransportForNextServer();
                }
                if (this.nameResolutionError != null) {
                    return this.tm.createFailingTransport(this.nameResolutionError);
                }
                if (this.interimTransport == null) {
                    this.interimTransport = this.tm.createInterimTransport();
                }
                return this.interimTransport.transport();
            }
        }

        @Override // io.grpc.LoadBalancer
        public void shutdown() {
            synchronized (this.lock) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                TransportManager.InterimTransport<T> interimTransport = this.interimTransport;
                this.interimTransport = null;
                if (interimTransport != null) {
                    interimTransport.closeWithError(SHUTDOWN_STATUS);
                }
            }
        }

        private RoundRobinLoadBalancer(TransportManager<T> transportManager) {
            this.lock = new Object();
            this.tm = transportManager;
        }
    }

    private RoundRobinLoadBalancerFactory() {
    }

    public static RoundRobinLoadBalancerFactory getInstance() {
        return instance;
    }

    @Override // io.grpc.LoadBalancer.Factory
    public <T> LoadBalancer<T> newLoadBalancer(String str, TransportManager<T> transportManager) {
        return new RoundRobinLoadBalancer(transportManager);
    }
}
