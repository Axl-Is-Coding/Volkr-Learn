package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcrh implements zzdyr<ParcelFileDescriptor> {
    private final /* synthetic */ zzasw zzgli;

    zzcrh(zzcqv zzcqvVar, zzasw zzaswVar) {
        this.zzgli = zzaswVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.zzgli.zzb(parcelFileDescriptor);
        } catch (RemoteException e2) {
            zzayp.zza("Service can't call client", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        try {
            this.zzgli.zza(zzazy.zzc(th));
        } catch (RemoteException e2) {
            zzayp.zza("Service can't call client", e2);
        }
    }
}
