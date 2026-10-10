package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TypefaceCompatUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public static File a(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029 A[Catch: IOException -> 0x002d, TRY_ENTER, TryCatch #3 {IOException -> 0x002d, blocks: (B:3:0x0001, B:5:0x0016, B:16:0x0029, B:17:0x002c), top: B:22:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer a(java.io.File r9) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L2d
            r1.<init>(r9)     // Catch: java.io.IOException -> L2d
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            long r6 = r2.size()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            r4 = 0
            java.nio.MappedByteBuffer r9 = r2.map(r3, r4, r6)     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1d
            r1.close()     // Catch: java.io.IOException -> L2d
            return r9
        L1a:
            r9 = move-exception
            r2 = r0
            goto L23
        L1d:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> L1f
        L1f:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r8
        L23:
            if (r2 == 0) goto L29
            r1.close()     // Catch: java.lang.Throwable -> L2c
            goto L2c
        L29:
            r1.close()     // Catch: java.io.IOException -> L2d
        L2c:
            throw r9     // Catch: java.io.IOException -> L2d
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a.l.a(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[Catch: all -> 0x0048, Throwable -> 0x004b, TRY_ENTER, TryCatch #0 {Throwable -> 0x004b, blocks: (B:8:0x0013, B:10:0x002c, B:23:0x0044, B:24:0x0047), top: B:40:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[Catch: IOException -> 0x005d, SYNTHETIC, TRY_LEAVE, TryCatch #6 {IOException -> 0x005d, blocks: (B:3:0x0005, B:6:0x000f, B:12:0x0031, B:35:0x0059, B:36:0x005c), top: B:47:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.ByteBuffer a(android.content.Context r8, android.os.CancellationSignal r9, android.net.Uri r10) throws java.lang.Throwable {
        /*
            android.content.ContentResolver r8 = r8.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r8 = r8.openFileDescriptor(r10, r1, r9)     // Catch: java.io.IOException -> L5d
            if (r8 != 0) goto L13
            if (r8 == 0) goto L12
            r8.close()     // Catch: java.io.IOException -> L5d
        L12:
            return r0
        L13:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L4b
            java.io.FileDescriptor r10 = r8.getFileDescriptor()     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L4b
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L4b
            java.nio.channels.FileChannel r1 = r9.getChannel()     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            long r5 = r1.size()     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            r3 = 0
            java.nio.MappedByteBuffer r10 = r1.map(r2, r3, r5)     // Catch: java.lang.Throwable -> L35 java.lang.Throwable -> L38
            r9.close()     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L4b
            if (r8 == 0) goto L34
            r8.close()     // Catch: java.io.IOException -> L5d
        L34:
            return r10
        L35:
            r10 = move-exception
            r1 = r0
            goto L3e
        L38:
            r10 = move-exception
            throw r10     // Catch: java.lang.Throwable -> L3a
        L3a:
            r1 = move-exception
            r7 = r1
            r1 = r10
            r10 = r7
        L3e:
            if (r1 == 0) goto L44
            r9.close()     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L48
            goto L47
        L44:
            r9.close()     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L4b
        L47:
            throw r10     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L4b
        L48:
            r9 = move-exception
            r10 = r0
            goto L51
        L4b:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> L4d
        L4d:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L51:
            if (r8 == 0) goto L5c
            if (r10 == 0) goto L59
            r8.close()     // Catch: java.lang.Throwable -> L5c
            goto L5c
        L59:
            r8.close()     // Catch: java.io.IOException -> L5d
        L5c:
            throw r9     // Catch: java.io.IOException -> L5d
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a.l.a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    public static ByteBuffer a(Context context, Resources resources, int i) {
        File fileA = a(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (a(fileA, resources, i)) {
                return a(fileA);
            }
            return null;
        } finally {
            fileA.delete();
        }
    }

    public static boolean a(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            a(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static boolean a(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zA = a(file, inputStreamOpenRawResource);
                a(inputStreamOpenRawResource);
                return zA;
            } catch (Throwable th) {
                th = th;
                a(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
