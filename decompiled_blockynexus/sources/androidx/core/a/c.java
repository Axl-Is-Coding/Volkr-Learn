package androidx.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.a.c;
import androidx.core.content.a.h;
import androidx.core.d.f;

/* JADX INFO: compiled from: TypefaceCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a.a.g<String, Typeface> f919b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f918a = new h();
        } else if (i >= 28) {
            f918a = new g();
        } else if (i >= 26) {
            f918a = new f();
        } else if (i >= 24 && e.a()) {
            f918a = new e();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f918a = new d();
        } else {
            f918a = new k();
        }
        f919b = new a.a.g<>(16);
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return f919b.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, h.a aVar2, Handler handler, boolean z) {
        Typeface typefaceA;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            typefaceA = androidx.core.d.f.a(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typefaceA = f918a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceA != null) {
                    aVar2.a(typefaceA, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f919b.put(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    private static Typeface b(Context context, Typeface typeface, int i) {
        c.b bVarA = f918a.a(typeface);
        if (bVarA == null) {
            return null;
        }
        return f918a.a(context, bVarA, context.getResources(), i);
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceA = f918a.a(context, resources, i, str, i2);
        if (typefaceA != null) {
            f919b.put(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        return f918a.a(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface typefaceB;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceB = b(context, typeface, i)) == null) ? Typeface.create(typeface, i) : typefaceB;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
