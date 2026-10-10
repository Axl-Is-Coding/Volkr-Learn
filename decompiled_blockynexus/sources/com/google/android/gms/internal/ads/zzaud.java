package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzaud extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setAppPackageName(String str) throws RemoteException;

    void setCustomData(String str) throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void show() throws RemoteException;

    void zza(zzaub zzaubVar) throws RemoteException;

    void zza(zzaug zzaugVar) throws RemoteException;

    void zza(zzaum zzaumVar) throws RemoteException;

    void zza(zzxj zzxjVar) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzyn zzki() throws RemoteException;

    void zzl(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzra() throws RemoteException;
}
