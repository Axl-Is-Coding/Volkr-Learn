package com.alibaba.mtl.log.d;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.appmonitor.AppMonitor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: TaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class s {
    private static int G = 1;
    private static int H = 3;
    private static int I = 10;
    private static int J = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s f3644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f67a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f3645f = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f3646b = new HandlerThread(AppMonitor.TAG);
    private Handler mHandler;

    /* JADX INFO: compiled from: TaskExecutor.java */
    static class a implements ThreadFactory {
        private int priority;

        public a(int i) {
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppMonitor:" + s.f3645f.getAndIncrement());
            thread.setPriority(this.priority);
            return thread;
        }
    }

    private s() {
        this.f3646b.start();
        this.mHandler = new Handler(this.f3646b.getLooper()) { // from class: com.alibaba.mtl.log.d.s.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    if (message.obj == null || !(message.obj instanceof Runnable)) {
                        return;
                    }
                    s.m26a().submit((Runnable) message.obj);
                } catch (Throwable unused) {
                }
            }
        };
    }

    public final void f(int i) {
        this.mHandler.removeMessages(i);
    }

    @TargetApi(9)
    private static ThreadPoolExecutor a(int i, int i2, int i3, int i4, int i5) {
        return new ThreadPoolExecutor(i2, i3, i4, TimeUnit.SECONDS, i5 > 0 ? new LinkedBlockingQueue(i5) : new LinkedBlockingQueue(), new a(i), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public final boolean b(int i) {
        return this.mHandler.hasMessages(i);
    }

    public void b(Runnable runnable) {
        try {
            m26a().submit(runnable);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized ThreadPoolExecutor m26a() {
        if (f67a == null) {
            f67a = a(G, H, I, J, 500);
        }
        return f67a;
    }

    public static synchronized s a() {
        if (f3644a == null) {
            f3644a = new s();
        }
        return f3644a;
    }

    public final void a(int i, Runnable runnable, long j) {
        try {
            Message messageObtain = Message.obtain(this.mHandler, i);
            messageObtain.obj = runnable;
            this.mHandler.sendMessageDelayed(messageObtain, j);
        } catch (Exception e2) {
            com.alibaba.mtl.appmonitor.b.b.m17a((Throwable) e2);
        }
    }
}
