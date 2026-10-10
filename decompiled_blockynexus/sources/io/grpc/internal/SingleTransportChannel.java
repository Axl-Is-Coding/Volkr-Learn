package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import io.grpc.internal.ClientCallImpl;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes5.dex */
final class SingleTransportChannel extends Channel {
    private final String authority;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final Executor executor;
    private final ClientTransport transport;
    private final ClientCallImpl.ClientTransportProvider transportProvider = new ClientCallImpl.ClientTransportProvider() { // from class: io.grpc.internal.SingleTransportChannel.1
        @Override // io.grpc.internal.ClientCallImpl.ClientTransportProvider
        public ClientTransport get(CallOptions callOptions) {
            return SingleTransportChannel.this.transport;
        }
    };

    public SingleTransportChannel(ClientTransport clientTransport, Executor executor, ScheduledExecutorService scheduledExecutorService, String str) {
        m.a(clientTransport, "transport");
        this.transport = clientTransport;
        m.a(executor, "executor");
        this.executor = executor;
        m.a(scheduledExecutorService, "deadlineCancellationExecutor");
        this.deadlineCancellationExecutor = scheduledExecutorService;
        m.a(str, "authority");
        this.authority = str;
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.authority;
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return new ClientCallImpl(methodDescriptor, new SerializingExecutor(this.executor), callOptions, this.transportProvider, this.deadlineCancellationExecutor);
    }
}
