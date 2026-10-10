package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzls {
    public final int[] zzaon;
    public final long[] zzaoo;
    public final int zzaxc;
    public final int zzaxi;
    public final int[] zzaxk;
    public final long[] zzbbh;

    public zzls(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        zzoz.checkArgument(iArr.length == jArr2.length);
        zzoz.checkArgument(jArr.length == jArr2.length);
        zzoz.checkArgument(iArr2.length == jArr2.length);
        this.zzaoo = jArr;
        this.zzaon = iArr;
        this.zzaxi = i;
        this.zzbbh = jArr2;
        this.zzaxk = iArr2;
        this.zzaxc = jArr.length;
    }

    public final int zzec(long j) {
        for (int iZza = zzpq.zza(this.zzbbh, j, true, false); iZza >= 0; iZza--) {
            if ((this.zzaxk[iZza] & 1) != 0) {
                return iZza;
            }
        }
        return -1;
    }

    public final int zzed(long j) {
        for (int iZzb = zzpq.zzb(this.zzbbh, j, true, false); iZzb < this.zzbbh.length; iZzb++) {
            if ((this.zzaxk[iZzb] & 1) != 0) {
                return iZzb;
            }
        }
        return -1;
    }
}
