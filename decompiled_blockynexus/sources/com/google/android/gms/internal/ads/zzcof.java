package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzcof extends Exception {
    private final zzdpg zzgiy;

    public zzcof(zzdpg zzdpgVar) {
        this.zzgiy = zzdpgVar;
    }

    public final zzdpg zzapr() {
        return this.zzgiy;
    }

    public zzcof(zzdpg zzdpgVar, String str) {
        super(str);
        this.zzgiy = zzdpgVar;
    }

    public zzcof(zzdpg zzdpgVar, String str, Throwable th) {
        super(str, th);
        this.zzgiy = zzdpgVar;
    }
}
