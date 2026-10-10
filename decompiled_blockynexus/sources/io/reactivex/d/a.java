package io.reactivex.d;

import io.reactivex.b.g;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ea;
import io.reactivex.p;

/* JADX INFO: compiled from: ConnectableObservable.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> extends p<T> {
    /* JADX WARN: Multi-variable type inference failed */
    private a<T> c() {
        return this instanceof ea ? io.reactivex.e.a.a((a) new ObservablePublishAlt(((ea) this).a())) : this;
    }

    public abstract void a(g<? super io.reactivex.disposables.b> gVar);

    public p<T> b() {
        return io.reactivex.e.a.a(new ObservableRefCount(c()));
    }
}
