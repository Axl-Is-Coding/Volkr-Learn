package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class e extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f23306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f23307d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(j jVar, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.f23307d = jVar;
        this.f23305b = i;
        this.f23306c = j;
    }

    @Override // okhttp3.a.b
    public void a() {
        try {
            this.f23307d.s.windowUpdate(this.f23305b, this.f23306c);
        } catch (IOException unused) {
            this.f23307d.o();
        }
    }
}
