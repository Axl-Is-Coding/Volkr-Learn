package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzavc extends zzgt implements zzavd {
    public zzavc() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaux zzauzVar;
        if (i == 1) {
            onRewardedAdOpened();
        } else if (i == 2) {
            onRewardedAdClosed();
        } else if (i == 3) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzauzVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                zzauzVar = iInterfaceQueryLocalInterface instanceof zzaux ? (zzaux) iInterfaceQueryLocalInterface : new zzauz(strongBinder);
            }
            zza(zzauzVar);
        } else if (i == 4) {
            onRewardedAdFailedToShow(parcel.readInt());
        } else {
            if (i != 5) {
                return false;
            }
            zzh((zzva) zzgw.zza(parcel, zzva.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
