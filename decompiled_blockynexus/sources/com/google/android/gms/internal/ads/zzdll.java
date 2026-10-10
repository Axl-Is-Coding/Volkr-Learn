package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdll {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdlk<T> zzdlkVar) {
        T t = atomicReference.get();
        if (t == null) {
            return;
        }
        try {
            zzdlkVar.zzq(t);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
