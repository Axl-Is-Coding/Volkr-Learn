package okio;

import java.io.IOException;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
        i.b(source, "delegate");
        this.delegate = source;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m138deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        i.b(buffer, "sink");
        return this.delegate.read(buffer, j);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
