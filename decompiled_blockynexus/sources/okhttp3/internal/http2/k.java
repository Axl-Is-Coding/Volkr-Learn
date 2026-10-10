package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.j;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class k extends j.b {
    k() {
    }

    @Override // okhttp3.internal.http2.j.b
    public void a(o oVar) throws IOException {
        oVar.a(ErrorCode.REFUSED_STREAM);
    }
}
