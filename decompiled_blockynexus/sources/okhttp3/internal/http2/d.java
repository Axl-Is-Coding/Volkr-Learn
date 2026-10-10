package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class d extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ErrorCode f23303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f23304d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(j jVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        super(str, objArr);
        this.f23304d = jVar;
        this.f23302b = i;
        this.f23303c = errorCode;
    }

    @Override // okhttp3.a.b
    public void a() {
        try {
            this.f23304d.b(this.f23302b, this.f23303c);
        } catch (IOException unused) {
            this.f23304d.o();
        }
    }
}
