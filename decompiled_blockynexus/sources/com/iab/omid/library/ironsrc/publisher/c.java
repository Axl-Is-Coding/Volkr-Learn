package com.iab.omid.library.ironsrc.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.ironsrc.adsession.d;
import com.iab.omid.library.ironsrc.adsession.f;
import com.iab.omid.library.ironsrc.adsession.g;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WebView f14557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Long f14558f = null;
    private Map<String, f> g;
    private final String h;

    public c(Map<String, f> map, String str) {
        this.g = map;
        this.h = str;
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void a() {
        super.a();
        i();
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void a(g gVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, f> mapC = dVar.c();
        for (String str : mapC.keySet()) {
            b.e.a.a.a.d.b.a(jSONObject, str, mapC.get(str));
        }
        a(gVar, dVar, jSONObject);
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new b(this), Math.max(4000 - (this.f14558f == null ? 4000L : TimeUnit.MILLISECONDS.convert(b.e.a.a.a.d.d.a() - this.f14558f.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f14557e = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void i() {
        this.f14557e = new WebView(b.e.a.a.a.b.d.a().b());
        this.f14557e.getSettings().setJavaScriptEnabled(true);
        a(this.f14557e);
        b.e.a.a.a.b.f.a().a(this.f14557e, this.h);
        for (String str : this.g.keySet()) {
            b.e.a.a.a.b.f.a().a(this.f14557e, this.g.get(str).a().toExternalForm(), str);
        }
        this.f14558f = Long.valueOf(b.e.a.a.a.d.d.a());
    }
}
