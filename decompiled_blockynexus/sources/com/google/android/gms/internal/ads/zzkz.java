package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkz implements zzky {
    private final zzpk zzawi;
    private final int zzaxc;
    private final int zzaxd;
    private int zzaxe;
    private int zzaxf;

    public zzkz(zzkt zzktVar) {
        this.zzawi = zzktVar.zzawi;
        this.zzawi.zzbo(12);
        this.zzaxd = this.zzawi.zzjf() & 255;
        this.zzaxc = this.zzawi.zzjf();
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgy() {
        return this.zzaxc;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgz() {
        int i = this.zzaxd;
        if (i == 8) {
            return this.zzawi.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzawi.readUnsignedShort();
        }
        int i2 = this.zzaxe;
        this.zzaxe = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzaxf & 15;
        }
        this.zzaxf = this.zzawi.readUnsignedByte();
        return (this.zzaxf & 240) >> 4;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final boolean zzha() {
        return false;
    }
}
