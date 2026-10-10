package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzato extends zzatq {
    private final Object lock = new Object();
    private final Context zzaai;
    private SharedPreferences zzdvn;
    private final zzalt<JSONObject, JSONObject> zzdvo;

    public zzato(Context context, zzalt<JSONObject, JSONObject> zzaltVar) {
        this.zzaai = context.getApplicationContext();
        this.zzdvo = zzaltVar;
    }

    public static JSONObject zzz(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbbx.zzyv().zzbre);
            jSONObject.put("mf", zzacw.zzdbr.get());
            jSONObject.put("cl", "330794610");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 20360);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzabb.zza(this.zzaai, 1, jSONObject);
        this.zzdvn.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis()).apply();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzatq
    public final zzdzc<Void> zzvo() {
        synchronized (this.lock) {
            if (this.zzdvn == null) {
                this.zzdvn = this.zzaai.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis() - this.zzdvn.getLong("js_last_update", 0L) < zzacw.zzdbs.get().longValue()) {
            return zzdyq.zzaf(null);
        }
        return zzdyq.zzb(this.zzdvo.zzi(zzz(this.zzaai)), new zzdvu(this) { // from class: com.google.android.gms.internal.ads.zzatr
            private final zzato zzdvr;

            {
                this.zzdvr = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return this.zzdvr.zzf((JSONObject) obj);
            }
        }, zzbbz.zzeeu);
    }
}
