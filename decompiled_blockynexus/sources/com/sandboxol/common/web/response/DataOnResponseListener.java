package com.sandboxol.common.web.response;

import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DataOnResponseListener<D> extends OnResponseListener<D> {
    public abstract void onErrorWithData(int i, String str, D d2);
}
