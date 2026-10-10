package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.m;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.MessageFramer;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractStream<IdT> implements Stream {
    public static final int DEFAULT_ONREADY_THRESHOLD = 32768;
    private boolean allocated;
    private final MessageDeframer deframer;
    private final MessageFramer framer;
    private Phase inboundPhase;
    private int numSentBytesQueued;
    private final Object onReadyLock;
    private int onReadyThreshold;
    private Phase outboundPhase;

    class DeframerListener implements MessageDeframer.Listener {
        DeframerListener() {
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void bytesRead(int i) {
            AbstractStream.this.returnProcessedBytes(i);
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deliveryStalled() {
            AbstractStream.this.inboundDeliveryPaused();
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void endOfStream() {
            AbstractStream.this.remoteEndClosed();
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void messageRead(InputStream inputStream) {
            AbstractStream.this.receiveMessage(inputStream);
        }
    }

    class FramerSink implements MessageFramer.Sink {
        FramerSink() {
        }

        @Override // io.grpc.internal.MessageFramer.Sink
        public void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2) {
            AbstractStream.this.internalSendFrame(writableBuffer, z, z2);
        }
    }

    protected enum Phase {
        HEADERS,
        MESSAGE,
        STATUS
    }

    AbstractStream(WritableBufferAllocator writableBufferAllocator, int i) {
        Phase phase = Phase.HEADERS;
        this.inboundPhase = phase;
        this.outboundPhase = phase;
        this.onReadyThreshold = 32768;
        this.onReadyLock = new Object();
        this.framer = new MessageFramer(new FramerSink(), writableBufferAllocator);
        this.deframer = new MessageDeframer(new DeframerListener(), Codec.Identity.NONE, i);
    }

    public boolean canReceive() {
        return inboundPhase() != Phase.STATUS;
    }

    public boolean canSend() {
        return outboundPhase() != Phase.STATUS;
    }

    protected final void closeDeframer() {
        this.deframer.close();
    }

    final void closeFramer() {
        if (this.framer.isClosed()) {
            return;
        }
        this.framer.close();
    }

    protected final void deframe(ReadableBuffer readableBuffer, boolean z) {
        try {
            this.deframer.deframe(readableBuffer, z);
        } catch (Throwable th) {
            deframeFailed(th);
        }
    }

    protected abstract void deframeFailed(Throwable th);

    public void dispose() {
        this.framer.dispose();
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        if (this.framer.isClosed()) {
            return;
        }
        this.framer.flush();
    }

    public int getOnReadyThreshold() {
        int i;
        synchronized (this.onReadyLock) {
            i = this.onReadyThreshold;
        }
        return i;
    }

    public abstract IdT id();

    protected abstract void inboundDeliveryPaused();

    final Phase inboundPhase() {
        return this.inboundPhase;
    }

    protected abstract void internalSendFrame(WritableBuffer writableBuffer, boolean z, boolean z2);

    public boolean isClosed() {
        return inboundPhase() == Phase.STATUS && outboundPhase() == Phase.STATUS;
    }

    protected final boolean isDeframerStalled() {
        return this.deframer.isStalled();
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        boolean z = false;
        if (listener() == null || outboundPhase() == Phase.STATUS) {
            return false;
        }
        synchronized (this.onReadyLock) {
            if (this.allocated && this.numSentBytesQueued < this.onReadyThreshold) {
                z = true;
            }
        }
        return z;
    }

    protected abstract StreamListener listener();

    final void notifyIfReady() {
        boolean zIsReady;
        synchronized (this.onReadyLock) {
            zIsReady = isReady();
        }
        if (zIsReady) {
            listener().onReady();
        }
    }

    protected final void onSendingBytes(int i) {
        synchronized (this.onReadyLock) {
            this.numSentBytesQueued += i;
        }
    }

    protected final void onSentBytes(int i) {
        boolean z;
        synchronized (this.onReadyLock) {
            z = true;
            boolean z2 = this.numSentBytesQueued < this.onReadyThreshold;
            this.numSentBytesQueued -= i;
            boolean z3 = this.numSentBytesQueued < this.onReadyThreshold;
            if (z2 || !z3) {
                z = false;
            }
        }
        if (z) {
            notifyIfReady();
        }
    }

    protected final void onStreamAllocated() {
        m.b(listener() != null);
        synchronized (this.onReadyLock) {
            m.b(this.allocated ? false : true, "Already allocated");
            this.allocated = true;
        }
        notifyIfReady();
    }

    final Phase outboundPhase() {
        return this.outboundPhase;
    }

    protected abstract void receiveMessage(InputStream inputStream);

    protected abstract void remoteEndClosed();

    protected final void requestMessagesFromDeframer(int i) {
        try {
            this.deframer.request(i);
        } catch (Throwable th) {
            deframeFailed(th);
        }
    }

    protected abstract void returnProcessedBytes(int i);

    @Override // io.grpc.internal.Stream
    public final void setCompressor(Compressor compressor) {
        MessageFramer messageFramer = this.framer;
        m.a(compressor, "compressor");
        messageFramer.setCompressor(compressor);
    }

    @Override // io.grpc.internal.Stream
    public final void setDecompressor(Decompressor decompressor) {
        MessageDeframer messageDeframer = this.deframer;
        m.a(decompressor, "decompressor");
        messageDeframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(boolean z) {
        this.framer.setMessageCompression(z);
    }

    public String toString() {
        return toStringHelper().toString();
    }

    protected j.a toStringHelper() {
        j.a aVarA = j.a(this);
        aVarA.a("id", id());
        aVarA.a("inboundPhase", inboundPhase().name());
        aVarA.a("outboundPhase", outboundPhase().name());
        return aVarA;
    }

    Phase verifyNextPhase(Phase phase, Phase phase2) {
        if (phase2.ordinal() >= phase.ordinal()) {
            return phase2;
        }
        throw new IllegalStateException(String.format("Cannot transition phase from %s to %s", phase, phase2));
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(InputStream inputStream) {
        m.a(inputStream);
        outboundPhase(Phase.MESSAGE);
        if (this.framer.isClosed()) {
            return;
        }
        this.framer.writePayload(inputStream);
    }

    final Phase inboundPhase(Phase phase) {
        Phase phase2 = this.inboundPhase;
        this.inboundPhase = verifyNextPhase(phase2, phase);
        return phase2;
    }

    final Phase outboundPhase(Phase phase) {
        Phase phase2 = this.outboundPhase;
        this.outboundPhase = verifyNextPhase(phase2, phase);
        return phase2;
    }

    AbstractStream(MessageFramer messageFramer, MessageDeframer messageDeframer) {
        Phase phase = Phase.HEADERS;
        this.inboundPhase = phase;
        this.outboundPhase = phase;
        this.onReadyThreshold = 32768;
        this.onReadyLock = new Object();
        this.framer = messageFramer;
        this.deframer = messageDeframer;
    }
}
