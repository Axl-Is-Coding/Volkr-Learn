package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import cn.qqtheme.framework.widget.WheelView;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f19209a = TimeUnit.SECONDS.toNanos(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f19210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f19211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f19212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f19213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19214f;
    public final String g;
    public final List<L> h;
    public final int i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;
    public final boolean q;
    public final Bitmap.Config r;
    public final Picasso.Priority s;

    String a() {
        Uri uri = this.f19213e;
        return uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(this.f19214f);
    }

    boolean b() {
        return this.h != null;
    }

    public boolean c() {
        return (this.i == 0 && this.j == 0) ? false : true;
    }

    String d() {
        long jNanoTime = System.nanoTime() - this.f19211c;
        if (jNanoTime > f19209a) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(jNanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(jNanoTime) + "ms";
    }

    boolean e() {
        return c() || this.n != WheelView.DividerConfig.FILL;
    }

    boolean f() {
        return e() || b();
    }

    String g() {
        return "[R" + this.f19210b + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i = this.f19214f;
        if (i > 0) {
            sb.append(i);
        } else {
            sb.append(this.f19213e);
        }
        List<L> list = this.h;
        if (list != null && !list.isEmpty()) {
            for (L l : this.h) {
                sb.append(' ');
                sb.append(l.a());
            }
        }
        if (this.g != null) {
            sb.append(" stableKey(");
            sb.append(this.g);
            sb.append(')');
        }
        if (this.i > 0) {
            sb.append(" resize(");
            sb.append(this.i);
            sb.append(',');
            sb.append(this.j);
            sb.append(')');
        }
        if (this.k) {
            sb.append(" centerCrop");
        }
        if (this.l) {
            sb.append(" centerInside");
        }
        if (this.n != WheelView.DividerConfig.FILL) {
            sb.append(" rotation(");
            sb.append(this.n);
            if (this.q) {
                sb.append(" @ ");
                sb.append(this.o);
                sb.append(',');
                sb.append(this.p);
            }
            sb.append(')');
        }
        if (this.r != null) {
            sb.append(' ');
            sb.append(this.r);
        }
        sb.append('}');
        return sb.toString();
    }

    private C(Uri uri, int i, String str, List<L> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f2, float f3, float f4, boolean z4, Bitmap.Config config, Picasso.Priority priority) {
        this.f19213e = uri;
        this.f19214f = i;
        this.g = str;
        if (list == null) {
            this.h = null;
        } else {
            this.h = Collections.unmodifiableList(list);
        }
        this.i = i2;
        this.j = i3;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = z4;
        this.r = config;
        this.s = priority;
    }

    /* JADX INFO: compiled from: Request.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f19215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f19216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f19218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f19219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f19220f;
        private boolean g;
        private boolean h;
        private float i;
        private float j;
        private float k;
        private boolean l;
        private List<L> m;
        private Bitmap.Config n;
        private Picasso.Priority o;

        a(Uri uri, int i, Bitmap.Config config) {
            this.f19215a = uri;
            this.f19216b = i;
            this.n = config;
        }

        public a a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.f19218d = i;
            this.f19219e = i2;
            return this;
        }

        public a b() {
            if (this.g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f19220f = true;
            return this;
        }

        boolean c() {
            return (this.f19215a == null && this.f19216b == 0) ? false : true;
        }

        boolean d() {
            return (this.f19218d == 0 && this.f19219e == 0) ? false : true;
        }

        public C a() {
            if (this.g && this.f19220f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f19220f && this.f19218d == 0 && this.f19219e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.g && this.f19218d == 0 && this.f19219e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.o == null) {
                this.o = Picasso.Priority.NORMAL;
            }
            return new C(this.f19215a, this.f19216b, this.f19217c, this.m, this.f19218d, this.f19219e, this.f19220f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.o);
        }
    }
}
