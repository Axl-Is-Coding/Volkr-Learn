package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzanr extends zzgu implements zzanp {
    zzanr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getAdvertiser() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getBody() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getCallToAction() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final Bundle getExtras() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzgw.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getHeadline() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final List getImages() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        ArrayList arrayListZzb = zzgw.zzb(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final zzyo getVideoController() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken());
        zzyo zzyoVarZzk = zzyr.zzk(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzyoVarZzk;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void recordImpression() throws RemoteException {
        zza(8, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper3);
        zza(22, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final zzadw zzsm() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
        zzadw zzadwVarZzm = zzadv.zzm(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzadwVarZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final IObjectWrapper zzsn() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(21, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final zzaee zzso() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzaee zzaeeVarZzo = zzaed.zzo(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzaeeVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(9, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final IObjectWrapper zzue() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final IObjectWrapper zzuf() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(20, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(10, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(14, parcelObtainAndWriteInterfaceToken);
    }
}
