package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfg extends zzayl {
    final zzbdu zzegh;
    private final String zzegt;
    private final String[] zzegu;
    final zzbfl zzelk;

    zzbfg(zzbdu zzbduVar, zzbfl zzbflVar, String str, String[] strArr) {
        this.zzegh = zzbduVar;
        this.zzelk = zzbflVar;
        this.zzegt = str;
        this.zzegu = strArr;
        com.google.android.gms.ads.internal.zzp.zzln().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzvb() {
        try {
            this.zzelk.zze(this.zzegt, this.zzegu);
        } finally {
            zzayu.zzeba.post(new zzbfj(this));
        }
    }
}
