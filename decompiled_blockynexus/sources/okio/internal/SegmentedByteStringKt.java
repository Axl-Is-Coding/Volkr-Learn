package okio.internal;

import kotlin.collections.C2933d;
import kotlin.jvm.a.d;
import kotlin.jvm.internal.i;
import kotlin.l;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        i.b(iArr, "$this$binarySearch");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final boolean commonEquals(SegmentedByteString segmentedByteString, Object obj) {
        i.b(segmentedByteString, "$this$commonEquals");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(SegmentedByteString segmentedByteString) {
        i.b(segmentedByteString, "$this$commonGetSize");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(SegmentedByteString segmentedByteString) {
        i.b(segmentedByteString, "$this$commonHashCode");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            byte[] bArr = segmentedByteString.getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        segmentedByteString.setHashCode$okio(i2);
        return i2;
    }

    public static final byte commonInternalGet(SegmentedByteString segmentedByteString, int i) {
        i.b(segmentedByteString, "$this$commonInternalGet");
        Util.checkOffsetAndCount(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], i, 1L);
        int iSegment = segment(segmentedByteString, i);
        return segmentedByteString.getSegments$okio()[iSegment][(i - (iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1])) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment]];
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i, ByteString byteString, int i2, int i3) {
        i.b(segmentedByteString, "$this$commonRangeEquals");
        i.b(byteString, "other");
        if (i < 0 || i > segmentedByteString.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(segmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = segmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!byteString.rangeEquals(i2, segmentedByteString.getSegments$okio()[iSegment], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(SegmentedByteString segmentedByteString, int i, int i2) {
        i.b(segmentedByteString, "$this$commonSubstring");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (!(i2 <= segmentedByteString.size())) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " > length(" + segmentedByteString.size() + ')').toString());
        }
        int i3 = i2 - i;
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " < beginIndex=" + i).toString());
        }
        if (i == 0 && i2 == segmentedByteString.size()) {
            return segmentedByteString;
        }
        if (i == i2) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(segmentedByteString, i);
        int iSegment2 = segment(segmentedByteString, i2 - 1);
        byte[][] bArr = (byte[][]) C2933d.a(segmentedByteString.getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i4 = iSegment;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(segmentedByteString.getDirectory$okio()[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i4];
                if (i4 == iSegment2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = iSegment != 0 ? segmentedByteString.getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new SegmentedByteString(bArr, iArr);
    }

    public static final byte[] commonToByteArray(SegmentedByteString segmentedByteString) {
        i.b(segmentedByteString, "$this$commonToByteArray");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            int i6 = i5 - i2;
            C2933d.a(segmentedByteString.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(SegmentedByteString segmentedByteString, Buffer buffer) {
        i.b(segmentedByteString, "$this$commonWrite");
        i.b(buffer, "buffer");
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = segmentedByteString.getDirectory$okio()[length + i];
            int i4 = segmentedByteString.getDirectory$okio()[i];
            Segment segment = new Segment(segmentedByteString.getSegments$okio()[i], i3, i3 + (i4 - i2), true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment.prev;
                buffer.head = segment.next;
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
                segment3.push(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.setSize$okio(buffer.size() + ((long) segmentedByteString.size()));
    }

    public static final void forEachSegment(SegmentedByteString segmentedByteString, d<? super byte[], ? super Integer, ? super Integer, l> dVar) {
        i.b(segmentedByteString, "$this$forEachSegment");
        i.b(dVar, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = segmentedByteString.getDirectory$okio()[length + i];
            int i4 = segmentedByteString.getDirectory$okio()[i];
            dVar.a(segmentedByteString.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    public static final int segment(SegmentedByteString segmentedByteString, int i) {
        i.b(segmentedByteString, "$this$segment");
        int iBinarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i + 1, 0, segmentedByteString.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : iBinarySearch ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, d<? super byte[], ? super Integer, ? super Integer, l> dVar) {
        int iSegment = segment(segmentedByteString, i);
        while (i < i2) {
            int i3 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i4 = segmentedByteString.getDirectory$okio()[iSegment] - i3;
            int i5 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - i;
            dVar.a(segmentedByteString.getSegments$okio()[iSegment], Integer.valueOf(i5 + (i - i3)), Integer.valueOf(iMin));
            i += iMin;
            iSegment++;
        }
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i, byte[] bArr, int i2, int i3) {
        i.b(segmentedByteString, "$this$commonRangeEquals");
        i.b(bArr, "other");
        if (i < 0 || i > segmentedByteString.size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(segmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = segmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!Util.arrayRangeEquals(segmentedByteString.getSegments$okio()[iSegment], i7 + (i - i5), bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }
}
