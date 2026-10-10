package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdic implements zzdgu<JSONObject> {
    private JSONObject zzgzb;

    public zzdic(JSONObject jSONObject) {
        this.zzgzb = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.zzgzb);
        } catch (JSONException unused) {
            zzayp.zzei("Unable to get cache_state");
        }
    }
}
