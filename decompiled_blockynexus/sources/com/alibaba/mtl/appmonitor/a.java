package com.alibaba.mtl.appmonitor;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;

/* JADX INFO: compiled from: BackgroundTrigger.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {
    private static boolean j;
    private static boolean l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Application f3555b;
    private boolean k = true;

    /* JADX INFO: renamed from: com.alibaba.mtl.appmonitor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BackgroundTrigger.java */
    @TargetApi(14)
    class C0045a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Runnable f38a;

        C0045a(Runnable runnable) {
            this.f38a = runnable;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            s.a().f(4);
            s.a().a(4, this.f38a, 60000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            s.a().f(4);
            s.a().a(4, this.f38a, 60000L);
        }
    }

    public a(Application application) {
        this.f3555b = application;
    }

    private static boolean a(Context context) {
        String strA = com.alibaba.mtl.log.d.b.a(context);
        i.a("BackgroundTrigger", "[checkRuningProcess]:", strA);
        return (TextUtils.isEmpty(strA) || strA.indexOf(":") == -1) ? false : true;
    }

    @TargetApi(14)
    public static void init(Application application) {
        if (j) {
            return;
        }
        i.a("BackgroundTrigger", "init BackgroundTrigger");
        l = a(application.getApplicationContext());
        a aVar = new a(application);
        if (l) {
            s.a().a(4, aVar, 60000L);
        } else if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(aVar.new C0045a(aVar));
        }
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        i.a("BackgroundTrigger", "[bg check]");
        boolean zB = com.alibaba.mtl.log.d.b.b(this.f3555b.getApplicationContext());
        if (this.k != zB) {
            this.k = zB;
            if (zB) {
                j.a().j();
                f[] fVarArrValues = f.values();
                int length = fVarArrValues.length;
                while (i < length) {
                    f fVar = fVarArrValues[i];
                    AppMonitorDelegate.setStatisticsInterval(fVar, fVar.c());
                    i++;
                }
                com.alibaba.mtl.log.a.l();
            } else {
                f[] fVarArrValues2 = f.values();
                int length2 = fVarArrValues2.length;
                while (i < length2) {
                    f fVar2 = fVarArrValues2[i];
                    AppMonitorDelegate.setStatisticsInterval(fVar2, fVar2.d());
                    i++;
                }
                AppMonitorDelegate.triggerUpload();
                com.alibaba.mtl.log.a.k();
            }
        }
        if (l) {
            s.a().a(4, this, 60000L);
        }
    }
}
