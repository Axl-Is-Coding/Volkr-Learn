package com.bytedance.sdk.openadsdk.core.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;

/* JADX INFO: compiled from: PermissionActivityCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Activity activity, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i);
        }
    }

    public static int a(Context context, String str) {
        if (str != null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable th) {
                th.printStackTrace();
                return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
            }
        }
        throw new IllegalArgumentException("permission is null");
    }
}
