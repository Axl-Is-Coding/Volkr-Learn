package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f3199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3200b = "DefaultSessionId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f3201c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f3202d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f3203e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f3204f = "";
    public static String g = "null";
    public static String h = "";
    public static String i = "";
    public static String j = "";
    private static String k = "3.5.1.16";
    private static String l = "";
    private static String m = "";
    private static Handler n = null;
    public static boolean o = true;

    public static Context a() {
        return f3199a;
    }

    public static void a(int i2, C c2, String str) {
        f3201c = SystemClock.elapsedRealtime();
        Process.myPid();
        Context context = c2.f2883a;
        f3199a = context.getApplicationContext();
        f3204f = context.getPackageName();
        f3202d = i2;
        f3203e = c2.f2885c;
        String str2 = c2.f2886d;
        if (C0455pa.a(str2)) {
            str2 = "";
        }
        i = str2;
        String str3 = c2.f2887e;
        if (C0455pa.a(str3)) {
            str3 = "";
        }
        j = str3;
        k = "3.5.1.16";
        new Handler(f3199a.getMainLooper());
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            g = packageInfo.versionName;
            int i3 = packageInfo.versionCode;
            h = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable unused) {
        }
        l = str;
        f3204f.equals(l);
        HandlerThread handlerThread = new HandlerThread("halley_" + f3202d + "_TempTask", 10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        n = handler;
        handler.post(new RunnableC0436j());
    }

    public static boolean b() {
        return false;
    }

    public static int c() {
        return f3202d;
    }

    public static String d() {
        return f3200b;
    }

    public static int e() {
        return (int) (SystemClock.elapsedRealtime() - f3201c);
    }

    public static String f() {
        return f3204f;
    }

    public static boolean g() {
        return f3203e;
    }

    public static String h() {
        return k;
    }

    public static String i() {
        if (!C0455pa.a(m)) {
            return m;
        }
        if (C0455pa.a(l) || !l.contains(":")) {
            return "";
        }
        return l.substring(l.indexOf(":") + 1);
    }

    public static Handler j() {
        return n;
    }
}
