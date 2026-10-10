package com.sandboxol.greendao.a;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: DaoTransformers.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static <T> Observable.Transformer<T, T> a() {
        return new Observable.Transformer() { // from class: com.sandboxol.greendao.a.a
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return ((Observable) obj).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
