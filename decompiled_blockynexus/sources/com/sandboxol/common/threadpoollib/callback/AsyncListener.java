package com.sandboxol.common.threadpoollib.callback;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncListener<T> {
    void onFailed(Throwable th);

    void onStart(String str);

    void onSuccess(T t);
}
