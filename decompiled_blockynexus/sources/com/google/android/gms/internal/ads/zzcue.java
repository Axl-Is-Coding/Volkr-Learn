package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcue implements zzbql {
    private final zzdpa zzgoo;

    private zzcue(zzdpa zzdpaVar) {
        this.zzgoo = zzdpaVar;
    }

    static zzbql zza(zzdpa zzdpaVar) {
        return new zzcue(zzdpaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzyo getVideoController() {
        return this.zzgoo.getVideoController();
    }
}
