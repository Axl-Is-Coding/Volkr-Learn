package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.j;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class n extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ s f23345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j.d f23346c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n(j.d dVar, String str, Object[] objArr, s sVar) {
        super(str, objArr);
        this.f23346c = dVar;
        this.f23345b = sVar;
    }

    @Override // okhttp3.a.b
    public void a() {
        try {
            j.this.s.a(this.f23345b);
        } catch (IOException unused) {
            j.this.o();
        }
    }
}
