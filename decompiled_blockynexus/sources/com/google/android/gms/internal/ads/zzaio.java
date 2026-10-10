package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaio implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbcg zzbvs;
    private final /* synthetic */ zzaik zzdfy;

    zzaio(zzaik zzaikVar, zzbcg zzbcgVar) {
        this.zzdfy = zzaikVar;
        this.zzbvs = zzbcgVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        try {
            this.zzbvs.set(this.zzdfy.zzdfx.zzsz());
        } catch (DeadObjectException e2) {
            this.zzbvs.setException(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbcg zzbcgVar = this.zzbvs;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbcgVar.setException(new RuntimeException(sb.toString()));
    }
}
