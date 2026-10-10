package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvm implements zzctb<zzdpa, zzcuu> {
    private final zzcku zzgij;

    public zzcvm(zzcku zzckuVar) {
        this.zzgij = zzckuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzctb
    public final zzctc<zzdpa, zzcuu> zzf(String str, JSONObject jSONObject) throws zzdos {
        zzdpa zzdpaVarZzd = this.zzgij.zzd(str, jSONObject);
        if (zzdpaVarZzd == null) {
            return null;
        }
        return new zzctc<>(zzdpaVarZzd, new zzcuu(), str);
    }
}
