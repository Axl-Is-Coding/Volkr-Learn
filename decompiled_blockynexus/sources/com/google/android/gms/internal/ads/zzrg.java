package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrg {
    private final Object zzbsz = new Object();
    private zzrf zzbta = null;
    private boolean zzbtb = false;

    public final Activity getActivity() {
        synchronized (this.zzbsz) {
            if (this.zzbta == null) {
                return null;
            }
            return this.zzbta.getActivity();
        }
    }

    public final Context getContext() {
        synchronized (this.zzbsz) {
            if (this.zzbta == null) {
                return null;
            }
            return this.zzbta.getContext();
        }
    }

    public final void initialize(Context context) {
        synchronized (this.zzbsz) {
            if (!this.zzbtb) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzbbq.zzfe("Can not cast Context to Application");
                    return;
                }
                if (this.zzbta == null) {
                    this.zzbta = new zzrf();
                }
                this.zzbta.zza(application, context);
                this.zzbtb = true;
            }
        }
    }

    public final void zza(zzrh zzrhVar) {
        synchronized (this.zzbsz) {
            if (this.zzbta == null) {
                this.zzbta = new zzrf();
            }
            this.zzbta.zza(zzrhVar);
        }
    }

    public final void zzb(zzrh zzrhVar) {
        synchronized (this.zzbsz) {
            if (this.zzbta == null) {
                return;
            }
            this.zzbta.zzb(zzrhVar);
        }
    }
}
