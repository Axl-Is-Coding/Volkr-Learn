package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzzq extends zzwx {
    final /* synthetic */ zzzo zzckv;

    private zzzq(zzzo zzzoVar) {
        this.zzckv = zzzoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvg zzvgVar, int i) throws RemoteException {
        zzbbq.zzfc("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbbg.zzaah.post(new zzzp(this));
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzb(zzvg zzvgVar) throws RemoteException {
        zza(zzvgVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final String zzkh() throws RemoteException {
        return null;
    }
}
