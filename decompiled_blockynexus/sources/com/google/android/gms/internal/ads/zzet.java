package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzet extends zzcu<Integer, Object> {
    public Long zzyn;
    public Boolean zzyo;
    public Boolean zzyp;

    public zzet() {
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzan(String str) {
        HashMap mapZzao = zzcu.zzao(str);
        if (mapZzao != null) {
            this.zzyn = (Long) mapZzao.get(0);
            this.zzyo = (Boolean) mapZzao.get(1);
            this.zzyp = (Boolean) mapZzao.get(2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Object> zzbn() {
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(0, this.zzyn);
        map.put(1, this.zzyo);
        map.put(2, this.zzyp);
        return map;
    }

    public zzet(String str) {
        zzan(str);
    }
}
