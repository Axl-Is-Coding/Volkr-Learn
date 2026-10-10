package b.f.d.b;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alibaba.android.arouter.utils.Consts;
import com.facebook.internal.NativeProtocol;
import com.ironsource.sdk.ISNAdView.i;
import com.ironsource.sdk.utils.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNAdunitWebView.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2663a = "loadWithUrl | webView is not null";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f2665c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f2668f;
    private String g = h.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ironsource.sdk.ISNAdView.h f2666d = new com.ironsource.sdk.ISNAdView.h();

    public h(com.ironsource.sdk.ISNAdView.d dVar, Activity activity, String str) {
        this.f2668f = activity;
        this.f2666d.c(str);
        this.f2667e = a(activity.getApplicationContext());
        this.f2664b = str;
        this.f2666d.a(dVar);
    }

    private String e(String str) {
        String strSubstring = str.substring(str.indexOf("/") + 1);
        return strSubstring.substring(strSubstring.indexOf("/"));
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        try {
            this.f2666d.a(str);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.ironsource.sdk.utils.f.c(this.g, "createWebView");
        this.f2665c = new WebView(this.f2668f);
        this.f2665c.addJavascriptInterface(new b(this), "containerMsgHandler");
        this.f2665c.setWebViewClient(new i(new d(this, str)));
        k.a(this.f2665c);
        this.f2666d.a(this.f2665c);
        this.f2666d.d(this.f2664b);
    }

    private boolean d(String str) {
        return str.startsWith(Consts.DOT);
    }

    public void b(JSONObject jSONObject, String str, String str2) {
        this.f2668f.runOnUiThread(new e(this, str2, jSONObject, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        if (!d(str)) {
            return str;
        }
        return "file://" + this.f2667e + e(str);
    }

    String a(Context context) {
        return com.ironsource.sdk.utils.e.b(context);
    }

    @Override // b.f.d.b.c
    public WebView a() {
        return this.f2665c;
    }

    @Override // b.f.d.b.c
    public void a(String str) throws Exception {
        try {
            this.f2665c.post(new f(this, str));
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // b.f.d.b.c
    public void a(JSONObject jSONObject, String str, String str2) throws Exception {
        try {
            this.f2666d.a(jSONObject.getString(NativeProtocol.WEB_DIALOG_PARAMS), str, str2);
        } catch (Exception e2) {
            com.ironsource.sdk.utils.f.c(this.g, "sendMessageToAd fail message: " + e2.getMessage());
            throw e2;
        }
    }

    @Override // b.f.d.b.c
    public synchronized void a(String str, String str2) {
        if (this.f2668f == null) {
            return;
        }
        this.f2668f.runOnUiThread(new g(this, str, str2));
    }
}
