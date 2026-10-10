package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaoa implements InitializationCompleteCallback {
    private final /* synthetic */ zzais zzdlo;

    zzaoa(zzanx zzanxVar, zzais zzaisVar) {
        this.zzdlo = zzaisVar;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.zzdlo.onInitializationFailed(str);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.zzdlo.onInitializationSucceeded();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }
}
