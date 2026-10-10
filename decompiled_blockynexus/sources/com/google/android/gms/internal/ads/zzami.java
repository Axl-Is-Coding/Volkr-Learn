package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzami implements zzbci {
    private final /* synthetic */ zzbcg zzdfq;
    private final /* synthetic */ zzali zzdit;

    zzami(zzamg zzamgVar, zzbcg zzbcgVar, zzali zzaliVar) {
        this.zzdfq = zzbcgVar;
        this.zzdit = zzaliVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbci
    public final void run() {
        this.zzdfq.setException(new zzalu("Unable to obtain a JavascriptEngine."));
        this.zzdit.release();
    }
}
