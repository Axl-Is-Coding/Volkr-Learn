package b.f.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import b.f.d.c.p;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceNetwork.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f2723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static JSONObject f2724b;

    public static synchronized void a(Activity activity, String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            com.ironsource.sdk.utils.f.b("IronSourceNetwork", "applicationKey is NULL");
            return;
        }
        if (f2723a == null) {
            com.ironsource.sdk.utils.i.b(map);
            try {
                JSONObject jSONObjectOptJSONObject = com.ironsource.sdk.utils.i.g().optJSONObject(com.umeng.analytics.pro.b.ao);
                if (jSONObjectOptJSONObject != null) {
                    a(activity, jSONObjectOptJSONObject, str2, str, map);
                }
            } catch (Exception e2) {
                com.ironsource.sdk.utils.f.b("IronSourceNetwork", "Failed to init event tracker: " + e2.getMessage());
            }
            f2723a = p.a(activity, str, str2);
            a(f2724b);
        }
    }

    public static synchronized void b(b bVar, Map<String, String> map) throws Exception {
        a();
        f2723a.a(bVar, map);
    }

    public static synchronized void c(JSONObject jSONObject) {
        com.ironsource.sdk.service.g.d().b(jSONObject);
    }

    public static synchronized void b(Activity activity) {
        if (f2723a == null) {
            return;
        }
        f2723a.onResume(activity);
    }

    public static synchronized String b(Context context) {
        return com.ironsource.sdk.service.g.d().c(context);
    }

    public static synchronized void b(JSONObject jSONObject) throws Exception {
        a();
        f2723a.a(jSONObject);
    }

    private static void a(Activity activity, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        b.f.a.a aVarA = b.f.d.a.f.a(jSONObject);
        if (aVarA.a()) {
            b.f.d.a.e.a(aVarA, b.f.d.a.f.a(activity, str, str2, map));
        }
    }

    private static synchronized void a() throws Exception {
        if (f2723a == null) {
            throw new NullPointerException("Call initSDK first");
        }
    }

    public static synchronized void a(b bVar, Map<String, String> map) throws Exception {
        a();
        f2723a.b(bVar, map);
    }

    public static synchronized boolean a(b bVar) {
        if (f2723a == null) {
            return false;
        }
        return f2723a.a(bVar);
    }

    public static synchronized void a(Activity activity) {
        if (f2723a == null) {
            return;
        }
        f2723a.onPause(activity);
    }

    public static synchronized void a(JSONObject jSONObject) {
        if (f2723a == null) {
            return;
        }
        if (jSONObject == null) {
            return;
        }
        f2723a.updateConsentInfo(jSONObject);
    }

    public static synchronized JSONObject a(Context context) {
        return com.ironsource.sdk.service.g.d().b(context);
    }
}
