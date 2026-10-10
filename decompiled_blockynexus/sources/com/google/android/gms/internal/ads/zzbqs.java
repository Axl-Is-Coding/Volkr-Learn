package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqs<AdT> implements zzbqp<AdT> {
    private final Map<String, zzcta<AdT>> zzfrw;

    zzbqs(Map<String, zzcta<AdT>> map) {
        this.zzfrw = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbqp
    public final zzcta<AdT> zze(int i, String str) {
        return this.zzfrw.get(str);
    }
}
