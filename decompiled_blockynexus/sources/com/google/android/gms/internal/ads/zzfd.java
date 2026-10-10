package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfd extends zzcu<Integer, Long> {
    public Long zzzp;
    public Long zzzq;
    public Long zzzr;
    public Long zzzs;
    public Long zzzt;
    public Long zzzu;
    public Long zzzv;
    public Long zzzw;
    public Long zzzx;
    public Long zzzy;
    public Long zzzz;

    public zzfd() {
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzan(String str) {
        HashMap mapZzao = zzcu.zzao(str);
        if (mapZzao != null) {
            this.zzzp = (Long) mapZzao.get(0);
            this.zzzq = (Long) mapZzao.get(1);
            this.zzzr = (Long) mapZzao.get(2);
            this.zzzs = (Long) mapZzao.get(3);
            this.zzzt = (Long) mapZzao.get(4);
            this.zzzu = (Long) mapZzao.get(5);
            this.zzzv = (Long) mapZzao.get(6);
            this.zzzw = (Long) mapZzao.get(7);
            this.zzzx = (Long) mapZzao.get(8);
            this.zzzy = (Long) mapZzao.get(9);
            this.zzzz = (Long) mapZzao.get(10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.zzzp);
        map.put(1, this.zzzq);
        map.put(2, this.zzzr);
        map.put(3, this.zzzs);
        map.put(4, this.zzzt);
        map.put(5, this.zzzu);
        map.put(6, this.zzzv);
        map.put(7, this.zzzw);
        map.put(8, this.zzzx);
        map.put(9, this.zzzy);
        map.put(10, this.zzzz);
        return map;
    }

    public zzfd(String str) {
        zzan(str);
    }
}
