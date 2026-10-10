package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRangeLong extends io.reactivex.p<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f22169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f22170b;

    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final io.reactivex.w<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(io.reactivex.w<? super Long> wVar, long j, long j2) {
            this.downstream = wVar;
            this.index = j;
            this.end = j2;
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        void run() {
            if (this.fused) {
                return;
            }
            io.reactivex.w<? super Long> wVar = this.downstream;
            long j = this.end;
            for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                wVar.onNext(Long.valueOf(j2));
            }
            if (get() == 0) {
                lazySet(1);
                wVar.onComplete();
            }
        }

        @Override // io.reactivex.c.a.k
        public Long poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j, long j2) {
        this.f22169a = j;
        this.f22170b = j2;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super Long> wVar) {
        long j = this.f22169a;
        RangeDisposable rangeDisposable = new RangeDisposable(wVar, j, j + this.f22170b);
        wVar.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
