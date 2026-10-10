package com.sandboxol.common.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.sandboxol.common.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionUtils {
    public static boolean checkAndApplyfPermissionActivity(Activity activity, String[] strArr, int i) {
        String[] strArrCheckPermissions;
        if (Build.VERSION.SDK_INT < 23 || (strArrCheckPermissions = checkPermissions(activity, strArr)) == null || strArrCheckPermissions.length <= 0) {
            return true;
        }
        ActivityCompat.a(activity, strArrCheckPermissions, i);
        return false;
    }

    public static boolean checkAndApplyfPermissionFragment(Fragment fragment, String[] strArr, int i) {
        String[] strArrCheckPermissions;
        if (Build.VERSION.SDK_INT < 23 || (strArrCheckPermissions = checkPermissions(fragment.getActivity(), strArr)) == null || strArrCheckPermissions.length <= 0) {
            return true;
        }
        if (fragment.getActivity() == null) {
            return false;
        }
        fragment.requestPermissions(strArrCheckPermissions, i);
        return false;
    }

    public static boolean checkPermission(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        int i = 0;
        for (int i2 : iArr) {
            if (i2 == 0) {
                i++;
            }
        }
        return i == iArr.length;
    }

    public static String[] checkPermissions(Context context, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (b.a(context, (String) arrayList.get(size)) == 0) {
                arrayList.remove(size);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr2[i] = (String) arrayList.get(i);
        }
        return strArr2;
    }

    public static void getAppDetailSettingIntent(Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        int i = Build.VERSION.SDK_INT;
        if (i >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (i <= 8) {
            intent.setAction("android.intent.action.VIEW");
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        launchApp(context, intent);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSystemProperty(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "getSystemProperty"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r4.<init>()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r4.append(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L63
            r4.close()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L63
            r4.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r7 = move-exception
            android.util.Log.e(r1, r0, r7)
        L3d:
            return r3
        L3e:
            r3 = move-exception
            goto L44
        L40:
            r7 = move-exception
            goto L65
        L42:
            r3 = move-exception
            r4 = r2
        L44:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r5.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L63
            r5.append(r7)     // Catch: java.lang.Throwable -> L63
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L63
            android.util.Log.e(r1, r7, r3)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r7 = move-exception
            android.util.Log.e(r1, r0, r7)
        L62:
            return r2
        L63:
            r7 = move-exception
            r2 = r4
        L65:
            if (r2 == 0) goto L6f
            r2.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L6f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.common.utils.PermissionUtils.getSystemProperty(java.lang.String):java.lang.String");
    }

    public static void gotoPermissionManager(Context context) {
        Intent intent;
        try {
            switch (Build.MANUFACTURER) {
                case "Huawei":
                    Intent intent2 = new Intent();
                    intent2.setFlags(268435456);
                    intent2.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    intent2.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
                    context.startActivity(intent2);
                    break;
                case "Meizu":
                    Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                    intent3.addCategory("android.intent.category.DEFAULT");
                    intent3.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    context.startActivity(intent3);
                    break;
                case "Xiaomi":
                    if ("v5".equals(getSystemProperty("ro.miui.ui.version.name"))) {
                        intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getApplicationInfo().packageName));
                    } else {
                        intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                        intent.putExtra("extra_pkgname", context.getPackageName());
                    }
                    context.startActivity(intent);
                    break;
                case "Sony":
                    Intent intent4 = new Intent();
                    intent4.setFlags(268435456);
                    intent4.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    intent4.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
                    context.startActivity(intent4);
                    break;
                case "OPPO":
                    Intent intent5 = new Intent();
                    intent5.setFlags(268435456);
                    intent5.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    intent5.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                    context.startActivity(intent5);
                    break;
                case "LG":
                    Intent intent6 = new Intent("android.intent.action.MAIN");
                    intent6.setFlags(268435456);
                    intent6.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    intent6.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
                    context.startActivity(intent6);
                    break;
                case "Letv":
                    Intent intent7 = new Intent();
                    intent7.setFlags(268435456);
                    intent7.putExtra("packageName", BuildConfig.APPLICATION_ID);
                    intent7.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
                    context.startActivity(intent7);
                    break;
                default:
                    getAppDetailSettingIntent(context);
                    break;
            }
        } catch (Exception unused) {
            getAppDetailSettingIntent(context);
        }
    }

    public static boolean launchApp(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void showPermissionToast(android.app.Activity r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.common.utils.PermissionUtils.showPermissionToast(android.app.Activity, java.lang.String):void");
    }

    public static void showPermissionsToast(Activity activity, String[] strArr) {
        if (strArr.length > 0) {
            for (String str : strArr) {
                showPermissionToast(activity, str);
            }
        }
    }
}
