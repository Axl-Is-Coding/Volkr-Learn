package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcut extends zzauq implements zzbvp {
    private zzaur zzgpb;
    private zzbvo zzgpc;
    private zzcas zzgpd;

    public final synchronized void zza(zzaur zzaurVar) {
        this.zzgpb = zzaurVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzaf(iObjectWrapper);
        }
        if (this.zzgpd != null) {
            this.zzgpd.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzag(iObjectWrapper);
        }
        if (this.zzgpc != null) {
            this.zzgpc.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzah(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzai(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzaj(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzak(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzal(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzam(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zzd(iObjectWrapper, i);
        }
        if (this.zzgpd != null) {
            this.zzgpd.zzdx(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zze(iObjectWrapper, i);
        }
        if (this.zzgpc != null) {
            this.zzgpc.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvp
    public final synchronized void zza(zzbvo zzbvoVar) {
        this.zzgpc = zzbvoVar;
    }

    public final synchronized void zza(zzcas zzcasVar) {
        this.zzgpd = zzcasVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzauv zzauvVar) throws RemoteException {
        if (this.zzgpb != null) {
            this.zzgpb.zza(iObjectWrapper, zzauvVar);
        }
    }
}
