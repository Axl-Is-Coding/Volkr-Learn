package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzaxg extends IInterface {
    void onError(String str) throws RemoteException;

    void zza(String str, String str2, Bundle bundle) throws RemoteException;

    void zzk(String str, String str2) throws RemoteException;
}
