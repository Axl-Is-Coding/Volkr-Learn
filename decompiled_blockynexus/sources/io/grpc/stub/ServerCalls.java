package io.grpc.stub;

import com.google.common.base.m;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
public class ServerCalls {

    public interface BidiStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
    }

    public interface ClientStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {
    }

    private static class EmptyServerCallListener<ReqT> extends ServerCall.Listener<ReqT> {
        private EmptyServerCallListener() {
        }

        @Override // io.grpc.ServerCall.Listener
        public void onCancel() {
        }

        @Override // io.grpc.ServerCall.Listener
        public void onComplete() {
        }

        @Override // io.grpc.ServerCall.Listener
        public void onHalfClose() {
        }

        @Override // io.grpc.ServerCall.Listener
        public void onMessage(ReqT reqt) {
        }
    }

    static class NoopStreamObserver<V> implements StreamObserver<V> {
        NoopStreamObserver() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(V v) {
        }
    }

    private static final class ServerCallStreamObserverImpl<ReqT, RespT> extends ServerCallStreamObserver<RespT> {
        private boolean autoFlowControlEnabled = true;
        final ServerCall<ReqT, RespT> call;
        volatile boolean cancelled;
        private boolean frozen;
        private Runnable onCancelHandler;
        private Runnable onReadyHandler;
        private boolean sentHeaders;

        ServerCallStreamObserverImpl(ServerCall<ReqT, RespT> serverCall) {
            this.call = serverCall;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void disableAutoInboundFlowControl() {
            if (this.frozen) {
                throw new IllegalStateException("Cannot disable auto flow control after initialization");
            }
            this.autoFlowControlEnabled = false;
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public boolean isCancelled() {
            return this.call.isCancelled();
        }

        @Override // io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            if (this.cancelled) {
                throw Status.CANCELLED.asRuntimeException();
            }
            this.call.close(Status.OK, new Metadata());
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
            Metadata metadataTrailersFromThrowable = Status.trailersFromThrowable(th);
            if (metadataTrailersFromThrowable == null) {
                metadataTrailersFromThrowable = new Metadata();
            }
            this.call.close(Status.fromThrowable(th), metadataTrailersFromThrowable);
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(RespT respt) {
            if (this.cancelled) {
                throw Status.CANCELLED.asRuntimeException();
            }
            if (!this.sentHeaders) {
                this.call.sendHeaders(new Metadata());
                this.sentHeaders = true;
            }
            this.call.sendMessage(respt);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void request(int i) {
            this.call.request(i);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setCompression(String str) {
            this.call.setCompression(str);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean z) {
            this.call.setMessageCompression(z);
        }

        @Override // io.grpc.stub.ServerCallStreamObserver
        public void setOnCancelHandler(Runnable runnable) {
            if (this.frozen) {
                throw new IllegalStateException("Cannot alter onCancelHandler after initialization");
            }
            this.onCancelHandler = runnable;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable runnable) {
            if (this.frozen) {
                throw new IllegalStateException("Cannot alter onReadyHandler after initialization");
            }
            this.onReadyHandler = runnable;
        }
    }

    public interface ServerStreamingMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
    }

    private interface StreamingRequestMethod<ReqT, RespT> {
        StreamObserver<ReqT> invoke(StreamObserver<RespT> streamObserver);
    }

    public interface UnaryMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {
    }

    private interface UnaryRequestMethod<ReqT, RespT> {
        void invoke(ReqT reqt, StreamObserver<RespT> streamObserver);
    }

    private ServerCalls() {
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncBidiStreamingCall(BidiStreamingMethod<ReqT, RespT> bidiStreamingMethod) {
        return asyncStreamingRequestCall(bidiStreamingMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncClientStreamingCall(ClientStreamingMethod<ReqT, RespT> clientStreamingMethod) {
        return asyncStreamingRequestCall(clientStreamingMethod);
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncServerStreamingCall(ServerStreamingMethod<ReqT, RespT> serverStreamingMethod) {
        return asyncUnaryRequestCall(serverStreamingMethod);
    }

    private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncStreamingRequestCall(final StreamingRequestMethod<ReqT, RespT> streamingRequestMethod) {
        return new ServerCallHandler<ReqT, RespT>() { // from class: io.grpc.stub.ServerCalls.2
            @Override // io.grpc.ServerCallHandler
            public ServerCall.Listener<ReqT> startCall(final ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
                final ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall);
                final StreamObserver<ReqT> streamObserverInvoke = streamingRequestMethod.invoke(serverCallStreamObserverImpl);
                serverCallStreamObserverImpl.freeze();
                if (serverCallStreamObserverImpl.autoFlowControlEnabled) {
                    serverCall.request(1);
                }
                return new EmptyServerCallListener<ReqT>() { // from class: io.grpc.stub.ServerCalls.2.1
                    boolean halfClosed;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                        this.halfClosed = false;
                    }

                    @Override // io.grpc.stub.ServerCalls.EmptyServerCallListener, io.grpc.ServerCall.Listener
                    public void onCancel() {
                        ServerCallStreamObserverImpl serverCallStreamObserverImpl2 = serverCallStreamObserverImpl;
                        serverCallStreamObserverImpl2.cancelled = true;
                        if (serverCallStreamObserverImpl2.onCancelHandler != null) {
                            serverCallStreamObserverImpl.onCancelHandler.run();
                        }
                        if (this.halfClosed) {
                            return;
                        }
                        streamObserverInvoke.onError(Status.CANCELLED.asException());
                    }

                    @Override // io.grpc.stub.ServerCalls.EmptyServerCallListener, io.grpc.ServerCall.Listener
                    public void onHalfClose() {
                        this.halfClosed = true;
                        streamObserverInvoke.onCompleted();
                    }

                    @Override // io.grpc.stub.ServerCalls.EmptyServerCallListener, io.grpc.ServerCall.Listener
                    public void onMessage(ReqT reqt) {
                        streamObserverInvoke.onNext(reqt);
                        if (serverCallStreamObserverImpl.autoFlowControlEnabled) {
                            serverCall.request(1);
                        }
                    }

                    @Override // io.grpc.ServerCall.Listener
                    public void onReady() {
                        if (serverCallStreamObserverImpl.onReadyHandler != null) {
                            serverCallStreamObserverImpl.onReadyHandler.run();
                        }
                    }
                };
            }
        };
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryCall(UnaryMethod<ReqT, RespT> unaryMethod) {
        return asyncUnaryRequestCall(unaryMethod);
    }

    private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryRequestCall(final UnaryRequestMethod<ReqT, RespT> unaryRequestMethod) {
        return new ServerCallHandler<ReqT, RespT>() { // from class: io.grpc.stub.ServerCalls.1
            @Override // io.grpc.ServerCallHandler
            public ServerCall.Listener<ReqT> startCall(final ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
                final ServerCallStreamObserverImpl serverCallStreamObserverImpl = new ServerCallStreamObserverImpl(serverCall);
                serverCall.request(2);
                return new EmptyServerCallListener<ReqT>() { // from class: io.grpc.stub.ServerCalls.1.1
                    ReqT request;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // io.grpc.stub.ServerCalls.EmptyServerCallListener, io.grpc.ServerCall.Listener
                    public void onCancel() {
                        ServerCallStreamObserverImpl serverCallStreamObserverImpl2 = serverCallStreamObserverImpl;
                        serverCallStreamObserverImpl2.cancelled = true;
                        if (serverCallStreamObserverImpl2.onCancelHandler != null) {
                            serverCallStreamObserverImpl.onCancelHandler.run();
                        }
                    }

                    @Override // io.grpc.stub.ServerCalls.EmptyServerCallListener, io.grpc.ServerCall.Listener
                    public void onHalfClose() {
                        ReqT reqt = this.request;
                        if (reqt == null) {
                            serverCall.close(Status.INTERNAL.withDescription("Half-closed without a request"), new Metadata());
                            return;
                        }
                        unaryRequestMethod.invoke(reqt, serverCallStreamObserverImpl);
                        serverCallStreamObserverImpl.freeze();
                        if (serverCall.isReady()) {
                            onReady();
                        }
                    }

                    @Override // io.grpc.stub.ServerCalls.EmptyServerCallListener, io.grpc.ServerCall.Listener
                    public void onMessage(ReqT reqt) {
                        this.request = reqt;
                    }

                    @Override // io.grpc.ServerCall.Listener
                    public void onReady() {
                        if (serverCallStreamObserverImpl.onReadyHandler != null) {
                            serverCallStreamObserverImpl.onReadyHandler.run();
                        }
                    }
                };
            }
        };
    }

    public static <T> StreamObserver<T> asyncUnimplementedStreamingCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        asyncUnimplementedUnaryCall(methodDescriptor, streamObserver);
        return new NoopStreamObserver();
    }

    public static void asyncUnimplementedUnaryCall(MethodDescriptor<?, ?> methodDescriptor, StreamObserver<?> streamObserver) {
        m.a(methodDescriptor);
        m.a(streamObserver);
        streamObserver.onError(Status.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented", methodDescriptor.getFullMethodName())).asException());
    }
}
