package com.bytedance.sdk.openadsdk.i;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: TTThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f6994a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadGroup f6995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f6996c = new AtomicInteger(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6998e;

    c(int i, String str) {
        this.f6998e = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.f6995b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (TextUtils.isEmpty(str)) {
            this.f6997d = "ttbackground-" + f6994a.getAndIncrement() + "-thread-";
            return;
        }
        this.f6997d = str + f6994a.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f6995b, runnable, this.f6997d + this.f6996c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.f6998e == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
