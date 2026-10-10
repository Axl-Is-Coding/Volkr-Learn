package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxe extends zzgu implements zzxc {
    zzxe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void destroy() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(37, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzgw.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String getAdUnitId() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(31, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzyo getVideoController() throws RemoteException {
        zzyo zzyqVar;
        Parcel parcelTransactAndReadException = transactAndReadException(26, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzyqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzyqVar = iInterfaceQueryLocalInterface instanceof zzyo ? (zzyo) iInterfaceQueryLocalInterface : new zzyq(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean isLoading() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(23, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean isReady() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void pause() throws RemoteException {
        zza(5, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void resume() throws RemoteException {
        zza(6, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.writeBoolean(parcelObtainAndWriteInterfaceToken, z);
        zza(34, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.writeBoolean(parcelObtainAndWriteInterfaceToken, z);
        zza(22, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setUserId(String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(25, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void showInterstitial() throws RemoteException {
        zza(9, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void stopLoading() throws RemoteException {
        zza(10, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean zza(zzvg zzvgVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        Parcel parcelTransactAndReadException = transactAndReadException(4, parcelObtainAndWriteInterfaceToken);
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzbp(String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(38, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final IObjectWrapper zzke() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzkf() throws RemoteException {
        zza(11, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzvn zzkg() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
        zzvn zzvnVar = (zzvn) zzgw.zza(parcelTransactAndReadException, zzvn.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String zzkh() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(35, obtainAndWriteInterfaceToken());
        String string = parcelTransactAndReadException.readString();
        parcelTransactAndReadException.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzyn zzki() throws RemoteException {
        zzyn zzypVar;
        Parcel parcelTransactAndReadException = transactAndReadException(41, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzypVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzypVar = iInterfaceQueryLocalInterface instanceof zzyn ? (zzyn) iInterfaceQueryLocalInterface : new zzyp(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzypVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzxk zzkj() throws RemoteException {
        zzxk zzxmVar;
        Parcel parcelTransactAndReadException = transactAndReadException(32, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzxmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzxmVar = iInterfaceQueryLocalInterface instanceof zzxk ? (zzxk) iInterfaceQueryLocalInterface : new zzxm(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzxmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzwt zzkk() throws RemoteException {
        zzwt zzwvVar;
        Parcel parcelTransactAndReadException = transactAndReadException(33, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzwvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzwvVar = iInterfaceQueryLocalInterface instanceof zzwt ? (zzwt) iInterfaceQueryLocalInterface : new zzwv(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzwvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwt zzwtVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzwtVar);
        zza(7, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxk zzxkVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzxkVar);
        zza(8, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvn zzvnVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        zza(13, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzari zzariVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzariVar);
        zza(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaro zzaroVar, String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaroVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(15, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaby zzabyVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzabyVar);
        zza(19, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwo zzwoVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzwoVar);
        zza(20, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxq zzxqVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzxqVar);
        zza(21, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaug zzaugVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaugVar);
        zza(24, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaak zzaakVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaakVar);
        zza(29, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyu zzyuVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzyuVar);
        zza(30, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxj zzxjVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzxjVar);
        zza(36, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvs zzvsVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvsVar);
        zza(39, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzsh zzshVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzshVar);
        zza(40, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyi zzyiVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzyiVar);
        zza(42, parcelObtainAndWriteInterfaceToken);
    }
}
