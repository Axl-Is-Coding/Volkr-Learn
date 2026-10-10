package okio;

import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: PeekSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        i.b(bufferedSource, "upstream");
        this.upstream = bufferedSource;
        this.buffer = this.upstream.getBuffer();
        Segment segment = this.buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.i.b(r9, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 < 0) goto Lf
            r4 = 1
            goto L10
        Lf:
            r4 = 0
        L10:
            if (r4 == 0) goto L8a
            boolean r4 = r8.closed
            r4 = r4 ^ r1
            if (r4 == 0) goto L82
            okio.Segment r4 = r8.expectedSegment
            r5 = 0
            if (r4 == 0) goto L2f
            okio.Buffer r6 = r8.buffer
            okio.Segment r6 = r6.head
            if (r4 != r6) goto L30
            int r4 = r8.expectedPos
            if (r6 == 0) goto L2b
            int r6 = r6.pos
            if (r4 != r6) goto L30
            goto L2f
        L2b:
            kotlin.jvm.internal.i.a()
            throw r5
        L2f:
            r0 = 1
        L30:
            if (r0 == 0) goto L7a
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 != 0) goto L37
            return r2
        L37:
            okio.BufferedSource r0 = r8.upstream
            long r1 = r8.pos
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L47
            r9 = -1
            return r9
        L47:
            okio.Segment r0 = r8.expectedSegment
            if (r0 != 0) goto L5e
            okio.Buffer r0 = r8.buffer
            okio.Segment r0 = r0.head
            if (r0 == 0) goto L5e
            r8.expectedSegment = r0
            if (r0 == 0) goto L5a
            int r0 = r0.pos
            r8.expectedPos = r0
            goto L5e
        L5a:
            kotlin.jvm.internal.i.a()
            throw r5
        L5e:
            okio.Buffer r0 = r8.buffer
            long r0 = r0.size()
            long r2 = r8.pos
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.buffer
            long r4 = r8.pos
            r3 = r9
            r6 = r10
            r2.copyTo(r3, r4, r6)
            long r0 = r8.pos
            long r0 = r0 + r10
            r8.pos = r0
            return r10
        L7a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L82:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L8a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
