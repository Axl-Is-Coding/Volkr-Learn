package okhttp3.internal.http2;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class i extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ErrorCode f23321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f23322d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i(j jVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        super(str, objArr);
        this.f23322d = jVar;
        this.f23320b = i;
        this.f23321c = errorCode;
    }

    @Override // okhttp3.a.b
    public void a() {
        this.f23322d.k.onReset(this.f23320b, this.f23321c);
        synchronized (this.f23322d) {
            this.f23322d.u.remove(Integer.valueOf(this.f23320b));
        }
    }
}
