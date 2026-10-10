package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhw implements zzdgu<JSONObject> {
    private String zzgyz;

    public zzdhw(String str) {
        this.zzgyz = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectZzb = zzbao.zzb(jSONObject, "pii");
            if (TextUtils.isEmpty(this.zzgyz)) {
                return;
            }
            jSONObjectZzb.put("attok", this.zzgyz);
        } catch (JSONException e2) {
            zzayp.zza("Failed putting attestation token.", e2);
        }
    }
}
