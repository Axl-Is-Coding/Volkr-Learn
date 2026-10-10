package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhi implements zzdgu<JSONObject> {
    private final AdvertisingIdClient.Info zzgyp;
    private final String zzgyq;

    public zzdhi(AdvertisingIdClient.Info info, String str) {
        this.zzgyp = info;
        this.zzgyq = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectZzb = zzbao.zzb(jSONObject, "pii");
            if (this.zzgyp == null || TextUtils.isEmpty(this.zzgyp.getId())) {
                jSONObjectZzb.put("pdid", this.zzgyq);
                jSONObjectZzb.put("pdidtype", "ssaid");
            } else {
                jSONObjectZzb.put("rdid", this.zzgyp.getId());
                jSONObjectZzb.put("is_lat", this.zzgyp.isLimitAdTrackingEnabled());
                jSONObjectZzb.put("idtype", "adid");
            }
        } catch (JSONException e2) {
            zzayp.zza("Failed putting Ad ID.", e2);
        }
    }
}
