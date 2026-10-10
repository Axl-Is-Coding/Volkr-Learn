package com.ironsource.mediationsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ContextProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f15020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f15021b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f15023d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f15022c = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: ContextProvider.java */
    public interface a {
        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private c() {
    }

    public static c c() {
        if (f15020a == null) {
            synchronized (c.class) {
                if (f15020a == null) {
                    f15020a = new c();
                }
            }
        }
        return f15020a;
    }

    public void a(Activity activity) {
        if (activity != null) {
            Iterator<a> it = this.f15022c.values().iterator();
            while (it.hasNext()) {
                it.next().onPause(activity);
            }
        }
    }

    public void b(Activity activity) {
        if (activity != null) {
            this.f15021b = activity;
            Iterator<a> it = this.f15022c.values().iterator();
            while (it.hasNext()) {
                it.next().onResume(this.f15021b);
            }
        }
    }

    public Context a() {
        return this.f15021b.getApplicationContext();
    }

    public void a(a aVar) {
        this.f15022c.put(aVar.getClass().getSimpleName(), aVar);
    }

    public Activity b() {
        return this.f15021b;
    }

    public void a(Runnable runnable) {
        Handler handler = this.f15023d;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void b(Runnable runnable) {
        Activity activity = this.f15021b;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        }
    }

    public void c(Activity activity) {
        if (activity != null) {
            this.f15021b = activity;
        }
    }
}
