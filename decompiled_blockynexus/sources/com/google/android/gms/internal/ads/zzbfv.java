package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfv extends zzbfl {
    public zzbfv(zzbdu zzbduVar) {
        super(zzbduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzfn(String str) {
        zzbdu zzbduVar = this.zzels.get();
        if (zzbduVar != null) {
            zzbduVar.zza(zzfo(str), this);
        }
        zzbbq.zzfe("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfo(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
