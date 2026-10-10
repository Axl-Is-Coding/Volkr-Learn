package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmb implements zzbma {
    private zzayr zzdzr;

    public zzbmb(zzayr zzayrVar) {
        this.zzdzr = zzayrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbma
    public final void zzl(Map<String, String> map) {
        this.zzdzr.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
