package io.grpc;

import io.grpc.ManagedChannelProvider;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ServerProvider {
    private static final ServerProvider provider = load(Thread.currentThread().getContextClassLoader());

    static final ServerProvider load(ClassLoader classLoader) {
        ServerProvider serverProvider = null;
        for (ServerProvider serverProvider2 : ServiceLoader.load(ServerProvider.class, classLoader)) {
            if (serverProvider2.isAvailable() && (serverProvider == null || serverProvider2.priority() > serverProvider.priority())) {
                serverProvider = serverProvider2;
            }
        }
        return serverProvider;
    }

    public static ServerProvider provider() {
        ServerProvider serverProvider = provider;
        if (serverProvider != null) {
            return serverProvider;
        }
        throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty artifact");
    }

    protected abstract ServerBuilder<?> builderForPort(int i);

    protected abstract boolean isAvailable();

    protected abstract int priority();
}
