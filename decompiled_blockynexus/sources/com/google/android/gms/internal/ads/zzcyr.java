package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyr implements zzcyl<zzcbe> {
    private final zzcce zzgos;
    private final Context zzvr;

    public zzcyr(Context context, zzcce zzcceVar) {
        this.zzvr = context;
        this.zzgos = zzcceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final /* synthetic */ zzcbe zza(zzdog zzdogVar, zzdnv zzdnvVar, View view, zzcys zzcysVar) {
        zzcbg zzcbgVarZza = this.zzgos.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzcyt(this, zzcyu.zzgsa));
        zzcysVar.zza(new zzcyw(this, zzcbgVarZza));
        return zzcbgVarZza.zzagj();
    }
}
