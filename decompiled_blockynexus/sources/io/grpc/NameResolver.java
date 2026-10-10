package io.grpc;

import io.grpc.Attributes;
import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NameResolver {

    public static abstract class Factory {
        public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.of("params-default-port");

        public abstract String getDefaultScheme();

        public abstract NameResolver newNameResolver(URI uri, Attributes attributes);
    }

    public interface Listener {
        void onError(Status status);

        void onUpdate(List<? extends List<ResolvedServerInfo>> list, Attributes attributes);
    }

    public abstract String getServiceAuthority();

    public void refresh() {
    }

    public abstract void shutdown();

    public abstract void start(Listener listener);
}
