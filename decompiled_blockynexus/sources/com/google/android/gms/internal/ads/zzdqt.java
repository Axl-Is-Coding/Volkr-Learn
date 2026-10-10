package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [AdT] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdqt<AdT> implements zzdyr<zzdqk<AdT>> {
    private final /* synthetic */ zzdqs zzhjg;

    zzdqt(zzdqs zzdqsVar) {
        this.zzhjg = zzdqsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Object obj) {
        zzdqk<?> zzdqkVar = (zzdqk) obj;
        synchronized (this.zzhjg) {
            this.zzhjg.zzhjd.zza(zzdqkVar);
            if (this.zzhjg.zzhjc != zzdqi.zzhin) {
                this.zzhjg.zzhbu.zza(this.zzhjg.zzhiz.zzasx(), zzdqkVar);
            }
            if (this.zzhjg.zzhjc == zzdqi.zzhim) {
                this.zzhjg.zzd(this.zzhjg.zzhiz);
            }
            this.zzhjg.zzhjc = zzdqi.zzhim;
            this.zzhjg.zzhja.set(zzdqkVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        synchronized (this.zzhjg) {
            this.zzhjg.zzhjd.zzb(th);
            this.zzhjg.zzhja.setException(th);
        }
    }
}
