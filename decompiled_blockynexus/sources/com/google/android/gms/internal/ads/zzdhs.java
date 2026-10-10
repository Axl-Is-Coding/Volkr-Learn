package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhs implements zzdgu<JSONObject> {
    private final JSONObject zzgyv;

    public zzdhs(JSONObject jSONObject) {
        this.zzgyv = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectZzb = zzbao.zzb(jSONObject, "content_info");
            JSONObject jSONObject2 = this.zzgyv;
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectZzb.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            zzayp.zzei("Failed putting app indexing json.");
        }
    }
}
