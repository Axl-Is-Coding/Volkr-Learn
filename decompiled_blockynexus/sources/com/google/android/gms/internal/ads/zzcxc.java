package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxc implements zzctb<zzdpa, zzcut> {
    private final zzcku zzgij;
    private final Map<String, zzctc<zzdpa, zzcut>> zzgql = new HashMap();

    public zzcxc(zzcku zzckuVar) {
        this.zzgij = zzckuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzctb
    public final zzctc<zzdpa, zzcut> zzf(String str, JSONObject jSONObject) throws zzdos {
        synchronized (this) {
            zzctc<zzdpa, zzcut> zzctcVar = this.zzgql.get(str);
            if (zzctcVar == null) {
                zzdpa zzdpaVarZzd = this.zzgij.zzd(str, jSONObject);
                if (zzdpaVarZzd == null) {
                    return null;
                }
                zzctcVar = new zzctc<>(zzdpaVarZzd, new zzcut(), str);
                this.zzgql.put(str, zzctcVar);
            }
            return zzctcVar;
        }
    }
}
