package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzaje extends IInterface {
    void destroy() throws RemoteException;

    zzyo getVideoController() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzajf zzajfVar) throws RemoteException;

    void zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzadz zzsw() throws RemoteException;
}
