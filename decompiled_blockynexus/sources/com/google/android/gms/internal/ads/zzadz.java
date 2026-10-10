package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzadz extends IInterface {
    float getAspectRatio() throws RemoteException;

    float getCurrentTime() throws RemoteException;

    float getDuration() throws RemoteException;

    zzyo getVideoController() throws RemoteException;

    boolean hasVideoContent() throws RemoteException;

    void zza(zzafq zzafqVar) throws RemoteException;

    void zzo(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzsj() throws RemoteException;
}
