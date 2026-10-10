package io.grpc;

import com.google.common.base.u;
import io.grpc.LoadBalancer;
import io.grpc.TransportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class DummyLoadBalancerFactory extends LoadBalancer.Factory {
    private static final DummyLoadBalancerFactory instance = new DummyLoadBalancerFactory();

    private static class DummyLoadBalancer<T> extends LoadBalancer<T> {
        private static final Status SHUTDOWN_STATUS = Status.UNAVAILABLE.augmentDescription("DummyLoadBalancer has shut down");
        private EquivalentAddressGroup addresses;
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
                ArrayList arrayList = new ArrayList();
                Iterator<? extends List<ResolvedServerInfo>> it = list.iterator();
                while (it.hasNext()) {
                    Iterator<ResolvedServerInfo> it2 = it.next().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next().getAddress());
                    }
                }
                final EquivalentAddressGroup equivalentAddressGroup = new EquivalentAddressGroup(arrayList);
                if (equivalentAddressGroup.equals(this.addresses)) {
                    return;
                }
                this.addresses = equivalentAddressGroup;
                this.nameResolutionError = null;
                TransportManager.InterimTransport<T> interimTransport = this.interimTransport;
                this.interimTransport = null;
                if (interimTransport != null) {
                    interimTransport.closeWithRealTransports(new u<T>() { // from class: io.grpc.DummyLoadBalancerFactory.DummyLoadBalancer.1
                        @Override // com.google.common.base.u
                        public T get() {
                            return (T) DummyLoadBalancer.this.tm.getTransport(equivalentAddressGroup);
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
                EquivalentAddressGroup equivalentAddressGroup = this.addresses;
                if (equivalentAddressGroup != null) {
                    return this.tm.getTransport(equivalentAddressGroup);
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

        private DummyLoadBalancer(TransportManager<T> transportManager) {
            this.lock = new Object();
            this.tm = transportManager;
        }
    }

    private DummyLoadBalancerFactory() {
    }

    public static DummyLoadBalancerFactory getInstance() {
        return instance;
    }

    @Override // io.grpc.LoadBalancer.Factory
    public <T> LoadBalancer<T> newLoadBalancer(String str, TransportManager<T> transportManager) {
        return new DummyLoadBalancer(transportManager);
    }
}
