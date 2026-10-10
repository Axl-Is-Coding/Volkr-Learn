package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzsw {
    private zztb zzbvb;
    private zztf zzbvc;
    private Context zzvr;
    private final Runnable zzbva = new zzsv(this);
    private final Object lock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect() {
        synchronized (this.lock) {
            if (this.zzvr != null && this.zzbvb == null) {
                this.zzbvb = zza(new zzsx(this), new zzta(this));
                this.zzbvb.checkAvailabilityAndConnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbvb == null) {
                return;
            }
            if (this.zzbvb.isConnected() || this.zzbvb.isConnecting()) {
                this.zzbvb.disconnect();
            }
            this.zzbvb = null;
            this.zzbvc = null;
            Binder.flushPendingCommands();
        }
    }

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.lock) {
            if (this.zzvr != null) {
                return;
            }
            this.zzvr = context.getApplicationContext();
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsz)).booleanValue()) {
                connect();
            } else {
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsy)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzp.zzku().zza(new zzsy(this));
                }
            }
        }
    }

    public final zzsz zza(zzte zzteVar) {
        synchronized (this.lock) {
            if (this.zzbvc == null) {
                return new zzsz();
            }
            try {
                return this.zzbvc.zza(zzteVar);
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call into cache service.", e2);
                return new zzsz();
            }
        }
    }

    public final void zzmv() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcta)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                com.google.android.gms.ads.internal.zzp.zzkr();
                zzayu.zzeba.removeCallbacks(this.zzbva);
                com.google.android.gms.ads.internal.zzp.zzkr();
                zzayu.zzeba.postDelayed(this.zzbva, ((Long) zzwm.zzpx().zzd(zzabb.zzctb)).longValue());
            }
        }
    }

    @VisibleForTesting
    private final synchronized zztb zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zztb(this.zzvr, com.google.android.gms.ads.internal.zzp.zzlf().zzyj(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    static /* synthetic */ zztb zza(zzsw zzswVar, zztb zztbVar) {
        zzswVar.zzbvb = null;
        return null;
    }
}
