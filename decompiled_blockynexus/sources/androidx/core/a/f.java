package androidx.core.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.core.content.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TypefaceCompatApi26Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    protected final Class<?> g;
    protected final Constructor<?> h;
    protected final Method i;
    protected final Method j;
    protected final Method k;
    protected final Method l;
    protected final Method m;

    public f() throws NoSuchMethodException {
        Method methodD;
        Constructor<?> constructorE;
        Method methodB;
        Method methodC;
        Method methodF;
        Method methodA;
        Class<?> cls = null;
        try {
            Class<?> clsA = a();
            constructorE = e(clsA);
            methodB = b(clsA);
            methodC = c(clsA);
            methodF = f(clsA);
            methodA = a(clsA);
            methodD = d(clsA);
            cls = clsA;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            methodD = null;
            constructorE = null;
            methodB = null;
            methodC = null;
            methodF = null;
            methodA = null;
        }
        this.g = cls;
        this.h = constructorE;
        this.i = methodB;
        this.j = methodC;
        this.k = methodF;
        this.l = methodA;
        this.m = methodD;
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void b(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean c() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    private Object d() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Constructor<?> e(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method f(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    protected Method b(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method d(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    private boolean c(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.j.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    protected Method c(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Typeface a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.a.d, androidx.core.a.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        if (!c()) {
            return super.a(context, bVar, resources, i);
        }
        Object objD = d();
        if (objD == null) {
            return null;
        }
        for (c.C0009c c0009c : bVar.a()) {
            if (!a(context, objD, c0009c.a(), c0009c.c(), c0009c.e(), c0009c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0009c.d()))) {
                b(objD);
                return null;
            }
        }
        if (c(objD)) {
            return a(objD);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[Catch: IOException -> 0x005e, SYNTHETIC, TRY_LEAVE, TryCatch #3 {IOException -> 0x005e, blocks: (B:8:0x0014, B:11:0x0022, B:15:0x0045, B:27:0x005a, B:28:0x005d), top: B:58:0x0014 }] */
    @Override // androidx.core.a.d, androidx.core.a.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface a(android.content.Context r12, android.os.CancellationSignal r13, androidx.core.d.f.b[] r14, int r15) throws java.lang.Throwable {
        /*
            r11 = this;
            int r0 = r14.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L6
            return r2
        L6:
            boolean r0 = r11.c()
            if (r0 != 0) goto L5f
            androidx.core.d.f$b r14 = r11.a(r14, r15)
            android.content.ContentResolver r12 = r12.getContentResolver()
            android.net.Uri r15 = r14.c()     // Catch: java.io.IOException -> L5e
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r12 = r12.openFileDescriptor(r15, r0, r13)     // Catch: java.io.IOException -> L5e
            if (r12 != 0) goto L26
            if (r12 == 0) goto L25
            r12.close()     // Catch: java.io.IOException -> L5e
        L25:
            return r2
        L26:
            android.graphics.Typeface$Builder r13 = new android.graphics.Typeface$Builder     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            java.io.FileDescriptor r15 = r12.getFileDescriptor()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            r13.<init>(r15)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            int r15 = r14.d()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r13 = r13.setWeight(r15)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            boolean r14 = r14.e()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r13 = r13.setItalic(r14)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface r13 = r13.build()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            if (r12 == 0) goto L48
            r12.close()     // Catch: java.io.IOException -> L5e
        L48:
            return r13
        L49:
            r13 = move-exception
            r14 = r2
            goto L52
        L4c:
            r13 = move-exception
            throw r13     // Catch: java.lang.Throwable -> L4e
        L4e:
            r14 = move-exception
            r10 = r14
            r14 = r13
            r13 = r10
        L52:
            if (r12 == 0) goto L5d
            if (r14 == 0) goto L5a
            r12.close()     // Catch: java.lang.Throwable -> L5d
            goto L5d
        L5a:
            r12.close()     // Catch: java.io.IOException -> L5e
        L5d:
            throw r13     // Catch: java.io.IOException -> L5e
        L5e:
            return r2
        L5f:
            java.util.Map r12 = androidx.core.d.f.a(r12, r14, r13)
            java.lang.Object r13 = r11.d()
            if (r13 != 0) goto L6a
            return r2
        L6a:
            int r0 = r14.length
            r3 = 0
            r9 = 0
        L6d:
            if (r9 >= r0) goto L9a
            r4 = r14[r9]
            android.net.Uri r5 = r4.c()
            java.lang.Object r5 = r12.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L7e
            goto L97
        L7e:
            int r6 = r4.b()
            int r7 = r4.d()
            boolean r8 = r4.e()
            r3 = r11
            r4 = r13
            boolean r3 = r3.a(r4, r5, r6, r7, r8)
            if (r3 != 0) goto L96
            r11.b(r13)
            return r2
        L96:
            r3 = 1
        L97:
            int r9 = r9 + 1
            goto L6d
        L9a:
            if (r3 != 0) goto La0
            r11.b(r13)
            return r2
        La0:
            boolean r12 = r11.c(r13)
            if (r12 != 0) goto La7
            return r2
        La7:
            android.graphics.Typeface r12 = r11.a(r13)
            if (r12 != 0) goto Lae
            return r2
        Lae:
            android.graphics.Typeface r12 = android.graphics.Typeface.create(r12, r15)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a.f.a(android.content.Context, android.os.CancellationSignal, androidx.core.d.f$b[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.a.k
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!c()) {
            return super.a(context, resources, i, str, i2);
        }
        Object objD = d();
        if (objD == null) {
            return null;
        }
        if (!a(context, objD, str, 0, -1, -1, null)) {
            b(objD);
            return null;
        }
        if (c(objD)) {
            return a(objD);
        }
        return null;
    }

    protected Class<?> a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Method a(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
