package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzsy implements zzrh {
    private final /* synthetic */ zzsw zzbuz;

    zzsy(zzsw zzswVar) {
        this.zzbuz = zzswVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrh
    public final void zzp(boolean z) {
        if (z) {
            this.zzbuz.connect();
        } else {
            this.zzbuz.disconnect();
        }
    }
}
