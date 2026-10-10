package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: compiled from: FlowableDoOnEach.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.g<? super T> f21905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.b.g<? super Throwable> f21906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.b.a f21907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final io.reactivex.b.a f21908f;

    /* JADX INFO: compiled from: FlowableDoOnEach.java */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final io.reactivex.b.g<? super T> f21909f;
        final io.reactivex.b.g<? super Throwable> g;
        final io.reactivex.b.a h;
        final io.reactivex.b.a i;

        a(io.reactivex.c.a.a<? super T> aVar, io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar2, io.reactivex.b.a aVar3) {
            super(aVar);
            this.f21909f = gVar;
            this.g = gVar2;
            this.h = aVar2;
            this.i = aVar3;
        }

        @Override // io.reactivex.internal.subscribers.a, f.b.c
        public void onComplete() {
            if (this.f22715d) {
                return;
            }
            try {
                this.h.run();
                this.f22715d = true;
                this.f22712a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.a, f.b.c
        public void onError(Throwable th) {
            if (this.f22715d) {
                io.reactivex.e.a.b(th);
                return;
            }
            boolean z = true;
            this.f22715d = true;
            try {
                this.g.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f22712a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f22712a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.e.a.b(th3);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // f.b.c
        public void onNext(T t) {
            if (this.f22715d) {
                return;
            }
            if (this.f22716e != 0) {
                this.f22712a.onNext(null);
                return;
            }
            try {
                this.f21909f.accept(t);
                this.f22712a.onNext((Object) t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            try {
                T tPoll = this.f22714c.poll();
                try {
                    if (tPoll != null) {
                        try {
                            this.f21909f.accept(tPoll);
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            try {
                                this.g.accept(th);
                                throw ExceptionHelper.a(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        }
                    } else if (this.f22716e == 1) {
                        this.h.run();
                    }
                    return tPoll;
                } finally {
                    this.i.run();
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                try {
                    this.g.accept(th3);
                    throw ExceptionHelper.a(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.c.a.a
        public boolean tryOnNext(T t) {
            if (this.f22715d) {
                return false;
            }
            try {
                this.f21909f.accept(t);
                return this.f22712a.tryOnNext((Object) t);
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: FlowableDoOnEach.java */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final io.reactivex.b.g<? super T> f21910f;
        final io.reactivex.b.g<? super Throwable> g;
        final io.reactivex.b.a h;
        final io.reactivex.b.a i;

        b(f.b.c<? super T> cVar, io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.a aVar2) {
            super(cVar);
            this.f21910f = gVar;
            this.g = gVar2;
            this.h = aVar;
            this.i = aVar2;
        }

        @Override // io.reactivex.internal.subscribers.b, f.b.c
        public void onComplete() {
            if (this.f22720d) {
                return;
            }
            try {
                this.h.run();
                this.f22720d = true;
                this.f22717a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.b, f.b.c
        public void onError(Throwable th) {
            if (this.f22720d) {
                io.reactivex.e.a.b(th);
                return;
            }
            boolean z = true;
            this.f22720d = true;
            try {
                this.g.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f22717a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f22717a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.e.a.b(th3);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // f.b.c
        public void onNext(T t) {
            if (this.f22720d) {
                return;
            }
            if (this.f22721e != 0) {
                this.f22717a.onNext(null);
                return;
            }
            try {
                this.f21910f.accept(t);
                this.f22717a.onNext((Object) t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            try {
                T tPoll = this.f22719c.poll();
                try {
                    if (tPoll != null) {
                        try {
                            this.f21910f.accept(tPoll);
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            try {
                                this.g.accept(th);
                                throw ExceptionHelper.a(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        }
                    } else if (this.f22721e == 1) {
                        this.h.run();
                    }
                    return tPoll;
                } finally {
                    this.i.run();
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                try {
                    this.g.accept(th3);
                    throw ExceptionHelper.a(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public d(io.reactivex.e<T> eVar, io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.a aVar2) {
        super(eVar);
        this.f21905c = gVar;
        this.f21906d = gVar2;
        this.f21907e = aVar;
        this.f21908f = aVar2;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        if (cVar instanceof io.reactivex.c.a.a) {
            this.f21902b.a((io.reactivex.h) new a((io.reactivex.c.a.a) cVar, this.f21905c, this.f21906d, this.f21907e, this.f21908f));
        } else {
            this.f21902b.a((io.reactivex.h) new b(cVar, this.f21905c, this.f21906d, this.f21907e, this.f21908f));
        }
    }
}
