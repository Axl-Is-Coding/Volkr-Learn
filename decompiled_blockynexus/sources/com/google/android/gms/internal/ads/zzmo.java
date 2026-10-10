package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmo implements zznl {
    private final zznl[] zzbej;

    public zzmo(zznl[] zznlVarArr) {
        this.zzbej = zznlVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final boolean zzef(long j) {
        boolean zZzef;
        boolean z = false;
        do {
            long jZzhp = zzhp();
            if (jZzhp == Long.MIN_VALUE) {
                break;
            }
            zZzef = false;
            for (zznl zznlVar : this.zzbej) {
                if (zznlVar.zzhp() == jZzhp) {
                    zZzef |= zznlVar.zzef(j);
                }
            }
            z |= zZzef;
        } while (zZzef);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final long zzhp() {
        long jMin = Long.MAX_VALUE;
        for (zznl zznlVar : this.zzbej) {
            long jZzhp = zznlVar.zzhp();
            if (jZzhp != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzhp);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }
}
