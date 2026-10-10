package com.sandboxol.center.transformers;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class DataTransformers {
    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() { // from class: com.sandboxol.center.transformers.DataTransformers.1
            @Override // rx.functions.Func1
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable.Transformer<T, T> applySchedulersIo() {
        return new Observable.Transformer<T, T>() { // from class: com.sandboxol.center.transformers.DataTransformers.2
            @Override // rx.functions.Func1
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
            }
        };
    }
}
