package cn.qqtheme.framework.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenUtils {
    private static DisplayMetrics dm;
    private static boolean isFullScreen;

    public static float density(Context context) {
        return displayMetrics(context).density;
    }

    public static int densityDpi(Context context) {
        return displayMetrics(context).densityDpi;
    }

    public static DisplayMetrics displayMetrics(Context context) {
        DisplayMetrics displayMetrics = dm;
        if (displayMetrics != null) {
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
        LogUtils.verbose("screen width=" + displayMetrics2.widthPixels + "px, screen height=" + displayMetrics2.heightPixels + "px, densityDpi=" + displayMetrics2.densityDpi + ", density=" + displayMetrics2.density);
        return displayMetrics2;
    }

    public static int heightPixels(Context context) {
        return displayMetrics(context).heightPixels;
    }

    public static boolean isFullScreen() {
        return isFullScreen;
    }

    public static void keepBright(Activity activity) {
        activity.getWindow().setFlags(128, 128);
    }

    public static void toggleFullScreen(Activity activity) {
        Window window = activity.getWindow();
        if (isFullScreen) {
            window.clearFlags(1024);
            isFullScreen = false;
        } else {
            window.setFlags(1024, 1024);
            isFullScreen = true;
        }
    }

    public static int widthPixels(Context context) {
        return displayMetrics(context).widthPixels;
    }
}
