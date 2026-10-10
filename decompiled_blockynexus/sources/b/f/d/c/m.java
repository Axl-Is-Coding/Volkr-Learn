package b.f.d.c;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f2708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.e f2709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f2710d;

    m(p pVar, String str, String str2, b.f.d.g.e eVar) {
        this.f2710d = pVar;
        this.f2707a = str;
        this.f2708b = str2;
        this.f2709c = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2710d.f2720d.a(this.f2707a, this.f2708b, this.f2709c);
    }
}
