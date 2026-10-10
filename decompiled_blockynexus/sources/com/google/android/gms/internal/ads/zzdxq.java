package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzdxq<V> extends zzdzt implements zzdzc<V> {
    private static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final Logger zzhrt;
    private static final zzb zzhru;
    private volatile zze listeners;
    private volatile Object value;
    private volatile zzk waiters;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zza {
        static final zza zzhrv;
        static final zza zzhrw;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (zzdxq.GENERATE_CANCELLATION_CAUSES) {
                zzhrw = null;
                zzhrv = null;
            } else {
                zzhrw = new zza(false, null);
                zzhrv = new zza(true, null);
            }
        }

        zza(boolean z, Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static abstract class zzb {
        private zzb() {
        }

        abstract void zza(zzk zzkVar, zzk zzkVar2);

        abstract void zza(zzk zzkVar, Thread thread);

        abstract boolean zza(zzdxq<?> zzdxqVar, zze zzeVar, zze zzeVar2);

        abstract boolean zza(zzdxq<?> zzdxqVar, zzk zzkVar, zzk zzkVar2);

        abstract boolean zza(zzdxq<?> zzdxqVar, Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzc {
        static final zzc zzhrx = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzdxq.zzc.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        zzc(Throwable th) {
            zzdwd.checkNotNull(th);
            this.exception = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzd extends zzb {
        final AtomicReferenceFieldUpdater<zzdxq, zze> listenersUpdater;
        final AtomicReferenceFieldUpdater<zzdxq, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<zzdxq, zzk> waitersUpdater;

        zzd(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdxq, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdxq, zze> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdxq, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final void zza(zzk zzkVar, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            this.waiterNextUpdater.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, zzk zzkVar, zzk zzkVar2) {
            return this.waitersUpdater.compareAndSet(zzdxqVar, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, zze zzeVar, zze zzeVar2) {
            return this.listenersUpdater.compareAndSet(zzdxqVar, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzdxqVar, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zze {
        static final zze zzhry = new zze(null, null);
        final Executor executor;
        zze next;
        final Runnable task;

        zze(Runnable runnable, Executor executor) {
            this.task = runnable;
            this.executor = executor;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzf extends zzb {
        private zzf() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final void zza(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzdxqVar) {
                if (((zzdxq) zzdxqVar).waiters != zzkVar) {
                    return false;
                }
                ((zzdxq) zzdxqVar).waiters = zzkVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzdxqVar) {
                if (((zzdxq) zzdxqVar).listeners != zzeVar) {
                    return false;
                }
                ((zzdxq) zzdxqVar).listeners = zzeVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, Object obj, Object obj2) {
            synchronized (zzdxqVar) {
                if (((zzdxq) zzdxqVar).value != obj) {
                    return false;
                }
                ((zzdxq) zzdxqVar).value = obj2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzg<V> implements Runnable {
        final zzdzc<? extends V> future;
        final zzdxq<V> zzhrz;

        zzg(zzdxq<V> zzdxqVar, zzdzc<? extends V> zzdzcVar) {
            this.zzhrz = zzdxqVar;
            this.future = zzdzcVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzdxq) this.zzhrz).value != this) {
                return;
            }
            if (zzdxq.zzhru.zza((zzdxq<?>) this.zzhrz, (Object) this, zzdxq.getFutureValue(this.future))) {
                zzdxq.zza((zzdxq<?>) this.zzhrz);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static abstract class zzh<V> extends zzdxq<V> implements zzi<V> {
        zzh() {
        }

        @Override // com.google.android.gms.internal.ads.zzdxq, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    interface zzi<V> extends zzdzc<V> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzj extends zzb {
        static final Unsafe zzhsa;
        static final long zzhsb;
        static final long zzhsc;
        static final long zzhsd;
        static final long zzhse;
        static final long zzhsf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzdxq.zzj.1
                    @Override // java.security.PrivilegedExceptionAction
                    public /* synthetic */ Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                zzhsc = unsafe.objectFieldOffset(zzdxq.class.getDeclaredField("waiters"));
                zzhsb = unsafe.objectFieldOffset(zzdxq.class.getDeclaredField("listeners"));
                zzhsd = unsafe.objectFieldOffset(zzdxq.class.getDeclaredField("value"));
                zzhse = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzhsf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zzhsa = unsafe;
            } catch (Exception e3) {
                zzdwh.zzi(e3);
                throw new RuntimeException(e3);
            }
        }

        private zzj() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final void zza(zzk zzkVar, Thread thread) {
            zzhsa.putObject(zzkVar, zzhse, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            zzhsa.putObject(zzkVar, zzhsf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, zzk zzkVar, zzk zzkVar2) {
            return zzhsa.compareAndSwapObject(zzdxqVar, zzhsc, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, zze zzeVar, zze zzeVar2) {
            return zzhsa.compareAndSwapObject(zzdxqVar, zzhsb, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxq.zzb
        final boolean zza(zzdxq<?> zzdxqVar, Object obj, Object obj2) {
            return zzhsa.compareAndSwapObject(zzdxqVar, zzhsd, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzk {
        static final zzk zzhsg = new zzk(false);
        volatile zzk next;
        volatile Thread thread;

        private zzk(boolean z) {
        }

        final void zzb(zzk zzkVar) {
            zzdxq.zzhru.zza(this, zzkVar);
        }

        zzk() {
            zzdxq.zzhru.zza(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zzb zzfVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        zzhrt = Logger.getLogger(zzdxq.class.getName());
        try {
            zzfVar = new zzj();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            try {
                th2 = null;
                th = th3;
                zzfVar = new zzd(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzdxq.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzdxq.class, zze.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzdxq.class, Object.class, "value"));
            } catch (Throwable th4) {
                th = th3;
                th2 = th4;
                zzfVar = new zzf();
            }
        }
        zzhru = zzfVar;
        if (th2 != null) {
            zzhrt.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            zzhrt.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        NULL = new Object();
    }

    protected zzdxq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object getFutureValue(zzdzc<?> zzdzcVar) {
        Throwable thZza;
        if (zzdzcVar instanceof zzi) {
            Object obj = ((zzdxq) zzdzcVar).value;
            if (!(obj instanceof zza)) {
                return obj;
            }
            zza zzaVar = (zza) obj;
            if (!zzaVar.wasInterrupted) {
                return obj;
            }
            Throwable th = zzaVar.cause;
            return th != null ? new zza(false, th) : zza.zzhrw;
        }
        if ((zzdzcVar instanceof zzdzt) && (thZza = zzdzw.zza((zzdzt) zzdzcVar)) != null) {
            return new zzc(thZza);
        }
        boolean zIsCancelled = zzdzcVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            return zza.zzhrw;
        }
        try {
            Object uninterruptibly = getUninterruptibly(zzdzcVar);
            if (!zIsCancelled) {
                return uninterruptibly == null ? NULL : uninterruptibly;
            }
            String strValueOf = String.valueOf(zzdzcVar);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(strValueOf);
            return new zza(false, new IllegalArgumentException(sb.toString()));
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new zza(false, e2);
            }
            String strValueOf2 = String.valueOf(zzdzcVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 77);
            sb2.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
            sb2.append(strValueOf2);
            return new zzc(new IllegalArgumentException(sb2.toString(), e2));
        } catch (ExecutionException e3) {
            if (!zIsCancelled) {
                return new zzc(e3.getCause());
            }
            String strValueOf3 = String.valueOf(zzdzcVar);
            StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf3).length() + 84);
            sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb3.append(strValueOf3);
            return new zza(false, new IllegalArgumentException(sb3.toString(), e3));
        } catch (Throwable th2) {
            return new zzc(th2);
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private final void zza(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 == zzk.zzhsg) {
                return;
            }
            zzk zzkVar3 = null;
            while (zzkVar2 != null) {
                zzk zzkVar4 = zzkVar2.next;
                if (zzkVar2.thread != null) {
                    zzkVar3 = zzkVar2;
                } else if (zzkVar3 != null) {
                    zzkVar3.next = zzkVar4;
                    if (zzkVar3.thread == null) {
                        break;
                    }
                } else if (zzhru.zza((zzdxq<?>) this, zzkVar2, zzkVar4)) {
                }
                zzkVar2 = zzkVar4;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static V zzae(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).exception);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzdzc
    public void addListener(Runnable runnable, Executor executor) {
        zze zzeVar;
        zzdwd.checkNotNull(runnable, "Runnable was null.");
        zzdwd.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (zzeVar = this.listeners) != zze.zzhry) {
            zze zzeVar2 = new zze(runnable, executor);
            do {
                zzeVar2.next = zzeVar;
                if (zzhru.zza((zzdxq<?>) this, zzeVar, zzeVar2)) {
                    return;
                } else {
                    zzeVar = this.listeners;
                }
            } while (zzeVar != zze.zzhry);
        }
        zza(runnable, executor);
    }

    protected void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zzg)) {
            return false;
        }
        zza zzaVar = GENERATE_CANCELLATION_CAUSES ? new zza(z, new CancellationException("Future.cancel() was called.")) : z ? zza.zzhrv : zza.zzhrw;
        boolean z2 = false;
        Object obj2 = obj;
        zzdxq<V> zzdxqVar = this;
        while (true) {
            if (zzhru.zza((zzdxq<?>) zzdxqVar, obj2, (Object) zzaVar)) {
                if (z) {
                    zzdxqVar.interruptTask();
                }
                zza((zzdxq<?>) zzdxqVar);
                if (!(obj2 instanceof zzg)) {
                    return true;
                }
                zzdzc<? extends V> zzdzcVar = ((zzg) obj2).future;
                if (!(zzdzcVar instanceof zzi)) {
                    zzdzcVar.cancel(z);
                    return true;
                }
                zzdxqVar = (zzdxq) zzdzcVar;
                obj2 = zzdxqVar.value;
                if (!(obj2 == null) && !(obj2 instanceof zzg)) {
                    return true;
                }
                z2 = true;
            } else {
                obj2 = zzdxqVar.value;
                if (!(obj2 instanceof zzg)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof zzg))) {
            return (V) zzae(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zzk zzkVar = this.waiters;
            if (zzkVar != zzk.zzhsg) {
                zzk zzkVar2 = new zzk();
                do {
                    zzkVar2.zzb(zzkVar);
                    if (zzhru.zza((zzdxq<?>) this, zzkVar, zzkVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                zza(zzkVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof zzg))) {
                                return (V) zzae(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzkVar2);
                    } else {
                        zzkVar = this.waiters;
                    }
                } while (zzkVar != zzk.zzhsg);
            }
            return (V) zzae(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof zzg))) {
                return (V) zzae(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
        sb.append("Waited ");
        sb.append(j);
        sb.append(" ");
        sb.append(lowerCase2);
        String string2 = sb.toString();
        if (nanos + 1000 < 0) {
            String strConcat = String.valueOf(string2).concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strValueOf = String.valueOf(strConcat);
                StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 21 + String.valueOf(lowerCase).length());
                sb2.append(strValueOf);
                sb2.append(jConvert);
                sb2.append(" ");
                sb2.append(lowerCase);
                String string3 = sb2.toString();
                if (z) {
                    string3 = String.valueOf(string3).concat(",");
                }
                strConcat = String.valueOf(string3).concat(" ");
            }
            if (z) {
                String strValueOf2 = String.valueOf(strConcat);
                StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf2).length() + 33);
                sb3.append(strValueOf2);
                sb3.append(nanos2);
                sb3.append(" nanoseconds ");
                strConcat = sb3.toString();
            }
            string2 = String.valueOf(strConcat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(string2).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb4 = new StringBuilder(String.valueOf(string2).length() + 5 + String.valueOf(string).length());
        sb4.append(string2);
        sb4.append(" for ");
        sb4.append(string);
        throw new TimeoutException(sb4.toString());
    }

    protected void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (obj != null) & (obj instanceof zzg ? false : true);
    }

    final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected boolean set(V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (!zzhru.zza((zzdxq<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        zza((zzdxq<?>) this);
        return true;
    }

    protected boolean setException(Throwable th) {
        zzdwd.checkNotNull(th);
        if (!zzhru.zza((zzdxq<?>) this, (Object) null, (Object) new zzc(th))) {
            return false;
        }
        zza((zzdxq<?>) this);
        return true;
    }

    protected final boolean setFuture(zzdzc<? extends V> zzdzcVar) {
        zzc zzcVar;
        zzdwd.checkNotNull(zzdzcVar);
        Object obj = this.value;
        if (obj == null) {
            if (zzdzcVar.isDone()) {
                if (!zzhru.zza((zzdxq<?>) this, (Object) null, getFutureValue(zzdzcVar))) {
                    return false;
                }
                zza((zzdxq<?>) this);
                return true;
            }
            zzg zzgVar = new zzg(this, zzdzcVar);
            if (zzhru.zza((zzdxq<?>) this, (Object) null, (Object) zzgVar)) {
                try {
                    zzdzcVar.addListener(zzgVar, zzdyj.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Throwable unused) {
                        zzcVar = zzc.zzhrx;
                    }
                    zzhru.zza((zzdxq<?>) this, (Object) zzgVar, (Object) zzcVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zza) {
            zzdzcVar.cancel(((zza) obj).wasInterrupted);
        }
        return false;
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zza(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.value;
            if (obj instanceof zzg) {
                sb.append(", setFuture=[");
                zza(sb, ((zzg) obj).future);
                sb.append("]");
            } else {
                try {
                    string = zzdwf.emptyToNull(pendingToString());
                } catch (RuntimeException | StackOverflowError e2) {
                    String strValueOf = String.valueOf(e2.getClass());
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 38);
                    sb2.append("Exception thrown from implementation: ");
                    sb2.append(strValueOf);
                    string = sb2.toString();
                }
                if (string != null) {
                    sb.append(", info=[");
                    sb.append(string);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zza(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zza) && ((zza) obj).wasInterrupted;
    }

    @Override // com.google.android.gms.internal.ads.zzdzt
    protected final Throwable zzaxv() {
        if (!(this instanceof zzi)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).exception;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void zza(zzdxq<?> zzdxqVar) {
        zze zzeVar;
        zze zzeVar2;
        zze zzeVar3 = null;
        while (true) {
            zzk zzkVar = ((zzdxq) zzdxqVar).waiters;
            if (zzhru.zza(zzdxqVar, zzkVar, zzk.zzhsg)) {
                while (zzkVar != null) {
                    Thread thread = zzkVar.thread;
                    if (thread != null) {
                        zzkVar.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzkVar = zzkVar.next;
                }
                zzdxqVar.afterDone();
                do {
                    zzeVar = ((zzdxq) zzdxqVar).listeners;
                } while (!zzhru.zza(zzdxqVar, zzeVar, zze.zzhry));
                while (true) {
                    zzeVar2 = zzeVar3;
                    zzeVar3 = zzeVar;
                    if (zzeVar3 == null) {
                        break;
                    }
                    zzeVar = zzeVar3.next;
                    zzeVar3.next = zzeVar2;
                }
                while (zzeVar2 != null) {
                    zzeVar3 = zzeVar2.next;
                    Runnable runnable = zzeVar2.task;
                    if (runnable instanceof zzg) {
                        zzg zzgVar = (zzg) runnable;
                        zzdxqVar = zzgVar.zzhrz;
                        if (((zzdxq) zzdxqVar).value == zzgVar) {
                            if (!zzhru.zza((zzdxq<?>) zzdxqVar, (Object) zzgVar, getFutureValue(zzgVar.future))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zza(runnable, zzeVar2.executor);
                    }
                    zzeVar2 = zzeVar3;
                }
                return;
            }
        }
    }

    private final void zza(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            zza(sb, uninterruptibly);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private final void zza(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e2) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e2.getClass());
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = zzhrt;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 57 + String.valueOf(strValueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof zzg))) {
                return (V) zzae(obj2);
            }
            zzk zzkVar = this.waiters;
            if (zzkVar != zzk.zzhsg) {
                zzk zzkVar2 = new zzk();
                do {
                    zzkVar2.zzb(zzkVar);
                    if (zzhru.zza((zzdxq<?>) this, zzkVar, zzkVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzkVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzg))));
                        return (V) zzae(obj);
                    }
                    zzkVar = this.waiters;
                } while (zzkVar != zzk.zzhsg);
            }
            return (V) zzae(this.value);
        }
        throw new InterruptedException();
    }
}
