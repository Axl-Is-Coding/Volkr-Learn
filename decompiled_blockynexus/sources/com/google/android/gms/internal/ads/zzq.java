package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzq implements zzan {
    private int zzac;
    private int zzad;
    private final int zzae;
    private final float zzaf;

    public zzq() {
        this(2500, 1, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final void zza(zzao zzaoVar) throws zzao {
        this.zzad++;
        int i = this.zzac;
        this.zzac = i + ((int) (i * this.zzaf));
        if (!(this.zzad <= this.zzae)) {
            throw zzaoVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final int zzb() {
        return this.zzac;
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final int zzc() {
        return this.zzad;
    }

    private zzq(int i, int i2, float f2) {
        this.zzac = 2500;
        this.zzae = 1;
        this.zzaf = 1.0f;
    }
}
