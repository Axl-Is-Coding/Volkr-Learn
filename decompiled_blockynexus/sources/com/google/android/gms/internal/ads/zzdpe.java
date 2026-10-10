package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpe {
    public static zzva zza(zzdpg zzdpgVar, zzva zzvaVar) {
        if (zzdpgVar.equals(zzdpg.MEDIATION_SHOW_ERROR)) {
            if (((Integer) zzwm.zzpx().zzd(zzabb.zzcyn)).intValue() > 0) {
                return zzvaVar;
            }
        }
        return zza(zzdpgVar, null, zzvaVar);
    }

    public static zzva zzh(Throwable th) {
        if (th instanceof zzcte) {
            zzcte zzcteVar = (zzcte) th;
            return zza(zzcteVar.zzapr(), zzcteVar.zzaqj());
        }
        if (th instanceof zzcof) {
            return th.getMessage() == null ? zza(((zzcof) th).zzapr(), null, null) : zza(((zzcof) th).zzapr(), th.getMessage(), null);
        }
        if (!(th instanceof zzbab)) {
            return zza(zzdpg.INTERNAL_ERROR, null, null);
        }
        zzbab zzbabVar = (zzbab) th;
        return new zzva(zzbabVar.getErrorCode(), zzdwf.zzhi(zzbabVar.getMessage()), MobileAds.ERROR_DOMAIN, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzva zza(com.google.android.gms.internal.ads.zzdpg r6, java.lang.String r7, com.google.android.gms.internal.ads.zzva r8) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpe.zza(com.google.android.gms.internal.ads.zzdpg, java.lang.String, com.google.android.gms.internal.ads.zzva):com.google.android.gms.internal.ads.zzva");
    }

    public static zzva zza(Throwable th, zzctd zzctdVar) {
        zzva zzvaVar;
        zzva zzvaVarZzh = zzh(th);
        int i = zzvaVarZzh.errorCode;
        if ((i == 3 || i == 0) && (zzvaVar = zzvaVarZzh.zzcgy) != null && !zzvaVar.zzcgx.equals(MobileAds.ERROR_DOMAIN)) {
            zzvaVarZzh.zzcgy = null;
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyp)).booleanValue() && zzctdVar != null) {
            zzvaVarZzh.zzcgz = zzctdVar.zzaqi();
        }
        return zzvaVarZzh;
    }
}
