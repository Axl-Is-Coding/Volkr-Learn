package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.ci;
import okio.Utf8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeni {
    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b2, char[] cArr, int i) {
        cArr[i] = (char) b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(byte b2) {
        return b2 >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzf(byte b2) {
        return b2 < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzg(byte b2) {
        return b2 < -16;
    }

    private static boolean zzh(byte b2) {
        return b2 > -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b2, byte b3, char[] cArr, int i) throws zzekj {
        if (b2 < -62 || zzh(b3)) {
            throw zzekj.zzbhf();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzekj {
        if (!zzh(b3) && ((b2 != -32 || b3 >= -96) && ((b2 != -19 || b3 < -96) && !zzh(b4)))) {
            cArr[i] = (char) (((b2 & ci.m) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzekj.zzbhf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzekj {
        if (!zzh(b3) && (((b2 << 28) + (b3 + 112)) >> 30) == 0 && !zzh(b4) && !zzh(b5)) {
            int i2 = ((b2 & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << 12) | ((b4 & Utf8.REPLACEMENT_BYTE) << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
            cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
            cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            return;
        }
        throw zzekj.zzbhf();
    }
}
