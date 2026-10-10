package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzy extends zzavb {
    @Override // com.google.android.gms.internal.ads.zzauy
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final String getMediationAdapterClassName() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavd zzavdVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavl zzavlVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavt zzavtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException {
        zza(zzavgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzyh zzyhVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzyi zzyiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zzb(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException {
        zza(zzavgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final zzyn zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final zzaux zzqz() {
        return null;
    }

    private static void zza(final zzavg zzavgVar) {
        zzbbq.zzfc("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbbg.zzaah.post(new Runnable(zzavgVar) { // from class: com.google.android.gms.internal.ads.zzzx
            private final zzavg zzckz;

            {
                this.zzckz = zzavgVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzavg zzavgVar2 = this.zzckz;
                if (zzavgVar2 != null) {
                    try {
                        zzavgVar2.onRewardedAdFailedToLoad(1);
                    } catch (RemoteException e2) {
                        zzbbq.zze("#007 Could not call remote method.", e2);
                    }
                }
            }
        });
    }
}
