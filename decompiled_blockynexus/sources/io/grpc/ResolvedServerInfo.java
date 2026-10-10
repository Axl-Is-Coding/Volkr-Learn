package io.grpc;

import java.net.SocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public final class ResolvedServerInfo {
    private final SocketAddress address;
    private final Attributes attributes;

    public ResolvedServerInfo(SocketAddress socketAddress, Attributes attributes) {
        this.address = socketAddress;
        this.attributes = attributes;
    }

    public SocketAddress getAddress() {
        return this.address;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public String toString() {
        return "[address=" + this.address + ", attrs=" + this.attributes + "]";
    }
}
