package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdip implements zzdgu<JSONObject> {
    private List<String> zzdrc;

    public zzdip(List<String> list) {
        this.zzdrc = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.zzdrc));
        } catch (JSONException unused) {
            zzayp.zzei("Failed putting experiment ids.");
        }
    }
}
