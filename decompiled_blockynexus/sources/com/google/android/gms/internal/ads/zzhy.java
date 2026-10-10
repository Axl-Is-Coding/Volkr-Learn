package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzhy {
    public static final zzhy zzaid = new zzib();

    public final boolean isEmpty() {
        return zzff() == 0;
    }

    public abstract zzia zza(int i, zzia zziaVar, boolean z);

    public final zzid zza(int i, zzid zzidVar, boolean z) {
        return zza(i, zzidVar, false, 0L);
    }

    public abstract zzid zza(int i, zzid zzidVar, boolean z, long j);

    public abstract int zzc(Object obj);

    public abstract int zzff();

    public abstract int zzfg();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(int r3, com.google.android.gms.internal.ads.zzia r4, com.google.android.gms.internal.ads.zzid r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.zza(r3, r4, r0)
            r2.zza(r0, r5, r0)
            r4 = 1
            if (r3 != 0) goto L31
            r3 = -1
            if (r6 == 0) goto L22
            if (r6 == r4) goto L20
            r1 = 2
            if (r6 != r1) goto L1a
            int r6 = r2.zzff()
            int r6 = r6 - r4
            if (r6 != 0) goto L2a
            goto L20
        L1a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L20:
            r4 = 0
            goto L2a
        L22:
            int r6 = r2.zzff()
            int r6 = r6 - r4
            if (r6 != 0) goto L2a
            r4 = -1
        L2a:
            if (r4 != r3) goto L2d
            return r3
        L2d:
            r2.zza(r4, r5, r0)
            return r0
        L31:
            int r3 = r3 + r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhy.zza(int, com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zzid, int):int");
    }
}
