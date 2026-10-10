package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.just.agentweb.WebIndicator;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpc {
    private static final byte[] zzbjr = {0, 0, 0, 1};
    private static final int[] zzbjs = {96000, 88200, 64000, 48000, 44100, LogType.UNEXP_KNOWN_REASON, 24000, 22050, 16000, 12000, 11025, WebIndicator.MAX_UNIFORM_SPEED_DURATION, 7350};
    private static final int[] zzbjt = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int zza(zzph zzphVar) {
        int iZzbk = zzphVar.zzbk(5);
        return iZzbk == 31 ? zzphVar.zzbk(6) + 32 : iZzbk;
    }

    private static int zzb(zzph zzphVar) {
        int iZzbk = zzphVar.zzbk(4);
        if (iZzbk == 15) {
            return zzphVar.zzbk(24);
        }
        zzoz.checkArgument(iZzbk < 13);
        return zzbjs[iZzbk];
    }

    public static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = zzbjr;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, zzbjr.length, i2);
        return bArr3;
    }

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzph zzphVar = new zzph(bArr);
        int iZza = zza(zzphVar);
        int iZzb = zzb(zzphVar);
        int iZzbk = zzphVar.zzbk(4);
        if (iZza == 5 || iZza == 29) {
            iZzb = zzb(zzphVar);
            if (zza(zzphVar) == 22) {
                iZzbk = zzphVar.zzbk(4);
            }
        }
        int i = zzbjt[iZzbk];
        zzoz.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(iZzb), Integer.valueOf(i));
    }
}
