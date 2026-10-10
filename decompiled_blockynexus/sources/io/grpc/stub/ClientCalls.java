package io.grpc.stub;

import com.google.common.base.m;
import com.google.common.util.concurrent.b;
import com.google.common.util.concurrent.n;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class ClientCalls {
    private static final Logger log = Logger.getLogger(ClientCalls.class.getName());

    private static class CallToStreamObserverAdapter<T> extends ClientCallStreamObserver<T> {
        private boolean autoFlowControlEnabled = true;
        private final ClientCall<T, ?> call;
        private boolean frozen;
        private Runnable onReadyHandler;

        public CallToStreamObserverAdapter(ClientCall<T, ?> clientCall) {
            this.call = clientCall;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void disableAutoInboundFlowControl() {
            if (this.frozen) {
                throw new IllegalStateException("Cannot disable auto flow control call started");
            }
            this.autoFlowControlEnabled = false;
        }

        @Override // io.grpc.stub.CallStreamObserver
        public boolean isReady() {
            return this.call.isReady();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onCompleted() {
            this.call.halfClose();
        }

        @Override // io.grpc.stub.StreamObserver
        public void onError(Throwable th) {
            this.call.cancel("Cancelled by client with StreamObserver.onError()", th);
        }

        @Override // io.grpc.stub.StreamObserver
        public void onNext(T t) {
            this.call.sendMessage(t);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void request(int i) {
            this.call.request(i);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setMessageCompression(boolean z) {
            this.call.setMessageCompression(z);
        }

        @Override // io.grpc.stub.CallStreamObserver
        public void setOnReadyHandler(Runnable runnable) {
            if (this.frozen) {
                throw new IllegalStateException("Cannot alter onReadyHandler after call started");
            }
            this.onReadyHandler = runnable;
        }
    }

    private static class GrpcFuture<RespT> extends b<RespT> {
        private final ClientCall<?, RespT> call;

        GrpcFuture(ClientCall<?, RespT> clientCall) {
            this.call = clientCall;
        }

        @Override // com.google.common.util.concurrent.b
        protected void interruptTask() {
            this.call.cancel("GrpcFuture was cancelled", null);
        }

        @Override // com.google.common.util.concurrent.b
        protected boolean set(RespT respt) {
            return super.set(respt);
        }

        @Override // com.google.common.util.concurrent.b
        protected boolean setException(Throwable th) {
            return super.setException(th);
        }
    }

    private static class StreamObserverToCallListenerAdapter<ReqT, RespT> extends ClientCall.Listener<RespT> {
        private final CallToStreamObserverAdapter<ReqT> adapter;
        private final ClientCall<ReqT, RespT> call;
        private boolean firstResponseReceived;
        private final StreamObserver<RespT> observer;
        private final boolean streamingResponse;

        StreamObserverToCallListenerAdapter(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver, CallToStreamObserverAdapter<ReqT> callToStreamObserverAdapter, boolean z) {
            this.call = clientCall;
            this.observer = streamObserver;
            this.streamingResponse = z;
            this.adapter = callToStreamObserverAdapter;
            if (streamObserver instanceof ClientResponseObserver) {
                ((ClientResponseObserver) streamObserver).beforeStart(callToStreamObserverAdapter);
            }
            callToStreamObserverAdapter.freeze();
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (status.isOk()) {
                this.observer.onCompleted();
            } else {
                this.observer.onError(status.asRuntimeException(metadata));
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            if (this.firstResponseReceived && !this.streamingResponse) {
                throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
            }
            this.firstResponseReceived = true;
            this.observer.onNext(respt);
            if (this.streamingResponse && ((CallToStreamObserverAdapter) this.adapter).autoFlowControlEnabled) {
                this.call.request(1);
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (((CallToStreamObserverAdapter) this.adapter).onReadyHandler != null) {
                ((CallToStreamObserverAdapter) this.adapter).onReadyHandler.run();
            }
        }
    }

    private static class ThreadlessExecutor implements Executor {
        private final BlockingQueue<Runnable> queue;

        private ThreadlessExecutor() {
            this.queue = new LinkedBlockingQueue();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.queue.add(runnable);
        }

        public void waitAndDrain() throws InterruptedException {
            Runnable runnableTake = this.queue.take();
            while (runnableTake != null) {
                try {
                    runnableTake.run();
                } catch (Throwable th) {
                    ClientCalls.log.log(Level.WARNING, "Runnable threw exception", th);
                }
                runnableTake = this.queue.poll();
            }
        }
    }

    private static class UnaryStreamToFuture<RespT> extends ClientCall.Listener<RespT> {
        private final GrpcFuture<RespT> responseFuture;
        private RespT value;

        public UnaryStreamToFuture(GrpcFuture<RespT> grpcFuture) {
            this.responseFuture = grpcFuture;
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(Status status, Metadata metadata) {
            if (!status.isOk()) {
                this.responseFuture.setException(status.asRuntimeException(metadata));
                return;
            }
            if (this.value == null) {
                this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(metadata));
            }
            this.responseFuture.set(this.value);
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(Metadata metadata) {
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(RespT respt) {
            if (this.value != null) {
                throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
            }
            this.value = respt;
        }
    }

    private ClientCalls() {
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver) {
        return asyncStreamingRequestCall(clientCall, streamObserver, true);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver) {
        return asyncStreamingRequestCall(clientCall, streamObserver, false);
    }

    public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver) {
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, (StreamObserver) streamObserver, true);
    }

    private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> clientCall, StreamObserver<RespT> streamObserver, boolean z) {
        CallToStreamObserverAdapter callToStreamObserverAdapter = new CallToStreamObserverAdapter(clientCall);
        startCall(clientCall, new StreamObserverToCallListenerAdapter(clientCall, streamObserver, callToStreamObserverAdapter, z), z);
        return callToStreamObserverAdapter;
    }

    public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver) {
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, (StreamObserver) streamObserver, false);
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, StreamObserver<RespT> streamObserver, boolean z) {
        asyncUnaryRequestCall(clientCall, reqt, new StreamObserverToCallListenerAdapter(clientCall, streamObserver, new CallToStreamObserverAdapter(clientCall), z), z);
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        BlockingResponseStream blockingResponseStream = new BlockingResponseStream(clientCall);
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, blockingResponseStream.listener(), true);
        return blockingResponseStream;
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        try {
            return (RespT) getUnchecked(futureUnaryCall(clientCall, reqt));
        } catch (Throwable th) {
            clientCall.cancel(null, th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw new RuntimeException(th);
        }
    }

    public static <ReqT, RespT> n<RespT> futureUnaryCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt) {
        GrpcFuture grpcFuture = new GrpcFuture(clientCall);
        asyncUnaryRequestCall((ClientCall) clientCall, (Object) reqt, (ClientCall.Listener) new UnaryStreamToFuture(grpcFuture), false);
        return grpcFuture;
    }

    private static <V> V getUnchecked(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withCause(e2).asRuntimeException();
        } catch (ExecutionException e3) {
            throw toStatusRuntimeException(e3);
        }
    }

    private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> clientCall, ClientCall.Listener<RespT> listener, boolean z) {
        clientCall.start(listener, new Metadata());
        if (z) {
            clientCall.request(1);
        } else {
            clientCall.request(2);
        }
    }

    private static StatusRuntimeException toStatusRuntimeException(Throwable th) {
        m.a(th);
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                StatusException statusException = (StatusException) cause;
                return new StatusRuntimeException(statusException.getStatus(), statusException.getTrailers());
            }
            if (cause instanceof StatusRuntimeException) {
                StatusRuntimeException statusRuntimeException = (StatusRuntimeException) cause;
                return new StatusRuntimeException(statusRuntimeException.getStatus(), statusRuntimeException.getTrailers());
            }
        }
        return Status.UNKNOWN.withCause(th).asRuntimeException();
    }

    private static class BlockingResponseStream<T> implements Iterator<T> {
        private final BlockingQueue<Object> buffer;
        private final ClientCall<?, T> call;
        private Object last;
        private final ClientCall.Listener<T> listener;
        private final ThreadlessExecutor threadless;

        private class QueuingListener extends ClientCall.Listener<T> {
            private boolean done;

            private QueuingListener() {
                this.done = false;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onClose(Status status, Metadata metadata) {
                m.b(!this.done, "ClientCall already closed");
                if (status.isOk()) {
                    BlockingResponseStream.this.buffer.add(BlockingResponseStream.this);
                } else {
                    BlockingResponseStream.this.buffer.add(status.asRuntimeException(metadata));
                }
                this.done = true;
            }

            @Override // io.grpc.ClientCall.Listener
            public void onHeaders(Metadata metadata) {
            }

            @Override // io.grpc.ClientCall.Listener
            public void onMessage(T t) {
                m.b(!this.done, "ClientCall already closed");
                BlockingResponseStream.this.buffer.add(t);
            }
        }

        private Object waitForNext() throws InterruptedException {
            if (this.threadless == null) {
                return this.buffer.take();
            }
            Object objPoll = this.buffer.poll();
            while (objPoll == null) {
                this.threadless.waitAndDrain();
                objPoll = this.buffer.poll();
            }
            return objPoll;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.last == null) {
                try {
                    this.last = waitForNext();
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw Status.CANCELLED.withCause(e2).asRuntimeException();
                }
            }
            Object obj = this.last;
            if (!(obj instanceof StatusRuntimeException)) {
                return obj != this;
            }
            StatusRuntimeException statusRuntimeException = (StatusRuntimeException) obj;
            throw statusRuntimeException.getStatus().asRuntimeException(statusRuntimeException.getTrailers());
        }

        ClientCall.Listener<T> listener() {
            return this.listener;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            try {
                this.call.request(1);
                return (T) this.last;
            } finally {
                this.last = null;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private BlockingResponseStream(ClientCall<?, T> clientCall) {
            this(clientCall, (ThreadlessExecutor) null);
        }

        private BlockingResponseStream(ClientCall<?, T> clientCall, ThreadlessExecutor threadlessExecutor) {
            this.buffer = new ArrayBlockingQueue(2);
            this.listener = new QueuingListener();
            this.call = clientCall;
            this.threadless = threadlessExecutor;
        }
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> clientCall, ReqT reqt, ClientCall.Listener<RespT> listener, boolean z) {
        startCall(clientCall, listener, z);
        try {
            clientCall.sendMessage(reqt);
            clientCall.halfClose();
        } catch (Throwable th) {
            clientCall.cancel(null, th);
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
        }
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel channel, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, ReqT reqt) {
        ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
        ClientCall clientCallNewCall = channel.newCall(methodDescriptor, callOptions.withExecutor(threadlessExecutor));
        BlockingResponseStream blockingResponseStream = new BlockingResponseStream(clientCallNewCall, threadlessExecutor);
        asyncUnaryRequestCall(clientCallNewCall, (Object) reqt, blockingResponseStream.listener(), true);
        return blockingResponseStream;
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(Channel channel, MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, ReqT reqt) {
        ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
        ClientCall clientCallNewCall = channel.newCall(methodDescriptor, callOptions.withExecutor(threadlessExecutor));
        try {
            n nVarFutureUnaryCall = futureUnaryCall(clientCallNewCall, reqt);
            while (!nVarFutureUnaryCall.isDone()) {
                try {
                    threadlessExecutor.waitAndDrain();
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw Status.CANCELLED.withCause(e2).asRuntimeException();
                }
            }
            return (RespT) getUnchecked(nVarFutureUnaryCall);
        } catch (Throwable th) {
            clientCallNewCall.cancel(null, th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw new RuntimeException(th);
        }
    }
}
