package io.grpc;

import com.google.common.base.m;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class EquivalentAddressGroup {
    private final List<SocketAddress> addrs;

    public EquivalentAddressGroup(List<SocketAddress> list) {
        m.a(!list.isEmpty(), "addrs is empty");
        this.addrs = Collections.unmodifiableList(new ArrayList(list));
    }

    public boolean equals(Object obj) {
        if (obj instanceof EquivalentAddressGroup) {
            return this.addrs.equals(((EquivalentAddressGroup) obj).addrs);
        }
        return false;
    }

    public List<SocketAddress> getAddresses() {
        return this.addrs;
    }

    public int hashCode() {
        return this.addrs.hashCode();
    }

    public String toString() {
        return this.addrs.toString();
    }

    public EquivalentAddressGroup(SocketAddress socketAddress) {
        this.addrs = Collections.singletonList(socketAddress);
    }
}
