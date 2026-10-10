package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzu extends zzxv {
    private zzait zzcky;

    @Override // com.google.android.gms.internal.ads.zzxs
    public final String getVersionString() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void initialize() throws RemoteException {
        zzbbq.zzfc("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzbbg.zzaah.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzzt
            private final zzzu zzckx;

            {
                this.zzckx = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzckx.zzqy();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void setAppMuted(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void setAppVolume(float f2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzaae zzaaeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzait zzaitVar) throws RemoteException {
        this.zzcky = zzaitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzanb zzanbVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzch(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzci(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final float zzqg() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final boolean zzqh() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final List<zzaiq> zzqi() throws RemoteException {
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzqj() {
    }

    final /* synthetic */ void zzqy() {
        zzait zzaitVar = this.zzcky;
        if (zzaitVar != null) {
            try {
                zzaitVar.zze(Collections.emptyList());
            } catch (RemoteException e2) {
                zzbbq.zzd("Could not notify onComplete event.", e2);
            }
        }
    }
}
