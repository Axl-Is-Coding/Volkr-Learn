package okio.internal;

import com.umeng.analytics.pro.ci;
import io.rong.common.dlog.DLog;
import java.io.EOFException;
import java.io.IOException;
import kotlin.collections.C2933d;
import kotlin.jvm.a.c;
import kotlin.jvm.internal.i;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;

    public static final void commonClear(Buffer buffer) throws EOFException {
        i.b(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        i.b(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        Segment segment2 = segment.prev;
        if (segment2 != null) {
            int i = segment2.limit;
            return (i >= 8192 || !segment2.owner) ? size : size - ((long) (i - segment2.pos));
        }
        i.a();
        throw null;
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer buffer2, long j, long j2) {
        i.b(buffer, "$this$commonCopyTo");
        i.b(buffer2, "out");
        Util.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j2);
        Segment segment = buffer.head;
        while (segment != null) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                while (j2 > 0) {
                    if (segment == null) {
                        i.a();
                        throw null;
                    }
                    Segment segmentSharedCopy = segment.sharedCopy();
                    segmentSharedCopy.pos += (int) j;
                    segmentSharedCopy.limit = Math.min(segmentSharedCopy.pos + ((int) j2), segmentSharedCopy.limit);
                    Segment segment2 = buffer2.head;
                    if (segment2 == null) {
                        segmentSharedCopy.prev = segmentSharedCopy;
                        segmentSharedCopy.next = segmentSharedCopy.prev;
                        buffer2.head = segmentSharedCopy.next;
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
                }
                return buffer;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        i.a();
        throw null;
    }

    public static final boolean commonEquals(Buffer buffer, Object obj) {
        i.b(buffer, "$this$commonEquals");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer2 = (Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        long j = 0;
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        Segment segment2 = buffer2.head;
        if (segment2 == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment2.pos;
        long j2 = 0;
        while (j2 < buffer.size()) {
            long jMin = Math.min(segment.limit - i, segment2.limit - i2);
            long j3 = j;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                if (segment2 == null) {
                    i.a();
                    throw null;
                }
                i2 = segment2.pos;
            }
            j2 += jMin;
            j = 0;
        }
        return true;
    }

    public static final byte commonGet(Buffer buffer, long j) {
        i.b(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
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

    public static final int commonHashCode(Buffer buffer) {
        i.b(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
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
        } while (segment != buffer.head);
        return i;
    }

    public static final long commonIndexOf(Buffer buffer, byte b2, long j, long j2) {
        Segment segment;
        int i;
        i.b(buffer, "$this$commonIndexOf");
        long size = 0;
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > buffer.size()) {
            j2 = buffer.size();
        }
        if (j == j2 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j < j) {
            size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                size -= (long) (segment.limit - segment.pos);
            }
            if (segment != null) {
                while (size < j2) {
                    byte[] bArr = segment.data;
                    int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - size);
                    i = (int) ((((long) segment.pos) + j) - size);
                    while (i < iMin) {
                        if (bArr[i] != b2) {
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
            }
            return -1L;
        }
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + size;
            if (j3 > j) {
                if (segment != null) {
                    while (size < j2) {
                        byte[] bArr2 = segment.data;
                        int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j2) - size);
                        i = (int) ((((long) segment.pos) + j) - size);
                        while (i < iMin2) {
                            if (bArr2[i] != b2) {
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
                }
                return -1L;
            }
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
            size = j3;
        }
        return ((long) (i - segment.pos)) + size;
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString byteString, long j) {
        int i;
        int i2;
        i.b(buffer, "$this$commonIndexOfElement");
        i.b(byteString, "targetBytes");
        long size = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j < j) {
            size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                size -= (long) (segment.limit - segment.pos);
            }
            if (segment != null) {
                if (byteString.size() == 2) {
                    byte b2 = byteString.getByte(0);
                    byte b3 = byteString.getByte(1);
                    while (size < buffer.size()) {
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
                } else {
                    byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                    while (size < buffer.size()) {
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
                }
            }
            return -1L;
        }
        while (true) {
            long j2 = ((long) (segment.limit - segment.pos)) + size;
            if (j2 > j) {
                if (segment != null) {
                    if (byteString.size() == 2) {
                        byte b7 = byteString.getByte(0);
                        byte b8 = byteString.getByte(1);
                        while (size < buffer.size()) {
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
                    } else {
                        byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
                        while (size < buffer.size()) {
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
                    }
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
        i2 = segment.pos;
        return ((long) (i - i2)) + size;
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j, ByteString byteString, int i, int i2) {
        i.b(buffer, "$this$commonRangeEquals");
        i.b(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (buffer.getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(Buffer buffer, byte[] bArr) {
        i.b(buffer, "$this$commonRead");
        i.b(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) throws IOException {
        i.b(buffer, "$this$commonReadAll");
        i.b(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final byte commonReadByte(Buffer buffer) throws EOFException {
        i.b(buffer, "$this$commonReadByte");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b2 = segment.data[i];
        buffer.setSize$okio(buffer.size() - 1);
        if (i3 == i2) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b2;
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        i.b(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        i.b(buffer, "$this$commonReadByteString");
        return new ByteString(buffer.readByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc A[EDGE_INSN: B:58:0x00cc->B:44:0x00cc BREAK  A[LOOP:0: B:5:0x0017->B:60:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(okio.Buffer r17) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(Buffer buffer, byte[] bArr) throws EOFException {
        i.b(buffer, "$this$commonReadFully");
        i.b(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = buffer.read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b4 A[EDGE_INSN: B:49:0x00b4->B:39:0x00b4 BREAK  A[LOOP:0: B:5:0x0012->B:51:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(okio.Buffer r15) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(Buffer buffer) throws EOFException {
        i.b(buffer, "$this$commonReadInt");
        if (buffer.size() < 4) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        buffer.setSize$okio(buffer.size() - 4);
        if (i8 == i2) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i8;
        }
        return i9;
    }

    public static final long commonReadLong(Buffer buffer) throws EOFException {
        i.b(buffer, "$this$commonReadLong");
        if (buffer.size() < 8) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
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
        buffer.setSize$okio(buffer.size() - 8);
        if (i10 == i2) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i10;
        }
        return j8;
    }

    public static final short commonReadShort(Buffer buffer) throws EOFException {
        i.b(buffer, "$this$commonReadShort");
        if (buffer.size() < 2) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        buffer.setSize$okio(buffer.size() - 2);
        if (i4 == i2) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i5;
    }

    public static final String commonReadUtf8(Buffer buffer, long j) throws EOFException {
        i.b(buffer, "$this$commonReadUtf8");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
        }
        int i2 = (int) j;
        String strCommonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i, i + i2);
        segment.pos += i2;
        buffer.setSize$okio(buffer.size() - j);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return strCommonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) throws EOFException {
        int i;
        int i2;
        int i3;
        i.b(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        byte b2 = buffer.getByte(0L);
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
                buffer.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = b2 & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (buffer.size() < j) {
            throw new EOFException("size < " + i2 + ": " + buffer.size() + " (to read code point prefixed " + Util.toHexString(b2) + ')');
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b3 = buffer.getByte(j2);
            if ((b3 & 192) != 128) {
                buffer.skip(j2);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i = (i << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
        }
        buffer.skip(j);
        return i > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i && 57343 >= i) || i < i3) ? Utf8.REPLACEMENT_CODE_POINT : i;
    }

    public static final String commonReadUtf8Line(Buffer buffer) {
        i.b(buffer, "$this$commonReadUtf8Line");
        long jIndexOf = buffer.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(buffer, jIndexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j) throws EOFException {
        i.b(buffer, "$this$commonReadUtf8LineStrict");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        byte b2 = (byte) 10;
        long jIndexOf = buffer.indexOf(b2, 0L, j2);
        if (jIndexOf != -1) {
            return readUtf8Line(buffer, jIndexOf);
        }
        if (j2 < buffer.size() && buffer.getByte(j2 - 1) == ((byte) 13) && buffer.getByte(j2) == b2) {
            return readUtf8Line(buffer, j2);
        }
        Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j) + " content=" + buffer2.readByteString().hex() + (char) 8230);
    }

    public static final int commonSelect(Buffer buffer, Options options) throws EOFException {
        i.b(buffer, "$this$commonSelect");
        i.b(options, "options");
        int iSelectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public static final void commonSkip(Buffer buffer, long j) throws EOFException {
        i.b(buffer, "$this$commonSkip");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            buffer.setSize$okio(buffer.size() - j2);
            j -= j2;
            segment.pos += iMin;
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        i.b(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    public static final Segment commonWritableSegment(Buffer buffer, int i) {
        i.b(buffer, "$this$commonWritableSegment");
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.INSTANCE.take();
            buffer.head = segmentTake;
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

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString) {
        i.b(buffer, "$this$commonWrite");
        i.b(byteString, "byteString");
        byteString.write$okio(buffer);
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) throws IOException {
        i.b(buffer, "$this$commonWriteAll");
        i.b(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(buffer, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i) {
        i.b(buffer, "$this$commonWriteByte");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j) {
        i.b(buffer, "$this$commonWriteDecimalLong");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return buffer.writeUtf8("-9223372036854775808");
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
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = (byte) 45;
        }
        segmentWritableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + ((long) i));
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j) {
        i.b(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j == 0) {
            return buffer.writeByte(48);
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
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + ((long) i));
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i) {
        i.b(buffer, "$this$commonWriteInt");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(4);
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
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j) {
        i.b(buffer, "$this$commonWriteLong");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(8);
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
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i) {
        i.b(buffer, "$this$commonWriteShort");
        Segment segmentWritableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = segmentWritableSegment$okio.data;
        int i2 = segmentWritableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i3 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String str, int i, int i2) {
        i.b(buffer, "$this$commonWriteUtf8");
        i.b(str, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
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
                buffer.setSize$okio(buffer.size() + ((long) i6));
                i = i4;
            } else {
                if (cCharAt < 2048) {
                    Segment segmentWritableSegment$okio2 = buffer.writableSegment$okio(2);
                    byte[] bArr2 = segmentWritableSegment$okio2.data;
                    int i7 = segmentWritableSegment$okio2.limit;
                    bArr2[i7] = (byte) ((cCharAt >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio2.limit = i7 + 2;
                    buffer.setSize$okio(buffer.size() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    Segment segmentWritableSegment$okio3 = buffer.writableSegment$okio(3);
                    byte[] bArr3 = segmentWritableSegment$okio3.data;
                    int i8 = segmentWritableSegment$okio3.limit;
                    bArr3[i8] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt & '?') | 128);
                    segmentWritableSegment$okio3.limit = i8 + 3;
                    buffer.setSize$okio(buffer.size() + 3);
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        buffer.writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment segmentWritableSegment$okio4 = buffer.writableSegment$okio(4);
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        int i11 = segmentWritableSegment$okio4.limit;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        segmentWritableSegment$okio4.limit = i11 + 4;
                        buffer.setSize$okio(buffer.size() + 4);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return buffer;
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i) {
        i.b(buffer, "$this$commonWriteUtf8CodePoint");
        if (i < 128) {
            buffer.writeByte(i);
        } else if (i < 2048) {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = segmentWritableSegment$okio.data;
            int i2 = segmentWritableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i2 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            buffer.writeByte(63);
        } else if (i < 65536) {
            Segment segmentWritableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            int i3 = segmentWritableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i3 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Util.toHexString(i));
            }
            Segment segmentWritableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            int i4 = segmentWritableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio3.limit = i4 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        }
        return buffer;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i, byte[] bArr, int i2, int i3) {
        i.b(segment, "segment");
        i.b(bArr, "bytes");
        int i4 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                byte[] bArr3 = segment.data;
                bArr2 = bArr3;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j) throws EOFException {
        i.b(buffer, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == ((byte) 13)) {
                String utf8 = buffer.readUtf8(j2);
                buffer.skip(2L);
                return utf8;
            }
        }
        String utf82 = buffer.readUtf8(j);
        buffer.skip(1L);
        return utf82;
    }

    public static final <T> T seek(Buffer buffer, long j, c<? super Segment, ? super Long, ? extends T> cVar) {
        i.b(buffer, "$this$seek");
        i.b(cVar, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return cVar.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                size -= (long) (segment.limit - segment.pos);
            }
            return cVar.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > j) {
                return cVar.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
            j2 = j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r19 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int selectPrefix(okio.Buffer r17, okio.Options r18, boolean r19) {
        /*
            r0 = r17
            java.lang.String r1 = "$this$selectPrefix"
            kotlin.jvm.internal.i.b(r0, r1)
            java.lang.String r1 = "options"
            r2 = r18
            kotlin.jvm.internal.i.b(r2, r1)
            okio.Segment r0 = r0.head
            r1 = -2
            r3 = -1
            if (r0 == 0) goto Lb0
            byte[] r4 = r0.data
            int r5 = r0.pos
            int r6 = r0.limit
            int[] r2 = r18.getTrie$okio()
            r7 = 0
            r8 = r5
            r10 = r6
            r9 = -1
            r5 = r0
            r6 = r4
            r4 = 0
        L25:
            int r11 = r4 + 1
            r4 = r2[r4]
            int r12 = r11 + 1
            r11 = r2[r11]
            if (r11 == r3) goto L30
            r9 = r11
        L30:
            if (r5 != 0) goto L33
            goto L5e
        L33:
            r11 = 0
            if (r4 >= 0) goto L7c
            int r4 = r4 * (-1)
            int r13 = r12 + r4
        L3a:
            int r4 = r8 + 1
            r8 = r6[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r14 = r12 + 1
            r12 = r2[r12]
            if (r8 == r12) goto L47
            return r9
        L47:
            if (r14 != r13) goto L4b
            r8 = 1
            goto L4c
        L4b:
            r8 = 0
        L4c:
            if (r4 != r10) goto L73
            if (r5 == 0) goto L6f
            okio.Segment r4 = r5.next
            if (r4 == 0) goto L6b
            int r5 = r4.pos
            byte[] r6 = r4.data
            int r10 = r4.limit
            if (r4 != r0) goto L65
            if (r8 != 0) goto L62
        L5e:
            if (r19 == 0) goto L61
            return r1
        L61:
            return r9
        L62:
            r4 = r5
            r5 = r11
            goto L73
        L65:
            r16 = r5
            r5 = r4
            r4 = r16
            goto L73
        L6b:
            kotlin.jvm.internal.i.a()
            throw r11
        L6f:
            kotlin.jvm.internal.i.a()
            throw r11
        L73:
            if (r8 == 0) goto L79
            r8 = r2[r14]
            r13 = r4
            goto La6
        L79:
            r8 = r4
            r12 = r14
            goto L3a
        L7c:
            int r13 = r8 + 1
            r8 = r6[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r14 = r12 + r4
        L84:
            if (r12 != r14) goto L87
            return r9
        L87:
            r15 = r2[r12]
            if (r8 != r15) goto Lad
            int r12 = r12 + r4
            r8 = r2[r12]
            if (r13 != r10) goto La6
            okio.Segment r4 = r5.next
            if (r4 == 0) goto La2
            int r5 = r4.pos
            byte[] r6 = r4.data
            int r10 = r4.limit
            if (r4 != r0) goto L9f
            r13 = r5
            r5 = r11
            goto La6
        L9f:
            r13 = r5
            r5 = r4
            goto La6
        La2:
            kotlin.jvm.internal.i.a()
            throw r11
        La6:
            if (r8 < 0) goto La9
            return r8
        La9:
            int r4 = -r8
            r8 = r13
            goto L25
        Lad:
            int r12 = r12 + 1
            goto L84
        Lb0:
            if (r19 == 0) goto Lb3
            goto Lb4
        Lb3:
            r1 = -1
        Lb4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.selectPrefix(okio.Buffer, okio.Options, boolean):int");
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(Buffer buffer, byte[] bArr, int i, int i2) {
        i.b(buffer, "$this$commonRead");
        i.b(bArr, "sink");
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        C2933d.a(bArr2, bArr, i, i3, i3 + iMin);
        segment.pos += iMin;
        buffer.setSize$okio(buffer.size() - ((long) iMin));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return iMin;
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j) throws EOFException {
        i.b(buffer, "$this$commonReadByteArray");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (buffer.size() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        buffer.readFully(bArr);
        return bArr;
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j) {
        i.b(buffer, "$this$commonReadByteString");
        return new ByteString(buffer.readByteArray(j));
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr) {
        i.b(buffer, "$this$commonWrite");
        i.b(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] bArr, int i, int i2) {
        i.b(buffer, "$this$commonWrite");
        i.b(bArr, "source");
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int iMin = Math.min(i3 - i, 8192 - segmentWritableSegment$okio.limit);
            int i4 = i + iMin;
            C2933d.a(bArr, segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, i, i4);
            segmentWritableSegment$okio.limit += iMin;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final void commonReadFully(Buffer buffer, Buffer buffer2, long j) throws EOFException {
        i.b(buffer, "$this$commonReadFully");
        i.b(buffer2, "sink");
        if (buffer.size() >= j) {
            buffer2.write(buffer, j);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer, int i) {
        i.b(buffer, "$this$commonSnapshot");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0L, i);
        int i2 = 0;
        Segment segment = buffer.head;
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
        Segment segment2 = buffer.head;
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

    public static final Buffer commonWrite(Buffer buffer, Source source, long j) throws IOException {
        i.b(buffer, "$this$commonWrite");
        i.b(source, "source");
        while (j > 0) {
            long j2 = source.read(buffer, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
        }
        return buffer;
    }

    public static final long commonRead(Buffer buffer, Buffer buffer2, long j) {
        i.b(buffer, "$this$commonRead");
        i.b(buffer2, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j > buffer.size()) {
            j = buffer.size();
        }
        buffer2.write(buffer, j);
        return j;
    }

    public static final void commonWrite(Buffer buffer, Buffer buffer2, long j) {
        Segment segment;
        i.b(buffer, "$this$commonWrite");
        i.b(buffer2, "source");
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0L, j);
            while (j > 0) {
                Segment segment2 = buffer2.head;
                if (segment2 == null) {
                    i.a();
                    throw null;
                }
                int i = segment2.limit;
                if (segment2 != null) {
                    if (j < i - segment2.pos) {
                        Segment segment3 = buffer.head;
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
                                Segment segment4 = buffer2.head;
                                if (segment4 != null) {
                                    segment4.writeTo(segment, (int) j);
                                    buffer2.setSize$okio(buffer2.size() - j);
                                    buffer.setSize$okio(buffer.size() + j);
                                    return;
                                }
                                i.a();
                                throw null;
                            }
                        }
                        Segment segment5 = buffer2.head;
                        if (segment5 == null) {
                            i.a();
                            throw null;
                        }
                        buffer2.head = segment5.split((int) j);
                    }
                    Segment segment6 = buffer2.head;
                    if (segment6 != null) {
                        long j2 = segment6.limit - segment6.pos;
                        buffer2.head = segment6.pop();
                        Segment segment7 = buffer.head;
                        if (segment7 == null) {
                            buffer.head = segment6;
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
                        buffer2.setSize$okio(buffer2.size() - j2);
                        buffer.setSize$okio(buffer.size() + j2);
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

    public static final long commonIndexOf(Buffer buffer, ByteString byteString, long j) {
        long j2 = j;
        i.b(buffer, "$this$commonIndexOf");
        i.b(byteString, "bytes");
        if (!(byteString.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j2 < j2) {
            long size = buffer.size();
            while (size > j2) {
                segment = segment.prev;
                if (segment != null) {
                    size -= (long) (segment.limit - segment.pos);
                } else {
                    i.a();
                    throw null;
                }
            }
            if (segment == null) {
                return -1L;
            }
            byte[] bArrInternalArray$okio = byteString.internalArray$okio();
            byte b2 = bArrInternalArray$okio[0];
            int size2 = byteString.size();
            long size3 = (buffer.size() - ((long) size2)) + 1;
            while (size < size3) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + size3) - size);
                for (int i = (int) ((((long) segment.pos) + j2) - size); i < iMin; i++) {
                    if (bArr[i] == b2 && rangeEquals(segment, i + 1, bArrInternalArray$okio, 1, size2)) {
                        return ((long) (i - segment.pos)) + size;
                    }
                }
                long j4 = ((long) (segment.limit - segment.pos)) + size;
                segment = segment.next;
                if (segment == null) {
                    i.a();
                    throw null;
                }
                size = j4;
                j2 = size;
            }
            return -1L;
        }
        while (true) {
            long j5 = ((long) (segment.limit - segment.pos)) + j3;
            if (j5 > j2) {
                if (segment == null) {
                    return -1L;
                }
                byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
                byte b3 = bArrInternalArray$okio2[0];
                int size4 = byteString.size();
                long j6 = j3;
                long size5 = (buffer.size() - ((long) size4)) + 1;
                while (j6 < size5) {
                    byte[] bArr2 = segment.data;
                    int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + size5) - j6);
                    for (int i2 = (int) ((((long) segment.pos) + j2) - j6); i2 < iMin2; i2++) {
                        if (bArr2[i2] == b3 && rangeEquals(segment, i2 + 1, bArrInternalArray$okio2, 1, size4)) {
                            return ((long) (i2 - segment.pos)) + j6;
                        }
                    }
                    long j7 = j6 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    if (segment == null) {
                        i.a();
                        throw null;
                    }
                    j6 = j7;
                    j2 = j6;
                }
                return -1L;
            }
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
            j3 = j5;
        }
    }
}
