package androidx.arch.core.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f731a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f732b = Executors.newFixedThreadPool(2, new d(this));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f733c;

    @Override // androidx.arch.core.a.f
    public void a(Runnable runnable) {
        this.f732b.execute(runnable);
    }

    @Override // androidx.arch.core.a.f
    public void b(Runnable runnable) {
        if (this.f733c == null) {
            synchronized (this.f731a) {
                if (this.f733c == null) {
                    this.f733c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f733c.post(runnable);
    }

    @Override // androidx.arch.core.a.f
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
