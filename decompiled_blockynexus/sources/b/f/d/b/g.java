package b.f.d.b;

import android.util.Log;
import b.f.d.a.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNAdunitWebView.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f2661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f2662c;

    g(h hVar, String str, String str2) {
        this.f2662c = hVar;
        this.f2660a = str;
        this.f2661b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ironsource.sdk.utils.f.c(this.f2662c.g, "perforemCleanup");
        try {
            if (this.f2662c.f2665c != null) {
                this.f2662c.f2665c.destroy();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adViewId", this.f2662c.f2664b);
            this.f2662c.f2666d.a(this.f2660a, jSONObject);
            this.f2662c.f2666d.a();
            this.f2662c.f2666d = null;
            this.f2662c.f2668f = null;
        } catch (Exception e2) {
            Log.e(this.f2662c.g, "performCleanup | could not destroy ISNAdView webView ID: " + this.f2662c.f2664b);
            g.a aVar = b.f.d.a.g.p;
            b.f.d.a.a aVar2 = new b.f.d.a.a();
            aVar2.a("callfailreason", e2.getMessage());
            b.f.d.a.e.a(aVar, aVar2.a());
            if (this.f2662c.f2666d != null) {
                this.f2662c.f2666d.a(this.f2661b, e2.getMessage());
            }
        }
    }
}
