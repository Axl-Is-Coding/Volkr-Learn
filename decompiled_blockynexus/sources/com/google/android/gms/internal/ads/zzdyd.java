package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxu;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzdyd<V, C> extends zzdxu<V, C> {
    private List<zzdyf<V>> zzhsv;

    zzdyd(zzdwk<? extends zzdzc<? extends V>> zzdwkVar, boolean z) {
        super(zzdwkVar, true, true);
        List<zzdyf<V>> listZzaxo = zzdwkVar.isEmpty() ? zzdwp.zzaxo() : zzdwx.zzep(zzdwkVar.size());
        for (int i = 0; i < zzdwkVar.size(); i++) {
            listZzaxo.add(null);
        }
        this.zzhsv = listZzaxo;
    }

    @Override // com.google.android.gms.internal.ads.zzdxu
    final void zza(zzdxu.zza zzaVar) {
        super.zza(zzaVar);
        this.zzhsv = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxu
    final void zzaxz() {
        List<zzdyf<V>> list = this.zzhsv;
        if (list != null) {
            set(zzk(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxu
    final void zzb(int i, V v) {
        List<zzdyf<V>> list = this.zzhsv;
        if (list != null) {
            list.set(i, new zzdyf<>(v));
        }
    }

    abstract C zzk(List<zzdyf<V>> list);
}
