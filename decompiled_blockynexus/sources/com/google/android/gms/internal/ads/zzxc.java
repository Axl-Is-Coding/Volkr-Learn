package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzxc extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzyo getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaak zzaakVar) throws RemoteException;

    void zza(zzaby zzabyVar) throws RemoteException;

    void zza(zzari zzariVar) throws RemoteException;

    void zza(zzaro zzaroVar, String str) throws RemoteException;

    void zza(zzaug zzaugVar) throws RemoteException;

    void zza(zzsh zzshVar) throws RemoteException;

    void zza(zzvn zzvnVar) throws RemoteException;

    void zza(zzvs zzvsVar) throws RemoteException;

    void zza(zzwo zzwoVar) throws RemoteException;

    void zza(zzwt zzwtVar) throws RemoteException;

    void zza(zzxj zzxjVar) throws RemoteException;

    void zza(zzxk zzxkVar) throws RemoteException;

    void zza(zzxq zzxqVar) throws RemoteException;

    void zza(zzyi zzyiVar) throws RemoteException;

    void zza(zzyu zzyuVar) throws RemoteException;

    boolean zza(zzvg zzvgVar) throws RemoteException;

    void zzbp(String str) throws RemoteException;

    IObjectWrapper zzke() throws RemoteException;

    void zzkf() throws RemoteException;

    zzvn zzkg() throws RemoteException;

    String zzkh() throws RemoteException;

    zzyn zzki() throws RemoteException;

    zzxk zzkj() throws RemoteException;

    zzwt zzkk() throws RemoteException;
}
