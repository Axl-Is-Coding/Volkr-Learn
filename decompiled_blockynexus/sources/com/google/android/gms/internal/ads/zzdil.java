package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdil implements zzdgu<JSONObject> {
    private String zzgzi;
    private String zzgzj;

    public zzdil(String str, String str2) {
        this.zzgzi = str;
        this.zzgzj = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectZzb = zzbao.zzb(jSONObject, "pii");
            jSONObjectZzb.put("doritos", this.zzgzi);
            jSONObjectZzb.put("doritos_v2", this.zzgzj);
        } catch (JSONException unused) {
            zzayp.zzei("Failed putting doritos string.");
        }
    }
}
