package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczk extends zzwx {
    private final zzdaa zzgsy;

    public zzczk(Context context, zzbix zzbixVar, zzdom zzdomVar, zzcep zzcepVar, zzwt zzwtVar) {
        zzdac zzdacVar = new zzdac(zzcepVar);
        zzdacVar.zzc(zzwtVar);
        this.zzgsy = new zzdaa(new zzdai(zzbixVar, context, zzdacVar, zzdomVar), zzdomVar.zzatl());
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String getMediationAdapterClassName() {
        return this.zzgsy.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgsy.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzvg zzvgVar, int i) throws RemoteException {
        this.zzgsy.zza(zzvgVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzb(zzvg zzvgVar) throws RemoteException {
        this.zzgsy.zza(zzvgVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String zzkh() {
        return this.zzgsy.zzkh();
    }
}
