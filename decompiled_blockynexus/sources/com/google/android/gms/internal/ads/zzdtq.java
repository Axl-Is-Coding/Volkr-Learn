package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdtq implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzgke = false;
    private boolean zzgkf = false;
    private final zzduk zzhmu;
    private final zzduc zzhmv;

    zzdtq(Context context, Looper looper, zzduc zzducVar) {
        this.zzhmv = zzducVar;
        this.zzhmu = new zzduk(context, looper, this, this, 12800000);
    }

    private final void zzapz() {
        synchronized (this.lock) {
            if (this.zzhmu.isConnected() || this.zzhmu.isConnecting()) {
                this.zzhmu.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.lock) {
            if (this.zzgkf) {
                return;
            }
            this.zzgkf = true;
            try {
                this.zzhmu.zzawm().zza(new zzdui(this.zzhmv.toByteArray()));
                zzapz();
            } catch (Exception unused) {
                zzapz();
            } catch (Throwable th) {
                zzapz();
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    final void zzawd() {
        synchronized (this.lock) {
            if (!this.zzgke) {
                this.zzgke = true;
                this.zzhmu.checkAvailabilityAndConnect();
            }
        }
    }
}
