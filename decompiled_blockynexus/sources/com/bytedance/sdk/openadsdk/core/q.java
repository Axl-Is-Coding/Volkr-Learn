package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.sandboxol.center.config.StringConstant;
import com.umeng.analytics.pro.au;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetApiImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class q implements p<com.bytedance.sdk.openadsdk.c.a> {
    private static volatile boolean g = false;
    private static boolean h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6333a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6338f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f6335c = Executors.newFixedThreadPool(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6334b = f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6336d = i();

    /* JADX INFO: compiled from: NetApiImpl.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f6350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f6351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f6352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f6353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final String f6354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f6355f;
        final String g;
        public final com.bytedance.sdk.openadsdk.core.d.a h;
        final String i;

        private a(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.d.a aVar, long j, long j2) {
            this.f6350a = i;
            this.f6353d = i2;
            this.f6354e = str2;
            this.g = str3;
            this.h = aVar;
            this.i = str;
            this.f6355f = i3;
            this.f6351b = j;
            this.f6352c = j2;
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString("desc");
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt("reason");
            com.bytedance.sdk.openadsdk.core.d.a aVarA = c.a(jSONObject, adSlot);
            if (aVarA != null) {
                aVarA.a(jSONObject.optLong("request_after"));
            }
            return new a(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, aVarA, jOptLong, jOptLong2);
        }
    }

    /* JADX INFO: compiled from: NetApiImpl.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f6357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.core.d.m f6358c;

        private b(int i, boolean z, com.bytedance.sdk.openadsdk.core.d.m mVar) {
            this.f6356a = i;
            this.f6357b = z;
            this.f6358c = mVar;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.d.m mVar = new com.bytedance.sdk.openadsdk.core.d.m();
            if (jSONObjectOptJSONObject != null) {
                try {
                    mVar.a(jSONObjectOptJSONObject.optInt("reason"));
                    mVar.b(jSONObjectOptJSONObject.optInt("corp_type"));
                    mVar.c(jSONObjectOptJSONObject.optInt("reward_amount"));
                    mVar.a(jSONObjectOptJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new b(iOptInt, zOptBoolean, mVar);
        }
    }

    q(Context context) {
        this.f6333a = context;
    }

    private int a(int i) {
        return 10000;
    }

    private static String b(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }

    private void c(JSONObject jSONObject) throws JSONException {
        int iF = h.b().f();
        if ((o.h().u() == -1 && ab.m()) || o.h().u() == 1) {
            if (iF == 1 || iF == -1 || h.b().g() == 1) {
                return;
            }
            jSONObject.put("ip", d());
            return;
        }
        if (o.h().u() == 1 && iF == 0) {
            jSONObject.put("ip", d());
            return;
        }
        boolean z = false;
        boolean z2 = o.h().u() == 1 && (iF == 1 || iF == -1);
        if (o.h().u() == -1 && iF == 1) {
            z = true;
        }
        if (z2 || z || h.b().g() == 1) {
            return;
        }
        jSONObject.put("ip", d());
    }

    private boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private void e(JSONObject jSONObject) {
        try {
            jSONObject.put(au.n, ab.f());
            jSONObject.put("version_code", ab.g());
            jSONObject.put("version", ab.h());
        } catch (Exception unused) {
        }
    }

    private static boolean f() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String g() {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.sdk.openadsdk.utils.u.e()) {
                sb.append("MIUI-");
            } else if (com.bytedance.sdk.openadsdk.utils.u.b()) {
                sb.append("FLYME-");
            } else {
                String strN = com.bytedance.sdk.openadsdk.utils.u.n();
                if (com.bytedance.sdk.openadsdk.utils.u.a(strN)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strN)) {
                    sb.append(strN);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static int h() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String i() {
        return com.bytedance.sdk.openadsdk.utils.g.b(this.f6333a) ? "tv" : com.bytedance.sdk.openadsdk.utils.g.a(this.f6333a) ? "android_pad" : "android";
    }

    private String j() {
        String strA = com.bytedance.sdk.openadsdk.core.a.a();
        return strA == null ? com.bytedance.sdk.openadsdk.core.b.a() : strA;
    }

    private JSONObject b(com.bytedance.sdk.openadsdk.core.d.h hVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "3.1.5.3");
            jSONObject2.put("extra", hVar.M());
            jSONObject2.put("filter_words", b(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String d() {
        return com.bytedance.sdk.openadsdk.utils.g.a(true);
    }

    private String d(String str) {
        String strA = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str != null) {
            return strA;
        }
        String strA2 = com.bytedance.sdk.openadsdk.core.b.a();
        return strA2.concat(strA2).substring(8, 24);
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", r.f6359a);
            jSONObject.put("openudid", j.c(this.f6333a));
            jSONObject.put("ad_sdk_version", "3.1.5.3");
            jSONObject.put("sim_op", a(this.f6333a));
            jSONObject.put("root", this.f6334b ? 1 : 0);
            jSONObject.put(au.L, h());
            jSONObject.put(au.P, com.bytedance.sdk.openadsdk.utils.q.f(this.f6333a));
            jSONObject.put(au.w, "Android");
            jSONObject.put(au.x, Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(au.ah, this.f6336d);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(au.E, Build.BRAND);
            jSONObject.put(au.G, Build.MANUFACTURER);
            jSONObject.put(au.M, Locale.getDefault().getLanguage());
            jSONObject.put(au.y, ac.d(this.f6333a) + "x" + ac.c(this.f6333a));
            jSONObject.put("display_density", b(ac.f(this.f6333a)));
            jSONObject.put("density_dpi", ac.f(this.f6333a));
            jSONObject.put("device_id", j.a(this.f6333a));
            jSONObject.put("aid", "1371");
            jSONObject.put("rom", g());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", j.e(this.f6333a));
            jSONObject.put("ut", this.f6338f);
            jSONObject.put(StringConstant.UID, this.f6337e);
            jSONObject.put("google_aid", b.a.a.a.a.b.b.a().b());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.i iVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strD = (iVar == null || TextUtils.isEmpty(iVar.f6115a)) ? ab.d() : iVar.f6115a;
            if (i == 7) {
                if (iVar != null && iVar.f6116b > 0) {
                    jSONObject2.put("req_type", iVar.f6116b);
                }
            } else if (i == 8 && iVar != null && iVar.f6117c > 0) {
                jSONObject2.put("req_type", iVar.f6117c);
            }
            try {
                String strE = o.h().e();
                String strF = o.h().f();
                if (!TextUtils.isEmpty(strE) && !TextUtils.isEmpty(strF)) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", strE);
                    jSONObject3.put("param", strF);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable unused) {
            }
            jSONObject2.put("request_id", strD);
            jSONObject2.put("ad_sdk_version", "3.1.5.3");
            jSONObject2.put("source_type", "app");
            jSONObject2.put("app", b());
            JSONObject jSONObjectD = com.bytedance.sdk.openadsdk.utils.g.d(this.f6333a);
            if (jSONObjectD != null) {
                jSONObjectD.put(AdUnitActivity.EXTRA_ORIENTATION, adSlot.getOrientation());
            }
            c(jSONObject2);
            jSONObject2.put("device", jSONObjectD);
            jSONObject2.put("user", c());
            jSONObject2.put("ua", ab.c());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(adSlot, i, iVar));
            jSONObject2.put("adslots", jSONArray);
            a(jSONObject2, iVar);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (adSlot.getCodeId() != null && strD != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(adSlot.getCodeId()).concat(strD);
            }
            jSONObject2.put("req_sign", com.bytedance.sdk.openadsdk.utils.h.a(strConcat));
            String strJ = j();
            String strA = com.bytedance.sdk.openadsdk.core.a.a(jSONObject2.toString(), d(strJ));
            String str = 2 + strJ + strA;
            if (b(strA)) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 2);
            } else {
                jSONObject.put("message", jSONObject2.toString());
                jSONObject.put("cypher", 0);
            }
            jSONObject.put("ad_sdk_version", "3.1.5.3");
            jSONObject.put("oversea_version_type", 1);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    private Map<String, String> c(String str) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        if (b(str)) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    private JSONArray b(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coppa", h.b().g());
            jSONObject.put("gdpr", h.b().f());
            jSONObject.put("is_gdpr_user", o.h().u());
            a(jSONObject, "keywords", h.b().i());
            a(jSONObject, "data", h.b().j());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", h.b().c());
            jSONObject.put("name", h.b().d());
            e(jSONObject);
            ab.a(jSONObject, false);
            jSONObject.put("is_paid_app", h.b().h());
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.utils.c.a(this.f6333a));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.c.h b(JSONObject jSONObject) {
        boolean z;
        com.bytedance.sdk.adnet.core.m mVar;
        if (!com.bytedance.sdk.openadsdk.core.g.g.a() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.adnet.b.i iVarA = com.bytedance.sdk.adnet.b.i.a();
        boolean z2 = true;
        new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/stats/batch/"), ab.a(jSONObject), iVarA).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).setUserAgent(r.f6359a).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6333a).d());
        String message = "error unknown";
        int i = 0;
        try {
            mVar = iVarA.get();
        } catch (Throwable unused) {
            z2 = false;
            z = false;
        }
        if (mVar == null) {
            return new com.bytedance.sdk.openadsdk.c.h(false, 0, "error unknown", false);
        }
        if (mVar.f5538a != 0) {
            int iOptInt = ((JSONObject) mVar.f5538a).optInt("code", -1);
            message = ((JSONObject) mVar.f5538a).optString("data", "");
            z = iOptInt == 20000;
            if (iOptInt != 60005) {
                z2 = false;
            }
        } else {
            z2 = false;
            z = false;
        }
        try {
            i = (int) mVar.h;
            if (mVar.f5540c != null) {
                message = mVar.f5540c.getMessage();
            }
        } catch (Throwable unused2) {
        }
        return new com.bytedance.sdk.openadsdk.c.h(z, i, message, z2);
    }

    private boolean b(p.a aVar) {
        if (!g) {
            if (com.bytedance.sdk.openadsdk.utils.k.a(o.a())) {
                g = true;
            } else if (aVar != null) {
                aVar.a(-15, g.a(-15));
                g = false;
            }
        }
        return g;
    }

    private void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.d.i iVar) {
        JSONArray jSONArray;
        if (iVar == null || (jSONArray = iVar.f6118d) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    private boolean a(String str) {
        if (com.bytedance.sdk.openadsdk.core.b.b.a()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.b.b.a(str)) {
            return false;
        }
        String strB = com.bytedance.sdk.openadsdk.core.b.b.b();
        if (!TextUtils.isEmpty(strB)) {
            com.bytedance.sdk.openadsdk.c.d.a(this.f6333a, strB, System.currentTimeMillis());
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.d.i iVar, final int i, final p.a aVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            if (aVar != null) {
                aVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
                return;
            }
            return;
        }
        if (b(aVar)) {
            com.bytedance.sdk.openadsdk.core.g.f.a((com.bytedance.sdk.openadsdk.core.g.d) null).c();
            if (aVar == null) {
                return;
            }
            if (a(adSlot.getCodeId())) {
                aVar.a(-8, g.a(-8));
                return;
            }
            if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                try {
                    JSONObject jSONObjectA = a(new JSONObject(adSlot.getBidAdm()));
                    if (jSONObjectA == null) {
                        a(aVar);
                        return;
                    }
                    a aVarA = a.a(jSONObjectA, adSlot);
                    j.a(this.f6333a, aVarA.i);
                    if (aVarA.f6353d != 20000) {
                        aVar.a(aVarA.f6353d, aVarA.f6354e);
                        return;
                    } else if (aVarA.h == null) {
                        a(aVar);
                        return;
                    } else {
                        aVarA.h.c(jSONObjectA.toString());
                        aVar.a(aVarA.h);
                        return;
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.o.c("NetApiImpl", "get ad error: ", th);
                    a(aVar);
                    return;
                }
            }
            JSONObject jSONObjectA2 = a(adSlot, iVar, i);
            if (jSONObjectA2 == null) {
                aVar.a(-9, g.a(-9));
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final AtomicLong atomicLong = new AtomicLong(jCurrentTimeMillis);
            final AtomicLong atomicLong2 = new AtomicLong(jCurrentTimeMillis);
            new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/get_ads/"), jSONObjectA2, new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.q.1
                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    atomicLong.set(System.currentTimeMillis());
                    JSONObject jSONObjectA3 = q.this.a(mVar.f5538a);
                    if (jSONObjectA3 == null) {
                        q.this.a(aVar);
                        q.this.a(mVar.f5542e, adSlot.getCodeId(), i, null, -1, "mate parse_fail");
                        return;
                    }
                    try {
                        a aVarA2 = a.a(jSONObjectA3, adSlot);
                        j.a(q.this.f6333a, aVarA2.i);
                        if (aVarA2.f6353d != 20000) {
                            if (o.h().n() || aVarA2.f6353d != 40029) {
                                aVar.a(aVarA2.f6353d, aVarA2.f6354e);
                            } else {
                                aVar.a(-100, g.a(-100));
                            }
                            q.this.a(mVar.f5542e, adSlot.getCodeId(), i, aVarA2, aVarA2.f6353d, String.valueOf(aVarA2.f6355f));
                            return;
                        }
                        if (aVarA2.h == null) {
                            q.this.a(aVar);
                            q.this.a(mVar.f5542e, adSlot.getCodeId(), i, aVarA2, -1, "parse_fail");
                            return;
                        }
                        aVarA2.h.c(jSONObjectA3.toString());
                        atomicLong2.set(System.currentTimeMillis());
                        aVar.a(aVarA2.h);
                        if (aVarA2.h.c() == null || aVarA2.h.c().isEmpty()) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.d.h hVar = aVarA2.h.c().get(0);
                        String strB = ab.b(i);
                        HashMap map = new HashMap();
                        if (iVar != null && iVar.f6120f > 0) {
                            map.put("client_start_time", Long.valueOf(jCurrentTimeMillis - iVar.f6120f));
                            map.put("load_ts", Long.valueOf(iVar.f6120f));
                            map.put("total_time", Long.valueOf(atomicLong2.get() - iVar.f6120f));
                        }
                        map.put("request_ts", Long.valueOf(jCurrentTimeMillis));
                        map.put("s_revice_ts", Long.valueOf(aVarA2.f6351b));
                        map.put("s_send_ts", Long.valueOf(aVarA2.f6352c));
                        map.put("c_revice_ts", Long.valueOf(atomicLong.get()));
                        map.put("c_end_ts", Long.valueOf(atomicLong2.get()));
                        map.put("network_time", Long.valueOf(mVar.f5543f));
                        map.put("go_time", Long.valueOf(aVarA2.f6351b - jCurrentTimeMillis));
                        map.put("sever_time", Integer.valueOf(aVarA2.f6350a));
                        map.put("back_time", Long.valueOf(atomicLong.get() - aVarA2.f6352c));
                        map.put("client_end_time", Long.valueOf(atomicLong2.get() - atomicLong.get()));
                        com.bytedance.sdk.openadsdk.c.d.a(hVar, strB, map);
                    } catch (Throwable th2) {
                        com.bytedance.sdk.openadsdk.utils.o.c("NetApiImpl", "get ad error: ", th2);
                        q.this.a(aVar);
                        q.this.a(mVar.f5542e, adSlot.getCodeId(), i, null, -1, "parse_fail");
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    int i2;
                    VAdError vAdError = mVar.f5540c;
                    if (vAdError instanceof com.bytedance.sdk.adnet.err.e) {
                        q.this.a(aVar);
                        q.this.a(mVar.f5542e, adSlot.getCodeId(), i, null, -1, g.a(-1));
                        return;
                    }
                    String strA = g.a(-2);
                    if (vAdError == null || mVar == null) {
                        i2 = -2;
                    } else {
                        int i3 = (int) mVar.h;
                        strA = vAdError.getMessage();
                        i2 = i3;
                    }
                    aVar.a(i2, strA);
                    q.this.a(mVar.f5542e, adSlot.getCodeId(), i, null, i2, vAdError instanceof com.bytedance.sdk.adnet.err.g ? "SocketTimeout" : strA);
                }
            }) { // from class: com.bytedance.sdk.openadsdk.core.q.2
                @Override // com.bytedance.sdk.adnet.core.Request
                public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                    return new HashMap();
                }
            }.setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(a(i)).b(0)).setUserAgent(r.f6359a).setShouldCache(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6333a).e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r4, java.lang.String r6, int r7, com.bytedance.sdk.openadsdk.core.q.a r8, int r9, java.lang.String r10) {
        /*
            r3 = this;
            boolean r0 = com.bytedance.sdk.openadsdk.core.g.g.a()
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L11
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.g.a(r9)
        L11:
            com.bytedance.sdk.openadsdk.f.a.b r0 = new com.bytedance.sdk.openadsdk.f.a.b
            r0.<init>()
            com.bytedance.sdk.openadsdk.f.a.c r7 = r0.a(r7)
            com.bytedance.sdk.openadsdk.f.a.b r7 = (com.bytedance.sdk.openadsdk.f.a.b) r7
            com.bytedance.sdk.openadsdk.f.a.c r7 = r7.b(r9)
            com.bytedance.sdk.openadsdk.f.a.b r7 = (com.bytedance.sdk.openadsdk.f.a.b) r7
            com.bytedance.sdk.openadsdk.f.a.c r7 = r7.f(r10)
            com.bytedance.sdk.openadsdk.f.a.b r7 = (com.bytedance.sdk.openadsdk.f.a.b) r7
            r9 = 0
            java.lang.String r10 = ""
            if (r8 == 0) goto L6a
            com.bytedance.sdk.openadsdk.core.d.a r0 = r8.h     // Catch: java.lang.Throwable -> Lac
            if (r0 == 0) goto L6a
            com.bytedance.sdk.openadsdk.core.d.a r0 = r8.h     // Catch: java.lang.Throwable -> Lac
            java.util.List r0 = r0.c()     // Catch: java.lang.Throwable -> Lac
            if (r0 == 0) goto L6a
            com.bytedance.sdk.openadsdk.core.d.a r0 = r8.h     // Catch: java.lang.Throwable -> Lac
            java.util.List r0 = r0.c()     // Catch: java.lang.Throwable -> Lac
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lac
            if (r0 <= 0) goto L6a
            com.bytedance.sdk.openadsdk.core.d.a r9 = r8.h     // Catch: java.lang.Throwable -> Lac
            java.util.List r9 = r9.c()     // Catch: java.lang.Throwable -> Lac
            r0 = 0
            java.lang.Object r9 = r9.get(r0)     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.core.d.h r9 = (com.bytedance.sdk.openadsdk.core.d.h) r9     // Catch: java.lang.Throwable -> Lac
            java.lang.String r0 = r9.M()     // Catch: java.lang.Throwable -> Lac
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lac
            if (r1 != 0) goto L68
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L68
            java.lang.String r2 = "req_id"
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L68
            goto L6c
        L68:
            r1 = r10
            goto L6c
        L6a:
            r0 = r10
            r1 = r0
        L6c:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lac
            if (r2 == 0) goto L7e
            if (r8 == 0) goto L7e
            com.bytedance.sdk.openadsdk.core.d.a r2 = r8.h     // Catch: java.lang.Throwable -> Lac
            if (r2 == 0) goto L7e
            com.bytedance.sdk.openadsdk.core.d.a r1 = r8.h     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = r1.a()     // Catch: java.lang.Throwable -> Lac
        L7e:
            com.bytedance.sdk.openadsdk.f.a.c r1 = r7.e(r1)     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.f.a.b r1 = (com.bytedance.sdk.openadsdk.f.a.b) r1     // Catch: java.lang.Throwable -> Lac
            if (r9 == 0) goto L8a
            java.lang.String r10 = r9.J()     // Catch: java.lang.Throwable -> Lac
        L8a:
            com.bytedance.sdk.openadsdk.f.a.c r9 = r1.d(r10)     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.f.a.b r9 = (com.bytedance.sdk.openadsdk.f.a.b) r9     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.f.a.c r9 = r9.g(r0)     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.f.a.b r9 = (com.bytedance.sdk.openadsdk.f.a.b) r9     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.f.a.c r6 = r9.c(r6)     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.f.a.b r6 = (com.bytedance.sdk.openadsdk.f.a.b) r6     // Catch: java.lang.Throwable -> Lac
            com.bytedance.sdk.openadsdk.f.a.b r4 = r6.a(r4)     // Catch: java.lang.Throwable -> Lac
            if (r8 == 0) goto La6
            int r5 = r8.f6350a     // Catch: java.lang.Throwable -> Lac
            long r5 = (long) r5     // Catch: java.lang.Throwable -> Lac
            goto La8
        La6:
            r5 = 0
        La8:
            r4.b(r5)     // Catch: java.lang.Throwable -> Lac
            goto Lb4
        Lac:
            r4 = move-exception
            java.lang.String r5 = "NetApiImpl"
            java.lang.String r6 = "uploadAdTypeTimeOutEvent throws exception "
            com.bytedance.sdk.openadsdk.utils.o.c(r5, r6, r4)
        Lb4:
            com.bytedance.sdk.openadsdk.f.a r4 = com.bytedance.sdk.openadsdk.f.a.a()
            r4.b(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(long, java.lang.String, int, com.bytedance.sdk.openadsdk.core.q$a, int, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.c.h a(List<com.bytedance.sdk.openadsdk.c.a> list) {
        String message;
        VAdError vAdError;
        com.bytedance.sdk.adnet.core.m mVar = null;
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        try {
            a(list.get(0));
            jSONObject.put("header", e());
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.c.a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().f5742b);
            }
            jSONObject.put("event", jSONArray);
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String strA = com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.b.b());
        if (!b(strA)) {
            strA = jSONObject.toString();
        }
        String str = strA;
        com.bytedance.sdk.openadsdk.utils.o.b("adevent", "adevent is :" + jSONObject.toString());
        final Map<String, String> mapC = c(str);
        com.bytedance.sdk.adnet.b.i iVarA = com.bytedance.sdk.adnet.b.i.a();
        new com.bytedance.sdk.adnet.b.f(1, ab.i(), str, iVarA) { // from class: com.bytedance.sdk.openadsdk.core.q.3
            @Override // com.bytedance.sdk.adnet.core.Request
            public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                return mapC;
            }
        }.setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).setUserAgent(r.f6359a).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6333a).d());
        try {
            mVar = iVarA.get();
        } catch (Throwable unused2) {
        }
        boolean z2 = mVar != null && d((JSONObject) mVar.f5538a);
        int i = mVar != null ? (int) mVar.h : 0;
        if (z2 || i != 200) {
            message = (mVar == null || (vAdError = mVar.f5540c) == null) ? "error unknown" : vAdError.getMessage();
        } else {
            message = "server say not success";
            z = true;
        }
        return new com.bytedance.sdk.openadsdk.c.h(z2, i, message, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, List<FilterWord> list) {
        JSONObject jSONObjectB;
        if (com.bytedance.sdk.openadsdk.core.g.g.a() && (jSONObjectB = b(hVar, list)) != null) {
            new com.bytedance.sdk.adnet.b.h(1, ab.i("/api/ad/union/dislike_event/"), ab.a(jSONObjectB), null).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6333a).d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.a aVar) {
        aVar.a(-1, g.a(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p.b bVar) {
        bVar.a(-1, g.a(-1));
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject a(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.d.i iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i);
            if (iVar != null) {
                jSONObject.put("render_method", iVar.f6119e);
            } else {
                jSONObject.put("render_method", 1);
            }
            jSONObject.put("ptpl_ids", o.h().h(adSlot.getCodeId()));
            jSONObject.put("pos", AdSlot.getPosition(i));
            a(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i == 9 || i == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            int adCount = adSlot.getAdCount();
            if (adCount < 1) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i == 7 || i == 8) {
                adCount = 1;
            }
            if (iVar != null && iVar.f6118d != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.f5742b) == null) {
            return;
        }
        String strOptString = jSONObject.optString("log_extra", "");
        long jE = ab.e(strOptString);
        int iF = ab.f(strOptString);
        if (jE == 0) {
            jE = this.f6337e;
        }
        this.f6337e = jE;
        if (iF == 0) {
            iF = this.f6338f;
        }
        this.f6338f = iF;
    }

    private static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public void a(JSONObject jSONObject, final p.b bVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            if (bVar != null) {
                bVar.a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || bVar == null) {
                return;
            }
            new com.bytedance.sdk.adnet.b.f(1, ab.i("/api/ad/union/sdk/reward_video/reward/"), ab.a(jSONObject), new m.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.q.4
                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    JSONObject jSONObject2;
                    if (mVar == null || (jSONObject2 = mVar.f5538a) == null) {
                        q.this.a(bVar);
                        return;
                    }
                    int iOptInt = jSONObject2.optInt("cypher", -1);
                    String strOptString = mVar.f5538a.optString("message");
                    JSONObject jSONObject3 = mVar.f5538a;
                    String strK = null;
                    if (iOptInt == 1) {
                        strK = com.bytedance.sdk.openadsdk.core.a.b(strOptString, com.bytedance.sdk.openadsdk.core.b.a());
                    } else if (iOptInt == 2) {
                        strK = ab.k(strOptString);
                    }
                    if (!TextUtils.isEmpty(strK)) {
                        try {
                            jSONObject3 = new JSONObject(strK);
                        } catch (Throwable unused) {
                        }
                    }
                    b bVarA = b.a(jSONObject3);
                    int i = bVarA.f6356a;
                    if (i != 20000) {
                        bVar.a(i, g.a(i));
                    } else if (bVarA.f6358c == null) {
                        q.this.a(bVar);
                    } else {
                        bVar.a(bVarA);
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    VAdError vAdError;
                    String strA = g.a(-2);
                    int i = mVar != null ? (int) mVar.h : -2;
                    if (mVar != null && (vAdError = mVar.f5540c) != null) {
                        strA = vAdError.getMessage();
                    }
                    bVar.a(i, strA);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6333a).d());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    @Override // com.bytedance.sdk.openadsdk.core.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a(org.json.JSONObject r8) {
        /*
            r7 = this;
            java.lang.String r0 = "auction_price"
            if (r8 != 0) goto L5
            return r8
        L5:
            boolean r1 = com.bytedance.sdk.openadsdk.core.q.h     // Catch: java.lang.Throwable -> L59
            if (r1 == 0) goto L59
            java.lang.String r1 = "cypher"
            r2 = -1
            int r1 = r8.optInt(r1, r2)     // Catch: java.lang.Throwable -> L59
            java.lang.String r2 = "message"
            java.lang.String r2 = r8.optString(r2)     // Catch: java.lang.Throwable -> L59
            java.lang.String r3 = ""
            java.lang.String r3 = r8.optString(r0, r3)     // Catch: java.lang.Throwable -> L59
            r4 = 1
            if (r1 != r4) goto L28
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.b.a()     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.b(r2, r5)     // Catch: java.lang.Throwable -> L59
            goto L29
        L28:
            r5 = r2
        L29:
            r6 = 2
            if (r1 != r6) goto L4a
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L59
            if (r1 != 0) goto L4a
            int r1 = r2.length()     // Catch: java.lang.Throwable -> L59
            r6 = 17
            if (r1 < r6) goto L4a
            java.lang.String r1 = r2.substring(r4, r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r1 = r7.d(r1)     // Catch: java.lang.Throwable -> L59
            java.lang.String r2 = r2.substring(r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.b(r2, r1)     // Catch: java.lang.Throwable -> L59
        L4a:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L59
            if (r1 != 0) goto L59
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r5)
            r1.put(r0, r3)     // Catch: java.lang.Throwable -> L5a
            goto L5a
        L59:
            r1 = r8
        L5a:
            boolean r0 = com.bytedance.sdk.openadsdk.core.q.h
            if (r0 == 0) goto L5f
            r8 = r1
        L5f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.core.p
    public com.bytedance.sdk.openadsdk.core.d.k a() {
        com.bytedance.sdk.adnet.core.m mVar;
        if (!com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return null;
        }
        com.bytedance.sdk.adnet.b.i iVarA = com.bytedance.sdk.adnet.b.i.a();
        new com.bytedance.sdk.adnet.b.j(0, o.h().s(), iVarA).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).setShouldCache(false).build(com.bytedance.sdk.openadsdk.g.d.a(this.f6333a).d());
        try {
            mVar = iVarA.get();
        } catch (Exception unused) {
            mVar = null;
        }
        if (mVar == null || !mVar.a()) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.core.d.k.d((String) mVar.f5538a);
    }
}
