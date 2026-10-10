package androidx.loader.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ModernAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f1638a = new AtomicInteger(1);

    d() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + this.f1638a.getAndIncrement());
    }
}
