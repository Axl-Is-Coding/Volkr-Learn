package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: BundleCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static IBinder a(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : a.a(bundle, str);
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }

    /* JADX INFO: compiled from: BundleCompat.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Method f986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static boolean f987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f989d;

        public static IBinder a(Bundle bundle, String str) {
            if (!f987b) {
                try {
                    f986a = Bundle.class.getMethod("getIBinder", String.class);
                    f986a.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e2);
                }
                f987b = true;
            }
            Method method = f986a;
            if (method != null) {
                try {
                    return (IBinder) method.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e3);
                    f986a = null;
                }
            }
            return null;
        }

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!f989d) {
                try {
                    f988c = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f988c.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e2);
                }
                f989d = true;
            }
            Method method = f988c;
            if (method != null) {
                try {
                    method.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e3);
                    f988c = null;
                }
            }
        }
    }
}
