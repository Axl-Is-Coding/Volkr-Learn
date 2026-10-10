package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzsq extends IInterface {
    void onAdDismissedFullScreenContent() throws RemoteException;

    void onAdShowedFullScreenContent() throws RemoteException;

    void zzb(zzva zzvaVar) throws RemoteException;
}
