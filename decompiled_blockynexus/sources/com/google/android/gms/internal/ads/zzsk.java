package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzsk extends zzgt implements zzsh {
    public zzsk() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzsh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        return iInterfaceQueryLocalInterface instanceof zzsh ? (zzsh) iInterfaceQueryLocalInterface : new zzsj(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzsg zzsiVar;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzsiVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
                zzsiVar = iInterfaceQueryLocalInterface instanceof zzsg ? (zzsg) iInterfaceQueryLocalInterface : new zzsi(strongBinder);
            }
            zza(zzsiVar);
        } else if (i == 2) {
            onAppOpenAdFailedToLoad(parcel.readInt());
        } else {
            if (i != 3) {
                return false;
            }
            zza((zzva) zzgw.zza(parcel, zzva.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
