package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzema implements zzelh {
    private final int flags;
    private final String info;
    private final Object[] zzilp;
    private final zzelj zzils;

    zzema(zzelj zzeljVar, String str, Object[] objArr) {
        this.zzils = zzeljVar;
        this.info = str;
        this.zzilp = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.flags = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.flags = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzelh
    public final int zzbhs() {
        return (this.flags & 1) == 1 ? zzejz.zze.zzijs : zzejz.zze.zzijt;
    }

    @Override // com.google.android.gms.internal.ads.zzelh
    public final boolean zzbht() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.zzelh
    public final zzelj zzbhu() {
        return this.zzils;
    }

    final String zzbid() {
        return this.info;
    }

    final Object[] zzbie() {
        return this.zzilp;
    }
}
