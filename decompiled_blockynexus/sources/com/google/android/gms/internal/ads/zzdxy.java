package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxq;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzdxy<OutputT> extends zzdxq.zzh<OutputT> {
    private static final Logger zzhrt = Logger.getLogger(zzdxy.class.getName());
    private static final zza zzhsp;
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static abstract class zza {
        private zza() {
        }

        abstract void zza(zzdxy zzdxyVar, Set<Throwable> set, Set<Throwable> set2);

        abstract int zzc(zzdxy zzdxyVar);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzb extends zza {
        private zzb() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdxy.zza
        final void zza(zzdxy zzdxyVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdxyVar) {
                if (zzdxyVar.seenExceptions == null) {
                    zzdxyVar.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdxy.zza
        final int zzc(zzdxy zzdxyVar) {
            int iZzb;
            synchronized (zzdxyVar) {
                iZzb = zzdxy.zzb(zzdxyVar);
            }
            return iZzb;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zzc extends zza {
        private final AtomicReferenceFieldUpdater<zzdxy, Set<Throwable>> zzhst;
        private final AtomicIntegerFieldUpdater<zzdxy> zzhsu;

        zzc(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzhst = atomicReferenceFieldUpdater;
            this.zzhsu = atomicIntegerFieldUpdater;
        }

        @Override // com.google.android.gms.internal.ads.zzdxy.zza
        final void zza(zzdxy zzdxyVar, Set<Throwable> set, Set<Throwable> set2) {
            this.zzhst.compareAndSet(zzdxyVar, null, set2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxy.zza
        final int zzc(zzdxy zzdxyVar) {
            return this.zzhsu.decrementAndGet(zzdxyVar);
        }
    }

    static {
        Throwable th;
        zza zzbVar;
        try {
            zzbVar = new zzc(AtomicReferenceFieldUpdater.newUpdater(zzdxy.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdxy.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzbVar = new zzb();
        }
        zzhsp = zzbVar;
        if (th != null) {
            zzhrt.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzdxy(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int zzb(zzdxy zzdxyVar) {
        int i = zzdxyVar.remaining - 1;
        zzdxyVar.remaining = i;
        return i;
    }

    final Set<Throwable> zzaya() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzh(setNewSetFromMap);
        zzhsp.zza(this, null, setNewSetFromMap);
        return this.seenExceptions;
    }

    final int zzayb() {
        return zzhsp.zzc(this);
    }

    final void zzayc() {
        this.seenExceptions = null;
    }

    abstract void zzh(Set<Throwable> set);
}
