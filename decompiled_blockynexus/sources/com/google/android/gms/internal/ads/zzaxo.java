package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxo extends zzgu implements zzaxm {
    zzaxo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzaxm
    public final zzaxl zze(IObjectWrapper iObjectWrapper, zzanb zzanbVar, int i) throws RemoteException {
        zzaxl zzaxnVar;
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(2, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzaxnVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzaxnVar = iInterfaceQueryLocalInterface instanceof zzaxl ? (zzaxl) iInterfaceQueryLocalInterface : new zzaxn(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzaxnVar;
    }
}
