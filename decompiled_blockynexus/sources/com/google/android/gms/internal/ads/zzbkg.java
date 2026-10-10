package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkg implements zzdjx {
    private final /* synthetic */ zzbjv zzfbq;
    private Context zzfib;
    private String zzfic;

    private zzbkg(zzbjv zzbjvVar) {
        this.zzfbq = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjx
    public final zzdju zzafu() {
        zzepe.zza(this.zzfib, (Class<Context>) Context.class);
        zzepe.zza(this.zzfic, (Class<String>) String.class);
        return new zzbkj(this.zzfbq, this.zzfib, this.zzfic);
    }

    @Override // com.google.android.gms.internal.ads.zzdjx
    public final /* synthetic */ zzdjx zzby(Context context) {
        zzepe.checkNotNull(context);
        this.zzfib = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjx
    public final /* synthetic */ zzdjx zzfv(String str) {
        zzepe.checkNotNull(str);
        this.zzfic = str;
        return this;
    }
}
