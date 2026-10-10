package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocationListener;

/* JADX INFO: renamed from: c.t.m.g.ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0446ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3303a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3304b = "";

    /* JADX INFO: renamed from: c.t.m.g.ma$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3308d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3309e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bundle f3310f;

        public a(int i, String str, boolean z, boolean z2, String str2, Bundle bundle) {
            this.f3307c = false;
            this.f3308d = false;
            this.f3309e = "";
            this.f3305a = i;
            this.f3306b = str;
            this.f3307c = z;
            this.f3308d = z2;
            this.f3309e = str2;
            this.f3310f = bundle;
        }

        public final String toString() {
            return "appid:" + this.f3305a + "," + this.f3306b + "," + this.f3307c + "," + this.f3308d + "," + this.f3309e;
        }
    }

    public static int a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return -407;
            }
            if (applicationInfo.metaData == null) {
                return -408;
            }
            int i = applicationInfo.metaData.getInt("halley_appid", 0);
            if (i <= 0) {
                return -408;
            }
            return i;
        } catch (PackageManager.NameNotFoundException unused) {
            return -407;
        }
    }

    public static a a(int i, Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(str, str2), 128);
            if (serviceInfo != null) {
                return new a(i, str, serviceInfo.enabled, serviceInfo.exported, serviceInfo.processName, serviceInfo.metaData);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static String a(int i) {
        return i == 2 ? "2g" : i == 3 ? "3g" : i == 4 ? "4g" : i == 1 ? TencentLocationListener.WIFI : "";
    }

    public static String a(Context context) throws Throwable {
        if (!TextUtils.isEmpty(f3303a)) {
            return f3303a;
        }
        String packageName = context.getPackageName();
        String strA = C0455pa.a(Process.myPid());
        if (TextUtils.isEmpty(strA) || !strA.startsWith(packageName)) {
            strA = C0455pa.a(context, Process.myPid());
        }
        f3303a = strA;
        return strA;
    }

    private static String a(boolean z) {
        fc.b();
        String str = "HalleyServicePreferences_" + fc.c();
        if (!z) {
            return str;
        }
        return str + "_" + fc.i();
    }

    public static void a(String str) {
        fc.a().getSharedPreferences(a(false), 0).edit().putString("deviceid", str).commit();
        f3304b = str;
    }

    public static void a(String str, int i) {
        fc.a().getSharedPreferences(a(false), 0).edit().putInt(str, i).commit();
    }

    public static void a(String str, long j) {
        fc.a().getSharedPreferences(a(false), 0).edit().putLong(str, j).commit();
    }

    public static void a(String str, String str2) {
        fc.a().getSharedPreferences(a(true), 0).edit().putString(str, str2).commit();
    }

    public static long b(String str) {
        return fc.a().getSharedPreferences(a(false), 0).getLong(str, 0L);
    }

    public static String b(String str, String str2) {
        return fc.a().getSharedPreferences(a(true), 0).getString(str, str2);
    }

    public static int c(String str) {
        return fc.a().getSharedPreferences(a(false), 0).getInt(str, 0);
    }

    public static String a() {
        if (!TextUtils.isEmpty(f3304b)) {
            return f3304b;
        }
        String string = fc.a().getSharedPreferences(a(false), 0).getString("deviceid", "");
        f3304b = string;
        return string;
    }
}
