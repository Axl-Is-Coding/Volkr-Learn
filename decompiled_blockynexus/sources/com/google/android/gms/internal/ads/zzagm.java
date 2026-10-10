package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzagm extends zzafj {
    private final /* synthetic */ zzagk zzdeg;

    private zzagm(zzagk zzagkVar) {
        this.zzdeg = zzagkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void zza(zzafa zzafaVar, String str) {
        if (this.zzdeg.zzdee == null) {
            return;
        }
        this.zzdeg.zzdee.onCustomClick(this.zzdeg.zzb(zzafaVar), str);
    }
}
