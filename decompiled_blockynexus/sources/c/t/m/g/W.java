package c.t.m.g;

/* JADX INFO: loaded from: classes.dex */
final class W implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f3029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ byte[] f3030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ V f3031c;

    W(V v, String str, byte[] bArr) {
        this.f3031c = v;
        this.f3029a = str;
        this.f3030b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB = this.f3029a;
        byte[] bArrA = this.f3030b;
        if (C0455pa.a(strB) || C0455pa.a(bArrA)) {
            qc.e();
            strB = qc.b();
            bArrA = this.f3031c.f3024a.a(strB);
        }
        X.c().f3041c.a(strB, bArrA, null);
    }
}
