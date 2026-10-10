package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ActivityLifecycleListener.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7081a = "pangle_event_timer_ten_min";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f7082b = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f7083c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashSet<Integer> f7084d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7085e = 0;

    public boolean a() {
        return this.f7083c.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.f7084d.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f7084d.add(Integer.valueOf(activity.hashCode()));
        if (this.f7085e == 0) {
            this.f7085e = SystemClock.elapsedRealtime();
        } else if (SystemClock.elapsedRealtime() - this.f7085e > 300000) {
            this.f7085e = SystemClock.elapsedRealtime();
            androidx.localbroadcastmanager.a.b.a(activity.getApplicationContext()).a(new Intent(f7081a));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.f7082b.incrementAndGet() > 0) {
            this.f7083c.set(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.f7082b.decrementAndGet() == 0) {
            this.f7083c.set(true);
        }
    }
}
