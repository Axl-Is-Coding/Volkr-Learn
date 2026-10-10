package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* JADX INFO: compiled from: FaultHidingSink.java */
/* JADX INFO: loaded from: classes5.dex */
class h extends ForwardingSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23204a;

    h(Sink sink) {
        super(sink);
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f23204a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.f23204a = true;
            onException(e2);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f23204a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.f23204a = true;
            onException(e2);
        }
    }

    protected void onException(IOException iOException) {
        throw null;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.f23204a) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (IOException e2) {
            this.f23204a = true;
            onException(e2);
        }
    }
}
