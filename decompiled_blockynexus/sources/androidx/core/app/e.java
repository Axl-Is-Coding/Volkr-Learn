package androidx.core.app;

import android.app.Application;
import androidx.core.app.g;

/* JADX INFO: compiled from: ActivityRecreator.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Application f971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g.a f972b;

    e(Application application, g.a aVar) {
        this.f971a = application;
        this.f972b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f971a.unregisterActivityLifecycleCallbacks(this.f972b);
    }
}
