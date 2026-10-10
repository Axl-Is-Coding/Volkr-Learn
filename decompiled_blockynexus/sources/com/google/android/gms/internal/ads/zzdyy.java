package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzdyy<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zzhti = new zzdyz();
    private static final Runnable zzhtj = new zzdyz();
    private static final Runnable zzhtk = new zzdyz();

    zzdyy() {
    }

    final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzhtj)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(zzhti) == zzhtk) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T tZzayd;
        Thread threadCurrentThread = Thread.currentThread();
        if (compareAndSet(null, threadCurrentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    tZzayd = zzayd();
                } catch (Throwable th) {
                    if (!compareAndSet(threadCurrentThread, zzhti)) {
                        Runnable runnable = get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != zzhtj && runnable != zzhtk) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = zzhtk;
                                if (runnable == runnable2 || compareAndSet(zzhtj, runnable2)) {
                                    boolean z3 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                    z2 = z3;
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z2) {
                            threadCurrentThread.interrupt();
                        }
                    }
                    if (z) {
                        zzb(null, null);
                    }
                    throw th;
                }
            } else {
                tZzayd = null;
            }
            if (!compareAndSet(threadCurrentThread, zzhti)) {
                Runnable runnable3 = get();
                boolean z4 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != zzhtj && runnable3 != zzhtk) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = zzhtk;
                        if (runnable3 == runnable4 || compareAndSet(zzhtj, runnable4)) {
                            boolean z5 = Thread.interrupted() || z4;
                            LockSupport.park(this);
                            z4 = z5;
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable3 = get();
                }
                if (z4) {
                    threadCurrentThread.interrupt();
                }
            }
            if (z) {
                zzb(tZzayd, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String string;
        Runnable runnable = get();
        if (runnable == zzhti) {
            string = "running=[DONE]";
        } else if (runnable == zzhtj) {
            string = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            string = sb.toString();
        } else {
            string = "running=[NOT STARTED YET]";
        }
        String strZzaye = zzaye();
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 2 + String.valueOf(strZzaye).length());
        sb2.append(string);
        sb2.append(", ");
        sb2.append(strZzaye);
        return sb2.toString();
    }

    abstract T zzayd() throws Exception;

    abstract String zzaye();

    abstract void zzb(T t, Throwable th);
}
