package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzye implements MuteThisAdReason {
    private final String description;
    private zzyd zzcjk;

    public zzye(zzyd zzydVar) {
        String description;
        this.zzcjk = zzydVar;
        try {
            description = zzydVar.getDescription();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            description = null;
        }
        this.description = description;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        return this.description;
    }

    public final zzyd zzql() {
        return this.zzcjk;
    }
}
