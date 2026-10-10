package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblx implements zzdya<zzdog, zzdog> {
    private Map<String, zzbma> zzfms;

    public zzblx(Map<String, zzbma> map) {
        this.zzfms = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final /* synthetic */ zzdzc<zzdog> zzf(zzdog zzdogVar) throws Exception {
        zzdog zzdogVar2 = zzdogVar;
        for (zzdoh zzdohVar : zzdogVar2.zzhew.zzheu) {
            if (this.zzfms.containsKey(zzdohVar.name)) {
                this.zzfms.get(zzdohVar.name).zzl(zzdohVar.zzhex);
            }
        }
        return zzdyq.zzaf(zzdogVar2);
    }
}
