package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxu extends zzgu implements zzxs {
    zzxu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final String getVersionString() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void initialize() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void setAppMuted(boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.writeBoolean(parcelObtainAndWriteInterfaceToken, z);
        zza(4, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void setAppVolume(float f2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeFloat(f2);
        zza(2, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(5, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzch(String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(3, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzci(String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(10, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final float zzqg() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        float f2 = parcelTransactAndReadException.readFloat();
        parcelTransactAndReadException.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final boolean zzqh() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final List<zzaiq> zzqi() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
        ArrayList arrayListCreateTypedArrayList = parcelTransactAndReadException.createTypedArrayList(zzaiq.CREATOR);
        parcelTransactAndReadException.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzqj() throws RemoteException {
        zza(15, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzanb zzanbVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanbVar);
        zza(11, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzait zzaitVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaitVar);
        zza(12, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzaae zzaaeVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaaeVar);
        zza(14, parcelObtainAndWriteInterfaceToken);
    }
}
