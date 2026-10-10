package io.grpc;

import io.grpc.ServerBuilder;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ServerBuilder<T extends ServerBuilder<T>> {
    public static ServerBuilder<?> forPort(int i) {
        return ServerProvider.provider().builderForPort(i);
    }

    public abstract T addService(BindableService bindableService);

    public abstract T addService(ServerServiceDefinition serverServiceDefinition);

    public abstract Server build();

    public abstract T compressorRegistry(CompressorRegistry compressorRegistry);

    public abstract T decompressorRegistry(DecompressorRegistry decompressorRegistry);

    public abstract T directExecutor();

    public abstract T executor(Executor executor);

    public abstract T fallbackHandlerRegistry(HandlerRegistry handlerRegistry);

    public abstract T useTransportSecurity(File file, File file2);
}
