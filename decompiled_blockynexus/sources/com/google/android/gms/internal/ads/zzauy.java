package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzauy extends IInterface {
    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    void zza(zzavd zzavdVar) throws RemoteException;

    void zza(zzavl zzavlVar) throws RemoteException;

    void zza(zzavt zzavtVar) throws RemoteException;

    void zza(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException;

    void zza(zzyh zzyhVar) throws RemoteException;

    void zza(zzyi zzyiVar) throws RemoteException;

    void zzb(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzyn zzki() throws RemoteException;

    zzaux zzqz() throws RemoteException;
}
