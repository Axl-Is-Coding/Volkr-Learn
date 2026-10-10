package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.just.agentweb.DefaultWebClient;
import com.sandboxol.center.config.StringConstant;
import io.rong.imkit.plugin.LocationConst;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ToolUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f7086a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static aa f7087b = new aa();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7088c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7089d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f7090e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f7091f = null;
    private static HashSet<String> g = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    /* JADX INFO: compiled from: ToolUtils.java */
    public static class a implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7092a;

        a(int i) {
            this.f7092a = 1;
            this.f7092a = i;
        }

        private String b() {
            String property;
            Throwable th;
            try {
                property = System.getProperty("http.agent");
                if (property != null) {
                    try {
                        if (!"unKnow".equals(property)) {
                            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "android_system_ua", property);
                            } else {
                                com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).a("android_system_ua", property);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        o.e("getUA", "e:" + th.getMessage());
                    }
                }
            } catch (Throwable th3) {
                property = "unKnow";
                th = th3;
            }
            return property;
        }

        private synchronized String c() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.ab.a.1
                @Override // java.lang.Runnable
                public void run() {
                    strArr[0] = ab.q();
                    o.b("getUA", "webview ua：" + strArr[0]);
                }
            });
            while ("unKnow".equals(strArr[0])) {
            }
            return strArr[0];
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized String call() throws Exception {
            String strC;
            strC = this.f7092a == 1 ? c() : "unKnow";
            if (this.f7092a == 2) {
                strC = b();
            }
            return strC;
        }
    }

    public static Intent a(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static String a(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, View view) {
    }

    public static String b(int i) {
        return i != 1 ? i != 2 ? (i == 3 || i == 4) ? "splash_ad" : i != 7 ? i != 8 ? i != 9 ? "embeded_ad" : "draw_ad" : "fullscreen_interstitial_ad" : "rewarded_video" : "interaction" : "banner_ad";
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        return (com.bytedance.sdk.openadsdk.core.h.b() == null || com.bytedance.sdk.openadsdk.core.h.b().a()) ? false : true;
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                b.a(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static long e(String str) {
        JSONObject jSONObjectB = b(str);
        if (jSONObjectB != null) {
            return jSONObjectB.optLong(StringConstant.UID, 0L);
        }
        return 0L;
    }

    public static int f(String str) {
        JSONObject jSONObjectB = b(str);
        if (jSONObjectB != null) {
            return jSONObjectB.optInt("ut", 0);
        }
        return 0;
    }

    public static double g(String str) {
        JSONObject jSONObjectB = b(str);
        if (jSONObjectB != null) {
            return jSONObjectB.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static String h(String str) {
        JSONObject jSONObjectB = b(str);
        return jSONObjectB != null ? jSONObjectB.optString("req_id", "") : "";
    }

    public static String i(String str) {
        String strO = com.bytedance.sdk.openadsdk.core.o.h().o();
        if (!TextUtils.isEmpty(strO)) {
            String str2 = DefaultWebClient.HTTPS_SCHEME + strO + str;
            aa aaVar = f7087b;
            if (!aa.a(com.bytedance.sdk.openadsdk.core.o.a())) {
                return str2;
            }
            aa aaVar2 = f7087b;
            String strA = aa.a("testIp.txt");
            if (strA == null) {
                return str2;
            }
            aa aaVar3 = f7087b;
            return aa.a(str2, strA);
        }
        if (l() == 1) {
            return DefaultWebClient.HTTPS_SCHEME + "pangolin.snssdk.com" + str;
        }
        if (l() == 2) {
            return DefaultWebClient.HTTPS_SCHEME + "pangolin16.sgsnssdk.com" + str;
        }
        return DefaultWebClient.HTTPS_SCHEME + "pangolin16.isnssdk.com" + str;
    }

    public static String j() {
        return l() == 1 ? "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json" : l() == 2 ? "https://sf-tb-sg.ibytedtos.com/obj/ad-pattern-sg/renderer/package_sg.json" : "https://sf16-muse-va.ibytedtos.com/obj/ad-pattern-va/renderer/package_va.json";
    }

    public static String k() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static int l() {
        try {
            String id = TimeZone.getDefault().getID();
            if (g.contains(id)) {
                return 1;
            }
            if (id != null) {
                return id.startsWith("Asia/") ? 2 : 3;
            }
            return 3;
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return 3;
        }
    }

    public static boolean m() {
        String strT = com.bytedance.sdk.openadsdk.core.o.h().t();
        o.b("isGDPRTimeZone", "isGDPRTimeZone-》dc:" + strT);
        if (TextUtils.isEmpty(strT)) {
            try {
                String id = TimeZone.getDefault().getID();
                o.b("isGDPRTimeZone", "isGDPRTimeZone-》isGDPRTimeZone:id:" + id);
                if (id != null) {
                    if (!id.startsWith("Europe/")) {
                        return false;
                    }
                }
            } catch (Exception e2) {
                o.e("ToolUtils", "can ignore msg : " + e2.toString());
            }
        } else if ("CN".equalsIgnoreCase(strT) || "SG".equalsIgnoreCase(strT)) {
            return false;
        }
        return true;
    }

    public static int n() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String o() {
        int i = -n();
        if (i >= 0) {
            return "Etc/GMT+" + i;
        }
        return "Etc/GMT" + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q() {
        try {
            String userAgentString = new WebView(com.bytedance.sdk.openadsdk.core.o.a()).getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).a("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            o.e("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        return hVar != null && c(hVar.M()) == 7;
    }

    public static boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", str);
    }

    public static int c(String str) {
        JSONObject jSONObjectB = b(str);
        if (jSONObjectB != null) {
            return jSONObjectB.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static String e(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar == null || hVar.K() == null || TextUtils.isEmpty(hVar.K().a())) {
            return null;
        }
        return hVar.K().a();
    }

    public static synchronized String f() {
        if (TextUtils.isEmpty(f7089d) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
            try {
                f7089d = com.bytedance.sdk.openadsdk.core.o.a().getPackageName();
            } catch (Throwable th) {
                o.c("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return f7089d;
    }

    public static synchronized String g() {
        if (TextUtils.isEmpty(f7090e) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(f(), 0);
                f7090e = String.valueOf(packageInfo.versionCode);
                f7091f = packageInfo.versionName;
            } catch (Throwable th) {
                o.c("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return f7090e;
    }

    public static synchronized String h() {
        if (TextUtils.isEmpty(f7091f) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(f(), 0);
                f7090e = String.valueOf(packageInfo.versionCode);
                f7091f = packageInfo.versionName;
            } catch (Throwable th) {
                o.c("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return f7091f;
    }

    public static boolean j(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return o(str) || p(str);
    }

    public static JSONObject b(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return com.bytedance.sdk.openadsdk.core.a.b(str.substring(17), q(str.substring(1, 17)));
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", str);
    }

    public static String c() {
        String strB;
        String str = "unKnow";
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                strB = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "webview_ua", "unKnow");
            } else {
                strB = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).b("webview_ua", "unKnow");
            }
        } catch (Exception e2) {
            o.e("getUA", "ee:" + e2.toString());
        }
        if (strB != null && !"unKnow".equals(strB)) {
            o.b("getUA", "getWebViewUA5555---userAgent:" + strB);
            return strB;
        }
        FutureTask futureTask = new FutureTask(new a(1));
        f7086a.execute(futureTask);
        str = (String) futureTask.get(1000L, TimeUnit.MILLISECONDS);
        o.b("getUA", "webview ua：" + str);
        return str;
    }

    public static String e() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return h.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar != null) {
            return c(hVar.M()) == 3 || c(hVar.M()) == 4;
        }
        return false;
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m(str) || n(str);
    }

    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities;
        return (intent == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536)) == null || listQueryIntentActivities.size() <= 0) ? false : true;
    }

    public static String b() {
        String strB;
        String str = "unKnow";
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                strB = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "android_system_ua", "unKnow");
            } else {
                strB = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).b("android_system_ua", "unKnow");
            }
            if (strB != null && !"unKnow".equals(strB)) {
                return strB;
            }
            FutureTask futureTask = new FutureTask(new a(2));
            f7086a.execute(futureTask);
            str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        o.e("getUA", " getAndroidSystemUA userAgent" + str);
        return str;
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        return hVar != null && c(hVar.M()) == 8;
    }

    private static String q(String str) {
        String strA = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str != null) {
            return strA;
        }
        String strA2 = com.bytedance.sdk.openadsdk.core.b.a();
        return strA2.concat(strA2).substring(8, 24);
    }

    public static int d(String str) {
        JSONObject jSONObjectB = b(str);
        if (jSONObjectB != null) {
            return jSONObjectB.optInt("rit", 0);
        }
        return 0;
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar == null) {
            return true;
        }
        int iC = com.bytedance.sdk.openadsdk.core.o.h().c(d(hVar.M()));
        if (iC == 1) {
            return q.d(com.bytedance.sdk.openadsdk.core.o.a());
        }
        if (iC == 2) {
            return q.e(com.bytedance.sdk.openadsdk.core.o.a()) || q.d(com.bytedance.sdk.openadsdk.core.o.a());
        }
        if (iC == 3) {
            return false;
        }
        if (iC != 4) {
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(android.content.Context r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = 0
            java.io.FileReader r0 = new java.io.FileReader     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L59
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L59
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
            r2 = 4096(0x1000, float:5.74E-42)
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L51
        Lf:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            if (r2 == 0) goto L1b
            boolean r3 = r2.contains(r7)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            if (r3 == 0) goto Lf
        L1b:
            if (r2 != 0) goto L24
            r1.close()     // Catch: java.lang.Exception -> L20
        L20:
            r0.close()     // Catch: java.lang.Exception -> L23
        L23:
            return r6
        L24:
            java.lang.String r7 = "\\s+"
            java.lang.String[] r7 = r2.split(r7)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            java.lang.String r2 = "ToolUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            r3.<init>()     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            java.lang.String r4 = "getTotalMemory = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            r4 = 1
            r5 = r7[r4]     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            r3.append(r5)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            com.bytedance.sdk.openadsdk.utils.o.b(r2, r3)     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            r6 = r7[r4]     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L6c
            r1.close()     // Catch: java.lang.Exception -> L48
        L48:
            r0.close()     // Catch: java.lang.Exception -> L4b
        L4b:
            return r6
        L4c:
            r7 = move-exception
            goto L5c
        L4e:
            r7 = move-exception
            r1 = r6
            goto L57
        L51:
            r7 = move-exception
            r1 = r6
            goto L5c
        L54:
            r7 = move-exception
            r0 = r6
            r1 = r0
        L57:
            r6 = r7
            goto L6d
        L59:
            r7 = move-exception
            r0 = r6
            r1 = r0
        L5c:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L66
            r1.close()     // Catch: java.lang.Exception -> L65
            goto L66
        L65:
        L66:
            if (r0 == 0) goto L6b
            r0.close()     // Catch: java.lang.Exception -> L6b
        L6b:
            return r6
        L6c:
            r6 = move-exception
        L6d:
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.lang.Exception -> L73
            goto L74
        L73:
        L74:
            if (r0 == 0) goto L79
            r0.close()     // Catch: java.lang.Exception -> L79
        L79:
            goto L7b
        L7a:
            throw r6
        L7b:
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ab.e(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r1 = 7
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 6
            r7 = 1
            switch(r0) {
                case -1695837674: goto L55;
                case -1364000502: goto L4b;
                case -764631662: goto L41;
                case -712491894: goto L37;
                case 174971131: goto L2d;
                case 564365438: goto L23;
                case 1844104722: goto L19;
                case 1912999166: goto Lf;
                default: goto Le;
            }
        Le:
            goto L5f
        Lf:
            java.lang.String r0 = "draw_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 1
            goto L60
        L19:
            java.lang.String r0 = "interaction"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 3
            goto L60
        L23:
            java.lang.String r0 = "cache_splash_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 5
            goto L60
        L2d:
            java.lang.String r0 = "splash_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 4
            goto L60
        L37:
            java.lang.String r0 = "embeded_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 0
            goto L60
        L41:
            java.lang.String r0 = "fullscreen_interstitial_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 6
            goto L60
        L4b:
            java.lang.String r0 = "rewarded_video"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 7
            goto L60
        L55:
            java.lang.String r0 = "banner_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L5f
            r8 = 2
            goto L60
        L5f:
            r8 = -1
        L60:
            switch(r8) {
                case 0: goto L6a;
                case 1: goto L69;
                case 2: goto L68;
                case 3: goto L67;
                case 4: goto L66;
                case 5: goto L66;
                case 6: goto L65;
                case 7: goto L64;
                default: goto L63;
            }
        L63:
            return r7
        L64:
            return r1
        L65:
            return r2
        L66:
            return r3
        L67:
            return r4
        L68:
            return r5
        L69:
            return r6
        L6a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ab.a(java.lang.String):int");
    }

    public static String d() {
        return UUID.randomUUID().toString();
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", str);
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        return hVar != null && c(hVar.M()) == 9;
    }

    public static String a() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(";");
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            String strSubstring = strConcat.substring(0, i);
            strConcat = strSubstring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String i() {
        String strP = com.bytedance.sdk.openadsdk.core.o.h().p();
        if (TextUtils.isEmpty(strP)) {
            return l() == 1 ? "https://extlog.snssdk.com/service/2/app_log/" : l() == 2 ? "https://log.sgsnssdk.com/service/2/app_log/" : "https://log-mva.isnssdk.com/service/2/app_log/";
        }
        if (strP.startsWith("http")) {
            return strP;
        }
        return DefaultWebClient.HTTPS_SCHEME + strP;
    }

    public static String b(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage() + "_" + locale.getCountry();
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static String c(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static String a(Context context) throws Throwable {
        String strB = com.bytedance.sdk.openadsdk.core.d.a(context).b("total_memory", (String) null);
        if (strB != null) {
            return strB;
        }
        String strE = e(context, "MemTotal");
        com.bytedance.sdk.openadsdk.core.d.a(context).a("total_memory", strE);
        return strE;
    }

    public static Map<String, Object> a(boolean z, com.bytedance.sdk.openadsdk.core.d.h hVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", hVar.J());
        map.put("load_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.n nVarV = hVar.v();
        if (nVarV != null) {
            map.put("video_size", Long.valueOf(nVarV.d()));
            map.put("video_resolution", nVarV.f());
        }
        if (!z) {
            map.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str);
        }
        return map;
    }

    public static Map<String, Object> a(long j, com.bytedance.sdk.openadsdk.core.d.h hVar, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        HashMap map = new HashMap();
        map.put("video_start_duration", Long.valueOf(j));
        if (hVar != null) {
            if (!TextUtils.isEmpty(hVar.J())) {
                map.put("creative_id", hVar.J());
            }
            com.bytedance.sdk.openadsdk.core.d.n nVarV = hVar.v();
            if (nVarV != null) {
                map.put("video_resolution", nVarV.f());
                map.put("video_size", Long.valueOf(nVarV.d()));
            }
        }
        a(map, dVar);
        return map;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.h hVar, int i, int i2, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        HashMap map = new HashMap();
        map.put("creative_id", hVar.J());
        map.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Integer.valueOf(i));
        map.put("extra_error_code", Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.core.d.n nVarV = hVar.v();
        if (nVarV != null) {
            map.put("video_size", Long.valueOf(nVarV.d()));
            map.put("video_resolution", nVarV.f());
        }
        a(map, dVar);
        return map;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.h hVar, long j, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        HashMap map = new HashMap();
        map.put("creative_id", hVar.J());
        map.put("buffers_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.n nVarV = hVar.v();
        if (nVarV != null) {
            map.put("video_size", Long.valueOf(nVarV.d()));
            map.put("video_resolution", nVarV.f());
        }
        a(map, dVar);
        return map;
    }

    private static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        if (map.containsKey("video_resolution") || dVar == null) {
            return;
        }
        try {
            if (dVar.a() != null) {
                map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(dVar.a().getVideoWidth()), Integer.valueOf(dVar.a().getVideoHeight())));
            }
        } catch (Throwable unused) {
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar, boolean z) {
        if (cVar == null || cVar.t() == null || !cVar.t().g()) {
            return 3;
        }
        return !z ? 1 : 0;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strA = com.bytedance.sdk.openadsdk.core.a.a();
                String str = 2 + strA + com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.a.a(strA));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        if (hVar != null) {
            try {
                String strA = hVar.A();
                if (TextUtils.isEmpty(strA) && hVar.L() != null && hVar.L().c() == 1 && !TextUtils.isEmpty(hVar.L().b())) {
                    strA = hVar.L().b();
                }
                String str2 = strA;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.x.a(com.bytedance.sdk.openadsdk.core.o.a(), str2, hVar, a(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, boolean z) {
        String strA;
        if (!aa.a(com.bytedance.sdk.openadsdk.core.o.a()) || (strA = aa.a("testGps.txt")) == null) {
            return;
        }
        String[] strArrSplit = strA.split(",");
        try {
            if (z) {
                jSONObject.put(LocationConst.LATITUDE, Float.parseFloat(strArrSplit[1]));
                jSONObject.put(LocationConst.LONGITUDE, Float.parseFloat(strArrSplit[0]));
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(LocationConst.LATITUDE, Float.parseFloat(strArrSplit[1]));
                jSONObject2.put(LocationConst.LONGITUDE, Float.parseFloat(strArrSplit[0]));
                jSONObject.put("geo", jSONObject2);
            }
        } catch (JSONException unused) {
        }
    }
}
