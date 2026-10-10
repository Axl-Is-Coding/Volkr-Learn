package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblz implements zzbma {
    private zzayr zzdzr;

    public zzblz(zzayr zzayrVar) {
        this.zzdzr = zzayrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbma
    public final void zzl(Map<String, String> map) {
        this.zzdzr.zzao(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
