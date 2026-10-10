package com.ironsource.sdk.ISNAdView;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNAdViewLogic.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f15097a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f15099c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WebView f15101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15102f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f15098b = null;
    private String g = h.class.getSimpleName();
    private String[] h = {"handleGetViewVisibility"};
    private final String[] i = {"loadWithUrl", "updateAd", "isExternalAdViewInitiated", "handleGetViewVisibility", "sendMessage"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k f15100d = new k();

    private boolean f() {
        return this.f15098b != null;
    }

    private void g() {
        if (this.f15099c == null || this.f15100d == null) {
            return;
        }
        a("containerIsVisible", d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) throws JSONException {
        JSONObject jSONObjectA = this.f15100d.a();
        jSONObjectA.put("adViewId", this.f15102f);
        a(str, jSONObjectA);
    }

    private boolean i(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.h;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equalsIgnoreCase(str)) {
                return true;
            }
            i++;
        }
    }

    private boolean j(String str) {
        return Build.VERSION.SDK_INT <= 22 ? str.equalsIgnoreCase("isWindowVisible") : str.equalsIgnoreCase("isVisible");
    }

    private Handler e() {
        try {
            if (f15097a == null) {
                f15097a = new Handler(Looper.getMainLooper());
            }
        } catch (Exception e2) {
            Log.e(this.g, "Error while trying execute method getUIThreadHandler");
            e2.printStackTrace();
        }
        return f15097a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str) {
        int i = 0;
        boolean z = false;
        while (true) {
            String[] strArr = this.i;
            if (i >= strArr.length || z) {
                break;
            }
            if (strArr[i].equalsIgnoreCase(str)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public void d(String str) {
        this.f15098b = new JSONObject();
        try {
            this.f15098b.put("externalAdViewId", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public String b() {
        return this.f15102f;
    }

    public void c(String str) {
        this.f15102f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        try {
            String str2 = "javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}";
            if (Build.VERSION.SDK_INT >= 19) {
                this.f15101e.evaluateJavascript(str2, null);
            } else {
                this.f15101e.loadUrl(str2);
            }
        } catch (Throwable th) {
            Log.e(this.g, "injectJavaScriptIntoWebView | Error while trying inject JS into external adunit: " + str + "Android API level: " + Build.VERSION.SDK_INT);
            th.printStackTrace();
        }
    }

    public void a(d dVar) {
        this.f15099c = dVar;
    }

    public void b(String str) {
        try {
            boolean z = (this.f15101e == null || this.f15101e.getUrl() == null) ? false : true;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isExternalAdViewInitiated", z);
            jSONObject.put("adViewId", this.f15102f);
            a(str, jSONObject);
        } catch (Exception e2) {
            Log.e(this.g, "Error while trying execute method sendIsExternalAdViewInitiated");
            e2.printStackTrace();
        }
    }

    public void c() {
        if (this.f15099c == null || this.f15100d == null) {
            return;
        }
        a("containerWasRemoved", d());
    }

    private JSONObject d() {
        return new f(this);
    }

    public void a(WebView webView) {
        this.f15101e = webView;
    }

    public void a() {
        this.f15098b = null;
        this.f15099c = null;
        this.f15100d = null;
        f15097a = null;
    }

    private String e(String str) {
        return String.format("window.ssa.onMessageReceived(%1$s)", str);
    }

    JSONObject a(JSONObject jSONObject, String str) throws Exception {
        try {
            boolean zF = f();
            if (this.f15098b == null) {
                this.f15098b = new JSONObject(jSONObject.toString());
            }
            this.f15098b.put("externalAdViewId", str);
            this.f15098b.put("isInReload", zF);
            return this.f15098b;
        } catch (Exception unused) {
            throw new Exception("ISNAdViewLogic | buildDataForLoadingAd | Could not build load parameters");
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        a(a(jSONObject).toString(), (String) null, (String) null);
    }

    public void a(String str, JSONObject jSONObject) {
        d dVar = this.f15099c;
        if (dVar != null) {
            dVar.a(str, jSONObject);
        }
    }

    public void a(String str, String str2) {
        d dVar = this.f15099c;
        if (dVar != null) {
            dVar.a(str, str2, this.f15102f);
        }
    }

    void a(String str, JSONObject jSONObject, String str2, String str3) {
        e().post(new e(this, str, str3, str2, jSONObject));
    }

    public void a(String str, int i, boolean z) {
        this.f15100d.a(str, i, z);
        if (j(str)) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
            jSONObject3.put("visibilityParams", jSONObject2);
            return jSONObject3;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public void a(String str, String str2, String str3) throws JSONException {
        if (this.f15101e == null) {
            String str4 = "No external adunit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.g, str4);
            this.f15099c.a(str3, str4, this.f15102f);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException unused) {
            str = "\"" + str + "\"";
        }
        e().post(new g(this, e(str)));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.f15102f);
        a(str2, jSONObject);
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(FirebaseAnalytics.Param.METHOD);
            if (!TextUtils.isEmpty(strOptString) && i(strOptString)) {
                if (strOptString.equalsIgnoreCase("handleGetViewVisibility")) {
                    b(jSONObject);
                }
            } else {
                a("containerSendMessage", jSONObject);
            }
        } catch (JSONException e2) {
            Log.e(this.g, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            e2.printStackTrace();
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", jSONObject.getString("id"));
            jSONObject2.put("data", this.f15100d.a());
        } catch (Exception e2) {
            Log.e(this.g, "Error while trying execute method buildVisibilityMessageForAdunit | params: " + jSONObject);
            e2.printStackTrace();
        }
        return jSONObject2;
    }
}
