package b.d.a.b;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: Matrix.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f2529a = new h(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f2530b = new h(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f2531c = new h(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f2532d = new h(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f2533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    double f2534f;
    double g;
    double h;
    double i;
    double j;
    double k;
    double l;
    double m;

    public h(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.f2533e = d6;
        this.f2534f = d7;
        this.g = d8;
        this.h = d2;
        this.i = d3;
        this.j = d4;
        this.k = d5;
        this.l = d9;
        this.m = d10;
    }

    public static h a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return new h(d2, d3, d5, d6, d4, d7, d10, d8, d9);
    }

    public void b(ByteBuffer byteBuffer) {
        b.b.a.e.b(byteBuffer, this.h);
        b.b.a.e.b(byteBuffer, this.i);
        b.b.a.e.a(byteBuffer, this.f2533e);
        b.b.a.e.b(byteBuffer, this.j);
        b.b.a.e.b(byteBuffer, this.k);
        b.b.a.e.a(byteBuffer, this.f2534f);
        b.b.a.e.b(byteBuffer, this.l);
        b.b.a.e.b(byteBuffer, this.m);
        b.b.a.e.a(byteBuffer, this.g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return Double.compare(hVar.h, this.h) == 0 && Double.compare(hVar.i, this.i) == 0 && Double.compare(hVar.j, this.j) == 0 && Double.compare(hVar.k, this.k) == 0 && Double.compare(hVar.l, this.l) == 0 && Double.compare(hVar.m, this.m) == 0 && Double.compare(hVar.f2533e, this.f2533e) == 0 && Double.compare(hVar.f2534f, this.f2534f) == 0 && Double.compare(hVar.g, this.g) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f2533e);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f2534f);
        int i = (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.g);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.h);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.i);
        int i4 = (i3 * 31) + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)));
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.j);
        int i5 = (i4 * 31) + ((int) (jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32)));
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.k);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)));
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.l);
        int i7 = (i6 * 31) + ((int) (jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32)));
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.m);
        return (i7 * 31) + ((int) (jDoubleToLongBits9 ^ (jDoubleToLongBits9 >>> 32)));
    }

    public String toString() {
        if (equals(f2529a)) {
            return "Rotate 0°";
        }
        if (equals(f2530b)) {
            return "Rotate 90°";
        }
        if (equals(f2531c)) {
            return "Rotate 180°";
        }
        if (equals(f2532d)) {
            return "Rotate 270°";
        }
        return "Matrix{u=" + this.f2533e + ", v=" + this.f2534f + ", w=" + this.g + ", a=" + this.h + ", b=" + this.i + ", c=" + this.j + ", d=" + this.k + ", tx=" + this.l + ", ty=" + this.m + '}';
    }

    public static h a(ByteBuffer byteBuffer) {
        return a(b.b.a.d.c(byteBuffer), b.b.a.d.c(byteBuffer), b.b.a.d.b(byteBuffer), b.b.a.d.c(byteBuffer), b.b.a.d.c(byteBuffer), b.b.a.d.b(byteBuffer), b.b.a.d.c(byteBuffer), b.b.a.d.c(byteBuffer), b.b.a.d.b(byteBuffer));
    }
}
