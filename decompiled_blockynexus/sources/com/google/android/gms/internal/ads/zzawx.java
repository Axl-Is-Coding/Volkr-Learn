package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzawx implements zzaxf {
    static final zzaxf zzdya = new zzawx();

    private zzawx() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxf
    public final Object zza(zzbiq zzbiqVar) throws RemoteException {
        String currentScreenName = zzbiqVar.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbiqVar.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
