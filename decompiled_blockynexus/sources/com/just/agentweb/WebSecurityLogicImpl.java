package com.just.agentweb;

import a.a.b;
import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;
import com.just.agentweb.AgentWeb;

/* JADX INFO: loaded from: classes2.dex */
public class WebSecurityLogicImpl implements WebSecurityCheckLogic {
    private String TAG = WebSecurityLogicImpl.class.getSimpleName();

    public static WebSecurityLogicImpl getInstance() {
        return new WebSecurityLogicImpl();
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    @TargetApi(11)
    public void dealHoneyComb(WebView webView) {
        int i = Build.VERSION.SDK_INT;
        if (11 > i || i > 17) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    public void dealJsInterface(b<String, Object> bVar, AgentWeb.SecurityType securityType) {
        if (securityType != AgentWeb.SecurityType.STRICT_CHECK || AgentWebConfig.WEBVIEW_TYPE == 2 || Build.VERSION.SDK_INT >= 17) {
            return;
        }
        LogUtils.e(this.TAG, "Give up all inject objects");
        bVar.clear();
        System.gc();
    }
}
