package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasv extends zzgu implements zzast {
    zzasv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final zzasp zza(zzasn zzasnVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzasnVar);
        Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
        zzasp zzaspVar = (zzasp) zzgw.zza(parcelTransactAndReadException, zzasp.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzaspVar;
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zzb(zzatc zzatcVar, zzasw zzaswVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzatcVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaswVar);
        zza(5, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zzc(zzatc zzatcVar, zzasw zzaswVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzatcVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaswVar);
        zza(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzasn zzasnVar, zzasu zzasuVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzasnVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzasuVar);
        zza(2, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzatc zzatcVar, zzasw zzaswVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzatcVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaswVar);
        zza(4, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(String str, zzasw zzaswVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaswVar);
        zza(7, parcelObtainAndWriteInterfaceToken);
    }
}
