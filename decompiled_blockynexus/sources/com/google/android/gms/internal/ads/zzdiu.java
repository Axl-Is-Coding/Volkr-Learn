package com.google.android.gms.internal.ads;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdiu implements zzdgu<JSONObject> {
    private Bundle zzgzm;

    public zzdiu(Bundle bundle) {
        this.zzgzm = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.zzgzm != null) {
            try {
                zzbao.zzb(zzbao.zzb(jSONObject2, "device"), "play_store").put("parental_controls", com.google.android.gms.ads.internal.zzp.zzkr().zzd(this.zzgzm));
            } catch (JSONException unused) {
                zzayp.zzei("Failed putting parental controls bundle.");
            }
        }
    }
}
