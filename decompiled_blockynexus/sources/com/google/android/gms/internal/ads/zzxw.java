package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxw extends zzgu implements zzxx {
    zzxw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final IBinder zzb(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        parcelTransactAndReadException.recycle();
        return strongBinder;
    }
}
