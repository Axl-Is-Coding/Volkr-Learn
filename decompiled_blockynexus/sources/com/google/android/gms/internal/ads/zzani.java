package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzani extends zzgu implements zzang {
    zzani(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void destroy() throws RemoteException {
        zza(5, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzgw.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzyo getVideoController() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(26, obtainAndWriteInterfaceToken());
        zzyo zzyoVarZzk = zzyr.zzk(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzyoVarZzk;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean isInitialized() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void pause() throws RemoteException {
        zza(8, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void resume() throws RemoteException {
        zza(9, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.writeBoolean(parcelObtainAndWriteInterfaceToken, z);
        zza(25, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showInterstitial() throws RemoteException {
        zza(4, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showVideo() throws RemoteException {
        zza(12, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(1, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzb(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(28, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzc(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(32, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(21, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(30, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzts() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzano zztt() throws RemoteException {
        zzano zzanqVar;
        Parcel parcelTransactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzanqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzanqVar = iInterfaceQueryLocalInterface instanceof zzano ? (zzano) iInterfaceQueryLocalInterface : new zzanq(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzanqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzanp zztu() throws RemoteException {
        zzanp zzanrVar;
        Parcel parcelTransactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzanrVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzanrVar = iInterfaceQueryLocalInterface instanceof zzanp ? (zzanp) iInterfaceQueryLocalInterface : new zzanr(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzanrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle zztv() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzgw.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle zztw() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzgw.zza(parcelTransactAndReadException, Bundle.CREATOR);
        parcelTransactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean zztx() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(22, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzafa zzty() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(24, obtainAndWriteInterfaceToken());
        zzafa zzafaVarZzr = zzaez.zzr(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzafaVarZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzanu zztz() throws RemoteException {
        zzanu zzanwVar;
        Parcel parcelTransactAndReadException = transactAndReadException(27, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzanwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzanwVar = iInterfaceQueryLocalInterface instanceof zzanu ? (zzanu) iInterfaceQueryLocalInterface : new zzanw(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzanwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzapv zzua() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(33, obtainAndWriteInterfaceToken());
        zzapv zzapvVar = (zzapv) zzgw.zza(parcelTransactAndReadException, zzapv.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzapvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzapv zzub() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(34, obtainAndWriteInterfaceToken());
        zzapv zzapvVar = (zzapv) zzgw.zza(parcelTransactAndReadException, zzapv.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzapvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(3, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(7, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzaur zzaurVar, String str2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaurVar);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zza(10, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzvg zzvgVar, String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(11, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar, zzadu zzaduVar, List<String> list) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaduVar);
        parcelObtainAndWriteInterfaceToken.writeStringList(list);
        zza(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(zzvg zzvgVar, String str, String str2) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zza(20, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzaur zzaurVar, List<String> list) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaurVar);
        parcelObtainAndWriteInterfaceToken.writeStringList(list);
        zza(23, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, zzais zzaisVar, List<zzaja> list) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaisVar);
        parcelObtainAndWriteInterfaceToken.writeTypedList(list);
        zza(31, parcelObtainAndWriteInterfaceToken);
    }
}
