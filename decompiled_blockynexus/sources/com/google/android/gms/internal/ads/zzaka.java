package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaka extends zzbik {
    private final /* synthetic */ zzaju zzdgq;

    private zzaka(zzaju zzajuVar) {
        this.zzdgq = zzajuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void zza(zzbin zzbinVar) {
        if (this.zzdgq.zzdgo != null) {
            this.zzdgq.zzdgo.zzti();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void zzb(zzbin zzbinVar) {
        this.zzdgq.zzg(zzbinVar.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final boolean zzc(zzbin zzbinVar) {
        return this.zzdgq.zzg(zzbinVar.uri);
    }
}
