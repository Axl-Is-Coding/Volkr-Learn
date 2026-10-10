package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.a.c;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TypefaceCompatApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class d extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor<?> f921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f924f;

    d() {
    }

    private static void a() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f924f) {
            return;
        }
        f924f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f921c = constructor;
        f920b = cls;
        f922d = method2;
        f923e = method;
    }

    private static Object b() throws NoSuchMethodException {
        a();
        try {
            return f921c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static Typeface a(Object obj) throws NoSuchMethodException {
        a();
        try {
            Object objNewInstance = Array.newInstance(f920b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f923e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        a();
        try {
            return ((Boolean) f922d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005c A[Catch: all -> 0x0060, Throwable -> 0x0063, TRY_ENTER, TryCatch #0 {all -> 0x0060, blocks: (B:11:0x0020, B:13:0x0026, B:16:0x002d, B:20:0x0037, B:22:0x0044, B:33:0x0058, B:35:0x005c, B:36:0x005f), top: B:52:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[Catch: IOException -> 0x0075, SYNTHETIC, TRY_LEAVE, TryCatch #3 {IOException -> 0x0075, blocks: (B:6:0x000e, B:9:0x001c, B:18:0x0033, B:24:0x0049, B:47:0x0071, B:48:0x0074), top: B:57:0x000e }] */
    @Override // androidx.core.a.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface a(android.content.Context r5, android.os.CancellationSignal r6, androidx.core.d.f.b[] r7, int r8) throws java.lang.Throwable {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L6
            return r1
        L6:
            androidx.core.d.f$b r7 = r4.a(r7, r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.c()     // Catch: java.io.IOException -> L75
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch: java.io.IOException -> L75
            if (r6 != 0) goto L20
            if (r6 == 0) goto L1f
            r6.close()     // Catch: java.io.IOException -> L75
        L1f:
            return r1
        L20:
            java.io.File r7 = r4.a(r6)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            if (r7 == 0) goto L37
            boolean r8 = r7.canRead()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            if (r8 != 0) goto L2d
            goto L37
        L2d:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            if (r6 == 0) goto L36
            r6.close()     // Catch: java.io.IOException -> L75
        L36:
            return r5
        L37:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            java.io.FileDescriptor r8 = r6.getFileDescriptor()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            android.graphics.Typeface r5 = super.a(r5, r7)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
            r7.close()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
            if (r6 == 0) goto L4c
            r6.close()     // Catch: java.io.IOException -> L75
        L4c:
            return r5
        L4d:
            r5 = move-exception
            r8 = r1
            goto L56
        L50:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L52
        L52:
            r8 = move-exception
            r3 = r8
            r8 = r5
            r5 = r3
        L56:
            if (r8 == 0) goto L5c
            r7.close()     // Catch: java.lang.Throwable -> L5f java.lang.Throwable -> L60
            goto L5f
        L5c:
            r7.close()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
        L5f:
            throw r5     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L63
        L60:
            r5 = move-exception
            r7 = r1
            goto L69
        L63:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L65
        L65:
            r7 = move-exception
            r3 = r7
            r7 = r5
            r5 = r3
        L69:
            if (r6 == 0) goto L74
            if (r7 == 0) goto L71
            r6.close()     // Catch: java.lang.Throwable -> L74
            goto L74
        L71:
            r6.close()     // Catch: java.io.IOException -> L75
        L74:
            throw r5     // Catch: java.io.IOException -> L75
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a.d.a(android.content.Context, android.os.CancellationSignal, androidx.core.d.f$b[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.a.k
    public Typeface a(Context context, c.b bVar, Resources resources, int i) throws NoSuchMethodException {
        Object objB = b();
        for (c.C0009c c0009c : bVar.a()) {
            File fileA = l.a(context);
            if (fileA == null) {
                return null;
            }
            try {
                if (!l.a(fileA, resources, c0009c.b())) {
                    return null;
                }
                if (!a(objB, fileA.getPath(), c0009c.e(), c0009c.f())) {
                    return null;
                }
                fileA.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileA.delete();
            }
        }
        return a(objB);
    }
}
