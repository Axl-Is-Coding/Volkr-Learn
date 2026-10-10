package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxd extends zzgu implements zzxa {
    zzxd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final IBinder zzc(IObjectWrapper iObjectWrapper, String str, zzanb zzanbVar, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        parcelTransactAndReadException.recycle();
        return strongBinder;
    }
}
