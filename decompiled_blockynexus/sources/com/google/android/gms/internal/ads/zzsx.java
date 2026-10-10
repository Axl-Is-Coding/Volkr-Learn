package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzsx implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzsw zzbuz;

    zzsx(zzsw zzswVar) {
        this.zzbuz = zzswVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbuz.lock) {
            try {
            } catch (DeadObjectException e2) {
                zzbbq.zzc("Unable to obtain a cache service instance.", e2);
                this.zzbuz.disconnect();
            }
            if (this.zzbuz.zzbvb != null) {
                this.zzbuz.zzbvc = this.zzbuz.zzbvb.zzmz();
                this.zzbuz.lock.notifyAll();
            } else {
                this.zzbuz.lock.notifyAll();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbuz.lock) {
            this.zzbuz.zzbvc = null;
            this.zzbuz.lock.notifyAll();
        }
    }
}
