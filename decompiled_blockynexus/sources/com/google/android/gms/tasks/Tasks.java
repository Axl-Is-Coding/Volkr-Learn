package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class Tasks {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    interface zza extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    private static final class zzb implements zza {
        private final CountDownLatch zza;

        private zzb() {
            this.zza = new CountDownLatch(1);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            this.zza.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.zza.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            this.zza.countDown();
        }

        public final void zza() throws InterruptedException {
            this.zza.await();
        }

        public final boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zza.await(j, timeUnit);
        }

        /* synthetic */ zzb(zzy zzyVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    private static final class zzc implements zza {
        private final Object zza = new Object();
        private final int zzb;
        private final zzu<Void> zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private Exception zzg;
        private boolean zzh;

        public zzc(int i, zzu<Void> zzuVar) {
            this.zzb = i;
            this.zzc = zzuVar;
        }

        private final void zza() {
            int i = this.zzd;
            int i2 = this.zze;
            int i3 = i + i2 + this.zzf;
            int i4 = this.zzb;
            if (i3 == i4) {
                if (this.zzg == null) {
                    if (this.zzh) {
                        this.zzc.zza();
                        return;
                    } else {
                        this.zzc.zza((Void) null);
                        return;
                    }
                }
                zzu<Void> zzuVar = this.zzc;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i2);
                sb.append(" out of ");
                sb.append(i4);
                sb.append(" underlying tasks failed");
                zzuVar.zza(new ExecutionException(sb.toString(), this.zzg));
            }
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            synchronized (this.zza) {
                this.zzf++;
                this.zzh = true;
                zza();
            }
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            synchronized (this.zza) {
                this.zze++;
                this.zzg = exc;
                zza();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            synchronized (this.zza) {
                this.zzd++;
                zza();
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) zza(task);
        }
        zzb zzbVar = new zzb(null);
        zza(task, zzbVar);
        zzbVar.zza();
        return (TResult) zza(task);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> forCanceled() {
        zzu zzuVar = new zzu();
        zzuVar.zza();
        return zzuVar;
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        zzu zzuVar = new zzu();
        zzuVar.zza(exc);
        return zzuVar;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzu zzuVar = new zzu();
        zzuVar.zza(tresult);
        return zzuVar;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzu zzuVar = new zzu();
        zzc zzcVar = new zzc(collection.size(), zzuVar);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            zza(it2.next(), zzcVar);
        }
        return zzuVar;
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        return (collection == null || collection.isEmpty()) ? forResult(Collections.emptyList()) : whenAll(collection).continueWithTask(new zzz(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        return (collection == null || collection.isEmpty()) ? forResult(Collections.emptyList()) : (Task<List<TResult>>) whenAll(collection).continueWith(new zzaa(collection));
    }

    private static <TResult> TResult zza(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzuVar = new zzu();
        executor.execute(new zzy(zzuVar, callable));
        return zzuVar;
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAllComplete(Arrays.asList(taskArr));
        }
        return forResult(Collections.emptyList());
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAllSuccess(Arrays.asList(taskArr));
        }
        return forResult(Collections.emptyList());
    }

    private static void zza(Task<?> task, zza zzaVar) {
        task.addOnSuccessListener(TaskExecutors.zza, zzaVar);
        task.addOnFailureListener(TaskExecutors.zza, zzaVar);
        task.addOnCanceledListener(TaskExecutors.zza, zzaVar);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) zza(task);
        }
        zzb zzbVar = new zzb(null);
        zza(task, zzbVar);
        if (zzbVar.zza(j, timeUnit)) {
            return (TResult) zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        if (taskArr != null && taskArr.length != 0) {
            return whenAll(Arrays.asList(taskArr));
        }
        return forResult(null);
    }
}
