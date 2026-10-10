package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;

/* JADX INFO: compiled from: BasicFuseableObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, R> implements w<T>, io.reactivex.c.a.f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final w<? super R> f21836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected io.reactivex.disposables.b f21837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected io.reactivex.c.a.f<T> f21838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f21839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f21840e;

    public a(w<? super R> wVar) {
        this.f21836a = wVar;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f21837b.dispose();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
        this.f21838c.clear();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f21837b.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f21837b.isDisposed();
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return this.f21838c.isEmpty();
    }

    @Override // io.reactivex.c.a.k
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (this.f21839d) {
            return;
        }
        this.f21839d = true;
        this.f21836a.onComplete();
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        if (this.f21839d) {
            io.reactivex.e.a.b(th);
        } else {
            this.f21839d = true;
            this.f21836a.onError(th);
        }
    }

    @Override // io.reactivex.w
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f21837b, bVar)) {
            this.f21837b = bVar;
            if (bVar instanceof io.reactivex.c.a.f) {
                this.f21838c = (io.reactivex.c.a.f) bVar;
            }
            if (b()) {
                this.f21836a.onSubscribe(this);
                a();
            }
        }
    }

    protected final int a(int i) {
        io.reactivex.c.a.f<T> fVar = this.f21838c;
        if (fVar == null || (i & 4) != 0) {
            return 0;
        }
        int iRequestFusion = fVar.requestFusion(i);
        if (iRequestFusion != 0) {
            this.f21840e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
