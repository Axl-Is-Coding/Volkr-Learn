package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzey extends zzcu<Integer, Long> {
    public Long zzzi;
    public Long zzzj;

    public zzey() {
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void zzan(String str) {
        HashMap mapZzao = zzcu.zzao(str);
        if (mapZzao != null) {
            this.zzzi = (Long) mapZzao.get(0);
            this.zzzj = (Long) mapZzao.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.zzzi);
        map.put(1, this.zzzj);
        return map;
    }

    public zzey(String str) {
        zzan(str);
    }
}
