package com.sandboxol.center.router.moduleInfo.game.team.connector;

import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectorGrpc {
    private static final int METHODID_QUEUE = 0;
    private static final int METHODID_TEAM_QUEUE = 1;
    public static final String SERVICE_NAME = "connector.Connector";
    public static final MethodDescriptor<QueueRequest, QueueResponse> METHOD_QUEUE = MethodDescriptor.create(MethodDescriptor.MethodType.BIDI_STREAMING, MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Queue"), ProtoLiteUtils.marshaller(QueueRequest.getDefaultInstance()), ProtoLiteUtils.marshaller(QueueResponse.getDefaultInstance()));
    public static final MethodDescriptor<TeamQueueRequest, TeamQueueResponse> METHOD_TEAM_QUEUE = MethodDescriptor.create(MethodDescriptor.MethodType.BIDI_STREAMING, MethodDescriptor.generateFullMethodName(SERVICE_NAME, "TeamQueue"), ProtoLiteUtils.marshaller(TeamQueueRequest.getDefaultInstance()), ProtoLiteUtils.marshaller(TeamQueueResponse.getDefaultInstance()));

    public static final class ConnectorBlockingStub extends AbstractStub<ConnectorBlockingStub> {
        private ConnectorBlockingStub(Channel channel) {
            super(channel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ConnectorBlockingStub build(Channel channel, CallOptions callOptions) {
            return new ConnectorBlockingStub(channel, callOptions);
        }

        private ConnectorBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    public static final class ConnectorFutureStub extends AbstractStub<ConnectorFutureStub> {
        private ConnectorFutureStub(Channel channel) {
            super(channel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ConnectorFutureStub build(Channel channel, CallOptions callOptions) {
            return new ConnectorFutureStub(channel, callOptions);
        }

        private ConnectorFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    public static abstract class ConnectorImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(ConnectorGrpc.getServiceDescriptor()).addMethod(ConnectorGrpc.METHOD_QUEUE, ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 0))).addMethod(ConnectorGrpc.METHOD_TEAM_QUEUE, ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 1))).build();
        }

        public StreamObserver<QueueRequest> queue(StreamObserver<QueueResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(ConnectorGrpc.METHOD_QUEUE, streamObserver);
        }

        public StreamObserver<TeamQueueRequest> teamQueue(StreamObserver<TeamQueueResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(ConnectorGrpc.METHOD_TEAM_QUEUE, streamObserver);
        }
    }

    public static final class ConnectorStub extends AbstractStub<ConnectorStub> {
        public StreamObserver<QueueRequest> queue(StreamObserver<QueueResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(ConnectorGrpc.METHOD_QUEUE, getCallOptions()), streamObserver);
        }

        public StreamObserver<TeamQueueRequest> teamQueue(StreamObserver<TeamQueueResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(ConnectorGrpc.METHOD_TEAM_QUEUE, getCallOptions()), streamObserver);
        }

        private ConnectorStub(Channel channel) {
            super(channel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public ConnectorStub build(Channel channel, CallOptions callOptions) {
            return new ConnectorStub(channel, callOptions);
        }

        private ConnectorStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    private ConnectorGrpc() {
    }

    public static ServiceDescriptor getServiceDescriptor() {
        return new ServiceDescriptor(SERVICE_NAME, (MethodDescriptor<?, ?>[]) new MethodDescriptor[]{METHOD_QUEUE, METHOD_TEAM_QUEUE});
    }

    public static ConnectorBlockingStub newBlockingStub(Channel channel) {
        return new ConnectorBlockingStub(channel);
    }

    public static ConnectorFutureStub newFutureStub(Channel channel) {
        return new ConnectorFutureStub(channel);
    }

    public static ConnectorStub newStub(Channel channel) {
        return new ConnectorStub(channel);
    }

    private static class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final ConnectorImplBase serviceImpl;

        public MethodHandlers(ConnectorImplBase connectorImplBase, int i) {
            this.serviceImpl = connectorImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.UnaryRequestMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.StreamingRequestMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            int i = this.methodId;
            if (i == 0) {
                return (StreamObserver<Req>) this.serviceImpl.queue(streamObserver);
            }
            if (i == 1) {
                return (StreamObserver<Req>) this.serviceImpl.teamQueue(streamObserver);
            }
            throw new AssertionError();
        }
    }
}
