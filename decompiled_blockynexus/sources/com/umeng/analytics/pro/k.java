package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackgroundMonitor.java */
/* JADX INFO: loaded from: classes5.dex */
public class k implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f20886a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20887b = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20888c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20889d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f20890e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<l> f20891f = new ArrayList<>();
    private a g = new a();

    /* JADX INFO: compiled from: BackgroundMonitor.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!k.this.f20888c || !k.this.f20889d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            k.this.f20888c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i = 0; i < k.this.f20891f.size(); i++) {
                ((l) k.this.f20891f.get(i)).n();
            }
        }
    }

    private k() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f20889d = true;
        a aVar = this.g;
        if (aVar != null) {
            this.f20890e.removeCallbacks(aVar);
            this.f20890e.postDelayed(this.g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f20889d = false;
        this.f20888c = true;
        a aVar = this.g;
        if (aVar != null) {
            this.f20890e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(l lVar) {
        if (lVar != null) {
            for (int i = 0; i < this.f20891f.size(); i++) {
                if (this.f20891f.get(i) == lVar) {
                    this.f20891f.remove(i);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f20886a);
        }
    }

    public static k a() {
        return f20886a;
    }

    public synchronized void a(l lVar) {
        if (lVar != null) {
            this.f20891f.add(lVar);
        }
    }
}
