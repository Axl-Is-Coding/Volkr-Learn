package com.bumptech.glide.load.engine.c;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RuntimeCompat.java */
/* JADX INFO: loaded from: classes.dex */
final class g {
    static int a() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), iAvailableProcessors) : iAvailableProcessors;
    }

    private static int b() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new f(Pattern.compile("cpu[0-9]+")));
            } catch (Throwable th) {
                if (Log.isLoggable("GlideRuntimeCompat", 6)) {
                    Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            }
            return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
