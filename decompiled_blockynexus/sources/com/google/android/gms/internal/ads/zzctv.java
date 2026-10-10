package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzctv implements zzbql {
    private final zzbgj zzeqk;

    private zzctv(zzbgj zzbgjVar) {
        this.zzeqk = zzbgjVar;
    }

    static zzbql zzp(zzbgj zzbgjVar) {
        return new zzctv(zzbgjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzyo getVideoController() {
        return this.zzeqk.zzzs();
    }
}
