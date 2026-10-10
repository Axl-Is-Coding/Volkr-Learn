package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbni implements zzeoy<JSONObject> {
    private final zzeph<zzdnv> zzfou;

    private zzbni(zzeph<zzdnv> zzephVar) {
        this.zzfou = zzephVar;
    }

    public static zzbni zzc(zzeph<zzdnv> zzephVar) {
        return new zzbni(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzbnf.zzb(this.zzfou.get());
    }
}
