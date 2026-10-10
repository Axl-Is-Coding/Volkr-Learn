package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaeb extends zzgu implements zzadz {
    zzaeb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final float getAspectRatio() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        float f2 = parcelTransactAndReadException.readFloat();
        parcelTransactAndReadException.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final float getCurrentTime() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        float f2 = parcelTransactAndReadException.readFloat();
        parcelTransactAndReadException.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final float getDuration() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        float f2 = parcelTransactAndReadException.readFloat();
        parcelTransactAndReadException.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final zzyo getVideoController() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        zzyo zzyoVarZzk = zzyr.zzk(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzyoVarZzk;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final boolean hasVideoContent() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final void zza(zzafq zzafqVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzafqVar);
        zza(9, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(3, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final IObjectWrapper zzsj() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }
}
