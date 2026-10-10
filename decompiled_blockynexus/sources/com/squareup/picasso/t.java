package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes5.dex */
public class t implements InterfaceC2756k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final LinkedHashMap<String, Bitmap> f19311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19316f;
    private int g;

    public t(Context context) {
        this(P.a(context));
    }

    @Override // com.squareup.picasso.InterfaceC2756k
    public void a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f19314d++;
            this.f19313c += P.a(bitmap);
            Bitmap bitmapPut = this.f19311a.put(str, bitmap);
            if (bitmapPut != null) {
                this.f19313c -= P.a(bitmapPut);
            }
        }
        a(this.f19312b);
    }

    @Override // com.squareup.picasso.InterfaceC2756k
    public Bitmap get(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = this.f19311a.get(str);
            if (bitmap != null) {
                this.f19316f++;
                return bitmap;
            }
            this.g++;
            return null;
        }
    }

    @Override // com.squareup.picasso.InterfaceC2756k
    public final synchronized int size() {
        return this.f19313c;
    }

    public t(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f19312b = i;
        this.f19311a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f19313c     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f19311a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r3.f19313c     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r3.f19313c     // Catch: java.lang.Throwable -> L71
            if (r0 <= r4) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f19311a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f19311a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f19311a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r1 = r3.f19313c     // Catch: java.lang.Throwable -> L71
            int r0 = com.squareup.picasso.P.a(r0)     // Catch: java.lang.Throwable -> L71
            int r1 = r1 - r0
            r3.f19313c = r1     // Catch: java.lang.Throwable -> L71
            int r0 = r3.f19315e     // Catch: java.lang.Throwable -> L71
            int r0 = r0 + 1
            r3.f19315e = r0     // Catch: java.lang.Throwable -> L71
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            goto L0
        L50:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r4     // Catch: java.lang.Throwable -> L71
        L71:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            goto L75
        L74:
            throw r4
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.t.a(int):void");
    }

    @Override // com.squareup.picasso.InterfaceC2756k
    public final synchronized int a() {
        return this.f19312b;
    }
}
