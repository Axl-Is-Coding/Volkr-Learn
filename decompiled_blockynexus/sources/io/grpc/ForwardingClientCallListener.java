package io.grpc;

import io.grpc.ClientCall;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ForwardingClientCallListener<RespT> extends ClientCall.Listener<RespT> {

    public static abstract class SimpleForwardingClientCallListener<RespT> extends ForwardingClientCallListener<RespT> {
        private final ClientCall.Listener<RespT> delegate;

        protected SimpleForwardingClientCallListener(ClientCall.Listener<RespT> listener) {
            this.delegate = listener;
        }

        @Override // io.grpc.ForwardingClientCallListener
        protected ClientCall.Listener<RespT> delegate() {
            return this.delegate;
        }
    }

    protected abstract ClientCall.Listener<RespT> delegate();

    @Override // io.grpc.ClientCall.Listener
    public void onClose(Status status, Metadata metadata) {
        delegate().onClose(status, metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onHeaders(Metadata metadata) {
        delegate().onHeaders(metadata);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onMessage(RespT respt) {
        delegate().onMessage(respt);
    }

    @Override // io.grpc.ClientCall.Listener
    public void onReady() {
        delegate().onReady();
    }
}
