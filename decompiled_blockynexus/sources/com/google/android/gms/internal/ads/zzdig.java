package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdig implements zzdgx<zzdgu<JSONObject>> {
    private final JSONObject zzgzf;

    zzdig(Context context) {
        this.zzgzf = zzato.zzz(context);
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<JSONObject>> zzarj() {
        return zzdyq.zzaf(new zzdgu(this) { // from class: com.google.android.gms.internal.ads.zzdij
            private final zzdig zzgzg;

            {
                this.zzgzg = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Object obj) {
                this.zzgzg.zzq((JSONObject) obj);
            }
        });
    }

    final /* synthetic */ void zzq(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzgzf);
        } catch (JSONException unused) {
            zzayp.zzei("Failed putting version constants.");
        }
    }
}
