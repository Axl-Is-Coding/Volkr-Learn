package io.reactivex.internal.subscriptions;

import f.b.d;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class SubscriptionArbiter extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;
    d actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<d> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public SubscriptionArbiter(boolean z) {
        this.cancelOnReplace = z;
    }

    @Override // f.b.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        d dVar = null;
        long jA = 0;
        int iAddAndGet = 1;
        do {
            d andSet = this.missedSubscription.get();
            if (andSet != null) {
                andSet = this.missedSubscription.getAndSet(null);
            }
            long andSet2 = this.missedRequested.get();
            if (andSet2 != 0) {
                andSet2 = this.missedRequested.getAndSet(0L);
            }
            long andSet3 = this.missedProduced.get();
            if (andSet3 != 0) {
                andSet3 = this.missedProduced.getAndSet(0L);
            }
            d dVar2 = this.actual;
            if (this.cancelled) {
                if (dVar2 != null) {
                    dVar2.cancel();
                    this.actual = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
            } else {
                long jA2 = this.requested;
                if (jA2 != Long.MAX_VALUE) {
                    jA2 = b.a(jA2, andSet2);
                    if (jA2 != Long.MAX_VALUE) {
                        long j = jA2 - andSet3;
                        if (j < 0) {
                            SubscriptionHelper.reportMoreProduced(j);
                            j = 0;
                        }
                        jA2 = j;
                    }
                    this.requested = jA2;
                }
                if (andSet != null) {
                    if (dVar2 != null && this.cancelOnReplace) {
                        dVar2.cancel();
                    }
                    this.actual = andSet;
                    if (jA2 != 0) {
                        jA = b.a(jA, jA2);
                        dVar = andSet;
                    }
                } else if (dVar2 != null && andSet2 != 0) {
                    jA = b.a(jA, andSet2);
                    dVar = dVar2;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jA != 0) {
            dVar.request(jA);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            b.a(this.missedProduced, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            long j4 = 0;
            if (j3 < 0) {
                SubscriptionHelper.reportMoreProduced(j3);
            } else {
                j4 = j3;
            }
            this.requested = j4;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    @Override // f.b.d
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            b.a(this.missedRequested, j);
            drain();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long jA = b.a(j2, j);
            this.requested = jA;
            if (jA == Long.MAX_VALUE) {
                this.unbounded = true;
            }
        }
        d dVar = this.actual;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (dVar != null) {
            dVar.request(j);
        }
    }

    public final void setSubscription(d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        a.a(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            d andSet = this.missedSubscription.getAndSet(dVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            drain();
            return;
        }
        d dVar2 = this.actual;
        if (dVar2 != null && this.cancelOnReplace) {
            dVar2.cancel();
        }
        this.actual = dVar;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j != 0) {
            dVar.request(j);
        }
    }
}
