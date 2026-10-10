package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzalk implements zzbck<zzalp> {
    private final /* synthetic */ zzali zzdia;

    zzalk(zzali zzaliVar) {
        this.zzdia = zzaliVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final /* synthetic */ void zzh(zzalp zzalpVar) {
        zzayp.zzei("Releasing engine reference.");
        this.zzdia.zzdhy.zztl();
    }
}
