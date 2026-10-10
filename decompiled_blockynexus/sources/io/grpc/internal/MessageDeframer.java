package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.Codec;
import io.grpc.Decompressor;
import io.grpc.Status;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class MessageDeframer implements Closeable {
    private static final int COMPRESSED_FLAG_MASK = 1;
    private static final int HEADER_LENGTH = 5;
    private static final int RESERVED_MASK = 254;
    private boolean compressedFlag;
    private Decompressor decompressor;
    private boolean endOfStream;
    private final Listener listener;
    private final int maxMessageSize;
    private CompositeReadableBuffer nextFrame;
    private long pendingDeliveries;
    private State state = State.HEADER;
    private int requiredLength = 5;
    private CompositeReadableBuffer unprocessed = new CompositeReadableBuffer();
    private boolean deliveryStalled = true;
    private boolean inDelivery = false;

    /* JADX INFO: renamed from: io.grpc.internal.MessageDeframer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$internal$MessageDeframer$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$io$grpc$internal$MessageDeframer$State[State.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$internal$MessageDeframer$State[State.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface Listener {
        void bytesRead(int i);

        void deliveryStalled();

        void endOfStream();

        void messageRead(InputStream inputStream);
    }

    private enum State {
        HEADER,
        BODY
    }

    public MessageDeframer(Listener listener, Decompressor decompressor, int i) {
        m.a(listener, "sink");
        this.listener = listener;
        m.a(decompressor, "decompressor");
        this.decompressor = decompressor;
        this.maxMessageSize = i;
    }

    private void checkNotClosed() {
        m.b(!isClosed(), "MessageDeframer is already closed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r7.unprocessed.readableBytes() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r7.endOfStream == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        if (r2 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        if (r7.nextFrame == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        if (r7.nextFrame.readableBytes() <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        if (r0 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
    
        r7.listener.endOfStream();
        r7.deliveryStalled = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
    
        throw io.grpc.Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame").asRuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r0 = r7.deliveryStalled;
        r7.deliveryStalled = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r2 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        if (r0 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
    
        r7.listener.deliveryStalled();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void deliver() {
        /*
            r7 = this;
            boolean r0 = r7.inDelivery
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r7.inDelivery = r0
        L8:
            r1 = 0
            long r2 = r7.pendingDeliveries     // Catch: java.lang.Throwable -> L96
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L4e
            boolean r2 = r7.readRequiredBytes()     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L4e
            int[] r2 = io.grpc.internal.MessageDeframer.AnonymousClass1.$SwitchMap$io$grpc$internal$MessageDeframer$State     // Catch: java.lang.Throwable -> L96
            io.grpc.internal.MessageDeframer$State r3 = r7.state     // Catch: java.lang.Throwable -> L96
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L96
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L96
            if (r2 == r0) goto L4a
            r3 = 2
            if (r2 != r3) goto L31
            r7.processBody()     // Catch: java.lang.Throwable -> L96
            long r2 = r7.pendingDeliveries     // Catch: java.lang.Throwable -> L96
            r4 = 1
            long r2 = r2 - r4
            r7.pendingDeliveries = r2     // Catch: java.lang.Throwable -> L96
            goto L8
        L31:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L96
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r2.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = "Invalid state: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L96
            io.grpc.internal.MessageDeframer$State r3 = r7.state     // Catch: java.lang.Throwable -> L96
            r2.append(r3)     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L96
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L96
            throw r0     // Catch: java.lang.Throwable -> L96
        L4a:
            r7.processHeader()     // Catch: java.lang.Throwable -> L96
            goto L8
        L4e:
            io.grpc.internal.CompositeReadableBuffer r2 = r7.unprocessed     // Catch: java.lang.Throwable -> L96
            int r2 = r2.readableBytes()     // Catch: java.lang.Throwable -> L96
            if (r2 != 0) goto L58
            r2 = 1
            goto L59
        L58:
            r2 = 0
        L59:
            boolean r3 = r7.endOfStream     // Catch: java.lang.Throwable -> L96
            if (r3 == 0) goto L86
            if (r2 == 0) goto L86
            io.grpc.internal.CompositeReadableBuffer r2 = r7.nextFrame     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L6c
            io.grpc.internal.CompositeReadableBuffer r2 = r7.nextFrame     // Catch: java.lang.Throwable -> L96
            int r2 = r2.readableBytes()     // Catch: java.lang.Throwable -> L96
            if (r2 <= 0) goto L6c
            goto L6d
        L6c:
            r0 = 0
        L6d:
            if (r0 != 0) goto L79
            io.grpc.internal.MessageDeframer$Listener r0 = r7.listener     // Catch: java.lang.Throwable -> L96
            r0.endOfStream()     // Catch: java.lang.Throwable -> L96
            r7.deliveryStalled = r1     // Catch: java.lang.Throwable -> L96
            r7.inDelivery = r1
            return
        L79:
            io.grpc.Status r0 = io.grpc.Status.INTERNAL     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = "Encountered end-of-stream mid-frame"
            io.grpc.Status r0 = r0.withDescription(r2)     // Catch: java.lang.Throwable -> L96
            io.grpc.StatusRuntimeException r0 = r0.asRuntimeException()     // Catch: java.lang.Throwable -> L96
            throw r0     // Catch: java.lang.Throwable -> L96
        L86:
            boolean r0 = r7.deliveryStalled     // Catch: java.lang.Throwable -> L96
            r7.deliveryStalled = r2     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L93
            if (r0 != 0) goto L93
            io.grpc.internal.MessageDeframer$Listener r0 = r7.listener     // Catch: java.lang.Throwable -> L96
            r0.deliveryStalled()     // Catch: java.lang.Throwable -> L96
        L93:
            r7.inDelivery = r1
            return
        L96:
            r0 = move-exception
            r7.inDelivery = r1
            goto L9b
        L9a:
            throw r0
        L9b:
            goto L9a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.MessageDeframer.deliver():void");
    }

    private InputStream getCompressedBody() {
        Decompressor decompressor = this.decompressor;
        if (decompressor == Codec.Identity.NONE) {
            throw Status.INTERNAL.withDescription("Can't decode compressed frame as compression not configured.").asRuntimeException();
        }
        try {
            return new SizeEnforcingInputStream(decompressor.decompress(ReadableBuffers.openStream(this.nextFrame, true)), this.maxMessageSize);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private InputStream getUncompressedBody() {
        return ReadableBuffers.openStream(this.nextFrame, true);
    }

    private void processBody() {
        InputStream compressedBody = this.compressedFlag ? getCompressedBody() : getUncompressedBody();
        this.nextFrame = null;
        this.listener.messageRead(compressedBody);
        this.state = State.HEADER;
        this.requiredLength = 5;
    }

    private void processHeader() {
        int unsignedByte = this.nextFrame.readUnsignedByte();
        if ((unsignedByte & 254) != 0) {
            throw Status.INTERNAL.withDescription("Frame header malformed: reserved bits not zero").asRuntimeException();
        }
        this.compressedFlag = (unsignedByte & 1) != 0;
        this.requiredLength = this.nextFrame.readInt();
        int i = this.requiredLength;
        if (i < 0 || i > this.maxMessageSize) {
            throw Status.INTERNAL.withDescription(String.format("Frame size %d exceeds maximum: %d. If this is normal, increase the maxMessageSize in the channel/server builder", Integer.valueOf(this.requiredLength), Integer.valueOf(this.maxMessageSize))).asRuntimeException();
        }
        this.state = State.BODY;
    }

    private boolean readRequiredBytes() throws Throwable {
        Throwable th;
        int i;
        try {
            if (this.nextFrame == null) {
                this.nextFrame = new CompositeReadableBuffer();
            }
            i = 0;
            while (true) {
                try {
                    int i2 = this.requiredLength - this.nextFrame.readableBytes();
                    if (i2 <= 0) {
                        if (i > 0) {
                            this.listener.bytesRead(i);
                        }
                        return true;
                    }
                    if (this.unprocessed.readableBytes() == 0) {
                        if (i > 0) {
                            this.listener.bytesRead(i);
                        }
                        return false;
                    }
                    int iMin = Math.min(i2, this.unprocessed.readableBytes());
                    i += iMin;
                    this.nextFrame.addBuffer(this.unprocessed.readBytes(iMin));
                } catch (Throwable th2) {
                    th = th2;
                    if (i > 0) {
                        this.listener.bytesRead(i);
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.unprocessed != null) {
                this.unprocessed.close();
            }
            if (this.nextFrame != null) {
                this.nextFrame.close();
            }
        } finally {
            this.unprocessed = null;
            this.nextFrame = null;
        }
    }

    public void deframe(ReadableBuffer readableBuffer, boolean z) throws Throwable {
        m.a(readableBuffer, "data");
        boolean z2 = true;
        try {
            checkNotClosed();
            m.b(!this.endOfStream, "Past end of stream");
            this.unprocessed.addBuffer(readableBuffer);
            try {
                this.endOfStream = z;
                deliver();
            } catch (Throwable th) {
                th = th;
                z2 = false;
                if (z2) {
                    readableBuffer.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean isClosed() {
        return this.unprocessed == null;
    }

    public boolean isStalled() {
        return this.deliveryStalled;
    }

    public void request(int i) {
        m.a(i > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.pendingDeliveries += (long) i;
        deliver();
    }

    public void setDecompressor(Decompressor decompressor) {
        m.a(decompressor, "Can't pass an empty decompressor");
        this.decompressor = decompressor;
    }

    static final class SizeEnforcingInputStream extends FilterInputStream {
        private long count;
        private long mark;
        private final int maxMessageSize;

        SizeEnforcingInputStream(InputStream inputStream, int i) {
            super(inputStream);
            this.mark = -1L;
            this.maxMessageSize = i;
        }

        private void verifySize() {
            long j = this.count;
            int i = this.maxMessageSize;
            if (j > i) {
                throw Status.INTERNAL.withDescription(String.format("Compressed frame exceeds maximum frame size: %d. Bytes read: %d. If this is normal, increase the maxMessageSize in the channel/server builder", Integer.valueOf(i), Long.valueOf(this.count))).asRuntimeException();
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            ((FilterInputStream) this).in.mark(i);
            this.mark = this.count;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = ((FilterInputStream) this).in.read();
            if (i != -1) {
                this.count++;
            }
            verifySize();
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.count = this.mark;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j);
            this.count += jSkip;
            verifySize();
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (i3 != -1) {
                this.count += (long) i3;
            }
            verifySize();
            return i3;
        }
    }
}
