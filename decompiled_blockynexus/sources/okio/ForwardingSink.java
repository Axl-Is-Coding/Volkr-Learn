package okio;

import java.io.IOException;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: ForwardingSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ForwardingSink implements Sink {
    private final Sink delegate;

    public ForwardingSink(Sink sink) {
        i.b(sink, "delegate");
        this.delegate = sink;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final Sink m137deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        i.b(buffer, "source");
        this.delegate.write(buffer, j);
    }
}
