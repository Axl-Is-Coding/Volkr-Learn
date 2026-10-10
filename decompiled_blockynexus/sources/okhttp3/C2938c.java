package okhttp3;

import java.io.IOException;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.InternalCache;

/* JADX INFO: renamed from: okhttp3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes5.dex */
class C2938c implements InternalCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2940e f23119a;

    C2938c(C2940e c2940e) {
        this.f23119a = c2940e;
    }

    @Override // okhttp3.internal.cache.InternalCache
    public H get(C c2) throws IOException {
        return this.f23119a.a(c2);
    }

    @Override // okhttp3.internal.cache.InternalCache
    public CacheRequest put(H h) throws IOException {
        return this.f23119a.a(h);
    }

    @Override // okhttp3.internal.cache.InternalCache
    public void remove(C c2) throws IOException {
        this.f23119a.b(c2);
    }

    @Override // okhttp3.internal.cache.InternalCache
    public void trackConditionalCacheHit() {
        this.f23119a.b();
    }

    @Override // okhttp3.internal.cache.InternalCache
    public void trackResponse(okhttp3.internal.cache.c cVar) {
        this.f23119a.a(cVar);
    }

    @Override // okhttp3.internal.cache.InternalCache
    public void update(H h, H h2) {
        this.f23119a.a(h, h2);
    }
}
