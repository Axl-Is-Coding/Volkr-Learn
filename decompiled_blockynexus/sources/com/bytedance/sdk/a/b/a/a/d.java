package com.bytedance.sdk.a.b.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable, Flushable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.bytedance.sdk.a.b.a.f.a f4920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f4921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.bytedance.sdk.a.a.d f4922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final LinkedHashMap<String, b> f4923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f4924f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private long m;
    private final Executor n;
    private final Runnable o;
    static final /* synthetic */ boolean j = !d.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f4919a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f4925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean[] f4926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f4927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4928d;

        void a() {
            if (this.f4925a.f4934f != this) {
                return;
            }
            int i = 0;
            while (true) {
                d dVar = this.f4927c;
                if (i >= dVar.f4921c) {
                    this.f4925a.f4934f = null;
                    return;
                } else {
                    try {
                        dVar.f4920b.a(this.f4925a.f4932d[i]);
                    } catch (IOException unused) {
                    }
                    i++;
                }
            }
        }

        public void b() throws IOException {
            synchronized (this.f4927c) {
                if (this.f4928d) {
                    throw new IllegalStateException();
                }
                if (this.f4925a.f4934f == this) {
                    this.f4927c.a(this, false);
                }
                this.f4928d = true;
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f4929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long[] f4930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final File[] f4931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final File[] f4932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f4933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        a f4934f;
        long g;

        void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
            for (long j : this.f4930b) {
                dVar.i(32).l(j);
            }
        }
    }

    private synchronized void d() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    synchronized void a(a aVar, boolean z) throws IOException {
        b bVar = aVar.f4925a;
        if (bVar.f4934f != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f4933e) {
            for (int i = 0; i < this.f4921c; i++) {
                if (!aVar.f4926b[i]) {
                    aVar.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.f4920b.b(bVar.f4932d[i])) {
                    aVar.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f4921c; i2++) {
            File file = bVar.f4932d[i2];
            if (!z) {
                this.f4920b.a(file);
            } else if (this.f4920b.b(file)) {
                File file2 = bVar.f4931c[i2];
                this.f4920b.a(file, file2);
                long j2 = bVar.f4930b[i2];
                long jC = this.f4920b.c(file2);
                bVar.f4930b[i2] = jC;
                this.l = (this.l - j2) + jC;
            }
        }
        this.f4924f++;
        bVar.f4934f = null;
        if (bVar.f4933e || z) {
            bVar.f4933e = true;
            this.f4922d.b("CLEAN").i(32);
            this.f4922d.b(bVar.f4929a);
            bVar.a(this.f4922d);
            this.f4922d.i(10);
            if (z) {
                long j3 = this.m;
                this.m = 1 + j3;
                bVar.g = j3;
            }
        } else {
            this.f4923e.remove(bVar.f4929a);
            this.f4922d.b("REMOVE").i(32);
            this.f4922d.b(bVar.f4929a);
            this.f4922d.i(10);
        }
        this.f4922d.flush();
        if (this.l > this.k || a()) {
            this.n.execute(this.o);
        }
    }

    public synchronized boolean b() {
        return this.h;
    }

    void c() throws IOException {
        while (this.l > this.k) {
            a(this.f4923e.values().iterator().next());
        }
        this.i = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.g && !this.h) {
            for (b bVar : (b[]) this.f4923e.values().toArray(new b[this.f4923e.size()])) {
                if (bVar.f4934f != null) {
                    bVar.f4934f.b();
                }
            }
            c();
            this.f4922d.close();
            this.f4922d = null;
            this.h = true;
            return;
        }
        this.h = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.g) {
            d();
            c();
            this.f4922d.flush();
        }
    }

    boolean a() {
        int i = this.f4924f;
        return i >= 2000 && i >= this.f4923e.size();
    }

    boolean a(b bVar) throws IOException {
        a aVar = bVar.f4934f;
        if (aVar != null) {
            aVar.a();
        }
        for (int i = 0; i < this.f4921c; i++) {
            this.f4920b.a(bVar.f4931c[i]);
            long j2 = this.l;
            long[] jArr = bVar.f4930b;
            this.l = j2 - jArr[i];
            jArr[i] = 0;
        }
        this.f4924f++;
        this.f4922d.b("REMOVE").i(32).b(bVar.f4929a).i(10);
        this.f4923e.remove(bVar.f4929a);
        if (a()) {
            this.n.execute(this.o);
        }
        return true;
    }
}
