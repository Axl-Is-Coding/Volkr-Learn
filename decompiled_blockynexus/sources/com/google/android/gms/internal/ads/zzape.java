package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzape extends zzgt implements zzapb {
    public zzape() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza(zzant.zzae(parcel.readStrongBinder()));
        } else if (i == 2) {
            zzdq(parcel.readString());
        } else {
            if (i != 3) {
                return false;
            }
            zzf((zzva) zzgw.zza(parcel, zzva.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
