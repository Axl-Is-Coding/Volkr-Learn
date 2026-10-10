package com.sandboxol.common.base.dao;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class DaoTransformers {
    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() { // from class: com.sandboxol.common.base.dao.DaoTransformers.1
            @Override // rx.functions.Func1
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
