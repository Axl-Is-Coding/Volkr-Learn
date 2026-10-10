package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkd implements zzke {
    private final long zzaih;

    public zzkd(long j) {
        this.zzaih = j;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long getDurationUs() {
        return this.zzaih;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final boolean isSeekable() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long zzdz(long j) {
        return 0L;
    }
}
