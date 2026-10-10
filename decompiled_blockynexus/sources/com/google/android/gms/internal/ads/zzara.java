package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzara extends zzgu implements zzaqy {
    zzara(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        parcelObtainAndWriteInterfaceToken.writeInt(i2);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, intent);
        zza(12, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onBackPressed() throws RemoteException {
        zza(10, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, bundle);
        zza(1, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onDestroy() throws RemoteException {
        zza(8, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onPause() throws RemoteException {
        zza(5, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onRestart() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onResume() throws RemoteException {
        zza(4, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, bundle);
        Parcel parcelTransactAndReadException = transactAndReadException(6, parcelObtainAndWriteInterfaceToken);
        if (parcelTransactAndReadException.readInt() != 0) {
            bundle.readFromParcel(parcelTransactAndReadException);
        }
        parcelTransactAndReadException.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onStart() throws RemoteException {
        zza(3, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onStop() throws RemoteException {
        zza(7, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(13, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void zzdq() throws RemoteException {
        zza(9, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final boolean zzut() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }
}
