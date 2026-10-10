package com.sandboxol.center.router.moduleInfo.game.team.teammgr;

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
public class TeammgrGrpc {
    private static final int METHODID_PARTY_LIST = 1;
    private static final int METHODID_TEAM = 0;
    public static final String SERVICE_NAME = "teammgr.Teammgr";
    public static final MethodDescriptor<TeamRequest, TeamResponse> METHOD_TEAM = MethodDescriptor.create(MethodDescriptor.MethodType.BIDI_STREAMING, MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Team"), ProtoLiteUtils.marshaller(TeamRequest.getDefaultInstance()), ProtoLiteUtils.marshaller(TeamResponse.getDefaultInstance()));
    public static final MethodDescriptor<PartyListRequest, PartyListResponse> METHOD_PARTY_LIST = MethodDescriptor.create(MethodDescriptor.MethodType.BIDI_STREAMING, MethodDescriptor.generateFullMethodName(SERVICE_NAME, "PartyList"), ProtoLiteUtils.marshaller(PartyListRequest.getDefaultInstance()), ProtoLiteUtils.marshaller(PartyListResponse.getDefaultInstance()));

    public static final class TeammgrBlockingStub extends AbstractStub<TeammgrBlockingStub> {
        private TeammgrBlockingStub(Channel channel) {
            super(channel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public TeammgrBlockingStub build(Channel channel, CallOptions callOptions) {
            return new TeammgrBlockingStub(channel, callOptions);
        }

        private TeammgrBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    public static final class TeammgrFutureStub extends AbstractStub<TeammgrFutureStub> {
        private TeammgrFutureStub(Channel channel) {
            super(channel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public TeammgrFutureStub build(Channel channel, CallOptions callOptions) {
            return new TeammgrFutureStub(channel, callOptions);
        }

        private TeammgrFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    public static abstract class TeammgrImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(TeammgrGrpc.getServiceDescriptor()).addMethod(TeammgrGrpc.METHOD_TEAM, ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 0))).addMethod(TeammgrGrpc.METHOD_PARTY_LIST, ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 1))).build();
        }

        public StreamObserver<PartyListRequest> partyList(StreamObserver<PartyListResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(TeammgrGrpc.METHOD_PARTY_LIST, streamObserver);
        }

        public StreamObserver<TeamRequest> team(StreamObserver<TeamResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(TeammgrGrpc.METHOD_TEAM, streamObserver);
        }
    }

    public static final class TeammgrStub extends AbstractStub<TeammgrStub> {
        public StreamObserver<PartyListRequest> partyList(StreamObserver<PartyListResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(TeammgrGrpc.METHOD_PARTY_LIST, getCallOptions()), streamObserver);
        }

        public StreamObserver<TeamRequest> team(StreamObserver<TeamResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(TeammgrGrpc.METHOD_TEAM, getCallOptions()), streamObserver);
        }

        private TeammgrStub(Channel channel) {
            super(channel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public TeammgrStub build(Channel channel, CallOptions callOptions) {
            return new TeammgrStub(channel, callOptions);
        }

        private TeammgrStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    private TeammgrGrpc() {
    }

    public static ServiceDescriptor getServiceDescriptor() {
        return new ServiceDescriptor(SERVICE_NAME, (MethodDescriptor<?, ?>[]) new MethodDescriptor[]{METHOD_TEAM, METHOD_PARTY_LIST});
    }

    public static TeammgrBlockingStub newBlockingStub(Channel channel) {
        return new TeammgrBlockingStub(channel);
    }

    public static TeammgrFutureStub newFutureStub(Channel channel) {
        return new TeammgrFutureStub(channel);
    }

    public static TeammgrStub newStub(Channel channel) {
        return new TeammgrStub(channel);
    }

    private static class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final TeammgrImplBase serviceImpl;

        public MethodHandlers(TeammgrImplBase teammgrImplBase, int i) {
            this.serviceImpl = teammgrImplBase;
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
                return (StreamObserver<Req>) this.serviceImpl.team(streamObserver);
            }
            if (i == 1) {
                return (StreamObserver<Req>) this.serviceImpl.partyList(streamObserver);
            }
            throw new AssertionError();
        }
    }
}
