package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes5.dex */
class e extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f23181b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(g gVar, Sink sink) {
        super(sink);
        this.f23181b = gVar;
    }

    @Override // okhttp3.internal.cache.h
    protected void onException(IOException iOException) {
        this.f23181b.n = true;
    }
}
