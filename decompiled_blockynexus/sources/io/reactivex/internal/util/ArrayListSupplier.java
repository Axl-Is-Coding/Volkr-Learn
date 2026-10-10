package io.reactivex.internal.util;

import io.reactivex.b.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public enum ArrayListSupplier implements Callable<List<Object>>, o<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> o<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // io.reactivex.b.o
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
