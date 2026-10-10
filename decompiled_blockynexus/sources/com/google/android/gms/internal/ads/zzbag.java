package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbag {
    private static zzae zzecm;
    private static final Object zzecn = new Object();

    @Deprecated
    private static final zzbak<Void> zzeco = new zzbaj();

    public zzbag(Context context) {
        zzbl(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzae zzbl(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbag.zzecn
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzae r1 = com.google.android.gms.internal.ads.zzbag.zzecm     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L32
            com.google.android.gms.internal.ads.zzabb.initialize(r3)     // Catch: java.lang.Throwable -> L36
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L24
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabb.zzctg     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzaax r2 = com.google.android.gms.internal.ads.zzwm.zzpx()     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L36
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L24
            r1 = 1
            goto L25
        L24:
            r1 = 0
        L25:
            if (r1 == 0) goto L2c
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzazz.zzbk(r3)     // Catch: java.lang.Throwable -> L36
            goto L30
        L2c:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzbk.zza(r3)     // Catch: java.lang.Throwable -> L36
        L30:
            com.google.android.gms.internal.ads.zzbag.zzecm = r3     // Catch: java.lang.Throwable -> L36
        L32:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzbag.zzecm     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            return r3
        L36:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbag.zzbl(android.content.Context):com.google.android.gms.internal.ads.zzae");
    }

    public static zzdzc<zzy> zzev(String str) {
        zzbcg zzbcgVar = new zzbcg();
        zzecm.zze(new zzbam(str, zzbcgVar));
        return zzbcgVar;
    }

    public final zzdzc<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        zzban zzbanVar = new zzban(null);
        zzbai zzbaiVar = new zzbai(this, str, zzbanVar);
        zzbbk zzbbkVar = new zzbbk(null);
        zzbal zzbalVar = new zzbal(this, i, str, zzbanVar, zzbaiVar, bArr, map, zzbbkVar);
        if (zzbbk.isEnabled()) {
            try {
                zzbbkVar.zza(str, "GET", zzbalVar.getHeaders(), zzbalVar.zzg());
            } catch (zzl e2) {
                zzbbq.zzfe(e2.getMessage());
            }
        }
        zzecm.zze(zzbalVar);
        return zzbanVar;
    }

    public final zzdzc<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
