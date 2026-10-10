package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcel extends zzcem {
    private final boolean zzdkw;
    private final boolean zzdkx;
    private final boolean zzdtm;
    private final JSONObject zzgaf;
    private final boolean zzgag;

    public zzcel(zzdnv zzdnvVar, JSONObject jSONObject) {
        super(zzdnvVar);
        boolean z = false;
        this.zzgaf = zzbao.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzdkx = zzbao.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdkw = zzbao.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdtm = zzbao.zza(false, jSONObject, "enable_omid");
        if (jSONObject != null && jSONObject.optJSONObject("overlay") != null) {
            z = true;
        }
        this.zzgag = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final boolean zzalw() {
        return this.zzdtm;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final JSONObject zzaml() {
        JSONObject jSONObject = this.zzgaf;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzgah.zzdsv);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final boolean zzamm() {
        return this.zzgag;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final boolean zzamn() {
        return this.zzdkx;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final boolean zzamo() {
        return this.zzdkw;
    }
}
