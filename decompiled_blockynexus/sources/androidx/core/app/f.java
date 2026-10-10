package androidx.core.app;

import android.util.Log;

/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f974b;

    f(Object obj, Object obj2) {
        this.f973a = obj;
        this.f974b = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (g.f978d != null) {
                g.f978d.invoke(this.f973a, this.f974b, false, "AppCompat recreation");
            } else {
                g.f979e.invoke(this.f973a, this.f974b, false);
            }
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
