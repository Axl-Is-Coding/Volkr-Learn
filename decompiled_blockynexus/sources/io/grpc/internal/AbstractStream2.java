package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.internal.MessageDeframer;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractStream2 implements Stream {
    protected final void endOfMessages() {
        framer().close();
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        if (framer().isClosed()) {
            return;
        }
        framer().flush();
    }

    protected abstract MessageFramer framer();

    @Override // io.grpc.internal.Stream
    public final boolean isReady() {
        if (framer().isClosed()) {
            return false;
        }
        return transportState().isReady();
    }

    protected final void onSendingBytes(int i) {
        transportState().onSendingBytes(i);
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(Compressor compressor) {
        MessageFramer messageFramerFramer = framer();
        m.a(compressor, "compressor");
        messageFramerFramer.setCompressor(compressor);
    }

    @Override // io.grpc.internal.Stream
    public final void setDecompressor(Decompressor decompressor) {
        TransportState transportState = transportState();
        m.a(decompressor, "decompressor");
        transportState.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(boolean z) {
        framer().setMessageCompression(z);
    }

    protected abstract TransportState transportState();

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        m.a(inputStream);
        if (framer().isClosed()) {
            return;
        }
        framer().writePayload(inputStream);
    }

    public static abstract class TransportState implements MessageDeframer.Listener {
        private static final int DEFAULT_ONREADY_THRESHOLD = 32768;
        private boolean allocated;
        private final MessageDeframer deframer;
        private int numSentBytesQueued;
        private final Object onReadyLock = new Object();

        protected TransportState(int i) {
            this.deframer = new MessageDeframer(this, Codec.Identity.NONE, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isReady() {
            boolean z;
            synchronized (this.onReadyLock) {
                z = this.allocated && this.numSentBytesQueued < 32768;
            }
            return z;
        }

        private void notifyIfReady() {
            boolean zIsReady;
            synchronized (this.onReadyLock) {
                zIsReady = isReady();
            }
            if (zIsReady) {
                listener().onReady();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendingBytes(int i) {
            synchronized (this.onReadyLock) {
                this.numSentBytesQueued += i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDecompressor(Decompressor decompressor) {
            if (this.deframer.isClosed()) {
                return;
            }
            this.deframer.setDecompressor(decompressor);
        }

        protected final void closeDeframer() {
            this.deframer.close();
        }

        protected final void deframe(ReadableBuffer readableBuffer, boolean z) {
            if (this.deframer.isClosed()) {
                readableBuffer.close();
                return;
            }
            try {
                this.deframer.deframe(readableBuffer, z);
            } catch (Throwable th) {
                deframeFailed(th);
            }
        }

        protected abstract void deframeFailed(Throwable th);

        protected abstract StreamListener listener();

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void messageRead(InputStream inputStream) {
            listener().messageRead(inputStream);
        }

        public final void onSentBytes(int i) {
            boolean z;
            synchronized (this.onReadyLock) {
                z = true;
                boolean z2 = this.numSentBytesQueued < 32768;
                this.numSentBytesQueued -= i;
                boolean z3 = this.numSentBytesQueued < 32768;
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

        public final void requestMessagesFromDeframer(int i) {
            if (this.deframer.isClosed()) {
                return;
            }
            try {
                this.deframer.request(i);
            } catch (Throwable th) {
                deframeFailed(th);
            }
        }

        TransportState(MessageDeframer messageDeframer) {
            this.deframer = messageDeframer;
        }
    }
}
