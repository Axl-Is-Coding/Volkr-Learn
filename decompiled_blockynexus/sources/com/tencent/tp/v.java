package com.tencent.tp;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collection;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f19725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PackageInfo f19726b;

    public static Boolean a(Object obj) {
        try {
            return (Boolean) k.a("android.app.ActivityThread$ActivityClientRecord", obj, "paused");
        } catch (Exception unused) {
            return true;
        }
    }

    public static void a() {
        Context contextC = c();
        if (contextC != null) {
            try {
                d(contextC);
            } catch (Throwable unused) {
            }
            c(contextC);
            r.a("info:main initialize done");
        }
    }

    public static void a(Context context) {
        r.a("apk_name:" + e());
        r.a("app_name:" + f());
        r.a("ver:" + g());
        r.a("vercode:" + h());
        r.a("model:" + s.e());
        r.a("api_level:" + s.b());
        r.a("sys_ver:" + s.h());
        r.a("sdcard:" + e(context));
        r.a("sd_package:" + f(context));
        r.a("ip_beg");
        k();
        r.a("ip_end");
        r.a("dev_cpuname:" + s.j());
        r.a("debugger:" + b());
        c cVar = new c(context, null);
        String strA = cVar.a();
        if (strA != null) {
            r.a("cert:" + strA);
        }
        String strC = cVar.c();
        if (strC != null) {
            r.a("cert_author:" + strC);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("certenv:");
        sb.append(f.a() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        r.a(sb.toString());
    }

    public static boolean b() {
        return Debug.isDebuggerConnected();
    }

    public static boolean b(Context context) {
        return j(context) && k(context);
    }

    public static Context c() {
        if (f19725a == null) {
            try {
                f19725a = (Context) k.a("android.app.ActivityThread", k.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]), "mInitialApplication");
            } catch (Exception unused) {
                f19725a = null;
            }
        }
        return f19725a;
    }

    private static void c(Context context) {
        new a(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static PackageInfo d() {
        PackageManager packageManager;
        if (f19726b == null) {
            try {
                Context contextC = c();
                String strE = e();
                if (contextC != null && strE != null && (packageManager = contextC.getPackageManager()) != null) {
                    try {
                        f19726b = packageManager.getPackageInfo(strE, 0);
                    } catch (Exception unused) {
                        f19726b = null;
                    }
                }
            } catch (Exception unused2) {
                f19726b = null;
            }
        }
        return f19726b;
    }

    private static void d(Context context) {
        r.a("jar_ver:5.0.5(2020/11/10)-jar-version");
        r.a("files_dir:" + h(context));
        r.a("apk_path:" + g(context));
        r.a("lib_dir:" + i(context));
        r.a("dev_resolution:" + s.c(context));
    }

    public static String e() {
        try {
            Context contextC = c();
            if (contextC != null) {
                return contextC.getPackageName();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String e(Context context) {
        try {
            return i.c(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f() {
        Context contextC = c();
        if (contextC != null) {
            return s.d(contextC);
        }
        return null;
    }

    private static String f(Context context) {
        try {
            return i.d(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g() {
        PackageInfo packageInfoD = d();
        if (packageInfoD != null) {
            return packageInfoD.versionName;
        }
        return null;
    }

    private static String g(Context context) {
        try {
            return context.getPackageResourcePath();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int h() {
        PackageInfo packageInfoD = d();
        if (packageInfoD != null) {
            return packageInfoD.versionCode;
        }
        return 0;
    }

    private static String h(Context context) {
        try {
            return i.a(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Activity i() {
        try {
            return (Activity) k.a("com.unity3d.player.UnityPlayer", "currentActivity");
        } catch (Exception unused) {
            return null;
        }
    }

    private static String i(Context context) {
        String str;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    str = (String) k.a("android.content.pm.ApplicationInfo", applicationInfo, "nativeLibraryDir");
                } catch (Exception unused) {
                    str = null;
                }
            } else {
                str = null;
            }
            if (str != null) {
                return str;
            }
            return applicationInfo.dataDir + File.separator + "lib";
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Activity j() {
        Activity activityI = i();
        return activityI == null ? l() : activityI;
    }

    private static boolean j(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void k() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return;
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                if (inetAddresses != null) {
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                            r.b("ip:" + inetAddressNextElement.getHostAddress());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean k(Context context) {
        try {
            return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Activity l() {
        try {
            Activity activity = null;
            for (Object obj : ((Collection) k.a("java.util.Map", "values", k.a("android.app.ActivityThread", k.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]), "mActivities"), new Class[0], new Object[0])).toArray()) {
                if (obj != null) {
                    Object objA = k.a("android.app.ActivityThread$ActivityClientRecord", obj, "activity");
                    Boolean boolA = a(obj);
                    if (objA != null && (activity == null || !boolA.booleanValue())) {
                        activity = (Activity) objA;
                    }
                }
            }
            return activity;
        } catch (Exception unused) {
            return null;
        }
    }
}
