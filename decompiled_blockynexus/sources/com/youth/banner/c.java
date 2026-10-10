package com.youth.banner;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: WeakHandler.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Lock f21406c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final a f21407d = new a(this.f21406c, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler.Callback f21404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f21405b = new b();

    /* JADX INFO: compiled from: WeakHandler.java */
    private static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<Handler.Callback> f21413a = null;

        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler.Callback callback;
            WeakReference<Handler.Callback> weakReference = this.f21413a;
            if (weakReference == null || (callback = weakReference.get()) == null) {
                return;
            }
            callback.handleMessage(message);
        }
    }

    /* JADX INFO: renamed from: com.youth.banner.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WeakHandler.java */
    static class RunnableC0191c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<Runnable> f21414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference<a> f21415b;

        RunnableC0191c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.f21414a = weakReference;
            this.f21415b = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f21414a.get();
            a aVar = this.f21415b.get();
            if (aVar != null) {
                aVar.a();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private RunnableC0191c c(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        a aVar = new a(this.f21406c, runnable);
        this.f21407d.a(aVar);
        return aVar.f21411d;
    }

    public final boolean a(Runnable runnable) {
        return this.f21405b.post(c(runnable));
    }

    public final void b(Runnable runnable) {
        RunnableC0191c runnableC0191cA = this.f21407d.a(runnable);
        if (runnableC0191cA != null) {
            this.f21405b.removeCallbacks(runnableC0191cA);
        }
    }

    public final boolean a(Runnable runnable, long j) {
        return this.f21405b.postDelayed(c(runnable), j);
    }

    public final void a(Object obj) {
        this.f21405b.removeCallbacksAndMessages(obj);
    }

    /* JADX INFO: compiled from: WeakHandler.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f21408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f21409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Runnable f21410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final RunnableC0191c f21411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Lock f21412e;

        public a(Lock lock, Runnable runnable) {
            this.f21410c = runnable;
            this.f21412e = lock;
            this.f21411d = new RunnableC0191c(new WeakReference(runnable), new WeakReference(this));
        }

        public RunnableC0191c a() {
            this.f21412e.lock();
            try {
                if (this.f21409b != null) {
                    this.f21409b.f21408a = this.f21408a;
                }
                if (this.f21408a != null) {
                    this.f21408a.f21409b = this.f21409b;
                }
                this.f21409b = null;
                this.f21408a = null;
                this.f21412e.unlock();
                return this.f21411d;
            } catch (Throwable th) {
                this.f21412e.unlock();
                throw th;
            }
        }

        public void a(a aVar) {
            this.f21412e.lock();
            try {
                if (this.f21408a != null) {
                    this.f21408a.f21409b = aVar;
                }
                aVar.f21408a = this.f21408a;
                this.f21408a = aVar;
                aVar.f21409b = this;
            } finally {
                this.f21412e.unlock();
            }
        }

        public RunnableC0191c a(Runnable runnable) {
            this.f21412e.lock();
            try {
                for (a aVar = this.f21408a; aVar != null; aVar = aVar.f21408a) {
                    if (aVar.f21410c == runnable) {
                        return aVar.a();
                    }
                }
                this.f21412e.unlock();
                return null;
            } finally {
                this.f21412e.unlock();
            }
        }
    }
}
