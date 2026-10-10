package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdji implements zzdgu<JSONObject> {
    private final Map<String, Object> zzgzr;

    public zzdji(Map<String, Object> map) {
        this.zzgzr = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", com.google.android.gms.ads.internal.zzp.zzkr().zzj(this.zzgzr));
        } catch (JSONException e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            zzayp.zzei(strValueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(strValueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
