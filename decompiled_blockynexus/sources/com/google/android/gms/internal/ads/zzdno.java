package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdno implements zzdag<zzcjg> {
    private final /* synthetic */ zzdnp zzhda;

    zzdno(zzdnp zzdnpVar) {
        this.zzhda = zzdnpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final /* synthetic */ void onSuccess(zzcjg zzcjgVar) {
        zzcjg zzcjgVar2 = zzcjgVar;
        synchronized (this.zzhda) {
            this.zzhda.zzhcz = zzcjgVar2;
            this.zzhda.zzhcz.zzaih();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzaqv() {
        synchronized (this.zzhda) {
            this.zzhda.zzhcz = null;
        }
    }
}
