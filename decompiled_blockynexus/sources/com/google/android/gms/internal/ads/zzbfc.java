package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfc implements zzbft {
    @Override // com.google.android.gms.internal.ads.zzbft
    public final zzbfl zza(zzbdu zzbduVar, int i, String str, zzbdv zzbdvVar) {
        if (i <= 0) {
            return new zzbfs(zzbduVar);
        }
        int iZzaaw = zzber.zzaaw();
        return iZzaaw < zzbdvVar.zzeiw ? new zzbfw(zzbduVar, zzbdvVar) : iZzaaw < zzbdvVar.zzeiq ? new zzbfx(zzbduVar, zzbdvVar) : new zzbfv(zzbduVar);
    }
}
