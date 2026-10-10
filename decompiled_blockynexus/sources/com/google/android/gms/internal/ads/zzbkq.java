package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkq implements zzdnm {
    private final /* synthetic */ zzbjv zzfbq;
    private Context zzfib;
    private String zzfic;

    private zzbkq(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdnm
    public final zzdnn zzagi() {
        zzepe.zza(this.zzfib, (Class<Context>) Context.class);
        return new zzbkt(this.zzfbq, this.zzfib, this.zzfic);
    }

    @Override // com.google.android.gms.internal.ads.zzdnm
    public final /* synthetic */ zzdnm zzbz(Context context) {
        zzepe.checkNotNull(context);
        this.zzfib = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdnm
    public final /* synthetic */ zzdnm zzfw(String str) {
        this.zzfic = str;
        return this;
    }
}
