package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ManagedClientTransport;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
abstract class ForwardingConnectionClientTransport implements ConnectionClientTransport {
    ForwardingConnectionClientTransport() {
    }

    protected abstract ConnectionClientTransport delegate();

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttrs() {
        return delegate().getAttrs();
    }

    @Override // io.grpc.internal.WithLogId
    public String getLogId() {
        return delegate().getLogId();
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        return delegate().newStream(methodDescriptor, metadata, callOptions);
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        delegate().ping(pingCallback, executor);
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdown() {
        delegate().shutdown();
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdownNow(Status status) {
        delegate().shutdownNow(status);
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void start(ManagedClientTransport.Listener listener) {
        delegate().start(listener);
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + delegate().toString() + "]";
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
        return delegate().newStream(methodDescriptor, metadata);
    }
}
