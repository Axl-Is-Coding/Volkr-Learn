package com.sandboxol.common.base.web;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OnResponseListener<D> {
    private int retryTimes = 1;

    public boolean needRetry() {
        return this.retryTimes > 0;
    }

    public abstract void onError(int i, String str);

    public abstract void onServerError(int i);

    public abstract void onSuccess(D d2);

    public void retry() {
        this.retryTimes--;
    }
}
