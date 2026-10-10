package com.alibaba.sdk.android.feedback.xblink.c;

import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f3781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f3782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f3785e;

    public a(String str, j jVar, Map map, String str2, int i, boolean z) {
        this.f3783c = i;
        this.f3781a = jVar;
        if (map != null) {
            this.f3782b = new HashMap(map);
        }
        this.f3784d = str2;
    }

    public void a() {
    }

    public synchronized void a(j jVar) {
        this.f3781a = jVar;
    }

    public void b() {
        Map map = this.f3782b;
        if (map != null) {
            map.clear();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar = new h(this.f3784d);
        hVar.a(this.f3782b);
        hVar.a(false);
        i iVarA = new c().a(hVar);
        this.f3785e = iVarA.c();
        synchronized (this) {
            if (this.f3781a != null) {
                Map mapB = iVarA.b();
                mapB.put("url", this.f3784d);
                mapB.put("response-code", iVarA.a() + "");
                mapB.put(HybridPlusWebView.HTTPSVERIFYERROR, hVar.i());
                String str = (String) mapB.get("content-type");
                if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("HtmlDownloader", "http charset:" + str);
                }
                String strA = com.alibaba.sdk.android.feedback.xblink.i.a.a(str);
                if (strA == null) {
                    strA = "utf-8";
                    if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                        com.alibaba.sdk.android.feedback.xblink.i.g.a("HtmlDownloader", "default charset:utf-8");
                    }
                }
                mapB.put(HybridPlusWebView.CHARSET, strA);
                this.f3781a.callback(this.f3785e, mapB, this.f3783c);
                this.f3782b = null;
                this.f3781a = null;
            }
        }
    }
}
