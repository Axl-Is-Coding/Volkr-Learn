package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: CacheInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
class a implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f23166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BufferedSource f23167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CacheRequest f23168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BufferedSink f23169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ b f23170e;

    a(b bVar, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
        this.f23170e = bVar;
        this.f23167b = bufferedSource;
        this.f23168c = cacheRequest;
        this.f23169d = bufferedSink;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f23166a && !okhttp3.a.e.a(this, 100, TimeUnit.MILLISECONDS)) {
            this.f23166a = true;
            this.f23168c.abort();
        }
        this.f23167b.close();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        try {
            long j2 = this.f23167b.read(buffer, j);
            if (j2 != -1) {
                buffer.copyTo(this.f23169d.buffer(), buffer.size() - j2, j2);
                this.f23169d.emitCompleteSegments();
                return j2;
            }
            if (!this.f23166a) {
                this.f23166a = true;
                this.f23169d.close();
            }
            return -1L;
        } catch (IOException e2) {
            if (!this.f23166a) {
                this.f23166a = true;
                this.f23168c.abort();
            }
            throw e2;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f23167b.timeout();
    }
}
