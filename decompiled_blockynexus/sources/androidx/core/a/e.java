package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.a.c;
import androidx.core.d.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: TypefaceCompatApi24Impl.java */
/* JADX INFO: loaded from: classes.dex */
class e extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor<?> f926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f928e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f926c = constructor;
        f925b = cls;
        f927d = method2;
        f928e = method;
    }

    e() {
    }

    public static boolean a() {
        if (f927d == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f927d != null;
    }

    private static Object b() {
        try {
            return f926c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f927d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f925b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f928e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.a.k
    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) throws Throwable {
        Object objB = b();
        if (objB == null) {
            return null;
        }
        a.a.i iVar = new a.a.i();
        for (f.b bVar : bVarArr) {
            Uri uriC = bVar.c();
            ByteBuffer byteBufferA = (ByteBuffer) iVar.get(uriC);
            if (byteBufferA == null) {
                byteBufferA = l.a(context, cancellationSignal, uriC);
                iVar.put(uriC, byteBufferA);
            }
            if (byteBufferA == null || !a(objB, byteBufferA, bVar.b(), bVar.d(), bVar.e())) {
                return null;
            }
        }
        Typeface typefaceA = a(objB);
        if (typefaceA == null) {
            return null;
        }
        return Typeface.create(typefaceA, i);
    }

    @Override // androidx.core.a.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object objB = b();
        if (objB == null) {
            return null;
        }
        for (c.C0009c c0009c : bVar.a()) {
            ByteBuffer byteBufferA = l.a(context, resources, c0009c.b());
            if (byteBufferA == null || !a(objB, byteBufferA, c0009c.c(), c0009c.e(), c0009c.f())) {
                return null;
            }
        }
        return a(objB);
    }
}
