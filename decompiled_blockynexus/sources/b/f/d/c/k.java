package b.f.d.c;

import java.util.Map;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f2701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f2702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.e f2703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ p f2704e;

    k(p pVar, String str, String str2, Map map, b.f.d.g.e eVar) {
        this.f2704e = pVar;
        this.f2700a = str;
        this.f2701b = str2;
        this.f2702c = map;
        this.f2703d = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2704e.f2720d.a(this.f2700a, this.f2701b, this.f2702c, this.f2703d);
    }
}
