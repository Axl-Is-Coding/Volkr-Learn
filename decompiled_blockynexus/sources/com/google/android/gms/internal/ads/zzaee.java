package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzaee extends IInterface {
    int getHeight() throws RemoteException;

    double getScale() throws RemoteException;

    Uri getUri() throws RemoteException;

    int getWidth() throws RemoteException;

    IObjectWrapper zzsg() throws RemoteException;
}
