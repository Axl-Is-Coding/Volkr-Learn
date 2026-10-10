package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatv implements zzatg {
    private zzalt<JSONObject, JSONObject> zzdvo;
    private zzalt<JSONObject, JSONObject> zzdvt;

    public zzatv(Context context) {
        zzamb zzambVarZza = com.google.android.gms.ads.internal.zzp.zzle().zza(context, zzbbx.zzyv());
        zzalx<JSONObject> zzalxVar = zzama.zzdio;
        this.zzdvt = zzambVarZza.zza("google.afma.request.getAdDictionary", zzalxVar, zzalxVar);
        zzamb zzambVarZza2 = com.google.android.gms.ads.internal.zzp.zzle().zza(context, zzbbx.zzyv());
        zzalx<JSONObject> zzalxVar2 = zzama.zzdio;
        this.zzdvo = zzambVarZza2.zza("google.afma.sdkConstants.getSdkConstants", zzalxVar2, zzalxVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzatg
    public final zzalt<JSONObject, JSONObject> zzvg() {
        return this.zzdvo;
    }
}
