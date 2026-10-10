package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkt implements zzdnn {
    private final /* synthetic */ zzbjv zzfbq;
    private zzeph<Context> zzfij;
    private zzeph<String> zzfik;
    private zzeph<zzdlv<zzcjj, zzcjg>> zzfkt;
    private zzeph<zzdmc> zzfku;
    private zzeph<zzdoj> zzfkv;
    private zzeph<zzdnb> zzfkw;
    private zzeph<zzdnp> zzfkx;
    private zzeph<zzdnj> zzfky;

    private zzbkt(zzbjv zzbjvVar, Context context, String str) {
        this.zzfbq = zzbjvVar;
        this.zzfij = zzeox.zzba(context);
        this.zzfkt = new zzdma(this.zzfij, this.zzfbq.zzeuw, this.zzfbq.zzeux);
        this.zzfku = zzeov.zzas(new zzdmz(this.zzfbq.zzeuw));
        this.zzfkv = zzeov.zzas(zzdoi.zzath());
        this.zzfkw = zzeov.zzas(new zzdng(this.zzfij, this.zzfbq.zzesy, this.zzfbq.zzesp, this.zzfkt, this.zzfku, zzdop.zzatq(), this.zzfkv));
        this.zzfkx = zzeov.zzas(new zzdnq(this.zzfkw, this.zzfku, this.zzfkv));
        this.zzfik = zzeox.zzbb(str);
        this.zzfky = zzeov.zzas(new zzdnk(this.zzfik, this.zzfkw, this.zzfij, this.zzfku, this.zzfkv));
    }

    @Override // com.google.android.gms.internal.ads.zzdnn
    public final zzdnp zzagm() {
        return this.zzfkx.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdnn
    public final zzdnj zzagn() {
        return this.zzfky.get();
    }
}
