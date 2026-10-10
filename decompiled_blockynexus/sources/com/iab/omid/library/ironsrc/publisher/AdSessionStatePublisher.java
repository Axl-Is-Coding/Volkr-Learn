package com.iab.omid.library.ironsrc.publisher;

import android.webkit.WebView;
import b.e.a.a.a.b.f;
import com.iab.omid.library.ironsrc.adsession.d;
import com.iab.omid.library.ironsrc.adsession.g;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b.e.a.a.a.e.b f14547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.adsession.a f14548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f14549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f14550d;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        h();
        this.f14547a = new b.e.a.a.a.e.b(null);
    }

    public void a() {
    }

    public void a(float f2) {
        f.a().a(g(), f2);
    }

    void a(WebView webView) {
        this.f14547a = new b.e.a.a.a.e.b(webView);
    }

    public void a(com.iab.omid.library.ironsrc.adsession.a aVar) {
        this.f14548b = aVar;
    }

    public void a(com.iab.omid.library.ironsrc.adsession.c cVar) {
        f.a().a(g(), cVar.b());
    }

    public void a(g gVar, d dVar) {
        a(gVar, dVar, null);
    }

    protected void a(g gVar, d dVar, JSONObject jSONObject) {
        String strI = gVar.i();
        JSONObject jSONObject2 = new JSONObject();
        b.e.a.a.a.d.b.a(jSONObject2, "environment", "app");
        b.e.a.a.a.d.b.a(jSONObject2, "adSessionType", dVar.a());
        b.e.a.a.a.d.b.a(jSONObject2, "deviceInfo", b.e.a.a.a.d.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        b.e.a.a.a.d.b.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        b.e.a.a.a.d.b.a(jSONObject3, "partnerName", dVar.e().a());
        b.e.a.a.a.d.b.a(jSONObject3, "partnerVersion", dVar.e().b());
        b.e.a.a.a.d.b.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        b.e.a.a.a.d.b.a(jSONObject4, "libraryVersion", "1.2.22-Ironsrc");
        b.e.a.a.a.d.b.a(jSONObject4, "appId", b.e.a.a.a.b.d.a().b().getApplicationContext().getPackageName());
        b.e.a.a.a.d.b.a(jSONObject2, "app", jSONObject4);
        if (dVar.b() != null) {
            b.e.a.a.a.d.b.a(jSONObject2, "customReferenceData", dVar.b());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (com.iab.omid.library.ironsrc.adsession.f fVar : dVar.f()) {
            b.e.a.a.a.d.b.a(jSONObject5, fVar.b(), fVar.c());
        }
        f.a().a(g(), strI, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(String str, long j) {
        if (j >= this.f14550d) {
            this.f14549c = a.AD_STATE_VISIBLE;
            f.a().b(g(), str);
        }
    }

    public void a(boolean z) {
        if (d()) {
            f.a().c(g(), z ? "foregrounded" : "backgrounded");
        }
    }

    public void b() {
        this.f14547a.clear();
    }

    public void b(String str, long j) {
        if (j >= this.f14550d) {
            a aVar = this.f14549c;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f14549c = aVar2;
                f.a().b(g(), str);
            }
        }
    }

    public com.iab.omid.library.ironsrc.adsession.a c() {
        return this.f14548b;
    }

    public boolean d() {
        return this.f14547a.get() != null;
    }

    public void e() {
        f.a().a(g());
    }

    public void f() {
        f.a().b(g());
    }

    public WebView g() {
        return this.f14547a.get();
    }

    public void h() {
        this.f14550d = b.e.a.a.a.d.d.a();
        this.f14549c = a.AD_STATE_IDLE;
    }
}
