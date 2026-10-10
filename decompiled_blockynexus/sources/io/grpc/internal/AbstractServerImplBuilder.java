package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.ServerBuilder;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.InternalHandlerRegistry;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractServerImplBuilder<T extends AbstractServerImplBuilder<T>> extends ServerBuilder<T> {
    private static final HandlerRegistry EMPTY_FALLBACK_REGISTRY = new HandlerRegistry() { // from class: io.grpc.internal.AbstractServerImplBuilder.1
        @Override // io.grpc.HandlerRegistry
        public ServerMethodDefinition<?, ?> lookupMethod(String str, String str2) {
            return null;
        }
    };
    private CompressorRegistry compressorRegistry;
    private DecompressorRegistry decompressorRegistry;
    private Executor executor;
    private HandlerRegistry fallbackRegistry;
    private final InternalHandlerRegistry.Builder registryBuilder = new InternalHandlerRegistry.Builder();

    private T thisT() {
        return this;
    }

    protected abstract InternalServer buildTransportServer();

    @Override // io.grpc.ServerBuilder
    public ServerImpl build() {
        return new ServerImpl(this.executor, this.registryBuilder.build(), (HandlerRegistry) j.a(this.fallbackRegistry, EMPTY_FALLBACK_REGISTRY), buildTransportServer(), Context.ROOT, (DecompressorRegistry) j.a(this.decompressorRegistry, DecompressorRegistry.getDefaultInstance()), (CompressorRegistry) j.a(this.compressorRegistry, CompressorRegistry.getDefaultInstance()));
    }

    @Override // io.grpc.ServerBuilder
    public final T compressorRegistry(CompressorRegistry compressorRegistry) {
        this.compressorRegistry = compressorRegistry;
        thisT();
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public final T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        this.decompressorRegistry = decompressorRegistry;
        thisT();
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public final T directExecutor() {
        return (T) executor(MoreExecutors.a());
    }

    @Override // io.grpc.ServerBuilder
    public final T executor(Executor executor) {
        this.executor = executor;
        thisT();
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public final T fallbackHandlerRegistry(HandlerRegistry handlerRegistry) {
        this.fallbackRegistry = handlerRegistry;
        thisT();
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public final T addService(ServerServiceDefinition serverServiceDefinition) {
        this.registryBuilder.addService(serverServiceDefinition);
        thisT();
        return this;
    }

    @Override // io.grpc.ServerBuilder
    public final T addService(BindableService bindableService) {
        return (T) addService(bindableService.bindService());
    }
}
