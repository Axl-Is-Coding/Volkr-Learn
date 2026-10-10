package io.grpc.inprocess;

import java.net.SocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public class InProcessSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -2803441206326023474L;
    private final String name;

    public InProcessSocketAddress(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
