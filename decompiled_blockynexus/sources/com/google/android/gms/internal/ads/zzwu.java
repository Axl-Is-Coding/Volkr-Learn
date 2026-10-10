package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzwu extends IInterface {
    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    void zza(zzvg zzvgVar, int i) throws RemoteException;

    void zzb(zzvg zzvgVar) throws RemoteException;

    String zzkh() throws RemoteException;
}
