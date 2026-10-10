package b.e.a.a.a.d;

import android.os.Build;
import com.umeng.analytics.pro.au;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static String c() {
        return "Android";
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "deviceType", a());
        b.a(jSONObject, "osVersion", b());
        b.a(jSONObject, au.w, c());
        return jSONObject;
    }
}
