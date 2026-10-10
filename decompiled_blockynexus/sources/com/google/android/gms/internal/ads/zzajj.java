package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzajj extends zzgt implements zzajk {
    public zzajj() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public static zzajk zzab(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
        return iInterfaceQueryLocalInterface instanceof zzajk ? (zzajk) iInterfaceQueryLocalInterface : new zzajm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaje zzajgVar;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzajgVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
                zzajgVar = iInterfaceQueryLocalInterface instanceof zzaje ? (zzaje) iInterfaceQueryLocalInterface : new zzajg(strongBinder);
            }
            zza(zzajgVar);
        } else if (i == 2) {
            onInstreamAdFailedToLoad(parcel.readInt());
        } else {
            if (i != 3) {
                return false;
            }
            zzd((zzva) zzgw.zza(parcel, zzva.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
