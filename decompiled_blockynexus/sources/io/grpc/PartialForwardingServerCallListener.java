package io.grpc;

import io.grpc.ServerCall;

/* JADX INFO: loaded from: classes5.dex */
abstract class PartialForwardingServerCallListener<ReqT> extends ServerCall.Listener<ReqT> {
    PartialForwardingServerCallListener() {
    }

    protected abstract ServerCall.Listener<?> delegate();

    @Override // io.grpc.ServerCall.Listener
    public void onCancel() {
        delegate().onCancel();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onComplete() {
        delegate().onComplete();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onHalfClose() {
        delegate().onHalfClose();
    }

    @Override // io.grpc.ServerCall.Listener
    public void onReady() {
        delegate().onReady();
    }
}
