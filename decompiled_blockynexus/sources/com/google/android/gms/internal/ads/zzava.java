package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzava extends zzgu implements zzauy {
    zzava(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzgw.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final boolean isLoaded() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzavgVar);
        zza(1, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zzb(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzavgVar);
        zza(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(5, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final zzyn zzki() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
        zzyn zzynVarZzj = zzym.zzj(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzynVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final zzaux zzqz() throws RemoteException {
        zzaux zzauzVar;
        Parcel parcelTransactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzauzVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzauzVar = iInterfaceQueryLocalInterface instanceof zzaux ? (zzaux) iInterfaceQueryLocalInterface : new zzauz(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzauzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavd zzavdVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzavdVar);
        zza(2, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavl zzavlVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzavlVar);
        zza(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavt zzavtVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzavtVar);
        zza(7, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzyh zzyhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzyhVar);
        zza(8, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.writeBoolean(parcelObtainAndWriteInterfaceToken, z);
        zza(10, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzyi zzyiVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzyiVar);
        zza(13, parcelObtainAndWriteInterfaceToken);
    }
}
