package com.alibaba.sdk.android.feedback.xblink.f;

import android.text.TextUtils;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f3858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f3859b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3860c = false;

    private h() {
    }

    public static synchronized h a() {
        if (f3858a == null) {
            f3858a = new h();
        }
        return f3858a;
    }

    public synchronized void a(WebView webView, String str) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVJsPatch", "start execute jspatch, url: " + str);
        }
        if (this.f3860c && webView != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry entry : this.f3859b.entrySet()) {
                String str2 = (String) entry.getKey();
                i iVar = (i) entry.getValue();
                if (iVar == null) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsPatch", "config is null");
                } else {
                    if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                        com.alibaba.sdk.android.feedback.xblink.i.g.a("WVJsPatch", "start match rules, rule: " + str2);
                    }
                    if (iVar.f3862b == null) {
                        try {
                            iVar.f3862b = Pattern.compile(str2);
                        } catch (PatternSyntaxException unused) {
                            com.alibaba.sdk.android.feedback.xblink.i.g.b("WVJsPatch", "compile rule error, pattern: " + str2);
                        }
                    }
                    if (iVar.f3862b != null && iVar.f3862b.matcher(str).matches()) {
                        if (!iVar.f3861a.startsWith("javascript:")) {
                            iVar.f3861a = "javascript:" + iVar.f3861a;
                        }
                        webView.loadUrl(iVar.f3861a);
                        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVJsPatch", "url matched, start execute jspatch, jsString: " + iVar.f3861a);
                        }
                    }
                }
            }
            return;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsPatch", "jspatch is not init, or parameter is empty.");
    }
}
