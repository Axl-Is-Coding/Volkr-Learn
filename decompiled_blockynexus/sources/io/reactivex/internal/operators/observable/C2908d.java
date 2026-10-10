package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BlockingObservableNext.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2908d<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22379a;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.d$a */
    /* JADX INFO: compiled from: BlockingObservableNext.java */
    static final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b<T> f22380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.u<T> f22381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private T f22382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f22383d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f22384e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Throwable f22385f;
        private boolean g;

        a(io.reactivex.u<T> uVar, b<T> bVar) {
            this.f22381b = uVar;
            this.f22380a = bVar;
        }

        private boolean a() {
            if (!this.g) {
                this.g = true;
                this.f22380a.b();
                new C2905aa(this.f22381b).subscribe(this.f22380a);
            }
            try {
                io.reactivex.n<T> nVarC = this.f22380a.c();
                if (nVarC.f()) {
                    this.f22384e = false;
                    this.f22382c = nVarC.c();
                    return true;
                }
                this.f22383d = false;
                if (nVarC.d()) {
                    return false;
                }
                this.f22385f = nVarC.b();
                throw ExceptionHelper.b(this.f22385f);
            } catch (InterruptedException e2) {
                this.f22380a.dispose();
                this.f22385f = e2;
                throw ExceptionHelper.b(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f22385f;
            if (th != null) {
                throw ExceptionHelper.b(th);
            }
            if (this.f22383d) {
                return !this.f22384e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f22385f;
            if (th != null) {
                throw ExceptionHelper.b(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f22384e = true;
            return this.f22382c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.d$b */
    /* JADX INFO: compiled from: BlockingObservableNext.java */
    static final class b<T> extends io.reactivex.observers.c<io.reactivex.n<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BlockingQueue<io.reactivex.n<T>> f22386b = new ArrayBlockingQueue(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f22387c = new AtomicInteger();

        b() {
        }

        @Override // io.reactivex.w
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(io.reactivex.n<T> nVar) {
            if (this.f22387c.getAndSet(0) == 1 || !nVar.f()) {
                while (!this.f22386b.offer(nVar)) {
                    io.reactivex.n<T> nVarPoll = this.f22386b.poll();
                    if (nVarPoll != null && !nVarPoll.f()) {
                        nVar = nVarPoll;
                    }
                }
            }
        }

        void b() {
            this.f22387c.set(1);
        }

        public io.reactivex.n<T> c() throws InterruptedException {
            b();
            io.reactivex.internal.util.c.a();
            return this.f22386b.take();
        }

        @Override // io.reactivex.w
        public void onComplete() {
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            io.reactivex.e.a.b(th);
        }
    }

    public C2908d(io.reactivex.u<T> uVar) {
        this.f22379a = uVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f22379a, new b());
    }
}
