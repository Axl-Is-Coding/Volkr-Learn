package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzaph extends IInterface {
    zzyo getVideoController() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvnVar, zzapm zzapmVar) throws RemoteException;

    void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzaov zzaovVar, zzanh zzanhVar, zzvn zzvnVar) throws RemoteException;

    void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapa zzapaVar, zzanh zzanhVar) throws RemoteException;

    void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapb zzapbVar, zzanh zzanhVar) throws RemoteException;

    void zza(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapg zzapgVar, zzanh zzanhVar) throws RemoteException;

    void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException;

    boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(String str, String str2, zzvg zzvgVar, IObjectWrapper iObjectWrapper, zzapg zzapgVar, zzanh zzanhVar) throws RemoteException;

    void zzdr(String str) throws RemoteException;

    zzapv zzua() throws RemoteException;

    zzapv zzub() throws RemoteException;

    void zzy(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException;
}
