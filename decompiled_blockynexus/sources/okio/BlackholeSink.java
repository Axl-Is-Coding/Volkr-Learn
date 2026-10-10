package okio;

import java.io.EOFException;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Okio.kt */
/* JADX INFO: loaded from: classes5.dex */
final class BlackholeSink implements Sink {
    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws EOFException {
        i.b(buffer, "source");
        buffer.skip(j);
    }
}
