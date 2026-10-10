package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdn implements zzeoy<JSONObject> {
    private final zzcdl zzfyp;

    public zzcdn(zzcdl zzcdlVar) {
        this.zzfyp = zzcdlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        JSONObject jSONObjectZzals = this.zzfyp.zzals();
        zzepe.zza(jSONObjectZzals, "Cannot return null from a non-@Nullable @Provides method");
        return jSONObjectZzals;
    }
}
