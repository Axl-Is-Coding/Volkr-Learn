package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaij implements zzdya<zzaii, ParcelFileDescriptor> {
    private final /* synthetic */ zzaic zzdfw;

    zzaij(zzaik zzaikVar, zzaic zzaicVar) {
        this.zzdfw = zzaicVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final /* synthetic */ zzdzc<ParcelFileDescriptor> zzf(zzaii zzaiiVar) throws Exception {
        zzbcg zzbcgVar = new zzbcg();
        zzaiiVar.zza(this.zzdfw, new zzaim(this, zzbcgVar));
        return zzbcgVar;
    }
}
