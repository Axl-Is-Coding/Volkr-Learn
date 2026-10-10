package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        i.b(bufferedSource, "source");
        i.b(inflater, "inflater");
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    private final void releaseInflatedBytes() throws IOException {
        int i = this.bufferBytesHeldByInflater;
        if (i == 0) {
            return;
        }
        int remaining = i - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        boolean zRefill;
        i.b(buffer, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zRefill = refill();
            try {
                Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
                int iInflate = this.inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit));
                if (iInflate > 0) {
                    segmentWritableSegment$okio.limit += iInflate;
                    long j2 = iInflate;
                    buffer.setSize$okio(buffer.size() + j2);
                    return j2;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (segmentWritableSegment$okio.pos != segmentWritableSegment$okio.limit) {
                    return -1L;
                }
                buffer.head = segmentWritableSegment$okio.pop();
                SegmentPool.INSTANCE.recycle(segmentWritableSegment$okio);
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!zRefill);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (!(this.inflater.getRemaining() == 0)) {
            throw new IllegalStateException("?");
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        if (segment == null) {
            i.a();
            throw null;
        }
        int i = segment.limit;
        int i2 = segment.pos;
        this.bufferBytesHeldByInflater = i - i2;
        this.inflater.setInput(segment.data, i2, this.bufferBytesHeldByInflater);
        return false;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
        i.b(source, "source");
        i.b(inflater, "inflater");
    }
}
