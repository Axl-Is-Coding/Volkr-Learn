package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2864a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f2865b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f2866c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f2867d = "";

    private static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable unused) {
            return "null";
        }
    }

    public static void a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(";Android ");
        stringBuffer.append(b());
        stringBuffer.append(",level ");
        stringBuffer.append(c());
        f2864a = stringBuffer.toString();
        f2865b = b(context);
        context.getPackageName();
        f2866c = d();
        f2867d = a();
    }

    private static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return "null";
        }
    }

    private static String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str != null && str.trim().length() > 0) {
                String strReplace = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
                int i2 = 0;
                for (char c2 : strReplace.toCharArray()) {
                    if (c2 == '.') {
                        i2++;
                    }
                }
                if (i2 >= 3) {
                    return strReplace;
                }
                return strReplace + Consts.DOT + i;
            }
            return String.valueOf(i);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String c() {
        try {
            return Build.VERSION.SDK;
        } catch (Throwable unused) {
            return "null";
        }
    }

    private static String d() {
        try {
            return Build.BRAND;
        } catch (Throwable unused) {
            return null;
        }
    }
}
