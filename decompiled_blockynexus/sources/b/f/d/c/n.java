package b.f.d.c;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f2712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f2713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f2714d;

    n(p pVar, String str, String str2, com.ironsource.sdk.data.d dVar) {
        this.f2714d = pVar;
        this.f2711a = str;
        this.f2712b = str2;
        this.f2713c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2714d.f2720d.a(this.f2711a, this.f2712b, this.f2713c, (b.f.d.g.a.c) this.f2714d);
    }
}
