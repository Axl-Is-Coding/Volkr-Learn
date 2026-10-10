package com.google.android.gms.internal.ads;

import io.rong.common.LibStorageUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpg {
    public static boolean zzbf(String str) {
        return LibStorageUtils.AUDIO.equals(zzbh(str));
    }

    public static boolean zzbg(String str) {
        return "video".equals(zzbh(str));
    }

    private static String zzbh(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1) {
            return str.substring(0, iIndexOf);
        }
        String strValueOf = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Invalid mime type: ".concat(strValueOf) : new String("Invalid mime type: "));
    }
}
