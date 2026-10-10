package androidx.databinding.a;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ListenerUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> f1346a = new SparseArray<>();

    public static <T> T a(View view, T t, int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            T t2 = (T) view.getTag(i);
            view.setTag(i, t);
            return t2;
        }
        synchronized (f1346a) {
            WeakHashMap<View, WeakReference<?>> weakHashMap = f1346a.get(i);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                f1346a.put(i, weakHashMap);
            }
            WeakReference<?> weakReferenceRemove = t == null ? weakHashMap.remove(view) : weakHashMap.put(view, new WeakReference<>(t));
            if (weakReferenceRemove == null) {
                return null;
            }
            return (T) weakReferenceRemove.get();
        }
    }
}
