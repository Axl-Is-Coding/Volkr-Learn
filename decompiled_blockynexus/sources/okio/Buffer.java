package okio;

import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.umeng.analytics.pro.ci;
import io.rong.common.dlog.DLog;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.TypeCastException;
import kotlin.collections.C2933d;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.text.c;
import okio.internal.BufferKt;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {
    public Segment head;
    private long size;

    /* JADX INFO: compiled from: Buffer.kt */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (!(i > 0)) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
            }
            if (!(i <= 8192)) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long size = buffer.size();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i);
            int i2 = 8192 - segmentWritableSegment$okio.limit;
            segmentWritableSegment$okio.limit = 8192;
            long j = i2;
            buffer.setSize$okio(size + j);
            this.segment = segmentWritableSegment$okio;
            this.offset = size;
            this.data = segmentWritableSegment$okio.data;
            this.start = 8192 - i2;
            this.end = 8192;
            return j;
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                i.a();
                throw null;
            }
            if (!(j != buffer.size())) {
                throw new IllegalStateException("no more bytes");
            }
            long j2 = this.offset;
            return seek(j2 == -1 ? 0L : j2 + ((long) (this.end - this.start)));
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long size = buffer.size();
            int i = 1;
            if (j <= size) {
                if (!(j >= 0)) {
                    throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                }
                long j2 = size - j;
                while (true) {
                    if (j2 <= 0) {
                        break;
                    }
                    Segment segment = buffer.head;
                    if (segment == null) {
                        i.a();
                        throw null;
                    }
                    Segment segment2 = segment.prev;
                    if (segment2 == null) {
                        i.a();
                        throw null;
                    }
                    int i2 = segment2.limit;
                    long j3 = i2 - segment2.pos;
                    if (j3 > j2) {
                        segment2.limit = i2 - ((int) j2);
                        break;
                    }
                    buffer.head = segment2.pop();
                    SegmentPool.INSTANCE.recycle(segment2);
                    j2 -= j3;
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > size) {
                long j4 = j - size;
                boolean z = true;
                while (j4 > 0) {
                    Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i);
                    int iMin = (int) Math.min(j4, 8192 - segmentWritableSegment$okio.limit);
                    segmentWritableSegment$okio.limit += iMin;
                    j4 -= (long) iMin;
                    if (z) {
                        this.segment = segmentWritableSegment$okio;
                        this.offset = size;
                        this.data = segmentWritableSegment$okio.data;
                        int i3 = segmentWritableSegment$okio.limit;
                        this.start = i3 - iMin;
                        this.end = i3;
                        z = false;
                    }
                    i = 1;
                }
            }
            buffer.setSize$okio(j);
            return size;
        }

        public final int seek(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j < -1 || j > buffer.size()) {
                m mVar = m.f22853a;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(buffer.size())};
                String str = String.format("offset=%s > size=%s", Arrays.copyOf(objArr, objArr.length));
                i.a((Object) str, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(str);
            }
            if (j == -1 || j == buffer.size()) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long j2 = 0;
            long size = buffer.size();
            Segment segment = buffer.head;
            Segment segmentPush = this.segment;
            if (segmentPush != null) {
                long j3 = this.offset;
                int i = this.start;
                if (segmentPush == null) {
                    i.a();
                    throw null;
                }
                long j4 = j3 - ((long) (i - segmentPush.pos));
                if (j4 > j) {
                    size = j4;
                    segmentPush = segment;
                    segment = segmentPush;
                } else {
                    j2 = j4;
                }
            } else {
                segmentPush = segment;
            }
            if (size - j > j - j2) {
                while (segmentPush != null) {
                    int i2 = segmentPush.limit;
                    int i3 = segmentPush.pos;
                    if (j >= ((long) (i2 - i3)) + j2) {
                        j2 += (long) (i2 - i3);
                        segmentPush = segmentPush.next;
                    }
                }
                i.a();
                throw null;
            }
            segmentPush = segment;
            j2 = size;
            while (j2 > j) {
                if (segmentPush == null) {
                    i.a();
                    throw null;
                }
                segmentPush = segmentPush.prev;
                if (segmentPush == null) {
                    i.a();
                    throw null;
                }
                j2 -= (long) (segmentPush.limit - segmentPush.pos);
            }
            if (this.readWrite) {
                if (segmentPush == null) {
                    i.a();
                    throw null;
                }
                if (segmentPush.shared) {
                    Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                    if (buffer.head == segmentPush) {
                        buffer.head = segmentUnsharedCopy;
                    }
                    segmentPush = segmentPush.push(segmentUnsharedCopy);
                    Segment segment2 = segmentPush.prev;
                    if (segment2 == null) {
                        i.a();
                        throw null;
                    }
                    segment2.pop();
                }
            }
            this.segment = segmentPush;
            this.offset = j;
            if (segmentPush == null) {
                i.a();
                throw null;
            }
            this.data = segmentPush.data;
            this.start = segmentPush.pos + ((int) (j - j2));
            this.end = segmentPush.limit;
            return this.end - this.start;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = buffer.size - j3;
        }
        return buffer.copyTo(outputStream, j3, j2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    private final ByteString digest(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i = segment.pos;
            messageDigest.update(bArr, i, segment.limit - i);
            Segment segment2 = segment.next;
            if (segment2 == null) {
                i.a();
                throw null;
            }
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i2 = segment2.pos;
                messageDigest.update(bArr2, i2, segment2.limit - i2);
                segment2 = segment2.next;
                if (segment2 == null) {
                    i.a();
                    throw null;
                }
            }
        }
        byte[] bArrDigest = messageDigest.digest();
        i.a((Object) bArrDigest, "messageDigest.digest()");
        return new ByteString(bArrDigest);
    }

    private final ByteString hmac(String str, ByteString byteString) throws NoSuchAlgorithmException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                Segment segment2 = segment.next;
                if (segment2 == null) {
                    i.a();
                    throw null;
                }
                while (segment2 != segment) {
                    mac.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    if (segment2 == null) {
                        i.a();
                        throw null;
                    }
                }
            }
            byte[] bArrDoFinal = mac.doFinal();
            i.a((Object) bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m125deprecated_getByte(long j) {
        return getByte(j);
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m126deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() throws EOFException {
        skip(size());
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            i.a();
            throw null;
        }
        int i = segment2.limit;
        if (i < 8192 && segment2.owner) {
            size -= (long) (i - segment2.pos);
        }
        return size;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0L, 0L, 6, (Object) null);
    }

    public final Buffer copyTo(OutputStream outputStream, long j) throws IOException {
        return copyTo$default(this, outputStream, j, 0L, 4, (Object) null);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        i.b(outputStream, "out");
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (segment != null) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                while (j2 > 0) {
                    if (segment == null) {
                        i.a();
                        throw null;
                    }
                    int i3 = (int) (((long) segment.pos) + j);
                    int iMin = (int) Math.min(segment.limit - i3, j2);
                    outputStream.write(segment.data, i3, iMin);
                    j2 -= (long) iMin;
                    segment = segment.next;
                    j = 0;
                }
                return this;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        i.a();
        throw null;
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            if (size() == buffer.size()) {
                if (size() == 0) {
                    return true;
                }
                Segment segment = this.head;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    i.a();
                    throw null;
                }
                int i = segment.pos;
                int i2 = segment2.pos;
                Segment segment3 = segment2;
                int i3 = i;
                int i4 = i2;
                long j = 0;
                while (j < size()) {
                    long jMin = Math.min(segment.limit - i3, segment3.limit - i4);
                    long j2 = 0;
                    while (j2 < jMin) {
                        int i5 = i3 + 1;
                        int i6 = i4 + 1;
                        if (segment.data[i3] == segment3.data[i4]) {
                            j2++;
                            i3 = i5;
                            i4 = i6;
                        }
                    }
                    if (i3 == segment.limit) {
                        Segment segment4 = segment.next;
                        if (segment4 == null) {
                            i.a();
                            throw null;
                        }
                        segment = segment4;
                        i3 = segment4.pos;
                    }
                    if (i4 == segment3.limit) {
                        Segment segment5 = segment3.next;
                        if (segment5 == null) {
                            i.a();
                            throw null;
                        }
                        i4 = segment5.pos;
                        segment3 = segment5;
                    }
                    j += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        Util.checkOffsetAndCount(size(), j, 1L);
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        if (size() - j < j) {
            long size = size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                size -= (long) (segment.limit - segment.pos);
            }
            if (segment != null) {
                return segment.data[(int) ((((long) segment.pos) + j) - size)];
            }
            i.a();
            throw null;
        }
        long j2 = 0;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            long j3 = ((long) (i - i2)) + j2;
            if (j3 > j) {
                if (segment != null) {
                    return segment.data[(int) ((((long) i2) + j) - j2)];
                }
                i.a();
                throw null;
            }
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
            j2 = j3;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
        } while (segment != this.head);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        i.b(byteString, "key");
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        i.b(byteString, "key");
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        i.b(byteString, "key");
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        i.b(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.inputStream.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                i.b(bArr, "sink");
                return Buffer.this.read(bArr, i, i2);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.outputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                i.b(bArr, "data");
                Buffer.this.write(bArr, i, i2);
            }
        };
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        i.b(byteString, "bytes");
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        i.b(byteBuffer, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        segment.pos += iMin;
        this.size -= (long) iMin;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return iMin;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        i.b(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        i.b(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b2 = segment.data[i];
        setSize$okio(size() - 1);
        if (i3 == i2) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b2;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7 A[EDGE_INSN: B:58:0x00c7->B:44:0x00c7 BREAK  A[LOOP:0: B:5:0x0012->B:60:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        i.b(inputStream, "input");
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        i.b(buffer, "sink");
        if (size() >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af A[EDGE_INSN: B:49:0x00af->B:39:0x00af BREAK  A[LOOP:0: B:5:0x000d->B:51:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lbe
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.Segment r6 = r15.head
            if (r6 == 0) goto Lb9
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L17:
            if (r8 >= r9) goto L99
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L28
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L28
            int r11 = r10 - r11
            goto L42
        L28:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L37
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L37
        L32:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L42
        L37:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7a
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7a
            goto L32
        L42:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L52
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L17
        L52:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7a:
            if (r0 == 0) goto L7e
            r1 = 1
            goto L99
        L7e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was "
            r1.append(r2)
            java.lang.String r2 = okio.Util.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L99:
            if (r8 != r9) goto La7
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool r7 = okio.SegmentPool.INSTANCE
            r7.recycle(r6)
            goto La9
        La7:
            r6.pos = r8
        La9:
            if (r1 != 0) goto Laf
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Ld
        Laf:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb9:
            kotlin.jvm.internal.i.a()
            r0 = 0
            throw r0
        Lbe:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            goto Lc5
        Lc4:
            throw r0
        Lc5:
            goto Lc4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        setSize$okio(size() - 4);
        if (i8 == i2) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i8;
        }
        return i9;
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 48);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        long j4 = ((((long) bArr[i5]) & 255) << 32) | j3;
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 8);
        int i10 = i9 + 1;
        long j8 = j7 | (((long) bArr[i9]) & 255);
        setSize$okio(size() - 8);
        if (i10 == i2) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i10;
        }
        return j8;
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        setSize$okio(size() - 2);
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        i.b(charset, HybridPlusWebView.CHARSET);
        return readString(this.size, charset);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        i.b(unsafeCursor, "unsafeCursor");
        if (!(unsafeCursor.buffer == null)) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, c.f22856a);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b2 = getByte(0L);
        if ((b2 & 128) == 0) {
            i = b2 & 127;
            i2 = 1;
            i3 = 0;
        } else if ((b2 & 224) == 192) {
            i = b2 & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b2 & 240) == 224) {
            i = b2 & ci.m;
            i2 = 3;
            i3 = DLog.CRS;
        } else {
            if ((b2 & 248) != 240) {
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = b2 & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (size() < j) {
            throw new EOFException("size < " + i2 + ": " + size() + " (to read code point prefixed " + Util.toHexString(b2) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b3 = getByte(j2);
            if ((b3 & 192) != 128) {
                skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
        }
        skip(j);
        return i > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i && 57343 >= i) || i < i3) ? Utf8.REPLACEMENT_CODE_POINT : i;
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) throws EOFException {
        i.b(options, "options");
        int iSelectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            setSize$okio(size() - j2);
            j -= j2;
            segment.pos += iMin;
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$okio(int i) {
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.INSTANCE.take();
            this.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        if (segment == null) {
            i.a();
            throw null;
        }
        Segment segment2 = segment.prev;
        if (segment2 != null) {
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.INSTANCE.take()) : segment2;
        }
        i.a();
        throw null;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        i.b(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(this, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0L, 2, null);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        i.b(outputStream, "out");
        Util.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        while (j > 0) {
            if (segment == null) {
                i.a();
                throw null;
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, iMin);
            segment.pos += iMin;
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            if (segment.pos == segment.limit) {
                Segment segmentPop = segment.pop();
                this.head = segmentPop;
                SegmentPool.INSTANCE.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        buffer.head = segment.sharedCopy();
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            i.a();
            throw null;
        }
        segment2.prev = segment2;
        if (segment2 == null) {
            i.a();
            throw null;
        }
        if (segment2 == null) {
            i.a();
            throw null;
        }
        segment2.next = segment2.prev;
        Segment segment3 = this.head;
        if (segment3 == null) {
            i.a();
            throw null;
        }
        for (Segment segment4 = segment3.next; segment4 != this.head; segment4 = segment4.next) {
            Segment segment5 = buffer.head;
            if (segment5 == null) {
                i.a();
                throw null;
            }
            Segment segment6 = segment5.prev;
            if (segment6 == null) {
                i.a();
                throw null;
            }
            if (segment4 == null) {
                i.a();
                throw null;
            }
            segment6.push(segment4.sharedCopy());
        }
        buffer.size = this.size;
        return buffer;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j) {
        return indexOf(b2, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        int i2;
        i.b(byteString, "targetBytes");
        long size = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j < j) {
            size = size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                size -= (long) (segment.limit - segment.pos);
            }
            if (segment == null) {
                return -1L;
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (size < size()) {
                    byte[] bArr = segment.data;
                    i = (int) ((((long) segment.pos) + j) - size);
                    int i3 = segment.limit;
                    while (i < i3) {
                        byte b4 = bArr[i];
                        if (b4 == b2 || b4 == b3) {
                            i2 = segment.pos;
                        } else {
                            i++;
                        }
                    }
                    j = ((long) (segment.limit - segment.pos)) + size;
                    segment = segment.next;
                    if (segment == null) {
                        i.a();
                        throw null;
                    }
                    size = j;
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = byteString.internalArray$okio();
            while (size < size()) {
                byte[] bArr2 = segment.data;
                i = (int) ((((long) segment.pos) + j) - size);
                int i4 = segment.limit;
                while (i < i4) {
                    byte b5 = bArr2[i];
                    for (byte b6 : bArrInternalArray$okio) {
                        if (b5 == b6) {
                            i2 = segment.pos;
                        }
                    }
                    i++;
                }
                j = ((long) (segment.limit - segment.pos)) + size;
                segment = segment.next;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                size = j;
            }
            return -1L;
        }
        while (true) {
            long j2 = ((long) (segment.limit - segment.pos)) + size;
            if (j2 > j) {
                if (segment == null) {
                    return -1L;
                }
                if (byteString.size() == 2) {
                    byte b7 = byteString.getByte(0);
                    byte b8 = byteString.getByte(1);
                    while (size < size()) {
                        byte[] bArr3 = segment.data;
                        i = (int) ((((long) segment.pos) + j) - size);
                        int i5 = segment.limit;
                        while (i < i5) {
                            byte b9 = bArr3[i];
                            if (b9 != b7 && b9 != b8) {
                                i++;
                            }
                        }
                        j = ((long) (segment.limit - segment.pos)) + size;
                        segment = segment.next;
                        if (segment == null) {
                            i.a();
                            throw null;
                        }
                        size = j;
                    }
                    return -1L;
                }
                byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
                while (size < size()) {
                    byte[] bArr4 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - size);
                    int i6 = segment.limit;
                    while (i < i6) {
                        byte b10 = bArr4[i];
                        for (byte b11 : bArrInternalArray$okio2) {
                            if (b10 != b11) {
                            }
                        }
                        i++;
                    }
                    j = ((long) (segment.limit - segment.pos)) + size;
                    segment = segment.next;
                    if (segment == null) {
                        i.a();
                        throw null;
                    }
                    size = j;
                }
                return -1L;
            }
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
            size = j2;
        }
        return ((long) (i - i2)) + size;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        i.b(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || size() - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        i.b(inputStream, "input");
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        i.b(charset, HybridPlusWebView.CHARSET);
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment.data, i, i2, charset);
        segment.pos += i2;
        this.size -= j;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, c.f22856a);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        byte b2 = (byte) 10;
        long jIndexOf = indexOf(b2, 0L, j2);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(this, jIndexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == ((byte) 13) && getByte(j2) == b2) {
            return BufferKt.readUtf8Line(this, j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment segmentWritableSegment$okio = writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i;
        setSize$okio(size() + ((long) i));
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        setSize$okio(size() + ((long) i));
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i5 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytes(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment segmentWritableSegment$okio = writableSegment$okio(8);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i = segmentWritableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        segmentWritableSegment$okio.limit = i8 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytes(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i3 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytes((short) i));
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            writeByte(63);
        } else if (i < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i3 = segmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i3 + 3;
            setSize$okio(size() + 3);
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Util.toHexString(i));
            }
            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i4 = segmentWritableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio3.limit = i4 + 4;
            setSize$okio(size() + 4);
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        i.b(byteString, "bytes");
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        i.b(str, "string");
        i.b(charset, HybridPlusWebView.CHARSET);
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        i.b(str, "string");
        return writeUtf8(str, 0, str.length());
    }

    private final void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int i = inputStream.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit));
            if (i == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            } else {
                segmentWritableSegment$okio.limit += i;
                long j2 = i;
                this.size += j2;
                j -= j2;
            }
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j, long j2) {
        Segment segment;
        int i;
        long j3 = j;
        long size = j2;
        long size2 = 0;
        if (!(0 <= j3 && size >= j3)) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j3 + " toIndex=" + size).toString());
        }
        if (size > size()) {
            size = size();
        }
        if (j3 != size && (segment = this.head) != null) {
            if (size() - j3 < j3) {
                size2 = size();
                while (size2 > j3) {
                    segment = segment.prev;
                    if (segment != null) {
                        size2 -= (long) (segment.limit - segment.pos);
                    } else {
                        i.a();
                        throw null;
                    }
                }
                if (segment != null) {
                    while (size2 < size) {
                        byte[] bArr = segment.data;
                        int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size) - size2);
                        i = (int) ((((long) segment.pos) + j3) - size2);
                        while (i < iMin) {
                            if (bArr[i] == b2) {
                                return ((long) (i - segment.pos)) + size2;
                            }
                            i++;
                        }
                        j3 = ((long) (segment.limit - segment.pos)) + size2;
                        segment = segment.next;
                        if (segment == null) {
                            i.a();
                            throw null;
                        }
                        size2 = j3;
                    }
                }
            } else {
                while (true) {
                    long j4 = ((long) (segment.limit - segment.pos)) + size2;
                    if (j4 <= j3) {
                        segment = segment.next;
                        if (segment == null) {
                            i.a();
                            throw null;
                        }
                        size2 = j4;
                    } else if (segment != null) {
                        while (size2 < size) {
                            byte[] bArr2 = segment.data;
                            int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size) - size2);
                            i = (int) ((((long) segment.pos) + j3) - size2);
                            while (i < iMin2) {
                                if (bArr2[i] != b2) {
                                    i++;
                                }
                            }
                            j3 = ((long) (segment.limit - segment.pos)) + size2;
                            segment = segment.next;
                            if (segment == null) {
                                i.a();
                                throw null;
                            }
                            size2 = j3;
                        }
                    }
                }
            }
        }
        return -1L;
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0L, i);
        int i2 = 0;
        Segment segment = this.head;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (segment != null) {
                int i5 = segment.limit;
                int i6 = segment.pos;
                if (i5 != i6) {
                    i3 += i5 - i6;
                    i4++;
                    segment = segment.next;
                } else {
                    throw new AssertionError("s.limit == s.pos");
                }
            } else {
                i.a();
                throw null;
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            if (segment2 != null) {
                bArr[i7] = segment2.data;
                i2 += segment2.limit - segment2.pos;
                iArr[i7] = Math.min(i2, i);
                iArr[bArr.length + i7] = segment2.pos;
                segment2.shared = true;
                i7++;
                segment2 = segment2.next;
            } else {
                i.a();
                throw null;
            }
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        i.b(str, "string");
        i.b(charset, HybridPlusWebView.CHARSET);
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 >= i) {
            if (i2 <= str.length()) {
                if (i.a(charset, c.f22856a)) {
                    return writeUtf8(str, i, i2);
                }
                String strSubstring = str.substring(i, i2);
                i.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (strSubstring != null) {
                    byte[] bytes = strSubstring.getBytes(charset);
                    i.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        i.b(str, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 >= i) {
            if (!(i2 <= str.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt < 128) {
                    Segment segmentWritableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = segmentWritableSegment$okio.data;
                    int i3 = segmentWritableSegment$okio.limit - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                    while (i4 < iMin) {
                        char cCharAt2 = str.charAt(i4);
                        if (cCharAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) cCharAt2;
                        i4++;
                    }
                    int i5 = segmentWritableSegment$okio.limit;
                    int i6 = (i3 + i4) - i5;
                    segmentWritableSegment$okio.limit = i5 + i6;
                    setSize$okio(size() + ((long) i6));
                    i = i4;
                } else {
                    if (cCharAt < 2048) {
                        Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = segmentWritableSegment$okio2.data;
                        int i7 = segmentWritableSegment$okio2.limit;
                        bArr2[i7] = (byte) ((cCharAt >> 6) | 192);
                        bArr2[i7 + 1] = (byte) ((cCharAt & '?') | 128);
                        segmentWritableSegment$okio2.limit = i7 + 2;
                        setSize$okio(size() + 2);
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i8 = i + 1;
                        char cCharAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                        if (cCharAt <= 56319 && 56320 <= cCharAt3 && 57343 >= cCharAt3) {
                            int i9 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = segmentWritableSegment$okio3.data;
                            int i10 = segmentWritableSegment$okio3.limit;
                            bArr3[i10] = (byte) ((i9 >> 18) | 240);
                            bArr3[i10 + 1] = (byte) (((i9 >> 12) & 63) | 128);
                            bArr3[i10 + 2] = (byte) (((i9 >> 6) & 63) | 128);
                            bArr3[i10 + 3] = (byte) ((i9 & 63) | 128);
                            segmentWritableSegment$okio3.limit = i10 + 4;
                            setSize$okio(size() + 4);
                            i += 2;
                        } else {
                            writeByte(63);
                            i = i8;
                        }
                    } else {
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i11 = segmentWritableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((cCharAt >> '\f') | 224);
                        bArr4[i11 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                        bArr4[i11 + 2] = (byte) ((cCharAt & '?') | 128);
                        segmentWritableSegment$okio4.limit = i11 + 3;
                        setSize$okio(size() + 3);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        i.b(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        i.b(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i, 8192 - segmentWritableSegment$okio.limit);
            byteBuffer.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        i.b(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        i.b(bArr, "sink");
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        C2933d.a(bArr2, bArr, i, i3, i3 + iMin);
        segment.pos += iMin;
        setSize$okio(size() - ((long) iMin));
        if (segment.pos != segment.limit) {
            return iMin;
        }
        this.head = segment.pop();
        SegmentPool.INSTANCE.recycle(segment);
        return iMin;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        i.b(byteString, "byteString");
        byteString.write$okio(this);
        return this;
    }

    public final Buffer copyTo(Buffer buffer, long j) {
        i.b(buffer, "out");
        return copyTo(buffer, j, this.size - j);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        i.b(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        i.b(buffer, "out");
        Util.checkOffsetAndCount(size(), j, j2);
        if (j2 != 0) {
            buffer.setSize$okio(buffer.size() + j2);
            Segment segment = this.head;
            while (segment != null) {
                int i = segment.limit;
                int i2 = segment.pos;
                if (j >= i - i2) {
                    j -= (long) (i - i2);
                    segment = segment.next;
                } else {
                    while (j2 > 0) {
                        if (segment != null) {
                            Segment segmentSharedCopy = segment.sharedCopy();
                            segmentSharedCopy.pos += (int) j;
                            segmentSharedCopy.limit = Math.min(segmentSharedCopy.pos + ((int) j2), segmentSharedCopy.limit);
                            Segment segment2 = buffer.head;
                            if (segment2 == null) {
                                segmentSharedCopy.prev = segmentSharedCopy;
                                segmentSharedCopy.next = segmentSharedCopy.prev;
                                buffer.head = segmentSharedCopy.next;
                            } else {
                                if (segment2 == null) {
                                    i.a();
                                    throw null;
                                }
                                Segment segment3 = segment2.prev;
                                if (segment3 == null) {
                                    i.a();
                                    throw null;
                                }
                                segment3.push(segmentSharedCopy);
                            }
                            j2 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                            segment = segment.next;
                            j = 0;
                        } else {
                            i.a();
                            throw null;
                        }
                    }
                }
            }
            i.a();
            throw null;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        i.b(bArr, "source");
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i3 - i, 8192 - segmentWritableSegment$okio.limit);
            int i4 = i + iMin;
            C2933d.a(bArr, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i, i4);
            segmentWritableSegment$okio.limit += iMin;
            i = i4;
        }
        setSize$okio(size() + j);
        return this;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        i.b(buffer, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j > size()) {
            j = size();
        }
        buffer.write(this, j);
        return j;
    }

    @Override // okio.BufferedSink
    public Buffer write(Source source, long j) throws IOException {
        i.b(source, "source");
        while (j > 0) {
            long j2 = source.read(this, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
        }
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        Segment segment;
        i.b(buffer, "source");
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size(), 0L, j);
            while (j > 0) {
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    i.a();
                    throw null;
                }
                int i = segment2.limit;
                if (segment2 != null) {
                    if (j < i - segment2.pos) {
                        Segment segment3 = this.head;
                        if (segment3 == null) {
                            segment = null;
                        } else {
                            if (segment3 == null) {
                                i.a();
                                throw null;
                            }
                            segment = segment3.prev;
                        }
                        if (segment != null && segment.owner) {
                            if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= 8192) {
                                Segment segment4 = buffer.head;
                                if (segment4 != null) {
                                    segment4.writeTo(segment, (int) j);
                                    buffer.setSize$okio(buffer.size() - j);
                                    setSize$okio(size() + j);
                                    return;
                                }
                                i.a();
                                throw null;
                            }
                        }
                        Segment segment5 = buffer.head;
                        if (segment5 == null) {
                            i.a();
                            throw null;
                        }
                        buffer.head = segment5.split((int) j);
                    }
                    Segment segment6 = buffer.head;
                    if (segment6 != null) {
                        long j2 = segment6.limit - segment6.pos;
                        buffer.head = segment6.pop();
                        Segment segment7 = this.head;
                        if (segment7 == null) {
                            this.head = segment6;
                            segment6.prev = segment6;
                            segment6.next = segment6.prev;
                        } else if (segment7 != null) {
                            Segment segment8 = segment7.prev;
                            if (segment8 != null) {
                                segment8.push(segment6).compact();
                            } else {
                                i.a();
                                throw null;
                            }
                        } else {
                            i.a();
                            throw null;
                        }
                        buffer.setSize$okio(buffer.size() - j2);
                        setSize$okio(size() + j2);
                        j -= j2;
                    } else {
                        i.a();
                        throw null;
                    }
                } else {
                    i.a();
                    throw null;
                }
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        long j2;
        long j3 = j;
        i.b(byteString, "bytes");
        if (!(byteString.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j4 = 0;
        if (j3 >= 0) {
            Segment segment = this.head;
            if (segment != null) {
                if (size() - j3 < j3) {
                    long size = size();
                    while (size > j3) {
                        segment = segment.prev;
                        if (segment != null) {
                            size -= (long) (segment.limit - segment.pos);
                        } else {
                            i.a();
                            throw null;
                        }
                    }
                    if (segment != null) {
                        byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                        byte b2 = bArrInternalArray$okio[0];
                        int size2 = byteString.size();
                        long size3 = (size() - ((long) size2)) + 1;
                        while (size < size3) {
                            byte[] bArr = segment.data;
                            long j5 = size;
                            int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - size);
                            for (int i = (int) ((((long) segment.pos) + j3) - j5); i < iMin; i++) {
                                if (bArr[i] == b2 && BufferKt.rangeEquals(segment, i + 1, bArrInternalArray$okio, 1, size2)) {
                                    j2 = ((long) (i - segment.pos)) + j5;
                                    return j2;
                                }
                            }
                            j3 = j5 + ((long) (segment.limit - segment.pos));
                            segment = segment.next;
                            if (segment == null) {
                                i.a();
                                throw null;
                            }
                            size = j3;
                        }
                    }
                } else {
                    while (true) {
                        long j6 = ((long) (segment.limit - segment.pos)) + j4;
                        if (j6 <= j3) {
                            segment = segment.next;
                            if (segment == null) {
                                i.a();
                                throw null;
                            }
                            j4 = j6;
                        } else if (segment != null) {
                            byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
                            byte b3 = bArrInternalArray$okio2[0];
                            int size4 = byteString.size();
                            long size5 = (size() - ((long) size4)) + 1;
                            while (j4 < size5) {
                                byte[] bArr2 = segment.data;
                                long j7 = size5;
                                int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - j4);
                                for (int i2 = (int) ((((long) segment.pos) + j3) - j4); i2 < iMin2; i2++) {
                                    if (bArr2[i2] == b3 && BufferKt.rangeEquals(segment, i2 + 1, bArrInternalArray$okio2, 1, size4)) {
                                        j2 = ((long) (i2 - segment.pos)) + j4;
                                    }
                                }
                                j3 = ((long) (segment.limit - segment.pos)) + j4;
                                segment = segment.next;
                                if (segment == null) {
                                    i.a();
                                    throw null;
                                }
                                j4 = j3;
                                size5 = j7;
                            }
                        }
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
    }
}
