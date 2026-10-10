package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BlockingObservableLatest.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2906b<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22361a;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.b$a */
    /* JADX INFO: compiled from: BlockingObservableLatest.java */
    static final class a<T> extends io.reactivex.observers.c<io.reactivex.n<T>> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.n<T> f22362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Semaphore f22363c = new Semaphore(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<io.reactivex.n<T>> f22364d = new AtomicReference<>();

        a() {
        }

        @Override // io.reactivex.w
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(io.reactivex.n<T> nVar) {
            if (this.f22364d.getAndSet(nVar) == null) {
                this.f22363c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            io.reactivex.n<T> nVar = this.f22362b;
            if (nVar != null && nVar.e()) {
                throw ExceptionHelper.b(this.f22362b.b());
            }
            if (this.f22362b == null) {
                try {
                    io.reactivex.internal.util.c.a();
                    this.f22363c.acquire();
                    io.reactivex.n<T> andSet = this.f22364d.getAndSet(null);
                    this.f22362b = andSet;
                    if (andSet.e()) {
                        throw ExceptionHelper.b(andSet.b());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f22362b = io.reactivex.n.a((Throwable) e2);
                    throw ExceptionHelper.b(e2);
                }
            }
            return this.f22362b.f();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tC = this.f22362b.c();
            this.f22362b = null;
            return tC;
        }

        @Override // io.reactivex.w
        public void onComplete() {
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            io.reactivex.e.a.b(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public C2906b(io.reactivex.u<T> uVar) {
        this.f22361a = uVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        io.reactivex.p.wrap(this.f22361a).materialize().subscribe(aVar);
        return aVar;
    }
}
