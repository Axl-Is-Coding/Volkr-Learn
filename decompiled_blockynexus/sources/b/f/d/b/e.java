package b.f.d.b;

import b.f.d.a.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNAdunitWebView.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f2655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f2656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f2657d;

    e(h hVar, String str, JSONObject jSONObject, String str2) {
        this.f2657d = hVar;
        this.f2654a = str;
        this.f2655b = jSONObject;
        this.f2656c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2657d.f2665c != null) {
            g.a aVar = b.f.d.a.g.o;
            b.f.d.a.a aVar2 = new b.f.d.a.a();
            aVar2.a("callfailreason", h.f2663a);
            b.f.d.a.e.a(aVar, aVar2.a());
        }
        try {
            this.f2657d.c(this.f2654a);
            this.f2657d.f2665c.loadUrl(this.f2657d.b(this.f2655b.getString("urlForWebView")));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adViewId", this.f2657d.f2664b);
            this.f2657d.f2666d.a(this.f2656c, jSONObject);
        } catch (Exception e2) {
            this.f2657d.f2666d.a(this.f2654a, e2.getMessage());
            g.a aVar3 = b.f.d.a.g.o;
            b.f.d.a.a aVar4 = new b.f.d.a.a();
            aVar4.a("callfailreason", e2.getMessage());
            b.f.d.a.e.a(aVar3, aVar4.a());
        }
    }
}
