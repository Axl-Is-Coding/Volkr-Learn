package b.f.d.c;

import java.util.Map;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f2691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f2692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f2693c;

    h(p pVar, com.ironsource.sdk.data.d dVar, Map map) {
        this.f2693c = pVar;
        this.f2691a = dVar;
        this.f2692b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2693c.f2720d.b(this.f2691a, this.f2692b, this.f2693c);
    }
}
