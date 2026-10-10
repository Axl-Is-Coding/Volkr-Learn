package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzahm implements zzahq<zzbgj> {
    zzahm() {
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        zzbgj zzbgjVar2 = zzbgjVar;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbgjVar2.zzkn();
        } else if ("resume".equals(str)) {
            zzbgjVar2.zzko();
        }
    }
}
