package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzff extends zzcu<Integer, Long> {
    public Long zzaab;
    public Long zzaac;
    public Long zzaad;
    public Long zzaae;

    public zzff() {
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzan(String str) {
        HashMap mapZzao = zzcu.zzao(str);
        if (mapZzao != null) {
            this.zzaab = (Long) mapZzao.get(0);
            this.zzaac = (Long) mapZzao.get(1);
            this.zzaad = (Long) mapZzao.get(2);
            this.zzaae = (Long) mapZzao.get(3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.zzaab);
        map.put(1, this.zzaac);
        map.put(2, this.zzaad);
        map.put(3, this.zzaae);
        return map;
    }

    public zzff(String str) {
        zzan(str);
    }
}
