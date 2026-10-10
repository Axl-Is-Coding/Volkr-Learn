package com.bytedance.sdk.openadsdk.core.g;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.w;
import com.umeng.analytics.pro.au;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SdkSettingsHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile f f6206e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f6210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f6205d = new AtomicLong(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f6207f = false;
    private static boolean g = true;

    /* JADX INFO: compiled from: SdkSettingsHelper.java */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    f.f6205d.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    if (f.this.f6208a != null) {
                        f.this.f6208a.a();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private f(d dVar) {
        this.f6208a = dVar == null ? o.h() : dVar;
        this.f6209b = o.a();
        this.f6210c = Executors.newSingleThreadExecutor();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                this.f6209b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    public static void b() {
        if (o.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                o.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean f() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.b().c());
    }

    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        int i = 1;
        ab.a(jSONObject, true);
        try {
            int iF = com.bytedance.sdk.openadsdk.core.h.b().f();
            com.bytedance.sdk.openadsdk.utils.o.b("setting", "Settings().isGdprUser =" + o.h().u());
            int iU = o.h().u();
            if (iU != -1) {
                if (iU == 0) {
                    a(jSONObject);
                } else if (iU == 1 && iF == 0) {
                    b(jSONObject);
                }
            } else if (ab.m()) {
                if (iF == 0) {
                    a(jSONObject);
                }
            } else if (iF == 0 || iF == -1) {
                a(jSONObject);
            }
            jSONObject.put("gdpr", iF);
            jSONObject.put("coppa", com.bytedance.sdk.openadsdk.core.h.b().e());
            jSONObject.put("MCC", w.b());
            jSONObject.put("conn_type", q.c(this.f6209b));
            jSONObject.put(au.w, 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(au.x, String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", "3.1.5.3");
            jSONObject.put(au.M, com.bytedance.sdk.openadsdk.core.j.a());
            jSONObject.put("time_zone", ab.o());
            jSONObject.put(au.n, ab.f());
            boolean zC = ab.c(this.f6209b, ab.f());
            com.bytedance.sdk.openadsdk.utils.o.c("isApplicationForeground", "isApplicationForeground:" + zC);
            if (!zC) {
                i = 2;
            }
            jSONObject.put("position", i);
            jSONObject.put("app_version", ab.h());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("android_id", com.bytedance.sdk.openadsdk.core.j.c(this.f6209b));
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.j.d(this.f6209b));
            if (com.bytedance.sdk.openadsdk.core.h.b() != null && com.bytedance.sdk.openadsdk.core.h.b().c() != null) {
                jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.h.b().c());
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (com.bytedance.sdk.openadsdk.core.h.b() != null && com.bytedance.sdk.openadsdk.core.h.b().c() != null) {
                strConcat = com.bytedance.sdk.openadsdk.core.h.b().c().concat(String.valueOf(jCurrentTimeMillis)).concat("3.1.5.3");
            }
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.utils.h.a(strConcat));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void c() {
        try {
            if (f()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - f6205d.get() < 600000) {
                return;
            }
            f6205d.set(jCurrentTimeMillis);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a(jCurrentTimeMillis);
            }
            this.f6210c.execute(this);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!q.a(this.f6209b)) {
            try {
                this.f6208a.a();
            } catch (Throwable unused) {
            }
        } else {
            if (f()) {
                return;
            }
            new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/settings/"), c(g()), new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.g.f.1
                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<JSONObject> mVar) {
                    JSONObject jSONObject;
                    String strK;
                    JSONObject jSONObject2;
                    if (mVar == null || (jSONObject = mVar.f5538a) == null) {
                        try {
                            f.this.f6208a.a();
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    int iOptInt = jSONObject.optInt("cypher", -1);
                    JSONObject jSONObject3 = mVar.f5538a;
                    JSONObject jSONObject4 = jSONObject3;
                    Map<String, String> map = null;
                    if (iOptInt == 1) {
                        strK = com.bytedance.sdk.openadsdk.core.a.b(jSONObject3.optString("message"), com.bytedance.sdk.openadsdk.core.b.a());
                        if (!TextUtils.isEmpty(strK)) {
                            try {
                                com.bytedance.sdk.openadsdk.utils.o.b("SdkSettingsHelper", "setting data : " + strK.toString());
                                jSONObject2 = new JSONObject(strK);
                                jSONObject4 = jSONObject2;
                            } catch (Throwable th) {
                                com.bytedance.sdk.openadsdk.utils.o.a("SdkSettingsHelper", "setting data error: ", th);
                            }
                        }
                    } else if (iOptInt == 2) {
                        strK = ab.k(jSONObject3.optString("message"));
                        if (!TextUtils.isEmpty(strK)) {
                            try {
                                com.bytedance.sdk.openadsdk.utils.o.b("SdkSettingsHelper", "setting data1 : " + strK.toString());
                                jSONObject2 = new JSONObject(strK);
                                jSONObject4 = jSONObject2;
                            } catch (Throwable th2) {
                                com.bytedance.sdk.openadsdk.utils.o.a("SdkSettingsHelper", "setting data error2: ", th2);
                            }
                        }
                    } else {
                        strK = null;
                    }
                    try {
                        if (mVar.f5539b != null) {
                            map = mVar.f5539b.h;
                        }
                        f.this.a(strK, map);
                    } catch (Throwable unused3) {
                    }
                    try {
                        if (!f.f6207f) {
                            boolean unused4 = f.f6207f = true;
                        }
                        f.this.f6208a.a(jSONObject4);
                    } catch (Throwable unused5) {
                    }
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f.b();
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<JSONObject> mVar) {
                    try {
                        f.this.f6208a.a();
                    } catch (Throwable unused2) {
                    }
                }
            }).setResponseOnMain(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6209b).d());
        }
    }

    public static f a(d dVar) {
        if (f6206e == null) {
            synchronized (f.class) {
                if (f6206e == null) {
                    f6206e = new f(dVar);
                }
            }
        }
        return f6206e;
    }

    private void b(JSONObject jSONObject) throws JSONException {
        jSONObject.put("ip", com.bytedance.sdk.openadsdk.utils.g.a(true));
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("device_city", ab.k());
        jSONObject.put("gaid", b.a.a.a.a.b.b.a().b());
    }

    private JSONObject c(JSONObject jSONObject) {
        return g ? ab.a(jSONObject) : jSONObject;
    }

    public static void a() {
        File file;
        try {
            Context contextA = o.a();
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(contextA.getDataDir(), "shared_prefs");
            } else {
                file = new File(contextA.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String strReplace = file2.getName().replace(".xml", "");
                if (Build.VERSION.SDK_INT >= 24) {
                    contextA.deleteSharedPreferences(strReplace);
                } else {
                    contextA.getSharedPreferences(strReplace, 0).edit().clear().apply();
                    com.bytedance.sdk.openadsdk.utils.i.c(file2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j) {
        if (j > 0 && o.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                o.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                int iIntValue = Integer.valueOf(map.get("active-control")).intValue();
                long jLongValue = Long.valueOf(map.get("ts")).longValue();
                String str2 = map.get("pst");
                String strA = com.bytedance.sdk.openadsdk.h.g.b.a(str + iIntValue + jLongValue);
                if (strA != null) {
                    if (strA.equalsIgnoreCase(str2)) {
                        i = iIntValue;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        g.a(i);
    }

    private void a(JSONObject jSONObject) throws JSONException {
        if (com.bytedance.sdk.openadsdk.core.h.b() == null || com.bytedance.sdk.openadsdk.core.h.b().g() == 1) {
            return;
        }
        jSONObject.put("ip", com.bytedance.sdk.openadsdk.utils.g.a(true));
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("device_city", ab.k());
        jSONObject.put("gaid", b.a.a.a.a.b.b.a().b());
    }
}
