package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaeg extends zzgu implements zzaee {
    zzaeg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final int getHeight() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        int i = parcelTransactAndReadException.readInt();
        parcelTransactAndReadException.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final double getScale() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        double d2 = parcelTransactAndReadException.readDouble();
        parcelTransactAndReadException.recycle();
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final Uri getUri() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        Uri uri = (Uri) zzgw.zza(parcelTransactAndReadException, Uri.CREATOR);
        parcelTransactAndReadException.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final int getWidth() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        int i = parcelTransactAndReadException.readInt();
        parcelTransactAndReadException.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final IObjectWrapper zzsg() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }
}
