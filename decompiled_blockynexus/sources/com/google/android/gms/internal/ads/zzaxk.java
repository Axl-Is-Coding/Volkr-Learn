package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaxk extends zzgt implements zzaxl {
    public zzaxk() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzaxl zzas(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return iInterfaceQueryLocalInterface instanceof zzaxl ? (zzaxl) iInterfaceQueryLocalInterface : new zzaxn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaxg zzaxiVar;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxr zzaxrVar = (zzaxr) zzgw.zza(parcel, zzaxr.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzaxiVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzaxiVar = iInterfaceQueryLocalInterface instanceof zzaxg ? (zzaxg) iInterfaceQueryLocalInterface : new zzaxi(strongBinder);
                }
                zza(iObjectWrapperAsInterface, zzaxrVar, zzaxiVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzan(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper iObjectWrapperZzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzb);
                return true;
            case 4:
                IObjectWrapper iObjectWrapperZzao = zzao(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgw.zza(parcel2, iObjectWrapperZzao);
                return true;
            case 5:
                zza(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzars.zzam(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zzb(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzars.zzam(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzasa) zzgw.zza(parcel, zzasa.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
