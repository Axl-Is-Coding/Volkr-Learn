package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcy extends zzcu<Integer, Object> {
    public String zznw;
    public long zznx;
    public String zzny;
    public String zznz;
    public String zzoa;

    public zzcy(String str) {
        this();
        zzan(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzan(String str) {
        HashMap mapZzao = zzcu.zzao(str);
        if (mapZzao != null) {
            this.zznw = mapZzao.get(0) == null ? "E" : (String) mapZzao.get(0);
            this.zznx = mapZzao.get(1) == null ? -1L : ((Long) mapZzao.get(1)).longValue();
            this.zzny = mapZzao.get(2) == null ? "E" : (String) mapZzao.get(2);
            this.zznz = mapZzao.get(3) == null ? "E" : (String) mapZzao.get(3);
            this.zzoa = mapZzao.get(4) != null ? (String) mapZzao.get(4) : "E";
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Object> zzbn() {
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(0, this.zznw);
        map.put(4, this.zzoa);
        map.put(3, this.zznz);
        map.put(2, this.zzny);
        map.put(1, Long.valueOf(this.zznx));
        return map;
    }

    public zzcy() {
        this.zznw = "E";
        this.zznx = -1L;
        this.zzny = "E";
        this.zznz = "E";
        this.zzoa = "E";
    }
}
