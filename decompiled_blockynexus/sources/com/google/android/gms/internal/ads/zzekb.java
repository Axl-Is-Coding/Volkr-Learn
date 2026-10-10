package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzekb {
    public static final byte[] zziex;
    private static final ByteBuffer zzijy;
    private static final zzeja zzijz;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zziex = bArr;
        zzijy = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zziex;
        zzijz = zzeja.zzb(bArr2, 0, bArr2.length, false);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int zzbu(boolean z) {
        return z ? 1231 : 1237;
    }

    static Object zze(Object obj, Object obj2) {
        return ((zzelj) obj).zzbgl().zzf((zzelj) obj2).zzbgs();
    }

    public static int zzfr(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static boolean zzk(zzelj zzeljVar) {
        if (!(zzeljVar instanceof zzeih)) {
            return false;
        }
        return false;
    }

    public static boolean zzy(byte[] bArr) {
        return zzeng.zzy(bArr);
    }

    public static String zzz(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }
}
