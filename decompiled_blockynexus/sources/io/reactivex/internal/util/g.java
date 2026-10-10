package io.reactivex.internal.util;

import io.reactivex.w;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: HalfSerializer.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(f.b.c<? super T> cVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = atomicThrowable.terminate();
                if (thTerminate != null) {
                    cVar.onError(thTerminate);
                } else {
                    cVar.onComplete();
                }
            }
        }
    }

    public static void a(f.b.c<?> cVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                cVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        io.reactivex.e.a.b(th);
    }

    public static void a(f.b.c<?> cVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = atomicThrowable.terminate();
            if (thTerminate != null) {
                cVar.onError(thTerminate);
            } else {
                cVar.onComplete();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(w<? super T> wVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            wVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thTerminate = atomicThrowable.terminate();
                if (thTerminate != null) {
                    wVar.onError(thTerminate);
                } else {
                    wVar.onComplete();
                }
            }
        }
    }

    public static void a(w<?> wVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                wVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        io.reactivex.e.a.b(th);
    }

    public static void a(w<?> wVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thTerminate = atomicThrowable.terminate();
            if (thTerminate != null) {
                wVar.onError(thTerminate);
            } else {
                wVar.onComplete();
            }
        }
    }
}
