package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjt implements zzke {
    private final int length;
    private final long zzaih;
    private final int[] zzaon;
    private final long[] zzaoo;
    private final long[] zzaop;
    private final long[] zzaoq;

    public zzjt(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzaon = iArr;
        this.zzaoo = jArr;
        this.zzaop = jArr2;
        this.zzaoq = jArr3;
        this.length = iArr.length;
        int i = this.length;
        if (i > 0) {
            this.zzaih = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.zzaih = 0L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long getDurationUs() {
        return this.zzaih;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzke
    public final long zzdz(long j) {
        return this.zzaoo[zzpq.zza(this.zzaoq, j, true, true)];
    }
}
