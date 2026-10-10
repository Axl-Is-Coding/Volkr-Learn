package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbsx implements zzbws {
    private final Context zzaai;
    private final zzbbx zzbot;
    private final zzayr zzdzr;
    private final zzcnu zzfmd;
    private final zzdok zzfsk;

    public zzbsx(Context context, zzdok zzdokVar, zzbbx zzbbxVar, zzayr zzayrVar, zzcnu zzcnuVar) {
        this.zzaai = context;
        this.zzfsk = zzdokVar;
        this.zzbot = zzbbxVar;
        this.zzdzr = zzayrVar;
        this.zzfmd = zzcnuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzb(zzdog zzdogVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(zzatc zzatcVar) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsq)).booleanValue()) {
            com.google.android.gms.ads.internal.zzp.zzkz().zza(this.zzaai, this.zzbot, this.zzfsk.zzhfb, this.zzdzr.zzxk());
        }
        this.zzfmd.zzapl();
    }
}
