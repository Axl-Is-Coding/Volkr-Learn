package io.grpc;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LoadBalancer<T> {

    public static abstract class Factory {
        public abstract <T> LoadBalancer<T> newLoadBalancer(String str, TransportManager<T> transportManager);
    }

    public void handleNameResolutionError(Status status) {
    }

    public void handleResolvedAddresses(List<? extends List<ResolvedServerInfo>> list, Attributes attributes) {
    }

    public void handleTransportReady(EquivalentAddressGroup equivalentAddressGroup) {
    }

    public void handleTransportShutdown(EquivalentAddressGroup equivalentAddressGroup, Status status) {
    }

    public abstract T pickTransport(Attributes attributes);

    public void shutdown() {
    }
}
