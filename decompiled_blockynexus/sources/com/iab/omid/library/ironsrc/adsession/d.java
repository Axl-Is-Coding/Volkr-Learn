package com.iab.omid.library.ironsrc.adsession;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f14530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebView f14531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f> f14532c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, f> f14533d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14535f;
    private final AdSessionContextType g;

    private d(e eVar, WebView webView, String str, List<f> list, String str2) {
        AdSessionContextType adSessionContextType;
        this.f14530a = eVar;
        this.f14531b = webView;
        this.f14534e = str;
        if (list != null) {
            this.f14532c.addAll(list);
            for (f fVar : list) {
                this.f14533d.put(UUID.randomUUID().toString(), fVar);
            }
            adSessionContextType = AdSessionContextType.NATIVE;
        } else {
            adSessionContextType = AdSessionContextType.HTML;
        }
        this.g = adSessionContextType;
        this.f14535f = str2;
    }

    public static d a(e eVar, WebView webView, String str) {
        b.e.a.a.a.d.e.a(eVar, "Partner is null");
        b.e.a.a.a.d.e.a(webView, "WebView is null");
        if (str != null) {
            b.e.a.a.a.d.e.a(str, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(eVar, webView, null, null, str);
    }

    public AdSessionContextType a() {
        return this.g;
    }

    public String b() {
        return this.f14535f;
    }

    public Map<String, f> c() {
        return Collections.unmodifiableMap(this.f14533d);
    }

    public String d() {
        return this.f14534e;
    }

    public e e() {
        return this.f14530a;
    }

    public List<f> f() {
        return Collections.unmodifiableList(this.f14532c);
    }

    public WebView g() {
        return this.f14531b;
    }
}
