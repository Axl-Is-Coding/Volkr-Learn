package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DisposableObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T> implements w<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f22745a = new AtomicReference<>();

    protected void a() {
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.f22745a);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f22745a.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.w
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.a(this.f22745a, bVar, getClass())) {
            a();
        }
    }
}
