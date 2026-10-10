package com.sandboxol.common.base.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: loaded from: classes3.dex */
public class HttpPageListSubscriber<T, R extends HttpResponse<PageData<T>>> extends BaseSubscriber<PageData<T>, R> {
    public HttpPageListSubscriber(OnResponseListener<PageData<T>> onResponseListener) {
        super(onResponseListener);
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }
}
