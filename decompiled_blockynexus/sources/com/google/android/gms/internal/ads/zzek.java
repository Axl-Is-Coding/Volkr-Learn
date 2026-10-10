package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzek extends zzcu<Integer, Long> {
    public long zzyk;
    public long zzyl;

    public zzek() {
        this.zzyk = -1L;
        this.zzyl = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzan(String str) {
        HashMap mapZzao = zzcu.zzao(str);
        if (mapZzao != null) {
            this.zzyk = ((Long) mapZzao.get(0)).longValue();
            this.zzyl = ((Long) mapZzao.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, Long.valueOf(this.zzyk));
        map.put(1, Long.valueOf(this.zzyl));
        return map;
    }

    public zzek(String str) {
        this();
        zzan(str);
    }
}
