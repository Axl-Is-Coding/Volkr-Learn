package androidx.arch.core.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DefaultTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f729a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f730b;

    d(e eVar) {
        this.f730b = eVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f729a.getAndIncrement())));
        return thread;
    }
}
