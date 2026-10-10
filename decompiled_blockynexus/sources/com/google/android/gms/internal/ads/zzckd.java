package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzckd implements zzcar {
    private final zzbgj zzeqk;

    private zzckd(zzbgj zzbgjVar) {
        this.zzeqk = zzbgjVar;
    }

    static zzcar zzn(zzbgj zzbgjVar) {
        return new zzckd(zzbgjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcar
    public final void zzakw() {
        this.zzeqk.destroy();
    }
}
