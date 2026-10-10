package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcen implements zzeoy<zzcel> {
    private final zzeph<JSONObject> zzfey;
    private final zzeph<zzdnv> zzfou;

    public zzcen(zzeph<zzdnv> zzephVar, zzeph<JSONObject> zzephVar2) {
        this.zzfou = zzephVar;
        this.zzfey = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcel(this.zzfou.get(), this.zzfey.get());
    }
}
