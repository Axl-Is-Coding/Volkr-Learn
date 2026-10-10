package com.sandboxol.common.base.dao;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.config.HttpCode;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public class DaoSubscribe<T> extends Subscriber<T> {
    private OnResponseListener<T> listener;

    public DaoSubscribe(OnResponseListener<T> onResponseListener) {
        this.listener = onResponseListener;
    }

    @Override // rx.Observer
    public void onCompleted() {
        System.out.println();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        if (this.listener != null) {
            if (th == null || !(th.getCause() instanceof DaoException)) {
                this.listener.onServerError(HttpCode.UN_KNOW);
            } else {
                this.listener.onServerError(((DaoException) th.getCause()).getCode());
            }
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        OnResponseListener<T> onResponseListener = this.listener;
        if (onResponseListener != null) {
            onResponseListener.onSuccess(t);
        }
    }
}
