package c.t.m.g;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: c.t.m.g.cb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class ThreadFactoryC0417cb implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ C0423eb f3102a;

    ThreadFactoryC0417cb(C0423eb c0423eb) {
        this.f3102a = c0423eb;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "network_request_pool");
    }
}
