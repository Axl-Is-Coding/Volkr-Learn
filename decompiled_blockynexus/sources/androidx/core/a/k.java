package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.a.c;
import androidx.core.d.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Long, c.b> f931a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
    interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    k() {
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    private static long b(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        } catch (NoSuchFieldException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        }
    }

    protected f.b a(f.b[] bVarArr, int i) {
        return (f.b) a(bVarArr, i, new i(this));
    }

    protected Typeface a(Context context, InputStream inputStream) {
        File fileA = l.a(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (l.a(fileA, inputStream)) {
                return Typeface.createFromFile(fileA.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileA.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(a(bVarArr, i).c());
        } catch (IOException unused) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface typefaceA = a(context, inputStreamOpenInputStream);
            l.a(inputStreamOpenInputStream);
            return typefaceA;
        } catch (IOException unused2) {
            l.a(inputStreamOpenInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
            l.a(inputStream);
            throw th;
        }
    }

    private c.C0009c a(c.b bVar, int i) {
        return (c.C0009c) a(bVar.a(), i, new j(this));
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0009c c0009cA = a(bVar, i);
        if (c0009cA == null) {
            return null;
        }
        Typeface typefaceA = c.a(context, resources, c0009cA.b(), c0009cA.a(), i);
        a(typefaceA, bVar);
        return typefaceA;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File fileA = l.a(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (l.a(fileA, resources, i)) {
                return Typeface.createFromFile(fileA.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileA.delete();
        }
    }

    c.b a(Typeface typeface) {
        long jB = b(typeface);
        if (jB == 0) {
            return null;
        }
        return this.f931a.get(Long.valueOf(jB));
    }

    private void a(Typeface typeface, c.b bVar) {
        long jB = b(typeface);
        if (jB != 0) {
            this.f931a.put(Long.valueOf(jB), bVar);
        }
    }
}
