package com.tencent.mapsdk.rastercore.b;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f19459a = Double.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f19460b = Double.MIN_VALUE;

    public f(double d2, double d3) {
        b(d2);
        a(d3);
    }

    public final double a() {
        return this.f19459a;
    }

    public final void a(double d2) {
        this.f19459a = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d2));
    }

    public final double b() {
        return this.f19460b;
    }

    public final void b(double d2) {
        this.f19460b = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d2));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.hashCode() != hashCode() || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Double.doubleToLongBits(fVar.f19460b) == Double.doubleToLongBits(this.f19460b) && Double.doubleToLongBits(fVar.f19459a) == Double.doubleToLongBits(this.f19459a);
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f19460b);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f19459a);
        return ((((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }
}
