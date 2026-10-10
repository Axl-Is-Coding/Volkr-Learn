package zlc.season.ironbranch;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: ThreadPools.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f23651a = new AtomicInteger(0);

    a() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        i.b(runnable, "r");
        Thread thread = new Thread(runnable);
        thread.setName("iron_branch_io_" + this.f23651a.getAndIncrement());
        return thread;
    }
}
