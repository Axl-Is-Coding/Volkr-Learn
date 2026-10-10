package com.sandboxol.common.base.app;

import android.app.Activity;
import android.os.Process;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CrashAppManager {
    private static CrashAppManager crashAppManager = new CrashAppManager();
    private Map<Integer, WeakReference<Activity>> activitys = new HashMap();

    public static CrashAppManager getInstance() {
        return crashAppManager;
    }

    public void addActivity(Activity activity) {
        this.activitys.put(Integer.valueOf(activity.hashCode()), new WeakReference<>(activity));
    }

    public void exitProcess() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        removeAll();
        Process.killProcess(Process.myPid());
    }

    public void removeActivity(Activity activity) {
        this.activitys.remove(Integer.valueOf(activity.hashCode()));
    }

    public void removeAll() {
        for (WeakReference<Activity> weakReference : this.activitys.values()) {
            if (weakReference.get() != null) {
                weakReference.get().finish();
            }
        }
        this.activitys.clear();
    }
}
