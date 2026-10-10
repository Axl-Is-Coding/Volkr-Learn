package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpw {
    private zzdpv zzhgr = null;
    private zzdpv zzhgs = null;
    private zzdpv zzhgt = null;
    private zzdpv zzhgu = null;
    private zzdpv zzhgv = null;
    private zzdpv zzhgw = null;
    private zzdpv zzhgx = null;
    private zzdpv zzhgy = null;

    public final void onAdClosed() {
        zzdpv zzdpvVar = this.zzhgu;
        if (zzdpvVar != null) {
            zzdpvVar.execute();
        }
    }

    public final void zza(zzdpv zzdpvVar) {
        this.zzhgu = zzdpvVar;
    }
}
