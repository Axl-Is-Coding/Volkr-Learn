package io.reactivex.internal.schedulers;

import io.reactivex.x;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: NewThreadScheduler.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RxThreadFactory f22681b = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ThreadFactory f22682c;

    public d() {
        this(f22681b);
    }

    @Override // io.reactivex.x
    public x.c a() {
        return new e(this.f22682c);
    }

    public d(ThreadFactory threadFactory) {
        this.f22682c = threadFactory;
    }
}
