package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamg<I, O> implements zzalt<I, O> {
    private final zzakr zzdis;
    private final zzalv<O> zzdiw;
    private final zzaly<I> zzdix;
    private final String zzdiy;

    zzamg(zzakr zzakrVar, String str, zzaly<I> zzalyVar, zzalv<O> zzalvVar) {
        this.zzdis = zzakrVar;
        this.zzdiy = str;
        this.zzdix = zzalyVar;
        this.zzdiw = zzalvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzali zzaliVar, zzalp zzalpVar, I i, zzbcg<O> zzbcgVar) {
        try {
            com.google.android.gms.ads.internal.zzp.zzkr();
            String strZzxs = zzayu.zzxs();
            zzagx.zzdfg.zza(strZzxs, new zzamh(this, zzaliVar, zzbcgVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", strZzxs);
            jSONObject.put("args", this.zzdix.zzj(i));
            zzalpVar.zzb(this.zzdiy, jSONObject);
        } catch (Exception e2) {
            try {
                zzbcgVar.setException(e2);
                zzbbq.zzc("Unable to invokeJavascript", e2);
            } finally {
                zzaliVar.release();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final zzdzc<O> zzf(I i) throws Exception {
        return zzi(i);
    }

    @Override // com.google.android.gms.internal.ads.zzalt
    public final zzdzc<O> zzi(I i) {
        zzbcg zzbcgVar = new zzbcg();
        zzali zzaliVarZzb = this.zzdis.zzb((zzeg) null);
        zzaliVarZzb.zza(new zzamf(this, zzaliVarZzb, i, zzbcgVar), new zzami(this, zzbcgVar, zzaliVarZzb));
        return zzbcgVar;
    }
}
