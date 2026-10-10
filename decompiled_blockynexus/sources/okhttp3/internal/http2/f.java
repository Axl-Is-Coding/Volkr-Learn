package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class f extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f23309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f23310d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(j jVar, String str, Object[] objArr, int i, List list) {
        super(str, objArr);
        this.f23310d = jVar;
        this.f23308b = i;
        this.f23309c = list;
    }

    @Override // okhttp3.a.b
    public void a() {
        if (this.f23310d.k.onRequest(this.f23308b, this.f23309c)) {
            try {
                this.f23310d.s.a(this.f23308b, ErrorCode.CANCEL);
                synchronized (this.f23310d) {
                    this.f23310d.u.remove(Integer.valueOf(this.f23308b));
                }
            } catch (IOException unused) {
            }
        }
    }
}
