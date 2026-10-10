package androidx.appcompat.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.M;
import androidx.core.content.b;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AppCompatResources.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f190a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0000a>> f191b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f192c = new Object();

    /* JADX INFO: renamed from: androidx.appcompat.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppCompatResources.java */
    private static class C0000a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ColorStateList f193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f194b;

        C0000a(ColorStateList colorStateList, Configuration configuration) {
            this.f193a = colorStateList;
            this.f194b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListC = c(context, i);
        if (colorStateListC != null) {
            return colorStateListC;
        }
        ColorStateList colorStateListD = d(context, i);
        if (colorStateListD == null) {
            return b.b(context, i);
        }
        a(context, i, colorStateListD);
        return colorStateListD;
    }

    public static Drawable b(Context context, int i) {
        return M.a().a(context, i);
    }

    private static ColorStateList c(Context context, int i) {
        C0000a c0000a;
        synchronized (f192c) {
            SparseArray<C0000a> sparseArray = f191b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0000a = sparseArray.get(i)) != null) {
                if (c0000a.f194b.equals(context.getResources().getConfiguration())) {
                    return c0000a.f193a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static ColorStateList d(Context context, int i) {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.a.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValueA = a();
        resources.getValue(i, typedValueA, true);
        int i2 = typedValueA.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f192c) {
            SparseArray<C0000a> sparseArray = f191b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f191b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0000a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static TypedValue a() {
        TypedValue typedValue = f190a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f190a.set(typedValue2);
        return typedValue2;
    }
}
