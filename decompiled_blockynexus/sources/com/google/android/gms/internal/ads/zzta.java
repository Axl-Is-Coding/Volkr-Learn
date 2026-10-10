package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzta implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzsw zzbuz;

    zzta(zzsw zzswVar) {
        this.zzbuz = zzswVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbuz.lock) {
            this.zzbuz.zzbvc = null;
            if (this.zzbuz.zzbvb != null) {
                zzsw.zza(this.zzbuz, (zztb) null);
            }
            this.zzbuz.lock.notifyAll();
        }
    }
}
