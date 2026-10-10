package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzla implements zzky {
    private final zzpk zzawi;
    private final int zzaxc;
    private final int zzaxg;

    public zzla(zzkt zzktVar) {
        this.zzawi = zzktVar.zzawi;
        this.zzawi.zzbo(12);
        this.zzaxg = this.zzawi.zzjf();
        this.zzaxc = this.zzawi.zzjf();
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgy() {
        return this.zzaxc;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgz() {
        int i = this.zzaxg;
        return i == 0 ? this.zzawi.zzjf() : i;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final boolean zzha() {
        return this.zzaxg != 0;
    }
}
