package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzamh implements zzahy {
    private final /* synthetic */ zzamg zzdiv;
    private final zzali zzdiz;
    private final zzbcg<O> zzdja;

    public zzamh(zzamg zzamgVar, zzali zzaliVar, zzbcg<O> zzbcgVar) {
        this.zzdiv = zzamgVar;
        this.zzdiz = zzaliVar;
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
        } finally {
            this.zzdiz.release();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.ads.zzahy
    public final void zzc(JSONObject jSONObject) {
        try {
            try {
                this.zzdja.set((O) this.zzdiv.zzdiw.zzd(jSONObject));
                this.zzdiz.release();
            } catch (IllegalStateException unused) {
                this.zzdiz.release();
            } catch (JSONException e2) {
                this.zzdja.setException(e2);
                this.zzdiz.release();
            }
        } catch (Throwable th) {
            this.zzdiz.release();
            throw th;
        }
    }
}
