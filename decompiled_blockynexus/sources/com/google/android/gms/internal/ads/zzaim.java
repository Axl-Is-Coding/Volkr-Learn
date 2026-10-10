package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaim extends zzaif {
    private final /* synthetic */ zzbcg zzbvs;

    zzaim(zzaij zzaijVar, zzbcg zzbcgVar) {
        this.zzbvs = zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        this.zzbvs.set(parcelFileDescriptor);
    }
}
