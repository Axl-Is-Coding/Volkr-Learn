package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzavd extends IInterface {
    void onRewardedAdClosed() throws RemoteException;

    void onRewardedAdFailedToShow(int i) throws RemoteException;

    void onRewardedAdOpened() throws RemoteException;

    void zza(zzaux zzauxVar) throws RemoteException;

    void zzh(zzva zzvaVar) throws RemoteException;
}
