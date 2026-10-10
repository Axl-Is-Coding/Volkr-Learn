package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
class FailingClientTransport implements ClientTransport {
    final Status error;

    FailingClientTransport(Status status) {
        m.a(!status.isOk(), "error must not be OK");
        this.error = status;
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        return new FailingClientStream(this.error);
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(final ClientTransport.PingCallback pingCallback, Executor executor) {
        executor.execute(new Runnable() { // from class: io.grpc.internal.FailingClientTransport.1
            @Override // java.lang.Runnable
            public void run() {
                pingCallback.onFailure(FailingClientTransport.this.error.asException());
            }
        });
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
        return newStream(methodDescriptor, metadata, CallOptions.DEFAULT);
    }
}
