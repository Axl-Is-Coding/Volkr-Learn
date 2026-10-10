package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaiw extends zzgt implements zzait {
    public zzaiw() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzait zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        return iInterfaceQueryLocalInterface instanceof zzait ? (zzait) iInterfaceQueryLocalInterface : new zzaiv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zze(parcel.createTypedArrayList(zzaiq.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
