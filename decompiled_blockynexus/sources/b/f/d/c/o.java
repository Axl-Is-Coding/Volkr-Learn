package b.f.d.c;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f2716b;

    o(p pVar, String str) {
        this.f2716b = pVar;
        this.f2715a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2716b.f2720d.a(this.f2715a, this.f2716b);
    }
}
