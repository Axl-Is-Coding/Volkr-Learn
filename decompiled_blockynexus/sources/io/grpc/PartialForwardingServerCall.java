package io.grpc;

/* JADX INFO: loaded from: classes5.dex */
abstract class PartialForwardingServerCall<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    PartialForwardingServerCall() {
    }

    @Override // io.grpc.ServerCall
    public Attributes attributes() {
        return delegate().attributes();
    }

    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata metadata) {
        delegate().close(status, metadata);
    }

    protected abstract ServerCall<?, ?> delegate();

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ServerCall
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata metadata) {
        delegate().sendHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    public void setCompression(String str) {
        delegate().setCompression(str);
    }

    @Override // io.grpc.ServerCall
    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }
}
