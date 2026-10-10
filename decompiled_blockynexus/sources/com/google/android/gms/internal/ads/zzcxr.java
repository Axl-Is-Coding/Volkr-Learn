package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxr implements zzctb<zzaph, zzcuu> {
    private final zzcyy zzgqy;

    public zzcxr(zzcyy zzcyyVar) {
        this.zzgqy = zzcyyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzctb
    public final zzctc<zzaph, zzcuu> zzf(String str, JSONObject jSONObject) throws zzdos {
        zzaph zzaphVarZzgp = this.zzgqy.zzgp(str);
        if (zzaphVarZzgp == null) {
            return null;
        }
        return new zzctc<>(zzaphVarZzgp, new zzcuu(), str);
    }
}
