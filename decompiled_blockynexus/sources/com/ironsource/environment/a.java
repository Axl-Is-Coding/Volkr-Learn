package com.ironsource.environment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApplicationContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static JSONObject a(Context context, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                int i = 0;
                if (jSONArray.length() == 0) {
                    while (i < packageInfo.requestedPermissions.length) {
                        jSONObject.put(packageInfo.requestedPermissions[i], (packageInfo.requestedPermissionsFlags[i] & 2) != 0 ? "Granted" : "Rejected");
                        i++;
                    }
                } else {
                    List listAsList = Arrays.asList(packageInfo.requestedPermissions);
                    while (i < jSONArray.length()) {
                        String string = jSONArray.getString(i);
                        int iIndexOf = listAsList.indexOf(string);
                        if (iIndexOf != -1) {
                            jSONObject.put(string, (packageInfo.requestedPermissionsFlags[iIndexOf] & 2) != 0 ? "Granted" : "Rejected");
                        } else {
                            jSONObject.put(string, "notFoundInManifest");
                        }
                        i++;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean c(Context context, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo.requestedPermissions == null) {
                return false;
            }
            boolean zEquals = false;
            for (int i = 0; i < packageInfo.requestedPermissions.length && !zEquals; i++) {
                try {
                    zEquals = str.equals(packageInfo.requestedPermissions[i]);
                } catch (Exception e2) {
                    e = e2;
                    z = zEquals;
                    e.printStackTrace();
                    return z;
                }
            }
            return zEquals;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static String d(Context context) {
        String installerPackageName;
        try {
            installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Throwable unused) {
            installerPackageName = null;
        }
        return TextUtils.isEmpty(installerPackageName) ? "" : installerPackageName;
    }

    public static long e(Context context) {
        try {
            return a(context).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static String f(Context context) {
        return context.getPackageName();
    }

    public static String b(Context context) {
        try {
            return a(context).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long c(Context context) {
        try {
            return a(context).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    static PackageInfo a(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(f(context), 0);
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean a() {
        try {
            Class.forName("kotlin.jvm.internal.i");
            return true;
        } catch (Throwable unused) {
            Log.d("ApplicationContext", "Kotlin Intrinsics not found");
            return false;
        }
    }
}
