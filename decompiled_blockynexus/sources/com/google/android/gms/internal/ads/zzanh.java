package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzanh extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoEnd() throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void zza(zzafa zzafaVar, String str) throws RemoteException;

    void zza(zzanm zzanmVar) throws RemoteException;

    void zza(zzaux zzauxVar) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;

    void zzb(zzauv zzauvVar) throws RemoteException;

    void zzc(int i, String str) throws RemoteException;

    void zzc(zzva zzvaVar) throws RemoteException;

    void zzdd(int i) throws RemoteException;

    void zzdn(String str) throws RemoteException;

    void zzdo(String str) throws RemoteException;

    void zze(zzva zzvaVar) throws RemoteException;

    void zzuc() throws RemoteException;

    void zzud() throws RemoteException;
}
