package io.grpc.inprocess;

import io.grpc.internal.InternalServer;
import io.grpc.internal.ServerListener;
import io.grpc.internal.ServerTransportListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes5.dex */
class InProcessServer implements InternalServer {
    private static final ConcurrentMap<String, InProcessServer> registry = new ConcurrentHashMap();
    private ServerListener listener;
    private final String name;
    private boolean shutdown;

    InProcessServer(String str) {
        this.name = str;
    }

    static InProcessServer findServer(String str) {
        return registry.get(str);
    }

    @Override // io.grpc.internal.InternalServer
    public int getPort() {
        return -1;
    }

    synchronized ServerTransportListener register(InProcessTransport inProcessTransport) {
        if (this.shutdown) {
            return null;
        }
        return this.listener.transportCreated(inProcessTransport);
    }

    @Override // io.grpc.internal.InternalServer
    public void shutdown() {
        if (!registry.remove(this.name, this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.shutdown = true;
            this.listener.serverShutdown();
        }
    }

    @Override // io.grpc.internal.InternalServer
    public void start(ServerListener serverListener) throws IOException {
        this.listener = serverListener;
        if (registry.putIfAbsent(this.name, this) == null) {
            return;
        }
        throw new IOException("name already registered: " + this.name);
    }
}
