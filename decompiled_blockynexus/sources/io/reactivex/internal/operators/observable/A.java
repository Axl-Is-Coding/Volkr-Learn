package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableDoOnLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class A<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final io.reactivex.b.g<? super io.reactivex.disposables.b> f21985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final io.reactivex.b.a f21986c;

    public A(io.reactivex.p<T> pVar, io.reactivex.b.g<? super io.reactivex.disposables.b> gVar, io.reactivex.b.a aVar) {
        super(pVar);
        this.f21985b = gVar;
        this.f21986c = aVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new io.reactivex.internal.observers.g(wVar, this.f21985b, this.f21986c));
    }
}
