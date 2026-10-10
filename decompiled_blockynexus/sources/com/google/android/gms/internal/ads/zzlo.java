package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlo {
    private static final int[] zzbai = {zzpq.zzbl("isom"), zzpq.zzbl("iso2"), zzpq.zzbl("iso3"), zzpq.zzbl("iso4"), zzpq.zzbl("iso5"), zzpq.zzbl("iso6"), zzpq.zzbl("avc1"), zzpq.zzbl("hvc1"), zzpq.zzbl("hev1"), zzpq.zzbl("mp41"), zzpq.zzbl("mp42"), zzpq.zzbl("3g2a"), zzpq.zzbl("3g2b"), zzpq.zzbl("3gr6"), zzpq.zzbl("3gs6"), zzpq.zzbl("3ge6"), zzpq.zzbl("3gg6"), zzpq.zzbl("M4V "), zzpq.zzbl("M4A "), zzpq.zzbl("f4v "), zzpq.zzbl("kddi"), zzpq.zzbl("M4VP"), zzpq.zzbl("qt  "), zzpq.zzbl("MSNV")};

    /* JADX WARN: Removed duplicated region for block: B:76:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean zza(com.google.android.gms.internal.ads.zzjy r16, boolean r17) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r0 = r16
            long r1 = r16.getLength()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L12
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L13
        L12:
            r1 = r3
        L13:
            int r2 = (int) r1
            com.google.android.gms.internal.ads.zzpk r1 = new com.google.android.gms.internal.ads.zzpk
            r3 = 64
            r1.<init>(r3)
            r3 = 0
            r4 = 0
            r5 = 0
        L1e:
            if (r4 >= r2) goto Lb8
            r7 = 8
            r1.reset(r7)
            byte[] r8 = r1.data
            r0.zza(r8, r3, r7)
            long r8 = r1.zzjc()
            int r10 = r1.readInt()
            r11 = 1
            r13 = 16
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 != 0) goto L47
            byte[] r8 = r1.data
            r0.zza(r8, r7, r7)
            r1.zzbn(r13)
            long r8 = r1.zzjg()
            goto L49
        L47:
            r13 = 8
        L49:
            long r11 = (long) r13
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 >= 0) goto L4f
            return r3
        L4f:
            int r4 = r4 + r13
            int r13 = com.google.android.gms.internal.ads.zzkr.zzatt
            if (r10 == r13) goto L1e
            int r13 = com.google.android.gms.internal.ads.zzkr.zzauc
            if (r10 == r13) goto Lb6
            int r13 = com.google.android.gms.internal.ads.zzkr.zzaue
            if (r10 != r13) goto L5d
            goto Lb6
        L5d:
            long r13 = (long) r4
            long r13 = r13 + r8
            long r13 = r13 - r11
            long r6 = (long) r2
            int r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r15 >= 0) goto Lb8
            long r8 = r8 - r11
            int r6 = (int) r8
            int r4 = r4 + r6
            int r7 = com.google.android.gms.internal.ads.zzkr.zzass
            if (r10 != r7) goto Laf
            r7 = 8
            if (r6 >= r7) goto L71
            return r3
        L71:
            r1.reset(r6)
            byte[] r7 = r1.data
            r0.zza(r7, r3, r6)
            int r6 = r6 / 4
            r7 = 0
        L7c:
            if (r7 >= r6) goto Lac
            r8 = 1
            if (r7 != r8) goto L86
            r8 = 4
            r1.zzbp(r8)
            goto La9
        L86:
            int r8 = r1.readInt()
            int r9 = r8 >>> 8
            java.lang.String r10 = "3gp"
            int r10 = com.google.android.gms.internal.ads.zzpq.zzbl(r10)
            if (r9 != r10) goto L96
        L94:
            r8 = 1
            goto La5
        L96:
            int[] r9 = com.google.android.gms.internal.ads.zzlo.zzbai
            int r10 = r9.length
            r11 = 0
        L9a:
            if (r11 >= r10) goto La4
            r12 = r9[r11]
            if (r12 != r8) goto La1
            goto L94
        La1:
            int r11 = r11 + 1
            goto L9a
        La4:
            r8 = 0
        La5:
            if (r8 == 0) goto La9
            r5 = 1
            goto Lac
        La9:
            int r7 = r7 + 1
            goto L7c
        Lac:
            if (r5 != 0) goto L1e
            return r3
        Laf:
            if (r6 == 0) goto L1e
            r0.zzaj(r6)
            goto L1e
        Lb6:
            r0 = 1
            goto Lb9
        Lb8:
            r0 = 0
        Lb9:
            if (r5 == 0) goto Lc1
            r1 = r17
            if (r1 != r0) goto Lc1
            r0 = 1
            return r0
        Lc1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlo.zza(com.google.android.gms.internal.ads.zzjy, boolean):boolean");
    }

    public static boolean zzd(zzjy zzjyVar) throws InterruptedException, IOException {
        return zza(zzjyVar, true);
    }

    public static boolean zze(zzjy zzjyVar) throws InterruptedException, IOException {
        return zza(zzjyVar, false);
    }
}
