package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.internal.cache.g;
import okio.Sink;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes5.dex */
class f extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g.a f23182b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(g.a aVar, Sink sink) {
        super(sink);
        this.f23182b = aVar;
    }

    @Override // okhttp3.internal.cache.h
    protected void onException(IOException iOException) {
        synchronized (g.this) {
            this.f23182b.c();
        }
    }
}
