package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
final class MetadataApplierImpl implements CallCredentials.MetadataApplier {
    private final CallOptions callOptions;
    DelayedStream delayedStream;
    boolean finalized;
    private final Object lock = new Object();
    private final MethodDescriptor<?, ?> method;
    private final Metadata origHeaders;
    private ClientStream returnedStream;
    private final ClientTransport transport;

    MetadataApplierImpl(ClientTransport clientTransport, MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        this.transport = clientTransport;
        this.method = methodDescriptor;
        this.origHeaders = metadata;
        this.callOptions = callOptions;
    }

    private void finalizeWith(ClientStream clientStream) {
        m.b(!this.finalized, "already finalized");
        this.finalized = true;
        synchronized (this.lock) {
            if (this.returnedStream == null) {
                this.returnedStream = clientStream;
            } else {
                m.b(this.delayedStream != null, "delayedStream is null");
                this.delayedStream.setStream(clientStream);
            }
        }
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void apply(Metadata metadata) {
        m.b(!this.finalized, "apply() or fail() already called");
        m.a(metadata, "headers");
        this.origHeaders.merge(metadata);
        finalizeWith(this.transport.newStream(this.method, this.origHeaders, this.callOptions));
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void fail(Status status) {
        m.a(!status.isOk(), "Cannot fail with OK status");
        m.b(!this.finalized, "apply() or fail() already called");
        finalizeWith(new FailingClientStream(status));
    }

    ClientStream returnStream() {
        synchronized (this.lock) {
            if (this.returnedStream != null) {
                return this.returnedStream;
            }
            this.delayedStream = new DelayedStream();
            DelayedStream delayedStream = this.delayedStream;
            this.returnedStream = delayedStream;
            return delayedStream;
        }
    }
}
