package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zztq implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zztk zzbvl;
    private final /* synthetic */ zzbcg zzbvs;

    zztq(zztk zztkVar, zzbcg zzbcgVar) {
        this.zzbvl = zztkVar;
        this.zzbvs = zzbcgVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbvl.lock) {
            this.zzbvs.setException(new RuntimeException("Connection failed."));
        }
    }
}
