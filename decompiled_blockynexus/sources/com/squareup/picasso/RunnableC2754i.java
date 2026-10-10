package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import cn.qqtheme.framework.widget.WheelView;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.E;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.squareup.picasso.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapHunter.java */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2754i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f19288a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f19289b = new C2748c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f19290c = new AtomicInteger();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final E f19291d = new C2749d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f19292e = f19290c.incrementAndGet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Picasso f19293f;
    final q g;
    final InterfaceC2756k h;
    final H i;
    final String j;
    final C k;
    final int l;
    int m;
    final E n;
    AbstractC2746a o;
    List<AbstractC2746a> p;
    Bitmap q;
    Future<?> r;
    Picasso.LoadedFrom s;
    Exception t;
    int u;
    int v;
    Picasso.Priority w;

    RunnableC2754i(Picasso picasso, q qVar, InterfaceC2756k interfaceC2756k, H h, AbstractC2746a abstractC2746a, E e2) {
        this.f19293f = picasso;
        this.g = qVar;
        this.h = interfaceC2756k;
        this.i = h;
        this.o = abstractC2746a;
        this.j = abstractC2746a.c();
        this.k = abstractC2746a.h();
        this.w = abstractC2746a.g();
        this.l = abstractC2746a.d();
        this.m = abstractC2746a.e();
        this.n = e2;
        this.v = e2.a();
    }

    static Bitmap a(InputStream inputStream, C c2) throws IOException {
        u uVar = new u(inputStream);
        long jA = uVar.a(65536);
        BitmapFactory.Options optionsB = E.b(c2);
        boolean zA = E.a(optionsB);
        boolean zB = P.b(uVar);
        uVar.b(jA);
        if (zB) {
            byte[] bArrC = P.c(uVar);
            if (zA) {
                BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length, optionsB);
                E.a(c2.i, c2.j, optionsB, c2);
            }
            return BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length, optionsB);
        }
        if (zA) {
            BitmapFactory.decodeStream(uVar, null, optionsB);
            E.a(c2.i, c2.j, optionsB, c2);
            uVar.b(jA);
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(uVar, null, optionsB);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    private static boolean a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    private Picasso.Priority o() {
        Picasso.Priority priorityG = Picasso.Priority.LOW;
        List<AbstractC2746a> list = this.p;
        boolean z = true;
        boolean z2 = (list == null || list.isEmpty()) ? false : true;
        if (this.o == null && !z2) {
            z = false;
        }
        if (!z) {
            return priorityG;
        }
        AbstractC2746a abstractC2746a = this.o;
        if (abstractC2746a != null) {
            priorityG = abstractC2746a.g();
        }
        if (z2) {
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                Picasso.Priority priorityG2 = this.p.get(i).g();
                if (priorityG2.ordinal() > priorityG.ordinal()) {
                    priorityG = priorityG2;
                }
            }
        }
        return priorityG;
    }

    void b(AbstractC2746a abstractC2746a) {
        boolean zRemove;
        if (this.o == abstractC2746a) {
            this.o = null;
            zRemove = true;
        } else {
            List<AbstractC2746a> list = this.p;
            zRemove = list != null ? list.remove(abstractC2746a) : false;
        }
        if (zRemove && abstractC2746a.g() == this.w) {
            this.w = o();
        }
        if (this.f19293f.p) {
            P.a("Hunter", "removed", abstractC2746a.f19275b.d(), P.a(this, "from "));
        }
    }

    List<AbstractC2746a> c() {
        return this.p;
    }

    C d() {
        return this.k;
    }

    Exception e() {
        return this.t;
    }

    String f() {
        return this.j;
    }

    Picasso.LoadedFrom g() {
        return this.s;
    }

    int h() {
        return this.l;
    }

    Picasso i() {
        return this.f19293f;
    }

    Picasso.Priority j() {
        return this.w;
    }

    Bitmap k() {
        return this.q;
    }

    Bitmap l() throws IOException {
        Bitmap bitmapA;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.l)) {
            bitmapA = this.h.get(this.j);
            if (bitmapA != null) {
                this.i.b();
                this.s = Picasso.LoadedFrom.MEMORY;
                if (this.f19293f.p) {
                    P.a("Hunter", "decoded", this.k.d(), "from cache");
                }
                return bitmapA;
            }
        } else {
            bitmapA = null;
        }
        this.k.f19212d = this.v == 0 ? NetworkPolicy.OFFLINE.index : this.m;
        E.a aVarA = this.n.a(this.k, this.m);
        if (aVarA != null) {
            this.s = aVarA.c();
            this.u = aVarA.b();
            bitmapA = aVarA.a();
            if (bitmapA == null) {
                InputStream inputStreamD = aVarA.d();
                try {
                    Bitmap bitmapA2 = a(inputStreamD, this.k);
                    P.a(inputStreamD);
                    bitmapA = bitmapA2;
                } catch (Throwable th) {
                    P.a(inputStreamD);
                    throw th;
                }
            }
        }
        if (bitmapA != null) {
            if (this.f19293f.p) {
                P.a("Hunter", "decoded", this.k.d());
            }
            this.i.a(bitmapA);
            if (this.k.f() || this.u != 0) {
                synchronized (f19288a) {
                    if (this.k.e() || this.u != 0) {
                        bitmapA = a(this.k, bitmapA, this.u);
                        if (this.f19293f.p) {
                            P.a("Hunter", "transformed", this.k.d());
                        }
                    }
                    if (this.k.b()) {
                        bitmapA = a(this.k.h, bitmapA);
                        if (this.f19293f.p) {
                            P.a("Hunter", "transformed", this.k.d(), "from custom transformations");
                        }
                    }
                }
                if (bitmapA != null) {
                    this.i.b(bitmapA);
                }
            }
        }
        return bitmapA;
    }

    boolean m() {
        Future<?> future = this.r;
        return future != null && future.isCancelled();
    }

    boolean n() {
        return this.n.b();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    a(this.k);
                    if (this.f19293f.p) {
                        P.a("Hunter", "executing", P.a(this));
                    }
                    this.q = l();
                    if (this.q == null) {
                        this.g.b(this);
                    } else {
                        this.g.a(this);
                    }
                } catch (NetworkRequestHandler.ContentLengthException e2) {
                    this.t = e2;
                    this.g.c(this);
                } catch (OutOfMemoryError e3) {
                    StringWriter stringWriter = new StringWriter();
                    this.i.a().a(new PrintWriter(stringWriter));
                    this.t = new RuntimeException(stringWriter.toString(), e3);
                    this.g.b(this);
                }
            } catch (Downloader.ResponseException e4) {
                if (!e4.localCacheOnly || e4.responseCode != 504) {
                    this.t = e4;
                }
                this.g.b(this);
            } catch (IOException e5) {
                this.t = e5;
                this.g.c(this);
            } catch (Exception e6) {
                this.t = e6;
                this.g.b(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    AbstractC2746a b() {
        return this.o;
    }

    void a(AbstractC2746a abstractC2746a) {
        boolean z = this.f19293f.p;
        C c2 = abstractC2746a.f19275b;
        if (this.o == null) {
            this.o = abstractC2746a;
            if (z) {
                List<AbstractC2746a> list = this.p;
                if (list != null && !list.isEmpty()) {
                    P.a("Hunter", "joined", c2.d(), P.a(this, "to "));
                    return;
                } else {
                    P.a("Hunter", "joined", c2.d(), "to empty hunter");
                    return;
                }
            }
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList(3);
        }
        this.p.add(abstractC2746a);
        if (z) {
            P.a("Hunter", "joined", c2.d(), P.a(this, "to "));
        }
        Picasso.Priority priorityG = abstractC2746a.g();
        if (priorityG.ordinal() > this.w.ordinal()) {
            this.w = priorityG;
        }
    }

    boolean a() {
        Future<?> future;
        if (this.o != null) {
            return false;
        }
        List<AbstractC2746a> list = this.p;
        return (list == null || list.isEmpty()) && (future = this.r) != null && future.cancel(false);
    }

    boolean a(boolean z, NetworkInfo networkInfo) {
        if (!(this.v > 0)) {
            return false;
        }
        this.v--;
        return this.n.a(z, networkInfo);
    }

    static void a(C c2) {
        String strA = c2.a();
        StringBuilder sb = f19289b.get();
        sb.ensureCapacity(strA.length() + 8);
        sb.replace(8, sb.length(), strA);
        Thread.currentThread().setName(sb.toString());
    }

    static RunnableC2754i a(Picasso picasso, q qVar, InterfaceC2756k interfaceC2756k, H h, AbstractC2746a abstractC2746a) {
        C cH = abstractC2746a.h();
        List<E> listA = picasso.a();
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            E e2 = listA.get(i);
            if (e2.a(cH)) {
                return new RunnableC2754i(picasso, qVar, interfaceC2756k, h, abstractC2746a, e2);
            }
        }
        return new RunnableC2754i(picasso, qVar, interfaceC2756k, h, abstractC2746a, f19291d);
    }

    static Bitmap a(List<L> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            L l = list.get(i);
            try {
                Bitmap bitmapA = l.a(bitmap);
                if (bitmapA == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(l.a());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<L> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().a());
                        sb.append('\n');
                    }
                    Picasso.f19259a.post(new RunnableC2751f(sb));
                    return null;
                }
                if (bitmapA == bitmap && bitmap.isRecycled()) {
                    Picasso.f19259a.post(new RunnableC2752g(l));
                    return null;
                }
                if (bitmapA != bitmap && !bitmap.isRecycled()) {
                    Picasso.f19259a.post(new RunnableC2753h(l));
                    return null;
                }
                i++;
                bitmap = bitmapA;
            } catch (RuntimeException e2) {
                Picasso.f19259a.post(new RunnableC2750e(l, e2));
                return null;
            }
        }
        return bitmap;
    }

    static Bitmap a(C c2, Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i5;
        int i6;
        int i7;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = c2.m;
        Matrix matrix = new Matrix();
        int i8 = 0;
        if (c2.e()) {
            int i9 = c2.i;
            int i10 = c2.j;
            float f7 = c2.n;
            if (f7 != WheelView.DividerConfig.FILL) {
                if (c2.q) {
                    matrix.setRotate(f7, c2.o, c2.p);
                } else {
                    matrix.setRotate(f7);
                }
            }
            if (c2.k) {
                float f8 = i9;
                float f9 = f8 / width;
                float f10 = i10;
                float f11 = f10 / height;
                if (f9 > f11) {
                    int iCeil = (int) Math.ceil(r10 * (f11 / f9));
                    i7 = (height - iCeil) / 2;
                    f11 = f10 / iCeil;
                    i5 = iCeil;
                    f6 = f9;
                    i6 = width;
                } else {
                    int iCeil2 = (int) Math.ceil(r6 * (f9 / f11));
                    f6 = f8 / iCeil2;
                    i5 = height;
                    i8 = (width - iCeil2) / 2;
                    i6 = iCeil2;
                    i7 = 0;
                }
                if (a(z, width, height, i9, i10)) {
                    matrix.preScale(f6, f11);
                }
                i4 = i7;
                i2 = i6;
                i3 = i5;
            } else {
                if (c2.l) {
                    float f12 = i9 / width;
                    float f13 = i10 / height;
                    if (f12 >= f13) {
                        f12 = f13;
                    }
                    if (a(z, width, height, i9, i10)) {
                        matrix.preScale(f12, f12);
                    }
                } else if ((i9 != 0 || i10 != 0) && (i9 != width || i10 != height)) {
                    if (i9 != 0) {
                        f2 = i9;
                        f3 = width;
                    } else {
                        f2 = i10;
                        f3 = height;
                    }
                    float f14 = f2 / f3;
                    if (i10 != 0) {
                        f4 = i10;
                        f5 = height;
                    } else {
                        f4 = i9;
                        f5 = width;
                    }
                    float f15 = f4 / f5;
                    if (a(z, width, height, i9, i10)) {
                        matrix.preScale(f14, f15);
                    }
                }
                i2 = width;
                i3 = height;
                i4 = 0;
            }
        } else {
            i2 = width;
            i3 = height;
            i4 = 0;
        }
        if (i != 0) {
            matrix.preRotate(i);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i8, i4, i2, i3, matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
