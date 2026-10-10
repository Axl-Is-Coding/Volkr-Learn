package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: SpCache.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5940b;

    h(Context context, String str) {
        this.f5940b = context;
        this.f5939a = TextUtils.isEmpty(str) ? "" : str;
    }

    private Context b() {
        Context context = this.f5940b;
        return context == null ? o.a() : context;
    }

    private String c() {
        return this.f5939a + "_adslot";
    }

    private String d() {
        return this.f5939a + "_adslot_preload";
    }

    private SharedPreferences f(String str) {
        try {
            if (b() != null) {
                return b().getSharedPreferences(str, 0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.f5939a + "_cache_" + str;
    }

    String a(String str) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b(g(str), "material_data", (String) null);
        }
        SharedPreferences sharedPreferencesF = f(g(str));
        if (sharedPreferencesF != null) {
            return sharedPreferencesF.getString("material_data", null);
        }
        return null;
    }

    AdSlot e(String str) {
        String string;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                string = com.bytedance.sdk.openadsdk.multipro.d.a.b(c(), str, (String) null);
            } else {
                SharedPreferences sharedPreferencesF = f(c());
                string = sharedPreferencesF != null ? sharedPreferencesF.getString(str, null) : null;
            }
            return AdSlot.getSlot(string != null ? new JSONObject(string) : null);
        } catch (Throwable unused) {
            return null;
        }
    }

    long b(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", 0L);
            }
            SharedPreferences sharedPreferencesF = f(g(str));
            if (sharedPreferencesF != null) {
                return sharedPreferencesF.getLong("create_time", 0L);
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    boolean c(String str) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", true);
        }
        SharedPreferences sharedPreferencesF = f(g(str));
        if (sharedPreferencesF != null) {
            return sharedPreferencesF.getBoolean("has_played", true);
        }
        return true;
    }

    void d(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str));
                return;
            }
            SharedPreferences sharedPreferencesF = f(g(str));
            if (sharedPreferencesF != null) {
                sharedPreferencesF.edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
    }

    void a(String str, String str2) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", (Boolean) false);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "material_data", str2);
            } else {
                SharedPreferences sharedPreferencesF = f(g(str));
                if (sharedPreferencesF != null) {
                    sharedPreferencesF.edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
                }
            }
        } catch (Throwable unused) {
        }
    }

    void b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String string = adSlot.toJsonObj().toString();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(d(), "preload_data", string);
                    } else {
                        SharedPreferences sharedPreferencesF = f(d());
                        if (sharedPreferencesF != null) {
                            sharedPreferencesF.edit().putString("preload_data", string).apply();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    void a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String string = adSlot.toJsonObj().toString();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(c(), adSlot.getCodeId(), string);
                    } else {
                        SharedPreferences sharedPreferencesF = f(c());
                        if (sharedPreferencesF != null) {
                            sharedPreferencesF.edit().putString(adSlot.getCodeId(), string).apply();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    AdSlot a() {
        String strB;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                strB = com.bytedance.sdk.openadsdk.multipro.d.a.b(d(), "preload_data", (String) null);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(d());
            } else {
                SharedPreferences sharedPreferencesF = f(d());
                if (sharedPreferencesF != null) {
                    String string = sharedPreferencesF.getString("preload_data", null);
                    sharedPreferencesF.edit().clear().apply();
                    strB = string;
                } else {
                    strB = null;
                }
            }
            return AdSlot.getSlot(strB != null ? new JSONObject(strB) : null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
