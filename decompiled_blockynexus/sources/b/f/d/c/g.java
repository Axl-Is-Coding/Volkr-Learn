package b.f.d.c;

import com.ironsource.sdk.data.SSAEnums$ProductType;
import java.util.Map;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.b f2688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f2689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f2690c;

    g(p pVar, b.f.d.b bVar, Map map) {
        this.f2690c = pVar;
        this.f2688a = bVar;
        this.f2689b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ironsource.sdk.data.d dVarA = this.f2690c.h.a(SSAEnums$ProductType.Interstitial, this.f2688a);
        b.f.d.a.a aVar = new b.f.d.a.a();
        aVar.a("isbiddinginstance", Boolean.valueOf(this.f2688a.e()));
        aVar.a("demandsourcename", this.f2688a.d());
        aVar.a("producttype", this.f2688a.g() ? SSAEnums$ProductType.RewardedVideo : SSAEnums$ProductType.Interstitial);
        b.f.d.a.e.a(b.f.d.a.g.g, aVar.a());
        this.f2690c.f2720d.a(this.f2690c.f2721e, this.f2690c.f2722f, dVarA, (b.f.d.g.a.c) this.f2690c);
        this.f2688a.a(true);
        this.f2690c.f2720d.a(dVarA, this.f2689b, this.f2690c);
    }
}
