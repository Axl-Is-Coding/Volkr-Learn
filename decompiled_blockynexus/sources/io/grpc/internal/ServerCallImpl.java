package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.base.v;
import com.umeng.analytics.pro.b;
import io.grpc.Attributes;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
final class ServerCallImpl<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    private volatile boolean cancelled;
    private boolean closeCalled;
    private Compressor compressor;
    private final CompressorRegistry compressorRegistry;
    private final Context.CancellableContext context;
    private final DecompressorRegistry decompressorRegistry;
    private final String messageAcceptEncoding;
    private final MethodDescriptor<ReqT, RespT> method;
    private boolean sendHeadersCalled;
    private final ServerStream stream;

    static final class ServerStreamListenerImpl<ReqT> implements ServerStreamListener {
        private final ServerCallImpl<ReqT, ?> call;
        private final Context.CancellableContext context;
        private final ServerCall.Listener<ReqT> listener;
        private boolean messageReceived;

        public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> serverCallImpl, ServerCall.Listener<ReqT> listener, Context.CancellableContext cancellableContext) {
            m.a(serverCallImpl, "call");
            this.call = serverCallImpl;
            m.a(listener, "listener must not be null");
            this.listener = listener;
            m.a(cancellableContext, b.Q);
            this.context = cancellableContext;
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
            try {
                if (status.isOk()) {
                    this.listener.onComplete();
                } else {
                    ((ServerCallImpl) this.call).cancelled = true;
                    this.listener.onCancel();
                }
            } finally {
                this.context.cancel(null);
            }
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            if (((ServerCallImpl) this.call).cancelled) {
                return;
            }
            this.listener.onHalfClose();
        }

        @Override // io.grpc.internal.StreamListener
        public void messageRead(InputStream inputStream) throws Throwable {
            try {
                if (((ServerCallImpl) this.call).cancelled) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                } else {
                    if (this.messageReceived && ((ServerCallImpl) this.call).method.getType() == MethodDescriptor.MethodType.UNARY) {
                        ((ServerCallImpl) this.call).stream.close(Status.INTERNAL.withDescription("More than one request messages for unary call or server streaming call"), new Metadata());
                        try {
                            inputStream.close();
                            return;
                        } catch (IOException e3) {
                            throw new RuntimeException(e3);
                        }
                    }
                    this.messageReceived = true;
                    this.listener.onMessage((ReqT) ((ServerCallImpl) this.call).method.parseRequest(inputStream));
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        throw new RuntimeException(e4);
                    }
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    v.b(th);
                    throw new RuntimeException(th);
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (((ServerCallImpl) this.call).cancelled) {
                return;
            }
            this.listener.onReady();
        }
    }

    ServerCallImpl(ServerStream serverStream, MethodDescriptor<ReqT, RespT> methodDescriptor, Metadata metadata, Context.CancellableContext cancellableContext, DecompressorRegistry decompressorRegistry, CompressorRegistry compressorRegistry) {
        this.stream = serverStream;
        this.method = methodDescriptor;
        this.context = cancellableContext;
        this.messageAcceptEncoding = (String) metadata.get(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        this.decompressorRegistry = decompressorRegistry;
        this.compressorRegistry = compressorRegistry;
        if (metadata.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY)) {
            String str = (String) metadata.get(GrpcUtil.MESSAGE_ENCODING_KEY);
            Decompressor decompressorLookupDecompressor = decompressorRegistry.lookupDecompressor(str);
            if (decompressorLookupDecompressor == null) {
                throw Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", str)).asRuntimeException();
            }
            serverStream.setDecompressor(decompressorLookupDecompressor);
        }
    }

    @Override // io.grpc.ServerCall
    public Attributes attributes() {
        return this.stream.attributes();
    }

    @Override // io.grpc.ServerCall
    public void close(Status status, Metadata metadata) {
        m.b(!this.closeCalled, "call already closed");
        this.closeCalled = true;
        this.stream.close(status, metadata);
    }

    @Override // io.grpc.ServerCall
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.method;
    }

    @Override // io.grpc.ServerCall
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // io.grpc.ServerCall
    public boolean isReady() {
        return this.stream.isReady();
    }

    ServerStreamListener newServerStreamListener(ServerCall.Listener<ReqT> listener) {
        return new ServerStreamListenerImpl(this, listener, this.context);
    }

    @Override // io.grpc.ServerCall
    public void request(int i) {
        this.stream.request(i);
    }

    @Override // io.grpc.ServerCall
    public void sendHeaders(Metadata metadata) {
        String str;
        m.b(!this.sendHeadersCalled, "sendHeaders has already been called");
        m.b(!this.closeCalled, "call is closed");
        metadata.removeAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (this.compressor == null || (str = this.messageAcceptEncoding) == null || !GrpcUtil.ACCEPT_ENCODING_SPLITER.a(str).contains(this.compressor.getMessageEncoding())) {
            this.compressor = Codec.Identity.NONE;
        }
        metadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, this.compressor.getMessageEncoding());
        this.stream.setCompressor(this.compressor);
        metadata.removeAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        String rawAdvertisedMessageEncodings = this.decompressorRegistry.getRawAdvertisedMessageEncodings();
        if (!rawAdvertisedMessageEncodings.isEmpty()) {
            metadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, rawAdvertisedMessageEncodings);
        }
        this.sendHeadersCalled = true;
        this.stream.writeHeaders(metadata);
    }

    @Override // io.grpc.ServerCall
    public void sendMessage(RespT respt) {
        m.b(this.sendHeadersCalled, "sendHeaders has not been called");
        m.b(!this.closeCalled, "call is closed");
        try {
            this.stream.writeMessage(this.method.streamResponse(respt));
            this.stream.flush();
        } catch (RuntimeException e2) {
            close(Status.fromThrowable(e2), new Metadata());
            throw e2;
        } catch (Throwable th) {
            close(Status.fromThrowable(th), new Metadata());
            throw new RuntimeException(th);
        }
    }

    @Override // io.grpc.ServerCall
    public void setCompression(String str) {
        m.b(!this.sendHeadersCalled, "sendHeaders has been called");
        this.compressor = this.compressorRegistry.lookupCompressor(str);
        m.a(this.compressor != null, "Unable to find compressor by name %s", str);
    }

    @Override // io.grpc.ServerCall
    public void setMessageCompression(boolean z) {
        this.stream.setMessageCompression(z);
    }
}
