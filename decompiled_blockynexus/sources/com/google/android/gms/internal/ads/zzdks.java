package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdks implements zzdag<zzboh> {
    private final /* synthetic */ zzdko zzhbb;

    zzdks(zzdko zzdkoVar) {
        this.zzhbb = zzdkoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final /* synthetic */ void onSuccess(zzboh zzbohVar) {
        zzboh zzbohVar2 = zzbohVar;
        synchronized (this.zzhbb) {
            if (this.zzhbb.zzhaz != null) {
                this.zzhbb.zzhaz.destroy();
            }
            this.zzhbb.zzhaz = zzbohVar2;
            this.zzhbb.zza(zzbohVar2);
            this.zzhbb.zzgzu.zzb(new zzbok(zzbohVar2, this.zzhbb, this.zzhbb.zzgzu));
            zzbohVar2.zzaih();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzaqv() {
        synchronized (this.zzhbb) {
            this.zzhbb.zzhaz = null;
        }
    }
}
