package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class g extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f23312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f23313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ j f23314e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(j jVar, String str, Object[] objArr, int i, List list, boolean z) {
        super(str, objArr);
        this.f23314e = jVar;
        this.f23311b = i;
        this.f23312c = list;
        this.f23313d = z;
    }

    @Override // okhttp3.a.b
    public void a() {
        boolean zOnHeaders = this.f23314e.k.onHeaders(this.f23311b, this.f23312c, this.f23313d);
        if (zOnHeaders) {
            try {
                this.f23314e.s.a(this.f23311b, ErrorCode.CANCEL);
            } catch (IOException unused) {
                return;
            }
        }
        if (zOnHeaders || this.f23313d) {
            synchronized (this.f23314e) {
                this.f23314e.u.remove(Integer.valueOf(this.f23311b));
            }
        }
    }
}
