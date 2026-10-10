package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzej implements Application.ActivityLifecycleCallbacks {
    private final Application zzyh;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzyi;
    private boolean zzyj = false;

    public zzej(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzyi = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyh = application;
    }

    private final void zza(zzer zzerVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzyi.get();
            if (activityLifecycleCallbacks != null) {
                zzerVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.zzyj) {
                    return;
                }
                this.zzyh.unregisterActivityLifecycleCallbacks(this);
                this.zzyj = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzem(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(new zzes(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(new zzen(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(new zzeo(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzep(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(new zzel(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zza(new zzeq(this, activity));
    }
}
