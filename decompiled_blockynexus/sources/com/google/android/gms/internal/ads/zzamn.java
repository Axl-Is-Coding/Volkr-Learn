package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamn<I, O> implements zzdya<I, O> {
    private final zzalv<O> zzdiw;
    private final zzaly<I> zzdix;
    private final String zzdiy;
    private final zzdzc<zzalp> zzdjc;

    zzamn(zzdzc<zzalp> zzdzcVar, String str, zzaly<I> zzalyVar, zzalv<O> zzalvVar) {
        this.zzdjc = zzdzcVar;
        this.zzdiy = str;
        this.zzdix = zzalyVar;
        this.zzdiw = zzalvVar;
    }

    final /* synthetic */ zzdzc zza(Object obj, zzalp zzalpVar) throws Exception {
        zzbcg zzbcgVar = new zzbcg();
        com.google.android.gms.ads.internal.zzp.zzkr();
        String strZzxs = zzayu.zzxs();
        zzagx.zzdfg.zza(strZzxs, new zzamp(this, zzbcgVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", strZzxs);
        jSONObject.put("args", this.zzdix.zzj(obj));
        zzalpVar.zzb(this.zzdiy, jSONObject);
        return zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final zzdzc<O> zzf(final I i) throws Exception {
        return zzdyq.zzb(this.zzdjc, new zzdya(this, i) { // from class: com.google.android.gms.internal.ads.zzamq
            private final zzamn zzdje;
            private final Object zzdjf;

            {
                this.zzdje = this;
                this.zzdjf = i;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzdje.zza(this.zzdjf, (zzalp) obj);
            }
        }, zzbbz.zzeeu);
    }
}
