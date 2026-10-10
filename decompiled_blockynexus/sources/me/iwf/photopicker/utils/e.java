package me.iwf.photopicker.utils;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: PermissionsUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static boolean a(Activity activity) {
        if (Build.VERSION.SDK_INT < 16) {
            return true;
        }
        boolean z = androidx.core.content.b.a(activity, "android.permission.READ_EXTERNAL_STORAGE") == 0;
        if (!z) {
            ActivityCompat.a(activity, d.f22950c, 2);
        }
        return z;
    }

    public static boolean b(Fragment fragment) {
        boolean z = androidx.core.content.b.a(fragment.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (!z) {
            fragment.requestPermissions(d.f22949b, 3);
        }
        return z;
    }

    public static boolean a(Fragment fragment) {
        boolean z = androidx.core.content.b.a(fragment.getContext(), "android.permission.CAMERA") == 0;
        if (!z) {
            fragment.requestPermissions(d.f22948a, 1);
        }
        return z;
    }
}
