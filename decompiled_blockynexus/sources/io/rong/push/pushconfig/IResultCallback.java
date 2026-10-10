package io.rong.push.pushconfig;

import io.rong.push.PushErrorCode;

/* JADX INFO: loaded from: classes5.dex */
public interface IResultCallback<T> {
    void onError(PushErrorCode pushErrorCode);

    void onSuccess(T t);
}
