package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhu {
    public static final zzhu zzahz = new zzhu(1.0f, 1.0f);
    public final float zzaia;
    public final float zzaib;
    private final int zzaic;

    public zzhu(float f2, float f3) {
        this.zzaia = f2;
        this.zzaib = f3;
        this.zzaic = Math.round(f2 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhu.class == obj.getClass()) {
            zzhu zzhuVar = (zzhu) obj;
            if (this.zzaia == zzhuVar.zzaia && this.zzaib == zzhuVar.zzaib) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzaia) + 527) * 31) + Float.floatToRawIntBits(this.zzaib);
    }

    public final long zzdu(long j) {
        return j * ((long) this.zzaic);
    }
}
