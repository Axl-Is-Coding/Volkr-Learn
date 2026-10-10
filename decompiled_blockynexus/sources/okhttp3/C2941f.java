package okhttp3;

import java.io.IOException;
import okhttp3.C2940e;
import okhttp3.internal.cache.g;
import okio.ForwardingSource;
import okio.Source;

/* JADX INFO: renamed from: okhttp3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes5.dex */
class C2941f extends ForwardingSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g.c f23144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2940e.b f23145b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2941f(C2940e.b bVar, Source source, g.c cVar) {
        super(source);
        this.f23145b = bVar;
        this.f23144a = cVar;
    }

    @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23144a.close();
        super.close();
    }
}
