package okio;

import java.util.Arrays;
import kotlin.collections.C2933d;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    /* JADX INFO: compiled from: Segment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i = 0;
        if (!(this.prev != this)) {
            throw new IllegalStateException("cannot compact");
        }
        Segment segment = this.prev;
        if (segment == null) {
            i.a();
            throw null;
        }
        if (segment.owner) {
            int i2 = this.limit - this.pos;
            if (segment == null) {
                i.a();
                throw null;
            }
            int i3 = 8192 - segment.limit;
            if (segment == null) {
                i.a();
                throw null;
            }
            if (!segment.shared) {
                if (segment == null) {
                    i.a();
                    throw null;
                }
                i = segment.pos;
            }
            if (i2 > i3 + i) {
                return;
            }
            Segment segment2 = this.prev;
            if (segment2 == null) {
                i.a();
                throw null;
            }
            writeTo(segment2, i2);
            pop();
            SegmentPool.INSTANCE.recycle(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        if (segment2 == null) {
            i.a();
            throw null;
        }
        segment2.next = this.next;
        Segment segment3 = this.next;
        if (segment3 == null) {
            i.a();
            throw null;
        }
        segment3.prev = segment2;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        i.b(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        if (segment2 == null) {
            i.a();
            throw null;
        }
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i) {
        Segment segmentTake;
        if (!(i > 0 && i <= this.limit - this.pos)) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.INSTANCE.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segmentTake.data;
            int i2 = this.pos;
            C2933d.a(bArr, bArr2, 0, i2, i2 + i, 2, null);
        }
        segmentTake.limit = segmentTake.pos + i;
        this.pos += i;
        Segment segment = this.prev;
        if (segment != null) {
            segment.push(segmentTake);
            return segmentTake;
        }
        i.a();
        throw null;
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        i.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i) {
        i.b(segment, "sink");
        if (!segment.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i2 = segment.limit;
        if (i2 + i > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i3 = segment.pos;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            C2933d.a(bArr, bArr, 0, i3, i2, 2, null);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = segment.data;
        int i4 = segment.limit;
        int i5 = this.pos;
        C2933d.a(bArr2, bArr3, i4, i5, i5 + i);
        segment.limit += i;
        this.pos += i;
    }

    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        i.b(bArr, "data");
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }
}
