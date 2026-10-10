package io.grpc;

import io.grpc.ClientCall;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {

    public static abstract class SimpleForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private final ClientCall<ReqT, RespT> delegate;

        protected SimpleForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        @Override // io.grpc.ForwardingClientCall
        protected ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }
    }

    @Override // io.grpc.ClientCall
    public void cancel(String str, Throwable th) {
        delegate().cancel(str, th);
    }

    protected abstract ClientCall<ReqT, RespT> delegate();

    @Override // io.grpc.ClientCall
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // io.grpc.ClientCall
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT reqt) {
        delegate().sendMessage(reqt);
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean z) {
        delegate().setMessageCompression(z);
    }

    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
        delegate().start(listener, metadata);
    }
}
