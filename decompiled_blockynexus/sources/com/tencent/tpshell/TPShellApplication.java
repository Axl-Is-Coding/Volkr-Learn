package com.tencent.tpshell;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class TPShellApplication extends Application {
    private final native int initialize(String str, String str2, String str3, String str4, String[] strArr, long j, String str5);

    static {
        System.loadLibrary("tprt");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        String[] strArr = null;
        super.attachBaseContext(context);
        try {
            ApplicationInfo applicationInfo = getApplicationInfo();
            String str = applicationInfo.packageName;
            String str2 = applicationInfo.nativeLibraryDir;
            String str3 = applicationInfo.sourceDir;
            File filesDir = getFilesDir();
            String str4 = getPackageManager().getPackageInfo(str, 0).versionName;
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Field declaredField = applicationInfo.getClass().getDeclaredField("splitSourceDirs");
                    declaredField.setAccessible(true);
                    strArr = (String[]) declaredField.get(applicationInfo);
                } catch (Exception e2) {
                }
            }
            if (initialize(str, filesDir.getAbsolutePath(), str2, str3, strArr, (System.currentTimeMillis() - (SystemClock.elapsedRealtimeNanos() / 1000000)) / 10, str4) != 0) {
                throw new Exception("initialize failed.");
            }
        } catch (Exception e3) {
        }
    }
}
