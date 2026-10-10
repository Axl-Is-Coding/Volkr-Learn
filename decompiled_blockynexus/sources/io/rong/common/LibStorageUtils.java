package io.rong.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import io.rong.imlib.R;
import io.rong.imlib.common.SavePathUtils;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class LibStorageUtils {
    public static final String AUDIO = "audio";
    public static final String DIR = "RongCloud";
    public static final String FILE = "file";
    public static final String IMAGE = "image";
    public static final String MEDIA = "media";
    private static final String TAG = "LibStorageUtils";
    public static final String VIDEO = "video";
    private static Boolean isBuildAndTargetForQ;
    private static Boolean isQMode;

    public static String getAppName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            int i = packageInfo.applicationInfo.labelRes;
            if (i > 0) {
                return context.getResources().getString(i);
            }
            CharSequence charSequence = packageInfo.applicationInfo.nonLocalizedLabel;
            if (TextUtils.isEmpty(charSequence)) {
                return null;
            }
            return charSequence.toString();
        } catch (PackageManager.NameNotFoundException e2) {
            RLog.e(TAG, "getAppName", e2);
            return null;
        } catch (Exception e3) {
            RLog.e(TAG, "getAppName", e3);
            return null;
        }
    }

    public static String getMediaDownloadDir(Context context) {
        return getMediaDownloadDir(context, "media");
    }

    public static boolean isBuildAndTargetForQ(Context context) {
        if (isBuildAndTargetForQ == null) {
            isBuildAndTargetForQ = Boolean.valueOf(Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29);
        }
        return isBuildAndTargetForQ.booleanValue();
    }

    public static boolean isQMode(Context context) {
        if (isQMode == null) {
            try {
                isQMode = Boolean.valueOf(context.getResources().getBoolean(R.bool.rc_q_storage_mode_enable));
            } catch (Resources.NotFoundException unused) {
                RLog.e(TAG, "isQMode rc_q_storage_mode_enable not found");
                isQMode = false;
            }
        }
        if (isBuildAndTargetForQ(context) && !isQMode.booleanValue()) {
            RLog.e(TAG, "请 rc_configuration 设置 rc_q_storage_mode_enable 为 true ");
        }
        return isQMode.booleanValue();
    }

    public static String getMediaDownloadDir(Context context, String str) {
        if (!SavePathUtils.isSavePathEmpty()) {
            File file = new File(SavePathUtils.getSavePath(), "media");
            if (!file.exists() && !file.mkdirs()) {
                RLog.e(TAG, "getSavePath mkdirs error path is  " + file.getAbsolutePath());
            }
            return file.getAbsolutePath();
        }
        boolean zEquals = Environment.getExternalStorageState().equals("mounted");
        String path = context.getCacheDir().getPath();
        if (!zEquals) {
            RLog.d(TAG, "getSavePath error, sdcard does not exist.");
            return path;
        }
        if (isQMode(context)) {
            File externalFilesDir = context.getExternalFilesDir(DIR);
            File file2 = new File(externalFilesDir, str);
            return (file2.exists() || file2.mkdirs()) ? file2.getPath() : externalFilesDir.getPath();
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + context.getString(R.string.rc_media_message_default_save_path);
        File file3 = new File(str2);
        if (file3.exists() || file3.mkdirs()) {
            return str2;
        }
        RLog.e(TAG, "mkdirs error path is  " + str2);
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
    }
}
