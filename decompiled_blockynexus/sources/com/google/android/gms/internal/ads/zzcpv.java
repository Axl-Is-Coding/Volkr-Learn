package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcpv implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected zzatc zzgkg;
    protected zzask zzgkh;
    protected final zzbcg<InputStream> zzdja = new zzbcg<>();
    protected final Object mLock = new Object();
    protected boolean zzgke = false;
    protected boolean zzgkf = false;

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzbbq.zzef("Disconnected from remote ad request service.");
        this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzbbq.zzef("Cannot connect to remote service, fallback to local instance.");
    }

    protected final void zzapz() {
        synchronized (this.mLock) {
            this.zzgkf = true;
            if (this.zzgkh.isConnected() || this.zzgkh.isConnecting()) {
                this.zzgkh.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
