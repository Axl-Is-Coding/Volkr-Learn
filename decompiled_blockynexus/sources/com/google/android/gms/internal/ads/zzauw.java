package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzauw extends zzgt implements zzaux {
    public zzauw() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public static zzaux zzaq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
        return iInterfaceQueryLocalInterface instanceof zzaux ? (zzaux) iInterfaceQueryLocalInterface : new zzauz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String type = getType();
            parcel2.writeNoException();
            parcel2.writeString(type);
        } else {
            if (i != 2) {
                return false;
            }
            int amount = getAmount();
            parcel2.writeNoException();
            parcel2.writeInt(amount);
        }
        return true;
    }
}
