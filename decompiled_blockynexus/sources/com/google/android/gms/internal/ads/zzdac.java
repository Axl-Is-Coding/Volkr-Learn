package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdac {
    private final zzcep zzgtr;
    private final zzczs zzgts = new zzczs();
    private final zzbui zzgtt;

    public zzdac(zzcep zzcepVar) {
        this.zzgtr = zzcepVar;
        final zzczs zzczsVar = this.zzgts;
        final zzajk zzajkVarZzamt = this.zzgtr.zzamt();
        this.zzgtt = new zzbui(zzczsVar, zzajkVarZzamt) { // from class: com.google.android.gms.internal.ads.zzdab
            private final zzczs zzgsz;
            private final zzajk zzgtq;

            {
                this.zzgsz = zzczsVar;
                this.zzgtq = zzajkVarZzamt;
            }

            @Override // com.google.android.gms.internal.ads.zzbui
            public final void zzk(zzva zzvaVar) {
                zzczs zzczsVar2 = this.zzgsz;
                zzajk zzajkVar = this.zzgtq;
                zzczsVar2.zzk(zzvaVar);
                if (zzajkVar != null) {
                    try {
                        zzajkVar.zzd(zzvaVar);
                    } catch (RemoteException e2) {
                        zzbbq.zze("#007 Could not call remote method.", e2);
                    }
                }
                if (zzajkVar != null) {
                    try {
                        zzajkVar.onInstreamAdFailedToLoad(zzvaVar.errorCode);
                    } catch (RemoteException e3) {
                        zzbbq.zze("#007 Could not call remote method.", e3);
                    }
                }
            }
        };
    }

    public final zzccw zzaqw() {
        return new zzccw(this.zzgtr, this.zzgts.zzaqt());
    }

    public final zzczs zzaqx() {
        return this.zzgts;
    }

    public final zzbuh zzaqy() {
        return this.zzgts;
    }

    public final zzbvs zzaqz() {
        return this.zzgts;
    }

    public final zzbui zzara() {
        return this.zzgtt;
    }

    public final zzbuz zzarb() {
        return this.zzgts;
    }

    public final zzux zzarc() {
        return this.zzgts;
    }

    public final void zzc(zzwt zzwtVar) {
        this.zzgts.zzc(zzwtVar);
    }
}
