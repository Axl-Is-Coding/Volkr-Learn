package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CharSequence f7132c = "sony";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CharSequence f7133d = "amigo";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CharSequence f7134e = "funtouch";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ExecutorService f7135f = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7130a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7131b = false;

    /* JADX INFO: compiled from: RomUtils.java */
    public static class a implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7136a;

        public a(String str) {
            this.f7136a = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strC = u.c(this.f7136a);
            o.b("RomUtils", "property:" + strC + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strC)) {
                try {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        o.d("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + strC);
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("rom_info", "rom_property_info", strC);
                    } else {
                        o.d("RomUtils", "SP-getPropertyFromSP:" + strC);
                        v.a("rom_info", com.bytedance.sdk.openadsdk.core.o.a()).a("rom_property_info", strC);
                    }
                } catch (Throwable unused) {
                }
            }
            return strC;
        }
    }

    public static String a() {
        if (o()) {
            return p();
        }
        if (e()) {
            return l();
        }
        if (b()) {
            return q();
        }
        if (r()) {
            return s();
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            return strM;
        }
        if (g()) {
            return f();
        }
        if (h()) {
            return i();
        }
        if (d()) {
            return c();
        }
        String strJ = j();
        return !TextUtils.isEmpty(strJ) ? strJ : Build.DISPLAY;
    }

    public static String c() {
        return d("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean e() {
        if (!f7131b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f7130a = true;
                    f7131b = true;
                    return f7130a;
                }
            } catch (Exception unused) {
            }
            f7131b = true;
        }
        return f7130a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String strD = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strD) && strD.toLowerCase().contains(f7134e);
    }

    public static boolean h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(f7133d);
    }

    public static String i() {
        return Build.DISPLAY + "_" + d("ro.gn.sv.version");
    }

    public static String j() {
        if (!k()) {
            return "";
        }
        return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        if (!e()) {
            return "";
        }
        return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String m() {
        String strN = n();
        if (strN == null || !strN.toLowerCase().contains("emotionui")) {
            return "";
        }
        return strN + "_" + Build.DISPLAY;
    }

    public static String n() {
        return d("ro.build.version.emui");
    }

    public static boolean o() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String p() {
        if (o()) {
            try {
                return "smartisan_" + d("ro.smartisan.version");
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean r() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String s() {
        if (!r()) {
            return "";
        }
        return "coloros_" + d("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static boolean t() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String u() {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                String strB = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
                o.c("RomUtils", "get Property From SPMultiHelper..." + strB);
                return strB;
            }
            String strB2 = v.a("rom_info", com.bytedance.sdk.openadsdk.core.o.a()).b("rom_property_info", "");
            o.c("RomUtils", "get Property From SP...=" + strB2);
            return strB2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) throws Throwable {
        Process processExec;
        BufferedReader bufferedReader;
        String line = "";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec("getprop " + str);
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                o.c("ToolUtils", "Exception while closing InputStream", e2);
            }
            return line;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            o.c("ToolUtils", "Unable to read sysprop " + str, th);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    o.c("ToolUtils", "Exception while closing InputStream", e3);
                }
            }
            return line;
        }
    }

    private static String d(String str) {
        String str2;
        try {
            String strU = u();
            if (TextUtils.isEmpty(strU)) {
                FutureTask futureTask = new FutureTask(new a(str));
                f7135f.execute(futureTask);
                str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
            } else {
                str2 = strU;
            }
        } catch (Throwable unused) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
    }
}
