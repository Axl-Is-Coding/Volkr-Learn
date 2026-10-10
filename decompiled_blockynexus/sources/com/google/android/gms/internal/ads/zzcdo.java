package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdo implements zzeoy<JSONObject> {
    private final zzeph<zzcem> zzfeh;
    private final zzcdl zzfyp;

    public zzcdo(zzcdl zzcdlVar, zzeph<zzcem> zzephVar) {
        this.zzfyp = zzcdlVar;
        this.zzfeh = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return this.zzfeh.get().zzaml();
    }
}
