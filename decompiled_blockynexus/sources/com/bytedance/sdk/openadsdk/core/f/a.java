package com.bytedance.sdk.openadsdk.core.f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.bytedance.sdk.openadsdk.utils.o;

/* JADX INFO: compiled from: MIUIPermissionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6163a = "a";

    public static boolean a(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? b(context, str) : c(context, str);
    }

    private static boolean b(Context context, String str) {
        o.e(f6163a, "checkPermissinKITKATNew，permission：" + str);
        boolean z = true;
        try {
            str.hashCode();
            String lowerCase = str.replaceFirst("android.permission.", "android:").toLowerCase();
            int iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
            o.e(f6163a, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
            if (iCheckOp == 0) {
                return true;
            }
            z = false;
            o.e(f6163a, "checkPermissinKITKATNew，false,permission：" + lowerCase);
            return false;
        } catch (Exception e2) {
            o.e(f6163a, "权限检查出错时默认返回有权限，异常代码：" + e2);
            return z;
        }
    }

    private static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
