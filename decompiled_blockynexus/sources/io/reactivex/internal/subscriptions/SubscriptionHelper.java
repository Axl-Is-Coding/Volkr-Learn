package io.reactivex.internal.subscriptions;

import f.b.d;
import io.reactivex.e.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public enum SubscriptionHelper implements d {
    CANCELLED;

    public static boolean cancel(AtomicReference<d> atomicReference) {
        d andSet;
        d dVar = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (dVar == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == CANCELLED) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void deferredRequest(AtomicReference<d> atomicReference, AtomicLong atomicLong, long j) {
        d dVar = atomicReference.get();
        if (dVar != null) {
            dVar.request(j);
            return;
        }
        if (validate(j)) {
            b.a(atomicLong, j);
            d dVar2 = atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<d> atomicReference, AtomicLong atomicLong, d dVar) {
        if (!setOnce(atomicReference, dVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        dVar.request(andSet);
        return true;
    }

    public static boolean replace(AtomicReference<d> atomicReference, d dVar) {
        d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        return true;
    }

    public static void reportMoreProduced(long j) {
        a.b(new ProtocolViolationException("More produced than requested: " + j));
    }

    public static void reportSubscriptionSet() {
        a.b(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<d> atomicReference, d dVar) {
        d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<d> atomicReference, d dVar) {
        io.reactivex.internal.functions.a.a(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean validate(d dVar, d dVar2) {
        if (dVar2 == null) {
            a.b(new NullPointerException("next is null"));
            return false;
        }
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // f.b.d
    public void cancel() {
    }

    @Override // f.b.d
    public void request(long j) {
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        a.b(new IllegalArgumentException("n > 0 required but it was " + j));
        return false;
    }

    public static boolean setOnce(AtomicReference<d> atomicReference, d dVar, long j) {
        if (!setOnce(atomicReference, dVar)) {
            return false;
        }
        dVar.request(j);
        return true;
    }
}
