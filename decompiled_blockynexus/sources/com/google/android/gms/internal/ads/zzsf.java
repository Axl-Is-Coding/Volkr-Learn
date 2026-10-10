package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzsf extends zzgt implements zzsg {
    public zzsf() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgt
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzxc zzxcVarZzdw = zzdw();
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzxcVarZzdw);
            return true;
        }
        zzsm zzsoVar = null;
        zzsq zzssVar = null;
        if (i == 3) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                zzsoVar = iInterfaceQueryLocalInterface instanceof zzsm ? (zzsm) iInterfaceQueryLocalInterface : new zzso(strongBinder);
            }
            zza(zzsoVar);
            parcel2.writeNoException();
            return true;
        }
        if (i != 4) {
            if (i != 5) {
                return false;
            }
            zzyn zzynVarZzki = zzki();
            parcel2.writeNoException();
            zzgw.zza(parcel2, zzynVarZzki);
            return true;
        }
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        IBinder strongBinder2 = parcel.readStrongBinder();
        if (strongBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
            zzssVar = iInterfaceQueryLocalInterface2 instanceof zzsq ? (zzsq) iInterfaceQueryLocalInterface2 : new zzss(strongBinder2);
        }
        zza(iObjectWrapperAsInterface, zzssVar);
        parcel2.writeNoException();
        return true;
    }
}
