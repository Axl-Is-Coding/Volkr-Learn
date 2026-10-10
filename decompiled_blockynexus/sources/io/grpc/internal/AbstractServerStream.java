package io.grpc.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.m;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream2;
import io.grpc.internal.MessageFramer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractServerStream extends AbstractStream2 implements MessageFramer.Sink, ServerStream {
    private final MessageFramer framer;
    private boolean headersSent;
    private boolean outboundClosed;

    protected interface Sink {
        void cancel(Status status);

        void request(int i);

        void writeFrame(WritableBuffer writableBuffer, boolean z);

        void writeHeaders(Metadata metadata);

        void writeTrailers(Metadata metadata, boolean z);
    }

    protected static abstract class TransportState extends AbstractStream2.TransportState {
        private ServerStreamListener listener;
        private boolean listenerClosed;

        protected TransportState(int i) {
            super(i);
        }

        private void closeListener(Status status) {
            if (this.listenerClosed) {
                return;
            }
            this.listenerClosed = true;
            closeDeframer();
            listener().closed(status);
        }

        public void complete() {
            closeListener(Status.OK);
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deliveryStalled() {
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void endOfStream() {
            closeDeframer();
            listener().halfClosed();
        }

        public void inboundDataReceived(ReadableBuffer readableBuffer, boolean z) {
            deframe(readableBuffer, z);
        }

        public final void setListener(ServerStreamListener serverStreamListener) {
            m.a(serverStreamListener);
            this.listener = serverStreamListener;
            onStreamAllocated();
        }

        public final void transportReportStatus(Status status) {
            m.a(!status.isOk(), "status must not be OK");
            closeListener(status);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.AbstractStream2.TransportState
        public ServerStreamListener listener() {
            return this.listener;
        }
    }

    protected AbstractServerStream(WritableBufferAllocator writableBufferAllocator) {
        this.framer = new MessageFramer(this, writableBufferAllocator);
    }

    private void addStatusToTrailers(Metadata metadata, Status status) {
        metadata.removeAll(Status.CODE_KEY);
        metadata.removeAll(Status.MESSAGE_KEY);
        metadata.put(Status.CODE_KEY, status);
        if (status.getDescription() != null) {
            metadata.put(Status.MESSAGE_KEY, status.getDescription());
        }
    }

    protected abstract Sink abstractServerStreamSink();

    @Override // io.grpc.internal.ServerStream
    public Attributes attributes() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ServerStream
    public final void cancel(Status status) {
        abstractServerStreamSink().cancel(status);
    }

    @Override // io.grpc.internal.ServerStream
    public final void close(Status status, Metadata metadata) {
        m.a(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        m.a(metadata, GrpcUtil.TE_TRAILERS);
        if (this.outboundClosed) {
            return;
        }
        this.outboundClosed = true;
        endOfMessages();
        addStatusToTrailers(metadata, status);
        abstractServerStreamSink().writeTrailers(metadata, this.headersSent);
    }

    @Override // io.grpc.internal.MessageFramer.Sink
    public final void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2) {
        Sink sinkAbstractServerStreamSink = abstractServerStreamSink();
        if (z) {
            z2 = false;
        }
        sinkAbstractServerStreamSink.writeFrame(writableBuffer, z2);
    }

    @Override // io.grpc.internal.AbstractStream2
    protected final MessageFramer framer() {
        return this.framer;
    }

    @Override // io.grpc.internal.Stream
    public final void request(int i) {
        abstractServerStreamSink().request(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractStream2
    public abstract TransportState transportState();

    @Override // io.grpc.internal.ServerStream
    public final void writeHeaders(Metadata metadata) {
        m.a(metadata, "headers");
        this.headersSent = true;
        abstractServerStreamSink().writeHeaders(metadata);
    }
}
