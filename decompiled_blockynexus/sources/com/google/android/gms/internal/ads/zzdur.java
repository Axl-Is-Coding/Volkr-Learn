package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdur {
    private final SharedPreferences zzcln;
    private final File zzhnw;

    @VisibleForTesting
    private final File zzhnx;
    private final zzgo zzvy;

    public zzdur(Context context, zzgo zzgoVar) {
        this.zzcln = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzduu.zza(dir, false);
        this.zzhnw = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzduu.zza(dir2, true);
        this.zzhnx = dir2;
        this.zzvy = zzgoVar;
    }

    private final File zzaws() {
        File file = new File(this.zzhnw, Integer.toString(this.zzvy.zzv()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zzawt() {
        int iZzv = this.zzvy.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(iZzv);
        return sb.toString();
    }

    private final String zzawu() {
        int iZzv = this.zzvy.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(iZzv);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzgr zzei(int r6) {
        /*
            r5 = this;
            int r0 = com.google.android.gms.internal.ads.zzduz.zzhof
            r1 = 0
            if (r6 != r0) goto L10
            android.content.SharedPreferences r6 = r5.zzcln
            java.lang.String r0 = r5.zzawu()
            java.lang.String r6 = r6.getString(r0, r1)
            goto L20
        L10:
            int r0 = com.google.android.gms.internal.ads.zzduz.zzhog
            if (r6 != r0) goto L1f
            android.content.SharedPreferences r6 = r5.zzcln
            java.lang.String r0 = r5.zzawt()
            java.lang.String r6 = r6.getString(r0, r1)
            goto L20
        L1f:
            r6 = r1
        L20:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L27
            return r1
        L27:
            byte[] r6 = com.google.android.gms.common.util.Hex.stringToBytes(r6)     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            com.google.android.gms.internal.ads.zzeip r6 = com.google.android.gms.internal.ads.zzeip.zzu(r6)     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            com.google.android.gms.internal.ads.zzgr r6 = com.google.android.gms.internal.ads.zzgr.zzl(r6)     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            java.lang.String r0 = r6.zzdg()     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            java.lang.String r2 = "pcam"
            java.io.File r3 = r5.zzaws()     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            java.io.File r2 = com.google.android.gms.internal.ads.zzduu.zza(r0, r2, r3)     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            java.lang.String r3 = "pcbc"
            java.io.File r4 = r5.zzaws()     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            java.io.File r0 = com.google.android.gms.internal.ads.zzduu.zza(r0, r3, r4)     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            boolean r2 = r2.exists()     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            if (r2 == 0) goto L59
            boolean r0 = r0.exists()     // Catch: com.google.android.gms.internal.ads.zzekj -> L5d
            if (r0 == 0) goto L59
            r0 = 1
            goto L5a
        L59:
            r0 = 0
        L5a:
            if (r0 == 0) goto L5d
            return r6
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdur.zzei(int):com.google.android.gms.internal.ads.zzgr");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.internal.ads.zzgq r9, com.google.android.gms.internal.ads.zzdux r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdur.zza(com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzdux):boolean");
    }

    public final zzdus zzp(int i) {
        zzgr zzgrVarZzei = zzei(i);
        if (zzgrVarZzei == null) {
            return null;
        }
        String strZzdg = zzgrVarZzei.zzdg();
        return new zzdus(zzgrVarZzei, zzduu.zza(strZzdg, "pcam", zzaws()), zzduu.zza(strZzdg, "pcbc", zzaws()), zzduu.zza(strZzdg, "pcopt", zzaws()));
    }

    @VisibleForTesting
    private static String zza(zzgr zzgrVar) {
        return Hex.bytesToStringLowercase(zzgrVar.zzbdw().toByteArray());
    }
}
