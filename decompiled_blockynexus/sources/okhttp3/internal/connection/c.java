package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.ws.c;
import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: compiled from: RealConnection.java */
/* JADX INFO: loaded from: classes5.dex */
class c extends c.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f23210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ d f23211e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(d dVar, boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink, g gVar) {
        super(z, bufferedSource, bufferedSink);
        this.f23211e = dVar;
        this.f23210d = gVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        g gVar = this.f23210d;
        gVar.a(true, gVar.b(), -1L, null);
    }
}
