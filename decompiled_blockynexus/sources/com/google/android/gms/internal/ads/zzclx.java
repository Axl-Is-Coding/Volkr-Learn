package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztu;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzclx implements zzeoy<zzcmg> {
    public static zzclx zzaot() {
        return zzcma.zzggo;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcmg zzcmgVar = new zzcmg(zztu.zza.zzb.REQUEST_WILL_MAKE_NETWORK_REQUEST, zztu.zza.zzb.REQUEST_DID_RECEIVE_NETWORK_RESPONSE, zztu.zza.zzb.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST);
        zzepe.zza(zzcmgVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcmgVar;
    }
}
