package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzk extends zzyc {
    private final String description;
    private final String zzcks;

    public zzzk(String str, String str2) {
        this.description = str;
        this.zzcks = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final String getDescription() throws RemoteException {
        return this.description;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final String zzqk() throws RemoteException {
        return this.zzcks;
    }
}
