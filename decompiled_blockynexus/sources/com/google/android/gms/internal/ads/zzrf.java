package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
final class zzrf implements Application.ActivityLifecycleCallbacks {
    private Activity zzaas;
    private Runnable zzbsx;
    private long zzbsy;
    private Context zzvr;
    private final Object lock = new Object();
    private boolean foreground = true;
    private boolean zzbsu = false;
    private final List<zzrh> zzbsv = new ArrayList();
    private final List<zzrw> zzbsw = new ArrayList();
    private boolean zzzh = false;

    zzrf() {
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zzaas = activity;
            }
        }
    }

    public final Activity getActivity() {
        return this.zzaas;
    }

    public final Context getContext() {
        return this.zzvr;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzaas == null) {
                return;
            }
            if (this.zzaas.equals(activity)) {
                this.zzaas = null;
            }
            Iterator<zzrw> it = this.zzbsw.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().zza(activity)) {
                        it.remove();
                    }
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzbbq.zzc("", e2);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            Iterator<zzrw> it = this.zzbsw.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityPaused(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbbq.zzc("", e2);
                }
            }
        }
        this.zzbsu = true;
        Runnable runnable = this.zzbsx;
        if (runnable != null) {
            zzayu.zzeba.removeCallbacks(runnable);
        }
        zzdvo zzdvoVar = zzayu.zzeba;
        zzri zzriVar = new zzri(this);
        this.zzbsx = zzriVar;
        zzdvoVar.postDelayed(zzriVar, this.zzbsy);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbsu = false;
        boolean z = !this.foreground;
        this.foreground = true;
        Runnable runnable = this.zzbsx;
        if (runnable != null) {
            zzayu.zzeba.removeCallbacks(runnable);
        }
        synchronized (this.lock) {
            Iterator<zzrw> it = this.zzbsw.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityResumed(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbbq.zzc("", e2);
                }
            }
            if (z) {
                Iterator<zzrh> it2 = this.zzbsv.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().zzp(true);
                    } catch (Exception e3) {
                        zzbbq.zzc("", e3);
                    }
                }
            } else {
                zzbbq.zzef("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (this.zzzh) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            setActivity((Activity) context);
        }
        this.zzvr = application;
        this.zzbsy = ((Long) zzwm.zzpx().zzd(zzabb.zzcoo)).longValue();
        this.zzzh = true;
    }

    public final void zzb(zzrh zzrhVar) {
        synchronized (this.lock) {
            this.zzbsv.remove(zzrhVar);
        }
    }

    public final void zza(zzrh zzrhVar) {
        synchronized (this.lock) {
            this.zzbsv.add(zzrhVar);
        }
    }

    static /* synthetic */ boolean zza(zzrf zzrfVar, boolean z) {
        zzrfVar.foreground = false;
        return false;
    }
}
