package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableSerialized.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ka<T> extends AbstractC2904a<T, T> {
    public ka(io.reactivex.p<T> pVar) {
        super(pVar);
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new io.reactivex.observers.f(wVar));
    }
}
