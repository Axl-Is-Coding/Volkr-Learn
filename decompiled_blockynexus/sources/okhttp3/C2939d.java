package okhttp3;

import java.io.IOException;
import okhttp3.C2940e;
import okhttp3.internal.cache.g;
import okio.ForwardingSink;
import okio.Sink;

/* JADX INFO: renamed from: okhttp3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes5.dex */
class C2939d extends ForwardingSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2940e f23120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g.a f23121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C2940e.a f23122c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2939d(C2940e.a aVar, Sink sink, C2940e c2940e, g.a aVar2) {
        super(sink);
        this.f23122c = aVar;
        this.f23120a = c2940e;
        this.f23121b = aVar2;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (C2940e.this) {
            if (this.f23122c.f23132d) {
                return;
            }
            this.f23122c.f23132d = true;
            C2940e.this.f23125c++;
            super.close();
            this.f23121b.b();
        }
    }
}
