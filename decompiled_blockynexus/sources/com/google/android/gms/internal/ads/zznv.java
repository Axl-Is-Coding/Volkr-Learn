package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznv extends zzoa {
    private static final int[] zzbgz = new int[0];
    private final zzoe zzbha;
    private final AtomicReference<zzny> zzbhb;

    public zznv() {
        this(null);
    }

    private static int zze(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b2  */
    @Override // com.google.android.gms.internal.ads.zzoa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.gms.internal.ads.zzob[] zza(com.google.android.gms.internal.ads.zzhw[] r37, com.google.android.gms.internal.ads.zznp[] r38, int[][][] r39) throws com.google.android.gms.internal.ads.zzhd {
        /*
            Method dump skipped, instruction units count: 1120
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznv.zza(com.google.android.gms.internal.ads.zzhw[], com.google.android.gms.internal.ads.zznp[], int[][][]):com.google.android.gms.internal.ads.zzob[]");
    }

    private zznv(zzoe zzoeVar) {
        this.zzbha = null;
        this.zzbhb = new AtomicReference<>(new zzny());
    }

    private static boolean zza(zzho zzhoVar, String str) {
        return str != null && TextUtils.equals(str, zzpq.zzbj(zzhoVar.zzaht));
    }
}
