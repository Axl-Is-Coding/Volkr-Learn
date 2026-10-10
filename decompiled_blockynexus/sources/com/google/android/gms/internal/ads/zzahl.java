package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzahl implements zzahq<zzbgj> {
    zzahl() {
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        zzbgj zzbgjVar2 = zzbgjVar;
        if (map.keySet().contains("start")) {
            zzbgjVar2.zzabw().zzabj();
        } else if (map.keySet().contains("stop")) {
            zzbgjVar2.zzabw().zzabk();
        } else if (map.keySet().contains("cancel")) {
            zzbgjVar2.zzabw().zzabl();
        }
    }
}
