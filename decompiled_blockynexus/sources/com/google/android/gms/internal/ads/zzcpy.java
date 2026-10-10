package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpy extends zzasz {
    private final /* synthetic */ zzcpv zzgkj;

    protected zzcpy(zzcpv zzcpvVar) {
        this.zzgkj = zzcpvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzazy zzazyVar) {
        this.zzgkj.zzdja.setException(new zzbab(zzazyVar.zzacm, zzazyVar.errorCode));
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgkj.zzdja.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
