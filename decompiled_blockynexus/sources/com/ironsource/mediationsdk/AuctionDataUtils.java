package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.logger.IronLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AuctionDataUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AuctionDataUtils f14602a = new AuctionDataUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14603b = "";

    private enum SecureFlag {
        NOT_SECURE,
        SECURE
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f14604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<C2325i> f14605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C2325i f14606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f14607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f14608e;

        public String c() {
            return this.f14608e;
        }

        public C2325i d() {
            return this.f14606c;
        }

        public List<C2325i> e() {
            return this.f14605b;
        }

        public int b() {
            return this.f14607d;
        }

        public String a() {
            return this.f14604a;
        }
    }

    public static AuctionDataUtils b() {
        return f14602a;
    }

    private SecureFlag d() {
        SecureFlag secureFlag;
        SecureFlag secureFlag2 = SecureFlag.SECURE;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            secureFlag = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? SecureFlag.NOT_SECURE : SecureFlag.SECURE;
        } else if (i >= 23) {
            secureFlag = (com.ironsource.mediationsdk.utils.c.c().a().getApplicationInfo().flags & 134217728) != 0 ? SecureFlag.NOT_SECURE : SecureFlag.SECURE;
        } else {
            secureFlag = SecureFlag.NOT_SECURE;
        }
        IronLog.INTERNAL.verbose("secureFlag = " + secureFlag);
        return secureFlag;
    }

    private String e() {
        String language = Locale.getDefault().getLanguage();
        IronLog.INTERNAL.verbose("lang = " + language);
        return language;
    }

    private String f() {
        return com.ironsource.environment.b.j(com.ironsource.mediationsdk.utils.c.c().b()) ? "Tablet" : "Phone";
    }

    public void c() {
        Context contextA = com.ironsource.mediationsdk.utils.c.c().a();
        if (contextA != null) {
            com.ironsource.mediationsdk.utils.c.c().b(new RunnableC2319f(this, contextA));
        }
    }

    public String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : str;
        } catch (JSONException unused) {
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.ironsource.mediationsdk.AuctionDataUtils.a a(org.json.JSONObject r6) throws org.json.JSONException {
        /*
            r5 = this;
            com.ironsource.mediationsdk.AuctionDataUtils$a r0 = new com.ironsource.mediationsdk.AuctionDataUtils$a
            r0.<init>()
            java.lang.String r1 = "auctionId"
            java.lang.String r1 = r6.getString(r1)
            com.ironsource.mediationsdk.AuctionDataUtils.a.a(r0, r1)
            java.lang.String r1 = "settings"
            boolean r2 = r6.has(r1)
            if (r2 == 0) goto L2f
            org.json.JSONObject r1 = r6.getJSONObject(r1)
            com.ironsource.mediationsdk.i r2 = new com.ironsource.mediationsdk.i
            r2.<init>(r1)
            com.ironsource.mediationsdk.AuctionDataUtils.a.a(r0, r2)
            java.lang.String r2 = "armData"
            boolean r3 = r1.has(r2)
            if (r3 == 0) goto L2f
            org.json.JSONObject r1 = r1.optJSONObject(r2)
            goto L30
        L2f:
            r1 = 0
        L30:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.ironsource.mediationsdk.AuctionDataUtils.a.a(r0, r2)
            java.lang.String r2 = "waterfall"
            org.json.JSONArray r6 = r6.getJSONArray(r2)
            r2 = 0
        L3f:
            int r3 = r6.length()
            if (r2 >= r3) goto L7f
            com.ironsource.mediationsdk.i r3 = new com.ironsource.mediationsdk.i
            org.json.JSONObject r4 = r6.getJSONObject(r2)
            r3.<init>(r4, r1)
            boolean r4 = r3.g()
            if (r4 == 0) goto L5e
            java.util.List r4 = com.ironsource.mediationsdk.AuctionDataUtils.a.a(r0)
            r4.add(r3)
            int r2 = r2 + 1
            goto L3f
        L5e:
            r6 = 1002(0x3ea, float:1.404E-42)
            com.ironsource.mediationsdk.AuctionDataUtils.a.a(r0, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "waterfall "
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.ironsource.mediationsdk.AuctionDataUtils.a.b(r0, r6)
            org.json.JSONException r6 = new org.json.JSONException
            java.lang.String r0 = "invalid response"
            r6.<init>(r0)
            throw r6
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.AuctionDataUtils.a(org.json.JSONObject):com.ironsource.mediationsdk.AuctionDataUtils$a");
    }

    public Map<String, String> c(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        map.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return map;
    }

    void e(String str) {
        new b().execute(str);
    }

    public String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                return "";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            return jSONObject2.has("dynamicDemandSource") ? jSONObject2.getString("dynamicDemandSource") : "";
        } catch (JSONException unused) {
            return "";
        }
    }

    static class b extends AsyncTask<String, Void, Boolean> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                httpURLConnection.disconnect();
                return Boolean.valueOf(responseCode == 200);
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
        }
    }

    public String a() {
        Context contextA;
        if (this.f14603b.isEmpty() && (contextA = com.ironsource.mediationsdk.utils.c.c().a()) != null) {
            return com.ironsource.mediationsdk.utils.j.a(contextA);
        }
        return this.f14603b;
    }

    public C2325i a(String str, List<C2325i> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).b().equals(str)) {
                return list.get(i);
            }
        }
        return null;
    }

    JSONObject a(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i, String str, com.ironsource.mediationsdk.utils.a aVar, C2374v c2374v) throws JSONException {
        Object objA;
        String strL;
        String[] strArrC;
        JSONObject jSONObject = new JSONObject();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            objA = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceType", 2);
            jSONObject2.put("biddingAdditionalData", new JSONObject((Map) map.get(next)));
            if (auctionHistory != null) {
                objA = auctionHistory.a(next);
            }
            jSONObject2.put("performance", objA);
            jSONObject.put(next, jSONObject2);
        }
        if (list != null) {
            for (String str2 : list) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("instanceType", 1);
                jSONObject3.put("performance", auctionHistory != null ? auctionHistory.a(str2) : "");
                jSONObject.put(str2, jSONObject3);
            }
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMapB = C2313c.a().b();
        JSONObject jSONObject4 = new JSONObject();
        for (Map.Entry<String, List<String>> entry : concurrentHashMapB.entrySet()) {
            jSONObject4.put(entry.getKey(), TextUtils.join(",", entry.getValue()));
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("applicationUserId", U.e().g());
        Boolean boolB = U.e().b();
        if (boolB != null) {
            jSONObject5.put("consent", boolB.booleanValue() ? 1 : 0);
        }
        jSONObject5.put("mobileCarrier", com.ironsource.environment.b.k(context));
        jSONObject5.put("connectionType", com.ironsource.mediationsdk.utils.j.b(context));
        jSONObject5.put("deviceOS", "android");
        jSONObject5.put("deviceWidth", context.getResources().getConfiguration().screenWidthDp);
        jSONObject5.put("deviceHeight", context.getResources().getConfiguration().screenHeightDp);
        jSONObject5.put("deviceOSVersion", Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")");
        jSONObject5.put("deviceModel", Build.MODEL);
        jSONObject5.put("deviceMake", Build.MANUFACTURER);
        jSONObject5.put("bundleId", context.getPackageName());
        jSONObject5.put("appVersion", com.ironsource.environment.a.a(context, context.getPackageName()));
        jSONObject5.put("clientTimestamp", new Date().getTime());
        jSONObject5.put("browserUserAgent", a());
        jSONObject5.put("deviceType", f());
        jSONObject5.put("deviceLang", e());
        jSONObject5.put("secure", d().ordinal());
        if (c2374v != null) {
            jSONObject5.put("bannerSize", c2374v.a());
            jSONObject5.put("bannerWidth", c2374v.c());
            jSONObject5.put("bannerHeight", c2374v.b());
        }
        boolean zBooleanValue = false;
        try {
            strArrC = com.ironsource.environment.b.c(context);
        } catch (Exception unused) {
        }
        if (strArrC == null || strArrC.length != 2) {
            strL = "";
        } else {
            strL = !TextUtils.isEmpty(strArrC[0]) ? strArrC[0] : "";
            try {
                zBooleanValue = Boolean.valueOf(strArrC[1]).booleanValue();
            } catch (Exception unused2) {
            }
        }
        if (TextUtils.isEmpty(strL)) {
            strL = com.ironsource.environment.b.l(context);
            if (!TextUtils.isEmpty(strL)) {
                objA = "UUID";
            }
        } else {
            objA = "GAID";
        }
        if (!TextUtils.isEmpty(strL)) {
            jSONObject5.put("advId", strL);
            jSONObject5.put("advIdType", objA);
            jSONObject5.put("isLimitAdTrackingEnabled", zBooleanValue ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("applicationKey", U.e().f());
        jSONObject6.put("SDKVersion", com.ironsource.mediationsdk.utils.j.c());
        jSONObject6.put("clientParams", jSONObject5);
        jSONObject6.put("sessionDepth", i);
        jSONObject6.put("sessionId", str);
        jSONObject6.put("instances", jSONObject);
        jSONObject6.put("auctionData", aVar.a());
        jSONObject6.put("metaData", jSONObject4);
        return jSONObject6;
    }

    JSONObject a(String str) {
        try {
            return new JSONObject(com.ironsource.mediationsdk.utils.i.a("C38FB23A402222A0C17D34A92F971D1F", str));
        } catch (Exception unused) {
            return null;
        }
    }

    public String a(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        return str.replace("${AUCTION_PRICE}", str4).replace("${AUCTION_LOSS}", str6).replace("${AUCTION_MBR}", str5).replace("${INSTANCE}", str2).replace("${INSTANCE_TYPE}", Integer.toString(i)).replace("${DYNAMIC_DEMAND_SOURCE}", str3).replace("${PLACEMENT_NAME}", str7);
    }

    public String a(String str, int i, C2325i c2325i, String str2, String str3, String str4) {
        String strE = c2325i.e();
        return a(str, c2325i.b(), i, b().d(c2325i.f()), strE, b().a(strE, str2), str3, str4);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double d2 = Double.parseDouble(str);
        double d3 = Double.parseDouble(str2);
        if (d3 == 0.0d) {
            return "";
        }
        double dRound = Math.round((d2 / d3) * 1000.0d);
        Double.isNaN(dRound);
        return String.valueOf(dRound / 1000.0d);
    }
}
