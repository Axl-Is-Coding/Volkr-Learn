package com.sandboxol.common.base.web;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OnResponseExceptionListener<D> extends OnResponseListener<D> {
    public abstract void onErrorWithData(int i, Throwable th);
}
