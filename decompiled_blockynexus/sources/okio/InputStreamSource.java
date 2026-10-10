package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Okio.kt */
/* JADX INFO: loaded from: classes5.dex */
final class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream inputStream, Timeout timeout) {
        i.b(inputStream, "input");
        i.b(timeout, "timeout");
        this.input = inputStream;
        this.timeout = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        i.b(buffer, "sink");
        if (j == 0) {
            return 0L;
        }
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        try {
            this.timeout.throwIfReached();
            Segment segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            int i = this.input.read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit));
            if (i == -1) {
                return -1L;
            }
            segmentWritableSegment$okio.limit += i;
            long j2 = i;
            buffer.setSize$okio(buffer.size() + j2);
            return j2;
        } catch (AssertionError e2) {
            if (Okio.isAndroidGetsocknameError(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
