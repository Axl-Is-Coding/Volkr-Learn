package com.just.agentweb;

import a.a.b;
import android.os.Build;
import android.webkit.WebView;
import com.just.agentweb.AgentWeb;

/* JADX INFO: loaded from: classes2.dex */
public class WebSecurityControllerImpl implements WebSecurityController<WebSecurityCheckLogic> {
    private b<String, Object> mMap;
    private AgentWeb.SecurityType mSecurityType;
    private WebView mWebView;

    public WebSecurityControllerImpl(WebView webView, b<String, Object> bVar, AgentWeb.SecurityType securityType) {
        this.mWebView = webView;
        this.mMap = bVar;
        this.mSecurityType = securityType;
    }

    @Override // com.just.agentweb.WebSecurityController
    public void check(WebSecurityCheckLogic webSecurityCheckLogic) {
        if (Build.VERSION.SDK_INT > 11) {
            webSecurityCheckLogic.dealHoneyComb(this.mWebView);
        }
        b<String, Object> bVar = this.mMap;
        if (bVar == null || this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK || bVar.isEmpty()) {
            return;
        }
        webSecurityCheckLogic.dealJsInterface(this.mMap, this.mSecurityType);
    }
}
