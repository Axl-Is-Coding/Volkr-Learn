package com.sandboxol.common.base.web;

import com.sandboxol.common.base.web.HttpResponse;

/* JADX INFO: loaded from: classes3.dex */
public class HttpSubscriber<T, R extends HttpResponse<T>> extends BaseSubscriber<T, R> {
    public HttpSubscriber(OnResponseListener<T> onResponseListener) {
        super(onResponseListener);
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }
}
