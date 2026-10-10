package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcuh extends zzaoy {
    private zzctc<zzaph, zzcuu> zzgoq;
    private final /* synthetic */ zzcug zzgor;

    private zzcuh(zzcug zzcugVar, zzctc<zzaph, zzcuu> zzctcVar) {
        this.zzgor = zzcugVar;
        this.zzgoq = zzctcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zzdq(String str) throws RemoteException {
        ((zzcuu) this.zzgoq.zzgns).zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zzf(zzva zzvaVar) throws RemoteException {
        ((zzcuu) this.zzgoq.zzgns).zzc(zzvaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzgor.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcuu) this.zzgoq.zzgns).onAdLoaded();
    }
}
