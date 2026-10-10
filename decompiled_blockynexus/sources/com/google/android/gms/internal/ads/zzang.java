package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzang extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzyo getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzais zzaisVar, List<zzaja> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaur zzaurVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzaur zzaurVar, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, String str2, zzanh zzanhVar, zzadu zzaduVar, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvg zzvgVar, String str, String str2, zzanh zzanhVar) throws RemoteException;

    void zza(zzvg zzvgVar, String str) throws RemoteException;

    void zza(zzvg zzvgVar, String str, String str2) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, zzvg zzvgVar, String str, zzanh zzanhVar) throws RemoteException;

    void zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzt(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzts() throws RemoteException;

    zzano zztt() throws RemoteException;

    zzanp zztu() throws RemoteException;

    Bundle zztv() throws RemoteException;

    Bundle zztw() throws RemoteException;

    boolean zztx() throws RemoteException;

    zzafa zzty() throws RemoteException;

    zzanu zztz() throws RemoteException;

    zzapv zzua() throws RemoteException;

    zzapv zzub() throws RemoteException;
}
