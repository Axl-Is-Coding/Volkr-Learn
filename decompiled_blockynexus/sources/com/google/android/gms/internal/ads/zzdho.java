package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdho implements zzdgu<JSONObject> {
    private final String zzgyt;

    public zzdho(String str) {
        this.zzgyt = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.zzgyt);
        } catch (JSONException e2) {
            zzayp.zza("Failed putting Ad ID.", e2);
        }
    }
}
