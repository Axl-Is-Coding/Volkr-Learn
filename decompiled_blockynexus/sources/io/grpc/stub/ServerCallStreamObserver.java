package io.grpc.stub;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ServerCallStreamObserver<V> extends CallStreamObserver<V> {
    public abstract boolean isCancelled();

    public abstract void setCompression(String str);

    public abstract void setOnCancelHandler(Runnable runnable);
}
