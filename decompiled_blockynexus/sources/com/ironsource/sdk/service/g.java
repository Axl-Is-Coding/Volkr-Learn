package com.ironsource.sdk.service;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.sdk.utils.i;
import com.sandboxol.center.config.VipSubscribeStatus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TokenService.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f15415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f15416b = new JSONObject();

    private g() {
    }

    public static synchronized g d() {
        if (f15415a == null) {
            f15415a = new g();
        }
        return f15415a;
    }

    public void a() {
        HashMap map = new HashMap();
        map.put("omidVersion", b.e.a.a.a.a.a());
        map.put("omidPartnerVersion", VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD);
        f15415a.a(map);
    }

    public void b() {
        if (com.ironsource.sdk.utils.c.c()) {
            f15415a.a(com.ironsource.sdk.utils.c.a().b());
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a("chinaCDN", new JSONObject(str).opt("chinaCDN"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str) {
        if (str != null) {
            a("applicationUserId", i.b(str));
        }
    }

    public void b(Activity activity) {
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a(i.b("immersiveMode"), Boolean.valueOf(com.ironsource.environment.b.a(activity)));
        }
        a("appOrientation", i.c(com.ironsource.environment.b.b(activity)));
    }

    synchronized void a(String str, Object obj) {
        try {
            this.f15416b.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public String c(Context context) {
        try {
            return c.a(b(context).toString());
        } catch (Exception unused) {
            return c.a(new JSONObject().toString());
        }
    }

    public void a(String str) {
        if (str != null) {
            a("applicationKey", i.b(str));
        }
    }

    public void c() {
        c(i.c());
        a(i.f());
        b();
        a();
    }

    public void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            new Thread(new f(this, activity)).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a("metadata_" + next, jSONObject.opt(next));
        }
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        a(b.c(context));
        a(b.b(context));
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            Log.d("TokenService", "collectDataFromExternalParams params=null");
            return;
        }
        for (String str : map.keySet()) {
            a(str, i.b(map.get(str)));
        }
    }

    public JSONObject b(Context context) {
        c();
        a(context);
        try {
            return new JSONObject(this.f15416b.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    public void a(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a(next, jSONObject.opt(next));
        }
    }

    public void a(Activity activity, String str, String str2) {
        a(activity);
        b(activity);
        a((Context) activity);
        b(str2);
        a(str);
    }
}
