package com.ironsource.mediationsdk.d;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.ironsource.environment.c;
import com.ironsource.mediationsdk.L;
import com.ironsource.mediationsdk.utils.j;
import java.util.ArrayList;

/* JADX INFO: compiled from: IntegrationHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(Activity activity) {
        Log.i("IntegrationHelper", "Verifying Integration:");
        c(activity);
        for (String str : new String[]{"AdColony", "AdMob", "Amazon", "AppLovin", "Chartboost", "Facebook", "Fyber", "HyprMX", "InMobi", "SupersonicAds", "Maio", "MyTarget", "Pangle", "Tapjoy", "UnityAds", "Vungle"}) {
            if (b(activity, str)) {
                if (str.equalsIgnoreCase("SupersonicAds")) {
                    Log.i("IntegrationHelper", ">>>> IronSource - VERIFIED");
                } else {
                    Log.i("IntegrationHelper", ">>>> " + str + " - VERIFIED");
                }
            } else if (str.equalsIgnoreCase("SupersonicAds")) {
                Log.e("IntegrationHelper", ">>>> IronSource - NOT VERIFIED");
            } else {
                Log.e("IntegrationHelper", ">>>> " + str + " - NOT VERIFIED");
            }
        }
        b(activity);
    }

    private static boolean b(Activity activity, String str) {
        try {
            if (str.equalsIgnoreCase("SupersonicAds")) {
                Log.i("IntegrationHelper", "--------------- IronSource  --------------");
            } else {
                Log.i("IntegrationHelper", "--------------- " + str + " --------------");
            }
            String str2 = "com.ironsource.adapters." + c.a(str) + Consts.DOT + str + "Adapter";
            L lA = a(activity, str2);
            if (lA == null) {
                return false;
            }
            if (!str.equalsIgnoreCase("SupersonicAds") && !a(lA)) {
                return false;
            }
            a(str2);
            boolean zA = a(activity, lA.f14676c);
            if (!a(lA.f14677d)) {
                zA = false;
            }
            if (!b(activity, lA.f14678e)) {
                zA = false;
            }
            if (!lA.f14679f || Build.VERSION.SDK_INT > 18) {
                return zA;
            }
            if (activity.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", activity.getPackageName()) == 0) {
                Log.i("IntegrationHelper", "android.permission.WRITE_EXTERNAL_STORAGE - VERIFIED");
                return zA;
            }
            Log.e("IntegrationHelper", "android.permission.WRITE_EXTERNAL_STORAGE - MISSING");
            return false;
        } catch (Exception e2) {
            Log.e("IntegrationHelper", "isAdapterValid " + str, e2);
            return false;
        }
    }

    private static void c(Activity activity) {
        Log.i("IntegrationHelper", "*** Permissions ***");
        PackageManager packageManager = activity.getPackageManager();
        if (packageManager.checkPermission("android.permission.INTERNET", activity.getPackageName()) == 0) {
            Log.i("IntegrationHelper", "android.permission.INTERNET - VERIFIED");
        } else {
            Log.e("IntegrationHelper", "android.permission.INTERNET - MISSING");
        }
        if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", activity.getPackageName()) == 0) {
            Log.i("IntegrationHelper", "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
        } else {
            Log.e("IntegrationHelper", "android.permission.ACCESS_NETWORK_STATE - MISSING");
        }
    }

    private static boolean a(ArrayList<Pair<String, String>> arrayList) {
        boolean z = true;
        if (arrayList == null) {
            return true;
        }
        Log.i("IntegrationHelper", "*** External Libraries ***");
        for (Pair<String, String> pair : arrayList) {
            try {
                Class.forName((String) pair.first);
                Log.i("IntegrationHelper", ((String) pair.second) + " - VERIFIED");
            } catch (ClassNotFoundException unused) {
                z = false;
                Log.e("IntegrationHelper", ((String) pair.second) + " - MISSING");
            }
        }
        return z;
    }

    private static boolean b(Activity activity, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        PackageManager packageManager = activity.getPackageManager();
        Log.i("IntegrationHelper", "*** Services ***");
        boolean z = true;
        for (String str : strArr) {
            try {
            } catch (ClassNotFoundException unused) {
                Log.e("IntegrationHelper", str + " - MISSING");
            }
            if (packageManager.queryIntentServices(new Intent(activity, Class.forName(str)), 65536).size() > 0) {
                Log.i("IntegrationHelper", str + " - VERIFIED");
            } else {
                Log.e("IntegrationHelper", str + " - MISSING");
                z = false;
            }
        }
        return z;
    }

    private static boolean a(Activity activity, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        Log.i("IntegrationHelper", "*** Activities ***");
        boolean z = true;
        for (String str : strArr) {
            try {
            } catch (ClassNotFoundException unused) {
                Log.e("IntegrationHelper", str + " - MISSING");
            }
            if (activity.getPackageManager().queryIntentActivities(new Intent(activity, Class.forName(str)), 65536).size() > 0) {
                Log.i("IntegrationHelper", str + " - VERIFIED");
            } else {
                Log.e("IntegrationHelper", str + " - MISSING");
                z = false;
            }
        }
        return z;
    }

    private static boolean a(L l) {
        if (!l.f14675b.startsWith("4.1") && !l.f14675b.startsWith("4.3")) {
            Log.e("IntegrationHelper", l.f14674a + " adapter " + l.f14675b + " is incompatible with SDK version " + j.c() + ", please update your adapter to version 4.1.*");
            return false;
        }
        Log.i("IntegrationHelper", "Adapter - VERIFIED");
        return true;
    }

    private static void b(Activity activity) {
        new a(activity).start();
    }

    private static L a(Activity activity, String str) {
        try {
            L l = (L) Class.forName(str).getMethod("getIntegrationData", Activity.class).invoke(null, activity);
            Log.i("IntegrationHelper", "Adapter " + l.f14675b + " - VERIFIED");
            return l;
        } catch (ClassNotFoundException unused) {
            Log.e("IntegrationHelper", "Adapter - MISSING");
            return null;
        } catch (Exception unused2) {
            Log.e("IntegrationHelper", "Adapter version - NOT VERIFIED");
            return null;
        }
    }

    private static void a(String str) {
        try {
            Log.i("IntegrationHelper", "SDK Version - " + ((String) Class.forName(str).getMethod("getAdapterSDKVersion", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception unused) {
            Log.w("validateSDKVersion", "Unable to get SDK version");
        }
    }
}
