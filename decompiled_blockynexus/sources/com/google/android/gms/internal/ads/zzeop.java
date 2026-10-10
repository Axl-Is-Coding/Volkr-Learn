package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeop {
    public static final zzeop zziui = new zzeop(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzeop zziuj = new zzeop(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzeop zziuk = new zzeop(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzeop zziul = new zzeop(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f13077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f13078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f13079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f13080d;
    private final double w;
    private final double zziue;
    private final double zziuf;
    private final double zziug;
    private final double zziuh;

    private zzeop(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.zziue = d6;
        this.zziuf = d7;
        this.w = d8;
        this.f13077a = d2;
        this.f13078b = d3;
        this.f13079c = d4;
        this.f13080d = d5;
        this.zziug = d9;
        this.zziuh = d10;
    }

    public static zzeop zzs(ByteBuffer byteBuffer) {
        double dZzi = zzbq.zzi(byteBuffer);
        double dZzi2 = zzbq.zzi(byteBuffer);
        double dZzj = zzbq.zzj(byteBuffer);
        return new zzeop(dZzi, dZzi2, zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer), dZzj, zzbq.zzj(byteBuffer), zzbq.zzj(byteBuffer), zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzeop.class != obj.getClass()) {
            return false;
        }
        zzeop zzeopVar = (zzeop) obj;
        return Double.compare(zzeopVar.f13077a, this.f13077a) == 0 && Double.compare(zzeopVar.f13078b, this.f13078b) == 0 && Double.compare(zzeopVar.f13079c, this.f13079c) == 0 && Double.compare(zzeopVar.f13080d, this.f13080d) == 0 && Double.compare(zzeopVar.zziug, this.zziug) == 0 && Double.compare(zzeopVar.zziuh, this.zziuh) == 0 && Double.compare(zzeopVar.zziue, this.zziue) == 0 && Double.compare(zzeopVar.zziuf, this.zziuf) == 0 && Double.compare(zzeopVar.w, this.w) == 0;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zziue);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zziuf);
        int i = (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.w);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f13077a);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.f13078b);
        int i4 = (i3 * 31) + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)));
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.f13079c);
        int i5 = (i4 * 31) + ((int) (jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32)));
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.f13080d);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)));
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.zziug);
        int i7 = (i6 * 31) + ((int) (jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32)));
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.zziuh);
        return (i7 * 31) + ((int) (jDoubleToLongBits9 ^ (jDoubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zziui)) {
            return "Rotate 0°";
        }
        if (equals(zziuj)) {
            return "Rotate 90°";
        }
        if (equals(zziuk)) {
            return "Rotate 180°";
        }
        if (equals(zziul)) {
            return "Rotate 270°";
        }
        double d2 = this.zziue;
        double d3 = this.zziuf;
        double d4 = this.w;
        double d5 = this.f13077a;
        double d6 = this.f13078b;
        double d7 = this.f13079c;
        double d8 = this.f13080d;
        double d9 = this.zziug;
        double d10 = this.zziuh;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }
}
