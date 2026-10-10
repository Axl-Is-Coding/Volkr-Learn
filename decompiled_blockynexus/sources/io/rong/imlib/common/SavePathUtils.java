package io.rong.imlib.common;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class SavePathUtils {
    private static final String TAG = "SavePathUtils";
    private static String savePath = "";

    public static String getSavePath() {
        return savePath;
    }

    public static boolean isDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            Log.e(TAG, "SavePath not exists..");
            return false;
        }
        if (file.isDirectory()) {
            return true;
        }
        Log.e(TAG, "SavePath not Directory..");
        return false;
    }

    public static boolean isSavePathEmpty() {
        return TextUtils.isEmpty(savePath);
    }

    public static void setSavePath(String str) {
        if (isDir(str)) {
            savePath = str;
        }
    }

    public static String getSavePath(String str) {
        return isSavePathEmpty() ? str : savePath;
    }

    public static File getSavePath(File file) {
        return isSavePathEmpty() ? file : new File(savePath);
    }
}
