package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbom extends zzsf {
    private final zzxc zzbut;
    private final zzbnv zzfpx;

    public zzbom(zzbnv zzbnvVar, zzxc zzxcVar) {
        this.zzfpx = zzbnvVar;
        this.zzbut = zzxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(IObjectWrapper iObjectWrapper, zzsq zzsqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsm zzsmVar) {
        this.zzfpx.zza(zzsmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzxc zzdw() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzyn zzki() {
        return null;
    }
}
