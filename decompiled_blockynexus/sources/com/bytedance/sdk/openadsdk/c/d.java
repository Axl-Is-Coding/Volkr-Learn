package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", com.bytedance.sdk.openadsdk.utils.g.e(context).toString());
            jSONObject2.put("is_cache", hVar.S() ? 1 : 0);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", hVar.M());
            double dCurrentTimeMillis = System.currentTimeMillis() / 1000;
            double dG = ab.g(hVar.M());
            Double.isNaN(dCurrentTimeMillis);
            float fFloatValue = Double.valueOf(dCurrentTimeMillis - dG).floatValue();
            if (fFloatValue <= WheelView.DividerConfig.FILL) {
                fFloatValue = WheelView.DividerConfig.FILL;
            }
            jSONObject.putOpt("show_time", Float.valueOf(fFloatValue));
            jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
            String strF = hVar.f();
            if (!TextUtils.isEmpty(strF)) {
                jSONObject.put("ttdsp_price", (long) (Float.parseFloat(strF) * 100000.0f));
            }
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str, "show", hVar.J(), jSONObject));
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a()))) {
            com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.D(), true));
        }
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "show " + hVar.J());
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, hVar, str, str2, jSONObject2);
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, hVar, str, str2, jSONObject2);
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        c(context, hVar, str, str2, jSONObject);
    }

    public static void e(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        c(context, hVar, str, str2, jSONObject);
    }

    public static void f(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        c(context, hVar, str, str2, jSONObject);
    }

    public static void g(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, hVar, str, str2, jSONObject);
    }

    private static void b(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", hVar.M());
            jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str, str2, hVar.J(), jSONObject));
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "tag: " + str + "label: " + str2 + " " + hVar.J());
        }
    }

    private static void c(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, JSONObject jSONObject) {
        if (hVar == null) {
            return;
        }
        if (jSONObject != null) {
            try {
                jSONObject.putOpt("log_extra", hVar.M());
                jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str, str2, hVar.J(), jSONObject));
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "tag: " + str + "label: " + str2 + " " + hVar.J());
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c(context, hVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, hVar, str, str2, jSONObject2);
    }

    public static void a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.h hVar, com.bytedance.sdk.openadsdk.core.d.d dVar, String str2, boolean z, Map<String, Object> map) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        JSONObject jSONObject = new JSONObject();
        if (dVar != null) {
            try {
                JSONObject jSONObjectA = dVar.a();
                jSONObjectA.put("device", com.bytedance.sdk.openadsdk.utils.g.e(context).toString());
                jSONObjectA.put("is_valid", z);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObjectA.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", jSONObjectA.toString());
            } catch (JSONException unused) {
            }
        }
        jSONObject.putOpt("log_extra", hVar.M());
        double dCurrentTimeMillis = System.currentTimeMillis() / 1000;
        double dG = ab.g(hVar.M());
        Double.isNaN(dCurrentTimeMillis);
        float fFloatValue = Double.valueOf(dCurrentTimeMillis - dG).floatValue();
        if (fFloatValue <= WheelView.DividerConfig.FILL) {
            fFloatValue = WheelView.DividerConfig.FILL;
        }
        jSONObject.putOpt("show_time", Float.valueOf(fFloatValue));
        jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str2, str, hVar.J(), jSONObject));
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a())) && "click".equals(str)) {
            com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.E(), true));
        }
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", str + " " + hVar.J());
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c(context, hVar, str, str2, jSONObject2);
            return;
        }
        b(context, hVar, str, str2);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, List<FilterWord> list) {
        com.bytedance.sdk.openadsdk.dislike.a.a().a(hVar, list);
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "tt_dislike_icon " + hVar.J());
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        b(context, hVar, str, "click_close");
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
        Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
        JSONObject jSONObject = new JSONObject();
        if (map != null && map.size() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.utils.g.e(contextA).toString());
                Object objRemove = map.remove("total_time");
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                if (objRemove instanceof Long) {
                    jSONObject.put("duration", objRemove);
                } else {
                    jSONObject.put("duration", 0);
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
            c(contextA, hVar, str, "load_ad_duration", jSONObject);
            return;
        }
        b(contextA, hVar, str, "load_ad_duration");
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, long j, int i, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put("percent", i);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, hVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2) {
        b(context, hVar, str, str2);
    }

    public static void a(Context context, String str, long j) {
        com.bytedance.sdk.openadsdk.core.b.c.a(context, str, j);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.utils.g.e(com.bytedance.sdk.openadsdk.core.o.a()).toString());
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.put("tag", str2);
                if ("click".equals(str3)) {
                    String strOptString2 = jSONObject.optString("log_extra");
                    double dCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    double dG = ab.g(strOptString2);
                    Double.isNaN(dCurrentTimeMillis);
                    float fFloatValue = Double.valueOf(dCurrentTimeMillis - dG).floatValue();
                    if (fFloatValue <= WheelView.DividerConfig.FILL) {
                        fFloatValue = WheelView.DividerConfig.FILL;
                    }
                    jSONObject.putOpt("show_time", Float.valueOf(fFloatValue));
                    if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a())) && hVar != null) {
                        com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.E(), true));
                    }
                }
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(str, str2, str3, j, j2, jSONObject));
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "sendJsAdEvent");
        }
    }
}
