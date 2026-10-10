package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztu;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzclz implements zzeoy<zzcmg> {
    public static zzclz zzaov() {
        return zzcmc.zzggr;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcmg zzcmgVar = new zzcmg(zztu.zza.zzb.REQUEST_WILL_PROCESS_RESPONSE, zztu.zza.zzb.REQUEST_DID_PROCESS_RESPONSE, zztu.zza.zzb.REQUEST_FAILED_TO_PROCESS_RESPONSE);
        zzepe.zza(zzcmgVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcmgVar;
    }
}
