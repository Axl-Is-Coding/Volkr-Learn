package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxn extends zzgu implements zzaxl {
    zzaxn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zza(IObjectWrapper iObjectWrapper, zzaxr zzaxrVar, zzaxg zzaxgVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaxrVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaxgVar);
        zza(1, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zzan(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(2, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(4, parcelObtainAndWriteInterfaceToken);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper2);
        Parcel parcelTransactAndReadException = transactAndReadException(3, parcelObtainAndWriteInterfaceToken);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzart zzartVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeTypedList(list);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzartVar);
        zza(5, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzart zzartVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeTypedList(list);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzartVar);
        zza(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaxl
    public final void zza(zzasa zzasaVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzasaVar);
        zza(7, parcelObtainAndWriteInterfaceToken);
    }
}
