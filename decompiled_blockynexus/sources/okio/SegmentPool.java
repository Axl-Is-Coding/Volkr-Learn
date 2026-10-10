package okio;

import kotlin.jvm.internal.i;
import kotlin.l;

/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SegmentPool {
    public static final SegmentPool INSTANCE = new SegmentPool();
    public static final long MAX_SIZE = 65536;
    private static long byteCount;
    private static Segment next;

    private SegmentPool() {
    }

    public final long getByteCount() {
        return byteCount;
    }

    public final Segment getNext() {
        return next;
    }

    public final void recycle(Segment segment) {
        i.b(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.shared) {
            return;
        }
        synchronized (this) {
            long j = 8192;
            if (byteCount + j > 65536) {
                return;
            }
            byteCount += j;
            segment.next = next;
            segment.limit = 0;
            segment.pos = segment.limit;
            next = segment;
            l lVar = l.f22855a;
        }
    }

    public final void setByteCount(long j) {
        byteCount = j;
    }

    public final void setNext(Segment segment) {
        next = segment;
    }

    public final Segment take() {
        synchronized (this) {
            Segment segment = next;
            if (segment == null) {
                return new Segment();
            }
            next = segment.next;
            segment.next = null;
            byteCount -= (long) 8192;
            return segment;
        }
    }
}
