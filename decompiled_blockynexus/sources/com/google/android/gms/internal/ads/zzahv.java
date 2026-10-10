package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzahv implements zzahy {
    private final /* synthetic */ zzbcg zzdfq;

    zzahv(zzahw zzahwVar, zzbcg zzbcgVar) {
        this.zzdfq = zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void onFailure(String str) {
        this.zzdfq.setException(new zzalu(str));
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void zzc(JSONObject jSONObject) {
        this.zzdfq.set(jSONObject);
    }
}
