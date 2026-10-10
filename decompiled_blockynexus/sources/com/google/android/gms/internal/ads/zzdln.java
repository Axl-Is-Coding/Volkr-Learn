package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdln<RequestComponentT extends zzbtn<AdT>, AdT> implements zzdlv<RequestComponentT, AdT> {
    private RequestComponentT zzhbn;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzdlv
    /* JADX INFO: renamed from: zzasw, reason: merged with bridge method [inline-methods] */
    public final synchronized RequestComponentT zzasv() {
        return this.zzhbn;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final synchronized zzdzc<AdT> zza(zzdlw zzdlwVar, zzdlx<RequestComponentT> zzdlxVar) {
        this.zzhbn = zzdlxVar.zzc(zzdlwVar.zzhcf).zzaey();
        return this.zzhbn.zzaev().zzajh();
    }
}
