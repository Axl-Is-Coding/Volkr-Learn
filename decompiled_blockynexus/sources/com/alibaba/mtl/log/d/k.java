package com.alibaba.mtl.log.d;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: MutiProcessLock.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static File f3639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static FileChannel f63a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static FileLock f64a;

    public static synchronized boolean c(Context context) {
        FileLock fileLockTryLock;
        if (f3639a == null) {
            f3639a = new File(context.getFilesDir() + File.separator + "ap.Lock");
        }
        boolean zExists = f3639a.exists();
        if (!zExists) {
            try {
                zExists = f3639a.createNewFile();
            } catch (IOException unused) {
            }
        }
        if (!zExists) {
            return true;
        }
        if (f63a == null) {
            try {
                f63a = new RandomAccessFile(f3639a, "rw").getChannel();
            } catch (Exception unused2) {
                return false;
            }
        }
        try {
            fileLockTryLock = f63a.tryLock();
            if (fileLockTryLock != null) {
                f64a = fileLockTryLock;
                return true;
            }
        } catch (Throwable unused3) {
            fileLockTryLock = null;
        }
        Log.d("TAG", "mLock:" + fileLockTryLock);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0018 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void release() {
        /*
            java.lang.Class<com.alibaba.mtl.log.d.k> r0 = com.alibaba.mtl.log.d.k.class
            monitor-enter(r0)
            java.nio.channels.FileLock r1 = com.alibaba.mtl.log.d.k.f64a     // Catch: java.lang.Throwable -> L26
            r2 = 0
            if (r1 == 0) goto L14
            java.nio.channels.FileLock r1 = com.alibaba.mtl.log.d.k.f64a     // Catch: java.io.IOException -> Ld java.lang.Throwable -> L10
            r1.release()     // Catch: java.io.IOException -> Ld java.lang.Throwable -> L10
        Ld:
            com.alibaba.mtl.log.d.k.f64a = r2     // Catch: java.lang.Throwable -> L26
            goto L14
        L10:
            r1 = move-exception
            com.alibaba.mtl.log.d.k.f64a = r2     // Catch: java.lang.Throwable -> L26
            throw r1     // Catch: java.lang.Throwable -> L26
        L14:
            java.nio.channels.FileChannel r1 = com.alibaba.mtl.log.d.k.f63a     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L24
            java.nio.channels.FileChannel r1 = com.alibaba.mtl.log.d.k.f63a     // Catch: java.lang.Exception -> L1d java.lang.Throwable -> L20
            r1.close()     // Catch: java.lang.Exception -> L1d java.lang.Throwable -> L20
        L1d:
            com.alibaba.mtl.log.d.k.f63a = r2     // Catch: java.lang.Throwable -> L26
            goto L24
        L20:
            r1 = move-exception
            com.alibaba.mtl.log.d.k.f63a = r2     // Catch: java.lang.Throwable -> L26
            throw r1     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r0)
            return
        L26:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.d.k.release():void");
    }
}
