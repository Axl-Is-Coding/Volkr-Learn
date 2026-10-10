package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
final class g {
    private static final Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Class<?> f975a = a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Field f976b = b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f977c = c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Method f978d = b(f975a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f979e = a(f975a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f980f = c(f975a);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ActivityRecreator.java */
    static final class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Activity f982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f983c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f984d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f985e = false;

        a(Activity activity) {
            this.f982b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f982b == activity) {
                this.f982b = null;
                this.f984d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f984d || this.f985e || this.f983c || !g.a(this.f981a, activity)) {
                return;
            }
            this.f985e = true;
            this.f981a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f982b == activity) {
                this.f983c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static boolean a(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (d() && f980f == null) {
            return false;
        }
        if (f979e == null && f978d == null) {
            return false;
        }
        try {
            Object obj2 = f977c.get(activity);
            if (obj2 == null || (obj = f976b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            a aVar = new a(activity);
            application.registerActivityLifecycleCallbacks(aVar);
            g.post(new d(aVar, obj2));
            try {
                if (d()) {
                    f980f.invoke(obj, obj2, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                g.post(new e(application, aVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (d() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    protected static boolean a(Object obj, Activity activity) {
        try {
            Object obj2 = f977c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            g.postAtFrontOfQueue(new f(f976b.get(activity), obj2));
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
