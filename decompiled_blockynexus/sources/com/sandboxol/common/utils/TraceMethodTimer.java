package com.sandboxol.common.utils;

import android.os.Debug;
import android.os.Environment;
import android.util.Log;
import com.sandboxol.center.config.StringConstant;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class TraceMethodTimer {
    public static void end() {
        Debug.stopMethodTracing();
    }

    public static void reportTime(int i) {
        Log.d("TraceMethodPoint", i + " ----  " + System.currentTimeMillis());
    }

    public static void start() {
        Debug.startMethodTracing(new File(Environment.getExternalStorageDirectory(), StringConstant.BLOCKY_MODS_APK_DOWNLOAD_PATH).getPath());
    }

    public static void start(String str) {
        Debug.startMethodTracing(new File(Environment.getExternalStorageDirectory(), "SandBoxOL/" + str).getPath());
    }
}
