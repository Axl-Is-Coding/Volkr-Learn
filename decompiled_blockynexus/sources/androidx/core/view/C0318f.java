package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: androidx.core.view.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LayoutInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0318f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1261b;

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                b(layoutInflater, factory2);
            }
        }
    }

    private static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f1261b) {
            try {
                f1260a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1260a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e2);
            }
            f1261b = true;
        }
        Field field = f1260a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }
}
