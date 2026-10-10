package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.C;
import com.squareup.picasso.Picasso;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RequestCreator.java */
/* JADX INFO: loaded from: classes5.dex */
public class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f19221a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Picasso f19222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C.a f19223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19226f = true;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    D(Picasso picasso, Uri uri, int i) {
        if (picasso.q) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f19222b = picasso;
        this.f19223c = new C.a(uri, i, picasso.n);
    }

    private Drawable d() {
        return this.g != 0 ? this.f19222b.g.getResources().getDrawable(this.g) : this.k;
    }

    public D a(Drawable drawable) {
        if (!this.f19226f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (this.g != 0) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.k = drawable;
        return this;
    }

    public D b() {
        this.f19225e = true;
        return this;
    }

    D c() {
        this.f19225e = false;
        return this;
    }

    public D a(int i) {
        if (i != 0) {
            if (this.l == null) {
                this.h = i;
                return this;
            }
            throw new IllegalStateException("Error image already set.");
        }
        throw new IllegalArgumentException("Error image resource invalid.");
    }

    public D a(int i, int i2) {
        this.f19223c.a(i, i2);
        return this;
    }

    public D a() {
        this.f19223c.b();
        return this;
    }

    public void a(J j) {
        Bitmap bitmapB;
        long jNanoTime = System.nanoTime();
        P.a();
        if (j != null) {
            if (!this.f19225e) {
                if (!this.f19223c.c()) {
                    this.f19222b.a(j);
                    j.onPrepareLoad(this.f19226f ? d() : null);
                    return;
                }
                C cA = a(jNanoTime);
                String strA = P.a(cA);
                if (MemoryPolicy.shouldReadFromMemoryCache(this.i) && (bitmapB = this.f19222b.b(strA)) != null) {
                    this.f19222b.a(j);
                    j.onBitmapLoaded(bitmapB, Picasso.LoadedFrom.MEMORY);
                    return;
                } else {
                    j.onPrepareLoad(this.f19226f ? d() : null);
                    this.f19222b.a((AbstractC2746a) new K(this.f19222b, j, cA, this.i, this.j, this.l, strA, this.m, this.h));
                    return;
                }
            }
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    public void a(ImageView imageView) {
        a(imageView, (InterfaceC2757l) null);
    }

    public void a(ImageView imageView, InterfaceC2757l interfaceC2757l) {
        Bitmap bitmapB;
        long jNanoTime = System.nanoTime();
        P.a();
        if (imageView != null) {
            if (!this.f19223c.c()) {
                this.f19222b.a(imageView);
                if (this.f19226f) {
                    z.a(imageView, d());
                    return;
                }
                return;
            }
            if (this.f19225e) {
                if (!this.f19223c.d()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width != 0 && height != 0) {
                        this.f19223c.a(width, height);
                    } else {
                        if (this.f19226f) {
                            z.a(imageView, d());
                        }
                        this.f19222b.a(imageView, new ViewTreeObserverOnPreDrawListenerC2760o(this, imageView, interfaceC2757l));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            C cA = a(jNanoTime);
            String strA = P.a(cA);
            if (MemoryPolicy.shouldReadFromMemoryCache(this.i) && (bitmapB = this.f19222b.b(strA)) != null) {
                this.f19222b.a(imageView);
                Picasso picasso = this.f19222b;
                z.a(imageView, picasso.g, bitmapB, Picasso.LoadedFrom.MEMORY, this.f19224d, picasso.o);
                if (this.f19222b.p) {
                    P.a("Main", "completed", cA.g(), "from " + Picasso.LoadedFrom.MEMORY);
                }
                if (interfaceC2757l != null) {
                    interfaceC2757l.onSuccess();
                    return;
                }
                return;
            }
            if (this.f19226f) {
                z.a(imageView, d());
            }
            this.f19222b.a((AbstractC2746a) new s(this.f19222b, imageView, cA, this.i, this.j, this.h, this.l, strA, this.m, interfaceC2757l, this.f19224d));
            return;
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    private C a(long j) {
        int andIncrement = f19221a.getAndIncrement();
        C cA = this.f19223c.a();
        cA.f19210b = andIncrement;
        cA.f19211c = j;
        boolean z = this.f19222b.p;
        if (z) {
            P.a("Main", "created", cA.g(), cA.toString());
        }
        this.f19222b.a(cA);
        if (cA != cA) {
            cA.f19210b = andIncrement;
            cA.f19211c = j;
            if (z) {
                P.a("Main", "changed", cA.d(), "into " + cA);
            }
        }
        return cA;
    }
}
