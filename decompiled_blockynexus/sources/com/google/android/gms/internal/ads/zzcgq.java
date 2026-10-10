package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcgq implements zzdvu<zzy, Bitmap> {
    private final /* synthetic */ double zzgct;
    private final /* synthetic */ boolean zzgcu;
    private final /* synthetic */ zzcgn zzgcv;

    zzcgq(zzcgn zzcgnVar, double d2, boolean z) {
        this.zzgcv = zzcgnVar;
        this.zzgct = d2;
        this.zzgcu = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final /* synthetic */ Bitmap apply(zzy zzyVar) {
        return this.zzgcv.zza(zzyVar.data, this.zzgct, this.zzgcu);
    }
}
