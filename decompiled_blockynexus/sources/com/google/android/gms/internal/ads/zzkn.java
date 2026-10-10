package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkn implements zzkm {
    private final /* synthetic */ zzkl zzark;

    private zzkn(zzkl zzklVar) {
        this.zzark = zzklVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zza(int i, double d2) throws zzhv {
        this.zzark.zza(i, d2);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final int zzan(int i) {
        return zzkl.zzan(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final boolean zzao(int i) {
        return zzkl.zzao(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zzap(int i) throws zzhv {
        this.zzark.zzap(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zzc(int i, long j) throws zzhv {
        this.zzark.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zzd(int i, long j, long j2) throws zzhv {
        this.zzark.zzd(i, j, j2);
    }

    /* synthetic */ zzkn(zzkl zzklVar, zzko zzkoVar) {
        this(zzklVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zza(int i, String str) throws zzhv {
        this.zzark.zza(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zza(int i, int i2, zzjy zzjyVar) throws InterruptedException, IOException {
        this.zzark.zza(i, i2, zzjyVar);
    }
}
