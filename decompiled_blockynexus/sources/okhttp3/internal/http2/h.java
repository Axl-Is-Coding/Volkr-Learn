package okhttp3.internal.http2;

import java.io.IOException;
import okio.Buffer;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
class h extends okhttp3.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Buffer f23316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f23317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f23318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ j f23319f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h(j jVar, String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
        super(str, objArr);
        this.f23319f = jVar;
        this.f23315b = i;
        this.f23316c = buffer;
        this.f23317d = i2;
        this.f23318e = z;
    }

    @Override // okhttp3.a.b
    public void a() {
        try {
            boolean zOnData = this.f23319f.k.onData(this.f23315b, this.f23316c, this.f23317d, this.f23318e);
            if (zOnData) {
                this.f23319f.s.a(this.f23315b, ErrorCode.CANCEL);
            }
            if (zOnData || this.f23318e) {
                synchronized (this.f23319f) {
                    this.f23319f.u.remove(Integer.valueOf(this.f23315b));
                }
            }
        } catch (IOException unused) {
        }
    }
}
