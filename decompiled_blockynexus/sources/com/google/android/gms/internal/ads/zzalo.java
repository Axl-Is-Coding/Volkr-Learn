package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzalo implements zzbci {
    private final /* synthetic */ zzali zzdib;

    zzalo(zzalm zzalmVar, zzali zzaliVar) {
        this.zzdib = zzaliVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbci
    public final void run() {
        zzayp.zzei("Rejecting reference for JS Engine.");
        this.zzdib.reject();
    }
}
