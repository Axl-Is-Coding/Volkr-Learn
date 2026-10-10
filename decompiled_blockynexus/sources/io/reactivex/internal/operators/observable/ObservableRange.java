package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRange extends io.reactivex.p<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f22168b;

    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        final io.reactivex.w<? super Integer> downstream;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(io.reactivex.w<? super Integer> wVar, long j, long j2) {
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
            io.reactivex.w<? super Integer> wVar = this.downstream;
            long j = this.end;
            for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                wVar.onNext(Integer.valueOf((int) j2));
            }
            if (get() == 0) {
                lazySet(1);
                wVar.onComplete();
            }
        }

        @Override // io.reactivex.c.a.k
        public Integer poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRange(int i, int i2) {
        this.f22167a = i;
        this.f22168b = ((long) i) + ((long) i2);
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super Integer> wVar) {
        RangeDisposable rangeDisposable = new RangeDisposable(wVar, this.f22167a, this.f22168b);
        wVar.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
