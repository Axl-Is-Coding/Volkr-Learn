package androidx.arch.core.a;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ArchTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f725b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Executor f726c = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f728e = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f727d = this.f728e;

    private c() {
    }

    public static c b() {
        if (f724a != null) {
            return f724a;
        }
        synchronized (c.class) {
            if (f724a == null) {
                f724a = new c();
            }
        }
        return f724a;
    }

    @Override // androidx.arch.core.a.f
    public void a(Runnable runnable) {
        this.f727d.a(runnable);
    }

    @Override // androidx.arch.core.a.f
    public boolean a() {
        return this.f727d.a();
    }

    @Override // androidx.arch.core.a.f
    public void b(Runnable runnable) {
        this.f727d.b(runnable);
    }
}
