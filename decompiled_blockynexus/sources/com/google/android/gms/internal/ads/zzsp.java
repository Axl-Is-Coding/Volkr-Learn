package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzsp extends zzgt implements zzsq {
    public zzsp() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            onAdShowedFullScreenContent();
        } else if (i == 2) {
            onAdDismissedFullScreenContent();
        } else {
            if (i != 3) {
                return false;
            }
            zzb((zzva) zzgw.zza(parcel, zzva.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
