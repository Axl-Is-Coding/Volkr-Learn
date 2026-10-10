package me.iwf.photopicker.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: AndroidLifecycleUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static boolean a(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return a((Activity) fragment.getActivity());
    }

    public static boolean a(Context context) {
        if (context != null && (context instanceof Activity)) {
            return a((Activity) context);
        }
        return true;
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return true;
        }
        return ((Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) || activity.isFinishing()) ? false : true;
    }
}
