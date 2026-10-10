package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdaz implements zzdyr<zzdbm> {
    private final /* synthetic */ zzaxg zzgum;
    private final /* synthetic */ zzdaq zzgun;

    zzdaz(zzdaq zzdaqVar, zzaxg zzaxgVar) {
        this.zzgun = zzdaqVar;
        this.zzgum = zzaxgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzdbm zzdbmVar) {
        zzdbm zzdbmVar2 = zzdbmVar;
        try {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxp)).booleanValue()) {
                if (this.zzgun.zzbot.zzeem >= ((Integer) zzwm.zzpx().zzd(zzabb.zzcxr)).intValue()) {
                    if (zzdbmVar2 == null) {
                        this.zzgum.zza(null, null, null);
                        return;
                    } else {
                        this.zzgum.zza(zzdbmVar2.zzguv, zzdbmVar2.zzguw, zzdbmVar2.zzgux);
                        return;
                    }
                }
            }
            if (zzdbmVar2 == null) {
                this.zzgum.zzk(null, null);
            } else {
                this.zzgum.zzk(zzdbmVar2.zzguv, zzdbmVar2.zzguw);
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        try {
            zzaxg zzaxgVar = this.zzgum;
            String strValueOf = String.valueOf(th.getMessage());
            zzaxgVar.onError(strValueOf.length() != 0 ? "Internal error. ".concat(strValueOf) : new String("Internal error. "));
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
