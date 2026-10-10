package androidx.core.d;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SelfDestructiveThread.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f1102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f1103c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1106f;
    private final int g;
    private final String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1101a = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler.Callback f1105e = new g(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1104d = 0;

    /* JADX INFO: compiled from: SelfDestructiveThread.java */
    public interface a<T> {
        void a(T t);
    }

    public k(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f1106f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.f1101a) {
            if (this.f1102b == null) {
                this.f1102b = new HandlerThread(this.h, this.g);
                this.f1102b.start();
                this.f1103c = new Handler(this.f1102b.getLooper(), this.f1105e);
                this.f1104d++;
            }
            this.f1103c.removeMessages(0);
            this.f1103c.sendMessage(this.f1103c.obtainMessage(1, runnable));
        }
    }

    public <T> void a(Callable<T> callable, a<T> aVar) {
        b(new i(this, callable, new Handler(), aVar));
    }

    public <T> T a(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionNewCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new j(this, atomicReference, callable, reentrantLock, atomicBoolean, conditionNewCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f1101a) {
            this.f1103c.removeMessages(0);
            this.f1103c.sendMessageDelayed(this.f1103c.obtainMessage(0), this.f1106f);
        }
    }

    void a() {
        synchronized (this.f1101a) {
            if (this.f1103c.hasMessages(1)) {
                return;
            }
            this.f1102b.quit();
            this.f1102b = null;
            this.f1103c = null;
        }
    }
}
