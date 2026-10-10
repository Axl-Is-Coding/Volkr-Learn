package b.f.d.c;

import java.util.Map;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f2705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f2706b;

    l(p pVar, Map map) {
        this.f2706b = pVar;
        this.f2705a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2706b.f2720d.a(this.f2705a);
    }
}
