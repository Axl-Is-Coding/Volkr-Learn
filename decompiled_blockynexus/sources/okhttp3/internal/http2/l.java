package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.j;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class l extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f23342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j.d f23343c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    l(j.d dVar, String str, Object[] objArr, o oVar) {
        super(str, objArr);
        this.f23343c = dVar;
        this.f23342b = oVar;
    }

    @Override // okhttp3.a.b
    public void a() {
        try {
            j.this.f23325c.a(this.f23342b);
        } catch (IOException e2) {
            okhttp3.a.b.f.a().a(4, "Http2Connection.Listener failure for " + j.this.f23327e, e2);
            try {
                this.f23342b.a(ErrorCode.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
