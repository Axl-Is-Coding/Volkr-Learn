package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzajd extends zzgt implements zzaje {
    public zzajd() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzajf zzajhVar;
        if (i == 3) {
            zzyo videoController = getVideoController();
            parcel2.writeNoException();
            zzgw.zza(parcel2, videoController);
            return true;
        }
        if (i == 4) {
            destroy();
            parcel2.writeNoException();
            return true;
        }
        if (i == 5) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzajhVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzajhVar = iInterfaceQueryLocalInterface instanceof zzajf ? (zzajf) iInterfaceQueryLocalInterface : new zzajh(strongBinder);
            }
            zza(iObjectWrapperAsInterface, zzajhVar);
            parcel2.writeNoException();
            return true;
        }
        if (i == 6) {
            zzr(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
        if (i != 7) {
            return false;
        }
        zzadz zzadzVarZzsw = zzsw();
        parcel2.writeNoException();
        zzgw.zza(parcel2, zzadzVarZzsw);
        return true;
    }
}
