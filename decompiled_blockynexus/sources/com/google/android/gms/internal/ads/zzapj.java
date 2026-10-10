package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzapj extends zzgu implements zzaph {
    zzapj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzyo getVideoController() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzyo zzyoVarZzk = zzyr.zzk(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzyoVarZzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvnVar, zzapm zzapmVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, bundle);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, bundle2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzapmVar);
        zza(1, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(17, parcelObtainAndWriteInterfaceToken);
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzb(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapg zzapgVar, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzapgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(20, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzdr(String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        zza(19, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzapv zzua() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        zzapv zzapvVar = (zzapv) zzgw.zza(parcelTransactAndReadException, zzapv.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzapvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzapv zzub() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        zzapv zzapvVar = (zzapv) zzgw.zza(parcelTransactAndReadException, zzapv.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzapvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(10, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        Parcel parcelTransactAndReadException = transactAndReadException(15, parcelObtainAndWriteInterfaceToken);
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeStringArray(strArr);
        parcelObtainAndWriteInterfaceToken.writeTypedArray(bundleArr, 0);
        zza(11, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzaov zzaovVar, zzanh zzanhVar, zzvn zzvnVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzaovVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvnVar);
        zza(13, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapa zzapaVar, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzapaVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapg zzapgVar, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzapgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(16, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapb zzapbVar, zzanh zzanhVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvgVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzapbVar);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzanhVar);
        zza(18, parcelObtainAndWriteInterfaceToken);
    }
}
