package com.google.android.gms.internal.ads;

import android.location.Location;
import com.umeng.analytics.pro.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdiq implements zzdgu<JSONObject> {
    private final Location zznb;

    public zzdiq(Location location) {
        this.zznb = location;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (this.zznb != null) {
                JSONObject jSONObject3 = new JSONObject();
                Float fValueOf = Float.valueOf(this.zznb.getAccuracy() * 1000.0f);
                Long lValueOf = Long.valueOf(this.zznb.getTime() * 1000);
                Long lValueOf2 = Long.valueOf((long) (this.zznb.getLatitude() * 1.0E7d));
                Long lValueOf3 = Long.valueOf((long) (this.zznb.getLongitude() * 1.0E7d));
                jSONObject3.put("radius", fValueOf);
                jSONObject3.put(b.B, lValueOf2);
                jSONObject3.put("long", lValueOf3);
                jSONObject3.put("time", lValueOf);
                jSONObject2.put("uule", jSONObject3);
            }
        } catch (JSONException e2) {
            zzayp.zza("Failed adding location to the request JSON.", e2);
        }
    }
}
