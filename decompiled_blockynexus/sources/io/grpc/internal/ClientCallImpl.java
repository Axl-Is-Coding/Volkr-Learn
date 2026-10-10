package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> implements Context.CancellationListener {
    private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
    private final Executor callExecutor;
    private final CallOptions callOptions;
    private boolean cancelCalled;
    private volatile boolean cancelListenersShouldBeRemoved;
    private final ClientTransportProvider clientTransportProvider;
    private final Context context;
    private ScheduledExecutorService deadlineCancellationExecutor;
    private volatile ScheduledFuture<?> deadlineCancellationFuture;
    private boolean halfCloseCalled;
    private final MethodDescriptor<ReqT, RespT> method;
    private ClientStream stream;
    private final boolean unaryRequest;
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    private CompressorRegistry compressorRegistry = CompressorRegistry.getDefaultInstance();

    private class ClientStreamListenerImpl implements ClientStreamListener {
        private boolean closed;
        private final ClientCall.Listener<RespT> observer;

        public ClientStreamListenerImpl(ClientCall.Listener<RespT> listener) {
            m.a(listener, "observer");
            this.observer = listener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void close(Status status, Metadata metadata) {
            this.closed = true;
            ClientCallImpl.this.cancelListenersShouldBeRemoved = true;
            try {
                this.observer.onClose(status, metadata);
            } finally {
                ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final Metadata metadata) {
            Deadline deadlineEffectiveDeadline = ClientCallImpl.this.effectiveDeadline();
            if (status.getCode() == Status.Code.CANCELLED && deadlineEffectiveDeadline != null && deadlineEffectiveDeadline.isExpired()) {
                status = Status.DEADLINE_EXCEEDED;
                metadata = new Metadata();
            }
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamClosed
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    if (ClientStreamListenerImpl.this.closed) {
                        return;
                    }
                    ClientStreamListenerImpl.this.close(status, metadata);
                }
            });
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            Decompressor decompressor = Codec.Identity.NONE;
            if (metadata.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY)) {
                String str = (String) metadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
                Decompressor decompressorLookupDecompressor = ClientCallImpl.this.decompressorRegistry.lookupDecompressor(str);
                if (decompressorLookupDecompressor == null) {
                    ClientCallImpl.this.stream.cancel(Status.INTERNAL.withDescription(String.format("Can't find decompressor for %s", str)));
                    return;
                }
                decompressor = decompressorLookupDecompressor;
            }
            ClientCallImpl.this.stream.setDecompressor(decompressor);
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1HeadersRead
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    try {
                        if (ClientStreamListenerImpl.this.closed) {
                            return;
                        }
                        ClientStreamListenerImpl.this.observer.onHeaders(metadata);
                    } catch (Throwable th) {
                        Status statusWithDescription = Status.CANCELLED.withCause(th).withDescription("Failed to read headers");
                        ClientCallImpl.this.stream.cancel(statusWithDescription);
                        ClientStreamListenerImpl.this.close(statusWithDescription, new Metadata());
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messageRead(final InputStream inputStream) {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1MessageRead
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    try {
                        if (ClientStreamListenerImpl.this.closed) {
                            return;
                        }
                        try {
                            ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(inputStream));
                            inputStream.close();
                        } catch (Throwable th) {
                            inputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        Status statusWithDescription = Status.CANCELLED.withCause(th2).withDescription("Failed to read message.");
                        ClientCallImpl.this.stream.cancel(statusWithDescription);
                        ClientStreamListenerImpl.this.close(statusWithDescription, new Metadata());
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.ClientStreamListenerImpl.1StreamOnReady
                {
                    Context context = ClientCallImpl.this.context;
                }

                @Override // io.grpc.internal.ContextRunnable
                public final void runInContext() {
                    try {
                        ClientStreamListenerImpl.this.observer.onReady();
                    } catch (Throwable th) {
                        Status statusWithDescription = Status.CANCELLED.withCause(th).withDescription("Failed to call onReady.");
                        ClientCallImpl.this.stream.cancel(statusWithDescription);
                        ClientStreamListenerImpl.this.close(statusWithDescription, new Metadata());
                    }
                }
            });
        }
    }

    interface ClientTransportProvider {
        ClientTransport get(CallOptions callOptions);
    }

    private class DeadlineTimer implements Runnable {
        private DeadlineTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClientCallImpl.this.stream.cancel(Status.DEADLINE_EXCEEDED);
        }
    }

    ClientCallImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Executor executor, CallOptions callOptions, ClientTransportProvider clientTransportProvider, ScheduledExecutorService scheduledExecutorService) {
        this.method = methodDescriptor;
        this.callExecutor = executor == MoreExecutors.a() ? new SerializeReentrantCallsDirectExecutor() : new SerializingExecutor(executor);
        this.context = Context.current();
        this.unaryRequest = methodDescriptor.getType() == MethodDescriptor.MethodType.UNARY || methodDescriptor.getType() == MethodDescriptor.MethodType.SERVER_STREAMING;
        this.callOptions = callOptions;
        this.clientTransportProvider = clientTransportProvider;
        this.deadlineCancellationExecutor = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Deadline effectiveDeadline() {
        return min(this.callOptions.getDeadline(), this.context.getDeadline());
    }

    private static void logIfContextNarrowedTimeout(long j, Deadline deadline, Deadline deadline2, Deadline deadline3) {
        if (log.isLoggable(Level.INFO) && deadline2 == deadline) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(j)));
            if (deadline3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(" Explicit call timeout was '%d' ns.", Long.valueOf(deadline3.timeRemaining(TimeUnit.NANOSECONDS))));
            }
            log.info(sb.toString());
        }
    }

    private static Deadline min(Deadline deadline, Deadline deadline2) {
        return deadline == null ? deadline2 : deadline2 == null ? deadline : deadline.minimum(deadline2);
    }

    static void prepareHeaders(Metadata metadata, DecompressorRegistry decompressorRegistry, Compressor compressor) {
        metadata.removeAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (compressor != Codec.Identity.NONE) {
            metadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, compressor.getMessageEncoding());
        }
        metadata.removeAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        String rawAdvertisedMessageEncodings = decompressorRegistry.getRawAdvertisedMessageEncodings();
        if (rawAdvertisedMessageEncodings.isEmpty()) {
            return;
        }
        metadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, rawAdvertisedMessageEncodings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeContextListenerAndCancelDeadlineFuture() {
        this.context.removeListener(this);
        ScheduledFuture<?> scheduledFuture = this.deadlineCancellationFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    private ScheduledFuture<?> startDeadlineTimer(Deadline deadline) {
        return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new DeadlineTimer()), deadline.timeRemaining(TimeUnit.NANOSECONDS), TimeUnit.NANOSECONDS);
    }

    private static void updateTimeoutHeaders(Deadline deadline, Deadline deadline2, Deadline deadline3, Metadata metadata) {
        metadata.removeAll(GrpcUtil.TIMEOUT_KEY);
        if (deadline == null) {
            return;
        }
        long jMax = Math.max(0L, deadline.timeRemaining(TimeUnit.NANOSECONDS));
        metadata.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(jMax));
        logIfContextNarrowedTimeout(jMax, deadline, deadline3, deadline2);
    }

    @Override // io.grpc.ClientCall
    public void cancel(String str, Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.cancelCalled) {
            return;
        }
        this.cancelCalled = true;
        try {
            if (this.stream != null) {
                Status statusWithCause = Status.CANCELLED;
                if (str != null) {
                    statusWithCause = statusWithCause.withDescription(str);
                }
                if (th != null) {
                    statusWithCause = statusWithCause.withCause(th);
                }
                this.stream.cancel(statusWithCause);
            }
        } finally {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    @Override // io.grpc.Context.CancellationListener
    public void cancelled(Context context) {
        this.stream.cancel(Contexts.statusFromCancelled(context));
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        m.b(this.stream != null, "Not started");
        m.b(!this.cancelCalled, "call was cancelled");
        m.b(!this.halfCloseCalled, "call already half-closed");
        this.halfCloseCalled = true;
        this.stream.halfClose();
    }

    @Override // io.grpc.ClientCall
    public boolean isReady() {
        return this.stream.isReady();
    }

    @Override // io.grpc.ClientCall
    public void request(int i) {
        m.b(this.stream != null, "Not started");
        m.a(i >= 0, "Number requested must be non-negative");
        this.stream.request(i);
    }

    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT reqt) {
        m.b(this.stream != null, "Not started");
        m.b(!this.cancelCalled, "call was cancelled");
        m.b(!this.halfCloseCalled, "call was half-closed");
        try {
            this.stream.writeMessage(this.method.streamRequest(reqt));
            if (this.unaryRequest) {
                return;
            }
            this.stream.flush();
        } catch (Throwable th) {
            this.stream.cancel(Status.CANCELLED.withCause(th).withDescription("Failed to stream message"));
        }
    }

    ClientCallImpl<ReqT, RespT> setCompressorRegistry(CompressorRegistry compressorRegistry) {
        this.compressorRegistry = compressorRegistry;
        return this;
    }

    ClientCallImpl<ReqT, RespT> setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        this.decompressorRegistry = decompressorRegistry;
        return this;
    }

    @Override // io.grpc.ClientCall
    public void setMessageCompression(boolean z) {
        m.b(this.stream != null, "Not started");
        this.stream.setMessageCompression(z);
    }

    @Override // io.grpc.ClientCall
    public void start(final ClientCall.Listener<RespT> listener, Metadata metadata) {
        Compressor compressorLookupCompressor;
        m.b(this.stream == null, "Already started");
        m.a(listener, "observer");
        m.a(metadata, "headers");
        if (this.context.isCancelled()) {
            this.stream = NoopClientStream.INSTANCE;
            this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.1ClosedByContext
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ClientCallImpl.this.context);
                }

                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    listener.onClose(Contexts.statusFromCancelled(ClientCallImpl.this.context), new Metadata());
                }
            });
            return;
        }
        final String compressor = this.callOptions.getCompressor();
        if (compressor != null) {
            compressorLookupCompressor = this.compressorRegistry.lookupCompressor(compressor);
            if (compressorLookupCompressor == null) {
                this.stream = NoopClientStream.INSTANCE;
                this.callExecutor.execute(new ContextRunnable() { // from class: io.grpc.internal.ClientCallImpl.1ClosedByNotFoundCompressor
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(ClientCallImpl.this.context);
                    }

                    @Override // io.grpc.internal.ContextRunnable
                    public void runInContext() {
                        listener.onClose(Status.INTERNAL.withDescription(String.format("Unable to find compressor by name %s", compressor)), new Metadata());
                    }
                });
                return;
            }
        } else {
            compressorLookupCompressor = Codec.Identity.NONE;
        }
        prepareHeaders(metadata, this.decompressorRegistry, compressorLookupCompressor);
        Deadline deadlineEffectiveDeadline = effectiveDeadline();
        if (deadlineEffectiveDeadline != null && deadlineEffectiveDeadline.isExpired()) {
            this.stream = new FailingClientStream(Status.DEADLINE_EXCEEDED);
        } else {
            updateTimeoutHeaders(deadlineEffectiveDeadline, this.callOptions.getDeadline(), this.context.getDeadline(), metadata);
            this.stream = this.clientTransportProvider.get(this.callOptions).newStream(this.method, metadata, this.callOptions);
        }
        if (this.callOptions.getAuthority() != null) {
            this.stream.setAuthority(this.callOptions.getAuthority());
        }
        this.stream.setCompressor(compressorLookupCompressor);
        this.stream.start(new ClientStreamListenerImpl(listener));
        this.context.addListener(this, MoreExecutors.a());
        if (deadlineEffectiveDeadline != null && this.context.getDeadline() != deadlineEffectiveDeadline) {
            this.deadlineCancellationFuture = startDeadlineTimer(deadlineEffectiveDeadline);
        }
        if (this.cancelListenersShouldBeRemoved) {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }
}
