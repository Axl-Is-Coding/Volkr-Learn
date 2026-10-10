package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagg extends zzgu implements zzage {
    zzagg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void cancelUnconfirmedClick() throws RemoteException {
        zza(22, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void destroy() throws RemoteException {
        zza(13, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getAdvertiser() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getBody() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getCallToAction() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final Bundle getExtras() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(20, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzgw.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getHeadline() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final List getImages() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        ArrayList arrayListZzb = zzgw.zzb(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final List getMuteThisAdReasons() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(23, obtainAndWriteInterfaceToken());
        ArrayList arrayListZzb = zzgw.zzb(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getPrice() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final double getStarRating() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
        double d2 = parcelTransactAndReadException.readDouble();
        parcelTransactAndReadException.recycle();
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final String getStore() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzyo getVideoController() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        zzyo zzyoVarZzk = zzyr.zzk(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzyoVarZzk;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final boolean isCustomClickGestureEnabled() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(30, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(24, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void performClick(Bundle bundle) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, bundle);
        zza(15, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void recordCustomClickGesture() throws RemoteException {
        zza(28, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, bundle);
        Parcel parcelTransactAndReadException = transactAndReadException(16, parcelObtainAndWriteInterfaceToken);
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, bundle);
        zza(17, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzafz zzafzVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzafzVar);
        zza(21, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzyn zzki() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(31, obtainAndWriteInterfaceToken());
        zzyn zzynVarZzj = zzym.zzj(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzynVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final IObjectWrapper zzsk() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzaee zzsl() throws RemoteException {
        zzaee zzaegVar;
        Parcel parcelTransactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzaegVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzaegVar = iInterfaceQueryLocalInterface instanceof zzaee ? (zzaee) iInterfaceQueryLocalInterface : new zzaeg(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzaegVar;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzadw zzsm() throws RemoteException {
        zzadw zzadyVar;
        Parcel parcelTransactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzadyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzadyVar = iInterfaceQueryLocalInterface instanceof zzadw ? (zzadw) iInterfaceQueryLocalInterface : new zzady(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final IObjectWrapper zzsn() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zzsv() throws RemoteException {
        zza(27, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final zzadz zzsw() throws RemoteException {
        zzadz zzaebVar;
        Parcel parcelTransactAndReadException = transactAndReadException(29, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzaebVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzaebVar = iInterfaceQueryLocalInterface instanceof zzadz ? (zzadz) iInterfaceQueryLocalInterface : new zzaeb(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzaebVar;
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzyd zzydVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzydVar);
        zza(25, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzxz zzxzVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzxzVar);
        zza(26, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void zza(zzyi zzyiVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzyiVar);
        zza(32, parcelObtainAndWriteInterfaceToken);
    }
}
