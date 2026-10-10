package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchg {
    private final Executor executor;
    private final zzcgw zzgda;

    public zzchg(Executor executor, zzcgw zzcgwVar) {
        this.executor = executor;
        this.zzgda = zzcgwVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzdzc<java.util.List<com.google.android.gms.internal.ads.zzchh>> zzg(org.json.JSONObject r10, java.lang.String r11) {
        /*
            r9 = this;
            org.json.JSONArray r10 = r10.optJSONArray(r11)
            if (r10 != 0) goto Lf
            java.util.List r10 = java.util.Collections.emptyList()
            com.google.android.gms.internal.ads.zzdzc r10 = com.google.android.gms.internal.ads.zzdyq.zzaf(r10)
            return r10
        Lf:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            int r0 = r10.length()
            r1 = 0
            r2 = 0
        L1a:
            if (r2 >= r0) goto L7b
            org.json.JSONObject r3 = r10.optJSONObject(r2)
            if (r3 == 0) goto L70
            java.lang.String r4 = "name"
            java.lang.String r4 = r3.optString(r4)
            if (r4 == 0) goto L70
            java.lang.String r5 = "type"
            java.lang.String r5 = r3.optString(r5)
            java.lang.String r6 = "string"
            boolean r6 = r6.equals(r5)
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L3c
            r5 = 1
            goto L47
        L3c:
            java.lang.String r6 = "image"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L46
            r5 = 2
            goto L47
        L46:
            r5 = 0
        L47:
            if (r5 == r8) goto L60
            if (r5 == r7) goto L4c
            goto L70
        L4c:
            com.google.android.gms.internal.ads.zzcgw r5 = r9.zzgda
            java.lang.String r6 = "image_value"
            com.google.android.gms.internal.ads.zzdzc r3 = r5.zzc(r3, r6)
            com.google.android.gms.internal.ads.zzchi r5 = new com.google.android.gms.internal.ads.zzchi
            r5.<init>(r4)
            java.util.concurrent.Executor r4 = r9.executor
            com.google.android.gms.internal.ads.zzdzc r3 = com.google.android.gms.internal.ads.zzdyq.zzb(r3, r5, r4)
            goto L75
        L60:
            com.google.android.gms.internal.ads.zzchh r5 = new com.google.android.gms.internal.ads.zzchh
            java.lang.String r6 = "string_value"
            java.lang.String r3 = r3.optString(r6)
            r5.<init>(r4, r3)
            com.google.android.gms.internal.ads.zzdzc r3 = com.google.android.gms.internal.ads.zzdyq.zzaf(r5)
            goto L75
        L70:
            r3 = 0
            com.google.android.gms.internal.ads.zzdzc r3 = com.google.android.gms.internal.ads.zzdyq.zzaf(r3)
        L75:
            r11.add(r3)
            int r2 = r2 + 1
            goto L1a
        L7b:
            com.google.android.gms.internal.ads.zzdzc r10 = com.google.android.gms.internal.ads.zzdyq.zzi(r11)
            com.google.android.gms.internal.ads.zzdvu r11 = com.google.android.gms.internal.ads.zzchf.zzdwz
            java.util.concurrent.Executor r0 = r9.executor
            com.google.android.gms.internal.ads.zzdzc r10 = com.google.android.gms.internal.ads.zzdyq.zzb(r10, r11, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchg.zzg(org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzdzc");
    }
}
