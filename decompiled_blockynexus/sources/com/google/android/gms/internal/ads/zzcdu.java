package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdu implements zzeoy<zzqo> {
    private final zzeph<zzbbx> zzfov;
    private final zzeph<String> zzfow;

    public zzcdu(zzeph<zzbbx> zzephVar, zzeph<String> zzephVar2) {
        this.zzfov = zzephVar;
        this.zzfow = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbbx zzbbxVar = this.zzfov.get();
        String str = this.zzfow.get();
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzqo zzqoVar = new zzqo(zzayu.zzxs(), zzbbxVar, str, new JSONObject(), false, true);
        zzepe.zza(zzqoVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzqoVar;
    }
}
