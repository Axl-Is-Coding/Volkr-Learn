package io.reactivex.android.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: HandlerScheduler.java */
/* JADX INFO: loaded from: classes5.dex */
final class c extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f21762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21763c;

    /* JADX INFO: compiled from: HandlerScheduler.java */
    private static final class a extends x.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f21764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f21765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f21766c;

        a(Handler handler, boolean z) {
            this.f21764a = handler;
            this.f21765b = z;
        }

        @Override // io.reactivex.x.c
        @SuppressLint({"NewApi"})
        public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f21766c) {
                return io.reactivex.disposables.c.a();
            }
            b bVar = new b(this.f21764a, io.reactivex.e.a.a(runnable));
            Message messageObtain = Message.obtain(this.f21764a, bVar);
            messageObtain.obj = this;
            if (this.f21765b) {
                messageObtain.setAsynchronous(true);
            }
            this.f21764a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.f21766c) {
                return bVar;
            }
            this.f21764a.removeCallbacks(bVar);
            return io.reactivex.disposables.c.a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f21766c = true;
            this.f21764a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21766c;
        }
    }

    /* JADX INFO: compiled from: HandlerScheduler.java */
    private static final class b implements io.reactivex.disposables.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f21767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f21768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f21769c;

        b(Handler handler, Runnable runnable) {
            this.f21767a = handler;
            this.f21768b = runnable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f21767a.removeCallbacks(this);
            this.f21769c = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21769c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f21768b.run();
            } catch (Throwable th) {
                io.reactivex.e.a.b(th);
            }
        }
    }

    c(Handler handler, boolean z) {
        this.f21762b = handler;
        this.f21763c = z;
    }

    @Override // io.reactivex.x
    @SuppressLint({"NewApi"})
    public io.reactivex.disposables.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        b bVar = new b(this.f21762b, io.reactivex.e.a.a(runnable));
        Message messageObtain = Message.obtain(this.f21762b, bVar);
        if (this.f21763c) {
            messageObtain.setAsynchronous(true);
        }
        this.f21762b.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
        return bVar;
    }

    @Override // io.reactivex.x
    public x.c a() {
        return new a(this.f21762b, this.f21763c);
    }
}
