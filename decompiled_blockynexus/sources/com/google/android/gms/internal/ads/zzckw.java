package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzckw {
    private final Executor executor;
    private final Map<String, Map<String, JSONObject>> zzggb = new ConcurrentHashMap();
    private JSONObject zzggc;
    private boolean zzxi;

    public zzckw(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaoi, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void zzaol() {
        Map<String, JSONObject> map;
        this.zzxi = true;
        zzaxy zzaxyVarZzxk = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxk();
        if (zzaxyVarZzxk == null) {
            return;
        }
        JSONObject jSONObjectZzwj = zzaxyVarZzxk.zzwj();
        if (jSONObjectZzwj == null) {
            return;
        }
        this.zzggc = jSONObjectZzwj.optJSONObject("ad_unit_patterns");
        JSONArray jSONArrayOptJSONArray = jSONObjectZzwj.optJSONArray("ad_unit_id_settings");
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("ad_unit_id");
                String strOptString2 = jSONObjectOptJSONObject.optString("format");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("request_signals");
                if (strOptString != null && jSONObjectOptJSONObject2 != null && strOptString2 != null) {
                    if (this.zzggb.containsKey(strOptString2)) {
                        map = this.zzggb.get(strOptString2);
                    } else {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        this.zzggb.put(strOptString2, concurrentHashMap);
                        map = concurrentHashMap;
                    }
                    map.put(strOptString, jSONObjectOptJSONObject2);
                }
            }
        }
    }

    public final void zzaoh() {
        com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzckv
            private final zzckw zzgga;

            {
                this.zzgga = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgga.zzaok();
            }
        });
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcky
            private final zzckw zzgga;

            {
                this.zzgga = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgga.zzaoj();
            }
        });
    }

    final /* synthetic */ void zzaok() {
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzckx
            private final zzckw zzgga;

            {
                this.zzgga = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgga.zzaol();
            }
        });
    }

    public final JSONObject zzq(String str, String str2) {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcsr)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzxi) {
            zzaol();
        }
        Map<String, JSONObject> map = this.zzggb.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String strZza = zzckz.zza(this.zzggc, str, str2);
        if (strZza == null) {
            return null;
        }
        return map.get(strZza);
    }
}
