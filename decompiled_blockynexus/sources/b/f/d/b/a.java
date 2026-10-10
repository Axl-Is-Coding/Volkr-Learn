package b.f.d.b;

import android.app.Activity;
import android.webkit.WebView;
import com.facebook.internal.NativeProtocol;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdViewsManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2648a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, c> f2650c = Collections.synchronizedMap(new HashMap());

    public static synchronized a a() {
        if (f2649b == null) {
            f2649b = new a();
        }
        return f2649b;
    }

    public void b(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = new JSONObject(jSONObject.getString(NativeProtocol.WEB_DIALOG_PARAMS)).getString("adViewId");
        if (string.isEmpty()) {
            com.ironsource.sdk.utils.f.c(f2648a, "sendMessageToAd fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (this.f2650c.containsKey(string)) {
            this.f2650c.get(string).a(jSONObject, str, str2);
        } else {
            com.ironsource.sdk.utils.f.c(f2648a, "sendMessageToAd fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }

    public String a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("adViewId")) {
            return (jSONObject == null || !jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) ? "" : new JSONObject(jSONObject.getString(NativeProtocol.WEB_DIALOG_PARAMS)).getString("adViewId");
        }
        return jSONObject.getString("adViewId");
    }

    public void a(com.ironsource.sdk.ISNAdView.d dVar, JSONObject jSONObject, Activity activity, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (!this.f2650c.containsKey(string)) {
                h hVar = new h(dVar, activity, string);
                this.f2650c.put(string, hVar);
                hVar.b(jSONObject, str, str2);
                return;
            }
            com.ironsource.sdk.utils.f.c(f2648a, "sendMessageToAd fail - collection already contain adViewId");
            throw new Exception("collection already contain adViewId");
        }
        com.ironsource.sdk.utils.f.c(f2648a, "loadWithUrl fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public WebView a(String str) {
        if (str.isEmpty() || !this.f2650c.containsKey(str)) {
            return null;
        }
        return this.f2650c.get(str).a();
    }

    public void a(JSONObject jSONObject, String str) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f2650c.containsKey(string)) {
                this.f2650c.get(string).a(str);
                return;
            } else {
                com.ironsource.sdk.utils.f.c(f2648a, "sendIsExternalAdViewInitiated fail - collection does not contain adViewId");
                throw new Exception("collection does not contain adViewId");
            }
        }
        com.ironsource.sdk.utils.f.c(f2648a, "sendIsExternalAdViewInitiated fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void a(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f2650c.containsKey(string)) {
                c cVar = this.f2650c.get(string);
                this.f2650c.remove(string);
                cVar.a(str, str2);
                return;
            }
            com.ironsource.sdk.utils.f.c(f2648a, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        com.ironsource.sdk.utils.f.c(f2648a, "removeAdView fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }
}
