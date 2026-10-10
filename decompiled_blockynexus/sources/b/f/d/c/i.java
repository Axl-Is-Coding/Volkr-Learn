package b.f.d.c;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f2695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f2696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f2697d;

    i(p pVar, String str, String str2, com.ironsource.sdk.data.d dVar) {
        this.f2697d = pVar;
        this.f2694a = str;
        this.f2695b = str2;
        this.f2696c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2697d.f2720d.a(this.f2694a, this.f2695b, this.f2696c, (b.f.d.g.a.d) this.f2697d);
    }
}
