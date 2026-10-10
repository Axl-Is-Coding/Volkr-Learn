package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcxp extends zzauq {
    private final /* synthetic */ zzbwa zzgqs;
    private final /* synthetic */ zzbuc zzgqt;
    private final /* synthetic */ zzbvh zzgqu;
    private final /* synthetic */ zzcal zzgqv;

    zzcxp(zzcxl zzcxlVar, zzbwa zzbwaVar, zzbuc zzbucVar, zzbvh zzbvhVar, zzcal zzcalVar) {
        this.zzgqs = zzbwaVar;
        this.zzgqt = zzbucVar;
        this.zzgqu = zzbvhVar;
        this.zzgqv = zzcalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(IObjectWrapper iObjectWrapper, zzauv zzauvVar) {
        this.zzgqv.zza(zzauvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.zzgqs.zzun();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgqv.zzta();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgqs.zzum();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgqt.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgqu.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzgqu.onRewardedVideoCompleted();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }
}
