package io.grpc;

import io.grpc.LoadBalancer;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ManagedChannelBuilder<T extends ManagedChannelBuilder<T>> {
    public static ManagedChannelBuilder<?> forAddress(String str, int i) {
        return ManagedChannelProvider.provider().builderForAddress(str, i);
    }

    public static ManagedChannelBuilder<?> forTarget(String str) {
        return ManagedChannelProvider.provider().builderForTarget(str);
    }

    public abstract ManagedChannel build();

    public abstract T compressorRegistry(CompressorRegistry compressorRegistry);

    public abstract T decompressorRegistry(DecompressorRegistry decompressorRegistry);

    public abstract T directExecutor();

    public abstract T executor(Executor executor);

    public abstract T idleTimeout(long j, TimeUnit timeUnit);

    public abstract T intercept(List<ClientInterceptor> list);

    public abstract T intercept(ClientInterceptor... clientInterceptorArr);

    public abstract T loadBalancerFactory(LoadBalancer.Factory factory);

    public abstract T nameResolverFactory(NameResolver.Factory factory);

    public abstract T overrideAuthority(String str);

    public abstract T usePlaintext(boolean z);

    public abstract T userAgent(String str);
}
