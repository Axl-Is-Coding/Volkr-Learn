package io.grpc.internal;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.V;
import io.grpc.EquivalentAddressGroup;
import io.grpc.Status;
import io.grpc.TransportManager;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RoundRobinServerList<T> {
    private final Iterator<EquivalentAddressGroup> cyclingIter;
    private final List<EquivalentAddressGroup> list;
    private final T requestDroppingTransport;
    private final TransportManager<T> tm;

    public static class Builder<T> {
        private final ImmutableList.a<EquivalentAddressGroup> listBuilder = ImmutableList.builder();
        private final TransportManager<T> tm;

        public Builder(TransportManager<T> transportManager) {
            this.tm = transportManager;
        }

        public void add(SocketAddress socketAddress) {
            this.listBuilder.a(new EquivalentAddressGroup(socketAddress));
        }

        public void addList(List<SocketAddress> list) {
            this.listBuilder.a(new EquivalentAddressGroup(list));
        }

        public RoundRobinServerList<T> build() {
            return new RoundRobinServerList<>(this.tm, this.listBuilder.a());
        }
    }

    public List<EquivalentAddressGroup> getList() {
        return this.list;
    }

    public T getTransportForNextServer() {
        EquivalentAddressGroup next;
        synchronized (this.cyclingIter) {
            next = this.cyclingIter.next();
        }
        return next == null ? this.requestDroppingTransport : this.tm.getTransport(next);
    }

    public int size() {
        return this.list.size();
    }

    private RoundRobinServerList(TransportManager<T> transportManager, List<EquivalentAddressGroup> list) {
        this.tm = transportManager;
        this.list = list;
        this.cyclingIter = V.a((Iterable) list);
        this.requestDroppingTransport = transportManager.createFailingTransport(Status.UNAVAILABLE.withDescription("Throttled by LB"));
    }
}
