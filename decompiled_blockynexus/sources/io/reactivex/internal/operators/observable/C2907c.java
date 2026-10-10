package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BlockingObservableMostRecent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2907c<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f22367b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c$a */
    /* JADX INFO: compiled from: BlockingObservableMostRecent.java */
    static final class a<T> extends io.reactivex.observers.b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Object f22368b;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BlockingObservableMostRecent.java */
        final class C0200a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Object f22369a;

            C0200a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f22369a = a.this.f22368b;
                return !NotificationLite.isComplete(this.f22369a);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f22369a == null) {
                        this.f22369a = a.this.f22368b;
                    }
                    if (NotificationLite.isComplete(this.f22369a)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.f22369a)) {
                        throw ExceptionHelper.b(NotificationLite.getError(this.f22369a));
                    }
                    T t = (T) this.f22369a;
                    NotificationLite.getValue(t);
                    return t;
                } finally {
                    this.f22369a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t) {
            NotificationLite.next(t);
            this.f22368b = t;
        }

        public a<T>.C0200a b() {
            return new C0200a();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22368b = NotificationLite.complete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22368b = NotificationLite.error(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            NotificationLite.next(t);
            this.f22368b = t;
        }
    }

    public C2907c(io.reactivex.u<T> uVar, T t) {
        this.f22366a = uVar;
        this.f22367b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f22367b);
        this.f22366a.subscribe(aVar);
        return aVar.b();
    }
}
