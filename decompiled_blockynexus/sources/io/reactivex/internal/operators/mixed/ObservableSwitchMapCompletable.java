package io.reactivex.internal.operators.mixed;

import io.reactivex.AbstractC2894a;
import io.reactivex.b;
import io.reactivex.b.o;
import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.p;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMapCompletable<T> extends AbstractC2894a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final p<T> f21970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends c> f21971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f21972c;

    public ObservableSwitchMapCompletable(p<T> pVar, o<? super T, ? extends c> oVar, boolean z) {
        this.f21970a = pVar;
        this.f21971b = oVar;
        this.f21972c = z;
    }

    @Override // io.reactivex.AbstractC2894a
    protected void b(b bVar) {
        if (a.a(this.f21970a, this.f21971b, bVar)) {
            return;
        }
        this.f21970a.subscribe(new SwitchMapCompletableObserver(bVar, this.f21971b, this.f21972c));
    }

    static final class SwitchMapCompletableObserver<T> implements w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SwitchMapInnerObserver f21973a = new SwitchMapInnerObserver(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b f21974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o<? super T, ? extends c> f21975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f21976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicThrowable f21977e = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference<SwitchMapInnerObserver> f21978f = new AtomicReference<>();
        volatile boolean g;
        io.reactivex.disposables.b h;

        static final class SwitchMapInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements b {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> parent;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onComplete() {
                this.parent.a(this);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onError(Throwable th) {
                this.parent.a(this, th);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        SwitchMapCompletableObserver(b bVar, o<? super T, ? extends c> oVar, boolean z) {
            this.f21974b = bVar;
            this.f21975c = oVar;
            this.f21976d = z;
        }

        void a() {
            SwitchMapInnerObserver andSet = this.f21978f.getAndSet(f21973a);
            if (andSet == null || andSet == f21973a) {
                return;
            }
            andSet.dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.h.dispose();
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21978f.get() == f21973a;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.g = true;
            if (this.f21978f.get() == null) {
                Throwable thTerminate = this.f21977e.terminate();
                if (thTerminate == null) {
                    this.f21974b.onComplete();
                } else {
                    this.f21974b.onError(thTerminate);
                }
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.f21977e.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (this.f21976d) {
                onComplete();
                return;
            }
            a();
            Throwable thTerminate = this.f21977e.terminate();
            if (thTerminate != ExceptionHelper.f22722a) {
                this.f21974b.onError(thTerminate);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                c cVarApply = this.f21975c.apply(t);
                io.reactivex.internal.functions.a.a(cVarApply, "The mapper returned a null CompletableSource");
                c cVar = cVarApply;
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f21978f.get();
                    if (switchMapInnerObserver == f21973a) {
                        return;
                    }
                } while (!this.f21978f.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                cVar.a(switchMapInnerObserver2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.h, bVar)) {
                this.h = bVar;
                this.f21974b.onSubscribe(this);
            }
        }

        void a(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (this.f21978f.compareAndSet(switchMapInnerObserver, null) && this.f21977e.addThrowable(th)) {
                if (this.f21976d) {
                    if (this.g) {
                        this.f21974b.onError(this.f21977e.terminate());
                        return;
                    }
                    return;
                }
                dispose();
                Throwable thTerminate = this.f21977e.terminate();
                if (thTerminate != ExceptionHelper.f22722a) {
                    this.f21974b.onError(thTerminate);
                    return;
                }
                return;
            }
            io.reactivex.e.a.b(th);
        }

        void a(SwitchMapInnerObserver switchMapInnerObserver) {
            if (this.f21978f.compareAndSet(switchMapInnerObserver, null) && this.g) {
                Throwable thTerminate = this.f21977e.terminate();
                if (thTerminate == null) {
                    this.f21974b.onComplete();
                } else {
                    this.f21974b.onError(thTerminate);
                }
            }
        }
    }
}
