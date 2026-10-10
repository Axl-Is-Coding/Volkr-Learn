package com.bumptech.glide.load.engine.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config f4489a = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f4490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Bitmap.Config> f4491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f4493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4494f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.a.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.a.k.a
        public void b(Bitmap bitmap) {
        }
    }

    k(long j, l lVar, Set<Bitmap.Config> set) {
        this.f4492d = j;
        this.f4494f = j;
        this.f4490b = lVar;
        this.f4491c = set;
        this.f4493e = new b();
    }

    private static Bitmap c(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = f4489a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private synchronized Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapA;
        a(config);
        bitmapA = this.f4490b.a(i, i2, config != null ? config : f4489a);
        if (bitmapA == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f4490b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.h++;
            this.g -= (long) this.f4490b.c(bitmapA);
            this.f4493e.a(bitmapA);
            c(bitmapA);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f4490b.b(i, i2, config));
        }
        c();
        return bitmapA;
    }

    private void e() {
        a(this.f4494f);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l g() {
        return Build.VERSION.SDK_INT >= 19 ? new o() : new c();
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f4490b.c(bitmap) <= this.f4494f && this.f4491c.contains(bitmap.getConfig())) {
                int iC = this.f4490b.c(bitmap);
                this.f4490b.a(bitmap);
                this.f4493e.b(bitmap);
                this.j++;
                this.g += (long) iC;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f4490b.b(bitmap));
                }
                c();
                e();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f4490b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f4491c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public long b() {
        return this.f4494f;
    }

    private static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapD = d(i, i2, config);
        return bitmapD == null ? c(i, i2, config) : bitmapD;
    }

    @TargetApi(19)
    private static void b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    public k(long j) {
        this(j, g(), f());
    }

    private void d() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f4494f + "\nStrategy=" + this.f4490b);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapD = d(i, i2, config);
        if (bitmapD != null) {
            bitmapD.eraseColor(0);
            return bitmapD;
        }
        return c(i, i2, config);
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        a(0L);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    private synchronized void a(long j) {
        while (this.g > j) {
            Bitmap bitmapRemoveLast = this.f4490b.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.g = 0L;
                return;
            }
            this.f4493e.a(bitmapRemoveLast);
            this.g -= (long) this.f4490b.c(bitmapRemoveLast);
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f4490b.b(bitmapRemoveLast));
            }
            c();
            bitmapRemoveLast.recycle();
        }
    }
}
