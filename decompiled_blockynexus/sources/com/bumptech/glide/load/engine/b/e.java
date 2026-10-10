package com.bumptech.glide.load.engine.b;

import android.util.Log;
import com.bumptech.glide.a.b;
import com.bumptech.glide.load.engine.b.a;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: DiskLruCacheWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f4513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f4514c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.a.b f4516e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f4515d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f4512a = new l();

    @Deprecated
    protected e(File file, long j) {
        this.f4513b = file;
        this.f4514c = j;
    }

    public static a a(File file, long j) {
        return new e(file, j);
    }

    private synchronized void b() {
        this.f4516e = null;
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public synchronized void clear() {
        try {
            try {
                a().b();
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e2);
                }
            }
        } finally {
            b();
        }
    }

    private synchronized com.bumptech.glide.a.b a() throws IOException {
        if (this.f4516e == null) {
            this.f4516e = com.bumptech.glide.a.b.a(this.f4513b, 1, 1, this.f4514c);
        }
        return this.f4516e;
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public File a(com.bumptech.glide.load.h hVar) {
        String strA = this.f4512a.a(hVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strA + " for for Key: " + hVar);
        }
        try {
            b.d dVarC = a().c(strA);
            if (dVarC != null) {
                return dVarC.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.b.a
    public void a(com.bumptech.glide.load.h hVar, a.b bVar) {
        com.bumptech.glide.a.b bVarA;
        String strA = this.f4512a.a(hVar);
        this.f4515d.a(strA);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strA + " for for Key: " + hVar);
            }
            try {
                bVarA = a();
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
            if (bVarA.c(strA) != null) {
                return;
            }
            b.C0051b c0051bA = bVarA.a(strA);
            if (c0051bA != null) {
                try {
                    if (bVar.a(c0051bA.a(0))) {
                        c0051bA.c();
                    }
                    c0051bA.b();
                    return;
                } catch (Throwable th) {
                    c0051bA.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + strA);
        } finally {
            this.f4515d.b(strA);
        }
    }
}
