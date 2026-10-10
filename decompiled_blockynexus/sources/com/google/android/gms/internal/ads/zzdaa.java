package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdaa {
    private zzyn zzadt;
    private boolean zzafc = false;
    private final String zzbuu;
    private final zzdae<zzbqo> zzgtp;

    public zzdaa(zzdae<zzbqo> zzdaeVar, String str) {
        this.zzgtp = zzdaeVar;
        this.zzbuu = str;
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            if (this.zzadt == null) {
                return null;
            }
            return this.zzadt.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgtp.isLoading();
    }

    public final synchronized void zza(zzvg zzvgVar, int i) throws RemoteException {
        this.zzadt = null;
        this.zzafc = this.zzgtp.zza(zzvgVar, this.zzbuu, new zzdaf(i), new zzczz(this));
    }

    public final synchronized String zzkh() {
        try {
            if (this.zzadt == null) {
                return null;
            }
            return this.zzadt.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    static /* synthetic */ boolean zza(zzdaa zzdaaVar, boolean z) {
        zzdaaVar.zzafc = false;
        return false;
    }
}
