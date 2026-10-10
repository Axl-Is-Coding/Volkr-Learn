package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f20528a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f20529b = false;

    c() {
    }

    private void a(Activity activity, int i) {
        if (1 == i) {
            String unused = b.ac = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.ac = "";
        }
        b.A();
        if (g.J()) {
            b.L();
            synchronized (b.aa) {
                b.aa.put(activity, Integer.valueOf(i));
                a(i);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (g.J()) {
            b.L();
            synchronized (b.aa) {
                b.aa.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    private void a(int i) {
        if (e.t()) {
            com.uc.crashsdk.a.a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z = 1 == i;
        if (!z) {
            Iterator it = b.aa.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object value = ((Map.Entry) it.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    z = true;
                    break;
                }
            }
        }
        if (this.f20528a != z) {
            b.b(z);
            this.f20528a = z;
        }
        boolean zIsEmpty = b.aa.isEmpty();
        if (this.f20529b != zIsEmpty) {
            if (zIsEmpty) {
                b.t();
            }
            this.f20529b = zIsEmpty;
        }
    }
}
