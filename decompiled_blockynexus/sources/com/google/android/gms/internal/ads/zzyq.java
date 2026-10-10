package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyq extends zzgu implements zzyo {
    zzyq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getAspectRatio() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
        float f2 = parcelTransactAndReadException.readFloat();
        parcelTransactAndReadException.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getCurrentTime() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        float f2 = parcelTransactAndReadException.readFloat();
        parcelTransactAndReadException.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getDuration() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        float f2 = parcelTransactAndReadException.readFloat();
        parcelTransactAndReadException.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final int getPlaybackState() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        int i = parcelTransactAndReadException.readInt();
        parcelTransactAndReadException.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isClickToExpandEnabled() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isCustomControlsEnabled() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isMuted() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        boolean zZza = zzgw.zza(parcelTransactAndReadException);
        parcelTransactAndReadException.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void mute(boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.writeBoolean(parcelObtainAndWriteInterfaceToken, z);
        zza(3, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void pause() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void play() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void stop() throws RemoteException {
        zza(13, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zza(zzyt zzytVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzytVar);
        zza(8, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzyt zzqm() throws RemoteException {
        zzyt zzyvVar;
        Parcel parcelTransactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        IBinder strongBinder = parcelTransactAndReadException.readStrongBinder();
        if (strongBinder == null) {
            zzyvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzyvVar = iInterfaceQueryLocalInterface instanceof zzyt ? (zzyt) iInterfaceQueryLocalInterface : new zzyv(strongBinder);
        }
        parcelTransactAndReadException.recycle();
        return zzyvVar;
    }
}
