package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgp implements zzdyr<Map<String, String>> {
    private final /* synthetic */ zzbgi zzeni;
    private final /* synthetic */ List zzenl;
    private final /* synthetic */ String zzenm;

    zzbgp(zzbgi zzbgiVar, List list, String str) {
        this.zzeni = zzbgiVar;
        this.zzenl = list;
        this.zzenm = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Map<String, String> map) {
        zzbgi zzbgiVar = this.zzeni;
        List list = this.zzenl;
        zzbgiVar.zza((Map<String, String>) map, (List<zzahq<? super zzbgj>>) list, this.zzenm);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
    }
}
