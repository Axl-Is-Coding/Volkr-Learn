package b.f.d.c;

import com.ironsource.sdk.data.SSAEnums$ProductType;
import java.util.Map;

/* JADX INFO: compiled from: IronSourceAdsPublisherAgent.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.b f2685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f2686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f2687c;

    f(p pVar, b.f.d.b bVar, Map map) {
        this.f2687c = pVar;
        this.f2685a = bVar;
        this.f2686b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ironsource.sdk.data.d dVarA = this.f2687c.h.a(SSAEnums$ProductType.Interstitial, this.f2685a.c());
        if (dVarA != null) {
            this.f2687c.f2720d.a(dVarA, this.f2686b, this.f2687c);
        }
    }
}
