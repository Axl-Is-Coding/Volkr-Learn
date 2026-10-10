package io.grpc.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.j;
import com.google.common.base.m;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractClientStream<IdT> extends AbstractStream<IdT> implements ClientStream {
    private static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());
    private volatile boolean cancelled;
    private Runnable closeListenerTask;
    private ClientStreamListener listener;
    private boolean listenerClosed;
    private Status status;
    private Metadata trailers;

    protected AbstractClientStream(WritableBufferAllocator writableBufferAllocator, int i) {
        super(writableBufferAllocator, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeListener(Status status, Metadata metadata) {
        m.b(this.listener != null, "stream not started");
        if (this.listenerClosed) {
            return;
        }
        this.listenerClosed = true;
        closeDeframer();
        this.listener.closed(status, metadata);
    }

    private Runnable newCloseListenerTask(final Status status, final Metadata metadata) {
        return new Runnable() { // from class: io.grpc.internal.AbstractClientStream.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractClientStream.this.closeListener(status, metadata);
            }
        };
    }

    private void runCloseListenerTask() {
        Runnable runnable = this.closeListenerTask;
        if (runnable != null) {
            runnable.run();
            this.closeListenerTask = null;
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status status) {
        m.a(!status.isOk(), "Should not cancel with OK status");
        this.cancelled = true;
        sendCancel(status);
        dispose();
    }

    @Override // io.grpc.internal.AbstractStream
    protected final void deframeFailed(Throwable th) {
        cancel(Status.INTERNAL.withDescription("Exception deframing message").withCause(th));
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        if (outboundPhase(AbstractStream.Phase.STATUS) != AbstractStream.Phase.STATUS) {
            closeFramer();
        }
    }

    protected void inboundDataReceived(ReadableBuffer readableBuffer) throws Throwable {
        m.a(readableBuffer, "frame");
        boolean z = true;
        try {
            if (inboundPhase() == AbstractStream.Phase.STATUS) {
                readableBuffer.close();
                return;
            }
            if (inboundPhase() == AbstractStream.Phase.HEADERS) {
                inboundTransportError(Status.INTERNAL.withDescription("headers not received before payload"), new Metadata());
                readableBuffer.close();
                return;
            }
            inboundPhase(AbstractStream.Phase.MESSAGE);
            try {
                deframe(readableBuffer, false);
            } catch (Throwable th) {
                th = th;
                z = false;
                if (z) {
                    readableBuffer.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // io.grpc.internal.AbstractStream
    protected void inboundDeliveryPaused() {
        runCloseListenerTask();
    }

    protected void inboundHeadersReceived(Metadata metadata) {
        m.b(this.listener != null, "stream not started");
        if (inboundPhase() == AbstractStream.Phase.STATUS) {
            log.log(Level.INFO, "Received headers on closed stream {0} {1}", new Object[]{id(), metadata});
        }
        inboundPhase(AbstractStream.Phase.MESSAGE);
        this.listener.headersRead(metadata);
    }

    protected void inboundTrailersReceived(Metadata metadata, Status status) {
        m.a(metadata, GrpcUtil.TE_TRAILERS);
        if (inboundPhase() == AbstractStream.Phase.STATUS) {
            log.log(Level.INFO, "Received trailers on closed stream {0}\n {1}\n {2}", new Object[]{id(), status, metadata});
        }
        this.status = status;
        this.trailers = metadata;
        deframe(ReadableBuffers.empty(), true);
    }

    protected void inboundTransportError(Status status, Metadata metadata) {
        m.a(metadata, "metadata");
        if (inboundPhase() == AbstractStream.Phase.STATUS) {
            log.log(Level.INFO, "Received transport error on closed stream {0} {1}", new Object[]{id(), status});
        } else {
            transportReportStatus(status, false, metadata);
        }
    }

    @Override // io.grpc.internal.AbstractStream
    protected final void internalSendFrame(WritableBuffer writableBuffer, boolean z, boolean z2) {
        m.a(writableBuffer != null || z, "null frame before EOS");
        sendFrame(writableBuffer, z, z2);
    }

    @Override // io.grpc.internal.AbstractStream
    public boolean isClosed() {
        return super.isClosed() || this.listenerClosed;
    }

    @Override // io.grpc.internal.AbstractStream, io.grpc.internal.Stream
    public final boolean isReady() {
        return !this.cancelled && super.isReady();
    }

    @Override // io.grpc.internal.AbstractStream
    protected void receiveMessage(InputStream inputStream) {
        if (this.listenerClosed) {
            return;
        }
        m.b(this.listener != null, "stream not started");
        this.listener.messageRead(inputStream);
    }

    @Override // io.grpc.internal.AbstractStream
    protected void remoteEndClosed() {
        transportReportStatus(this.status, true, this.trailers);
    }

    protected abstract void sendCancel(Status status);

    protected abstract void sendFrame(WritableBuffer writableBuffer, boolean z, boolean z2);

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        m.b(this.listener == null, "stream already started");
        m.a(clientStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = clientStreamListener;
    }

    @Override // io.grpc.internal.AbstractStream
    protected j.a toStringHelper() {
        j.a stringHelper = super.toStringHelper();
        Status status = this.status;
        if (status != null) {
            stringHelper.a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, status);
        }
        return stringHelper;
    }

    public void transportReportStatus(Status status, boolean z, Metadata metadata) {
        m.a(status, "newStatus");
        boolean z2 = (this.closeListenerTask == null || z) ? false : true;
        if (this.listenerClosed || z2) {
            return;
        }
        inboundPhase(AbstractStream.Phase.STATUS);
        this.status = status;
        this.closeListenerTask = null;
        boolean zIsDeframerStalled = isDeframerStalled();
        if (z || zIsDeframerStalled) {
            closeListener(status, metadata);
        } else {
            this.closeListenerTask = newCloseListenerTask(status, metadata);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractStream
    public final ClientStreamListener listener() {
        return this.listener;
    }
}
