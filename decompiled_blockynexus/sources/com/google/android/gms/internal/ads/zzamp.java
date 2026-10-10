package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzamp implements zzahy {
    private final zzbcg<O> zzdja;
    private final /* synthetic */ zzamn zzdjd;

    public zzamp(zzamn zzamnVar, zzbcg<O> zzbcgVar) {
        this.zzdjd = zzamnVar;
        this.zzdja = zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void onFailure(String str) {
        try {
            if (str == null) {
                this.zzdja.setException(new zzalu());
            } else {
                this.zzdja.setException(new zzalu(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.ads.zzahy
    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdja.set((O) this.zzdjd.zzdiw.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e2) {
            this.zzdja.setException(e2);
        }
    }
}
