package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbna implements zzeoy<zzqo> {
    private final zzeph<JSONObject> zzffa;
    private final zzeph<zzdnv> zzfou;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<String> zzfow;

    private zzbna(zzeph<zzdnv> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<JSONObject> zzephVar3, zzeph<String> zzephVar4) {
        this.zzfou = zzephVar;
        this.zzfov = zzephVar2;
        this.zzffa = zzephVar3;
        this.zzfow = zzephVar4;
    }

    public static zzbna zza(zzeph<zzdnv> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<JSONObject> zzephVar3, zzeph<String> zzephVar4) {
        return new zzbna(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        this.zzfou.get();
        zzbbx zzbbxVar = this.zzfov.get();
        JSONObject jSONObject = this.zzffa.get();
        String str = this.zzfow.get();
        boolean zEquals = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str);
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzqo zzqoVar = new zzqo(zzayu.zzxs(), zzbbxVar, str, jSONObject, false, zEquals);
        zzepe.zza(zzqoVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzqoVar;
    }
}
