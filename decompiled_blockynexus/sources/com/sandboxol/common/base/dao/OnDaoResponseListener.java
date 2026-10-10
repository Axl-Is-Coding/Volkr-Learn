package com.sandboxol.common.base.dao;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OnDaoResponseListener<D> {
    public abstract void onError(int i, String str);

    public abstract void onSuccess(D d2);
}
