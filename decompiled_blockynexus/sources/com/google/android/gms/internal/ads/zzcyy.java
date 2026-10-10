package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyy {
    private final zzcku zzgij;
    private final ConcurrentHashMap<String, zzaph> zzgsc = new ConcurrentHashMap<>();

    public zzcyy(zzcku zzckuVar) {
        this.zzgij = zzckuVar;
    }

    public final void zzgo(String str) {
        try {
            this.zzgsc.put(str, this.zzgij.zzdk(str));
        } catch (RemoteException e2) {
            zzbbq.zzc("Couldn't create RTB adapter : ", e2);
        }
    }

    public final zzaph zzgp(String str) {
        if (this.zzgsc.containsKey(str)) {
            return this.zzgsc.get(str);
        }
        return null;
    }
}
