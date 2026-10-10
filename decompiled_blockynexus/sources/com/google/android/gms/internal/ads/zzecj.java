package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecj {
    public static void zza(zzeei zzeeiVar) throws GeneralSecurityException {
        zzegy.zza(zza(zzeeiVar.zzbas().zzbbf()));
        zza(zzeeiVar.zzbas().zzbbg());
        if (zzeeiVar.zzbau() == zzeec.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzear.zza(zzeeiVar.zzbat().zzban());
    }

    public static String zza(zzeer zzeerVar) throws NoSuchAlgorithmException {
        int i = zzecm.zzhwk[zzeerVar.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String strValueOf = String.valueOf(zzeerVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(strValueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static zzeha zza(zzeeq zzeeqVar) throws GeneralSecurityException {
        int i = zzecm.zzhwl[zzeeqVar.ordinal()];
        if (i == 1) {
            return zzeha.NIST_P256;
        }
        if (i == 2) {
            return zzeha.NIST_P384;
        }
        if (i == 3) {
            return zzeha.NIST_P521;
        }
        String strValueOf = String.valueOf(zzeeqVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(strValueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzegz zza(zzeec zzeecVar) throws GeneralSecurityException {
        int i = zzecm.zzhwm[zzeecVar.ordinal()];
        if (i == 1) {
            return zzegz.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzegz.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzegz.COMPRESSED;
        }
        String strValueOf = String.valueOf(zzeecVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(strValueOf);
        throw new GeneralSecurityException(sb.toString());
    }
}
