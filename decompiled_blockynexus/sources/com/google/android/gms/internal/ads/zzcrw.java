package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcrw {
    private final zzcru zzglw;
    private final zzdzb zzglx;

    public zzcrw(zzcru zzcruVar, zzdzb zzdzbVar) {
        this.zzglw = zzcruVar;
        this.zzglx = zzdzbVar;
    }

    public final void zza(zzdrp<SQLiteDatabase, Void> zzdrpVar) {
        zzdzb zzdzbVar = this.zzglx;
        zzcru zzcruVar = this.zzglw;
        zzcruVar.getClass();
        zzdyq.zza(zzdzbVar.submit(zzcrv.zza(zzcruVar)), new zzcry(this, zzdrpVar), this.zzglx);
    }
}
