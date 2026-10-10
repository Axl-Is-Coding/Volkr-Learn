package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcro implements zzdrp<zzcrn, zzcrq> {
    private final String zzdrm;
    private final zzatt zzglb;
    private final String zzglr;
    private final int zzgls;
    private final Context zzvr;

    public zzcro(Context context, String str, zzatt zzattVar, String str2, int i) {
        this.zzvr = context;
        this.zzglr = str;
        this.zzglb = zzattVar;
        this.zzdrm = str2;
        this.zzgls = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x024f, code lost:
    
        r2 = new java.lang.StringBuilder(46);
        r2.append("Received error HTTP response code: ");
        r2.append(r11);
        com.google.android.gms.internal.ads.zzbbq.zzfe(r2.toString());
        r4 = com.google.android.gms.internal.ads.zzdpg.INTERNAL_ERROR;
        r5 = new java.lang.StringBuilder(46);
        r5.append("Received error HTTP response code: ");
        r5.append(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0279, code lost:
    
        throw new com.google.android.gms.internal.ads.zzcof(r4, r5.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzcrq zza(java.lang.String r22, com.google.android.gms.internal.ads.zzati r23, org.json.JSONObject r24, java.lang.String r25) throws com.google.android.gms.internal.ads.zzcof {
        /*
            Method dump skipped, instruction units count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcro.zza(java.lang.String, com.google.android.gms.internal.ads.zzati, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzcrq");
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final /* synthetic */ zzcrq apply(zzcrn zzcrnVar) throws Exception {
        zzcrn zzcrnVar2 = zzcrnVar;
        return zza(zzcrnVar2.zzgll.getUrl(), zzcrnVar2.zzgll, zzcrnVar2.zzglk, this.zzdrm);
    }
}
