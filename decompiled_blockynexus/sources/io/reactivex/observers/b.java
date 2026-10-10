package io.reactivex.observers;

import io.reactivex.w;

/* JADX INFO: compiled from: DefaultObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private io.reactivex.disposables.b f22744a;

    protected void a() {
    }

    @Override // io.reactivex.w
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (io.reactivex.internal.util.f.a(this.f22744a, bVar, getClass())) {
            this.f22744a = bVar;
            a();
        }
    }
}
