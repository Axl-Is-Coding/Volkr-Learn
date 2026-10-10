package b.f.d.c;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f2678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f2679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f2680d;

    c(p pVar, String str, String str2, com.ironsource.sdk.data.d dVar) {
        this.f2680d = pVar;
        this.f2677a = str;
        this.f2678b = str2;
        this.f2679c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2680d.f2720d.a(this.f2677a, this.f2678b, this.f2679c, (b.f.d.g.a.b) this.f2680d);
    }
}
