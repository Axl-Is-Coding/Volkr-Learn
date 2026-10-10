package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmg implements zzbma {
    private final zzayr zzdzr;

    public zzbmg(zzayr zzayrVar) {
        this.zzdzr = zzayrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbma
    public final void zzl(Map<String, String> map) {
        String str = map.get("key");
        String str2 = map.get("value");
        if ("auto_collect_location".equals(str)) {
            this.zzdzr.zzaq(Boolean.parseBoolean(str2));
        }
    }
}
