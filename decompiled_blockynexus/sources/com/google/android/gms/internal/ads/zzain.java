package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzain implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbcg zzbvs;

    zzain(zzaik zzaikVar, zzbcg zzbcgVar) {
        this.zzbvs = zzbcgVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbvs.setException(new RuntimeException("Connection failed."));
    }
}
