package com.bytedance.sdk.adnet.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.d.e;
import com.bytedance.sdk.adnet.d.g;
import com.bytedance.sdk.adnet.d.h;
import com.just.agentweb.DefaultWebClient;
import io.rong.imkit.plugin.LocationConst;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.sdk.adnet.c.a, h.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f5360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5362c;
    private final Context j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f5363d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5364e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5365f = false;
    private long g = 0;
    private long h = 0;
    private AtomicBoolean i = new AtomicBoolean(false);
    private volatile boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final h f5361a = new h(Looper.getMainLooper(), this);

    private a(Context context, boolean z) {
        this.j = context;
        this.f5362c = z;
    }

    private void d(boolean z) {
        if (this.f5365f) {
            return;
        }
        if (this.f5364e) {
            this.f5364e = false;
            this.g = 0L;
            this.h = 0L;
        }
        long j = z ? 10800000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.g <= j || jCurrentTimeMillis - this.h <= 120000) {
            return;
        }
        boolean zA = e.a(this.j);
        if (!this.k || zA) {
            b(zA);
        }
    }

    private boolean e() {
        String[] strArrD = d();
        if (strArrD != null && strArrD.length != 0) {
            a(0);
        }
        return false;
    }

    public synchronized void c() {
        if (this.k) {
            return;
        }
        this.k = true;
        long j = this.j.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.g = j;
        if (f.a().e() != null) {
            f.a().e().a();
        }
    }

    public static void b(Context context) {
        a aVar = f5360b;
        if (aVar != null) {
            if (com.bytedance.sdk.adnet.d.f.b(context)) {
                aVar.a(true);
            } else {
                aVar.a();
            }
        }
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f5360b == null) {
                f5360b = new a(context.getApplicationContext(), com.bytedance.sdk.adnet.d.f.b(context));
                com.bytedance.sdk.adnet.a.a(f5360b);
            }
            aVar = f5360b;
        }
        return aVar;
    }

    synchronized void b() {
        if (System.currentTimeMillis() - this.g > 3600000) {
            this.g = System.currentTimeMillis();
            try {
                if (f.a().e() != null) {
                    f.a().e().b();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        a(false);
    }

    public synchronized void a(boolean z) {
        if (this.f5362c) {
            d(z);
        } else if (this.g <= 0) {
            try {
                new Thread("LoadDomainConfig4Other-Thread") { // from class: com.bytedance.sdk.adnet.a.a.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        a.this.b();
                    }
                }.start();
            } catch (Throwable unused) {
            }
        }
    }

    void c(boolean z) {
        c.b("TNCManager", "doRefresh, actual request");
        c();
        this.f5365f = true;
        if (!z) {
            this.f5361a.sendEmptyMessage(102);
            return;
        }
        try {
            e();
        } catch (Exception unused) {
            this.i.set(false);
        }
    }

    public boolean b(final boolean z) {
        c.b("TNCManager", "doRefresh: updating state " + this.i.get());
        if (!this.i.compareAndSet(false, true)) {
            c.b("TNCManager", "doRefresh, already running");
            return false;
        }
        if (z) {
            this.h = System.currentTimeMillis();
        }
        new Thread("AppConfigThread") { // from class: com.bytedance.sdk.adnet.a.a.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                a.this.c(z);
            }
        }.start();
        return true;
    }

    public String[] d() {
        String[] strArrF = com.bytedance.sdk.adnet.a.a().f();
        return (strArrF == null || strArrF.length <= 0) ? new String[0] : strArrF;
    }

    @Override // com.bytedance.sdk.adnet.d.h.a
    public void a(Message message) {
        int i = message.what;
        if (i == 101) {
            this.f5365f = false;
            this.g = System.currentTimeMillis();
            c.b("TNCManager", "doRefresh, succ");
            if (this.f5364e) {
                a();
            }
            this.i.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.f5365f = false;
        if (this.f5364e) {
            a();
        }
        c.b("TNCManager", "doRefresh, error");
        this.i.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        h hVar = this.f5361a;
        if (hVar != null) {
            hVar.sendEmptyMessage(i);
        }
    }

    private String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Address addressA = com.bytedance.sdk.adnet.a.a().a(this.j);
        g gVar = new g(DefaultWebClient.HTTPS_SCHEME + str + "/get_domains/v4/");
        if (addressA != null && addressA.hasLatitude() && addressA.hasLongitude()) {
            gVar.a(LocationConst.LATITUDE, addressA.getLatitude());
            gVar.a(LocationConst.LONGITUDE, addressA.getLongitude());
            String locality = addressA.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                gVar.a("city", Uri.encode(locality));
            }
        }
        if (this.f5363d) {
            gVar.a("force", 1);
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str2 = Build.CPU_ABI;
            } else {
                str2 = Build.SUPPORTED_ABIS[0];
            }
            gVar.a("abi", str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        gVar.a("aid", com.bytedance.sdk.adnet.a.a().a());
        gVar.a("device_platform", com.bytedance.sdk.adnet.a.a().c());
        gVar.a("channel", com.bytedance.sdk.adnet.a.a().b());
        gVar.a("version_code", com.bytedance.sdk.adnet.a.a().d());
        gVar.a("custom_info_1", com.bytedance.sdk.adnet.a.a().e());
        return gVar.toString();
    }

    @Override // com.bytedance.sdk.adnet.c.a
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                return f.a().a(str);
            } catch (Throwable unused) {
                return str;
            }
        }
        try {
            if (this.f5362c) {
                c();
            } else {
                b();
            }
            return f.a().a(str);
        } catch (Throwable unused2) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.j.getSharedPreferences("ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (f.a().e() == null) {
            return true;
        }
        f.a().e().a(jSONObject2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        String[] strArrD = d();
        if (strArrD != null && strArrD.length > i) {
            String str = strArrD[i];
            if (TextUtils.isEmpty(str)) {
                b(102);
                return;
            }
            try {
                String strB = b(str);
                if (TextUtils.isEmpty(strB)) {
                    b(102);
                    return;
                } else {
                    new com.bytedance.sdk.adnet.b.f(0, strB, new JSONObject(), new m.a<JSONObject>() { // from class: com.bytedance.sdk.adnet.a.a.3
                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void a(m<JSONObject> mVar) {
                            JSONObject jSONObject = mVar.f5538a;
                            if (jSONObject == null) {
                                a.this.a(i + 1);
                                return;
                            }
                            String string = null;
                            try {
                                string = jSONObject.getString("message");
                            } catch (Exception unused) {
                            }
                            if (!"success".equals(string)) {
                                a.this.a(i + 1);
                                return;
                            }
                            try {
                                if (a.this.a(jSONObject)) {
                                    a.this.b(101);
                                } else {
                                    a.this.a(i + 1);
                                }
                            } catch (Exception unused2) {
                            }
                        }

                        @Override // com.bytedance.sdk.adnet.core.m.a
                        public void b(m<JSONObject> mVar) {
                            a.this.a(i + 1);
                        }
                    }).setRetryPolicy(new com.bytedance.sdk.adnet.core.e().a(10000).b(0)).build(com.bytedance.sdk.adnet.a.a(this.j));
                    return;
                }
            } catch (Throwable th) {
                c.b("AppConfig", "try app config exception: " + th);
                return;
            }
        }
        b(102);
    }
}
