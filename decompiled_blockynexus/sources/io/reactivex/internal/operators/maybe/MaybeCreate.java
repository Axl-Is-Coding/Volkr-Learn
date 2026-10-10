package io.reactivex.internal.operators.maybe;

import io.reactivex.b.f;
import io.reactivex.i;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;
import io.reactivex.l;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeCreate<T> extends i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final l<T> f21934a;

    static final class Emitter<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2467358622224974244L;
        final k<? super T> downstream;

        Emitter(k<? super T> kVar) {
            this.downstream = kVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        public void onComplete() {
            io.reactivex.disposables.b andSet;
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // io.reactivex.j
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.e.a.b(th);
        }

        @Override // io.reactivex.j
        public void onSuccess(T t) {
            io.reactivex.disposables.b andSet;
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                if (t == null) {
                    this.downstream.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.downstream.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
            }
        }

        public void setCancellable(f fVar) {
            setDisposable(new CancellableDisposable(fVar));
        }

        public void setDisposable(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", Emitter.class.getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th) {
            io.reactivex.disposables.b andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
                return false;
            }
            try {
                this.downstream.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    public MaybeCreate(l<T> lVar) {
        this.f21934a = lVar;
    }

    @Override // io.reactivex.i
    protected void b(k<? super T> kVar) {
        Emitter emitter = new Emitter(kVar);
        kVar.onSubscribe(emitter);
        try {
            this.f21934a.a(emitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            emitter.onError(th);
        }
    }
}
