package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzasz extends zzgt implements zzasw {
    public zzasz() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((ParcelFileDescriptor) zzgw.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zza((zzazy) zzgw.zza(parcel, zzazy.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
