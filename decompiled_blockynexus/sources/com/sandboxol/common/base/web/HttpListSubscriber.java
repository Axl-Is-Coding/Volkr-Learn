package com.sandboxol.common.base.web;

import com.sandboxol.common.base.web.HttpResponse;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HttpListSubscriber<T, R extends HttpResponse<List<T>>> extends BaseSubscriber<List<T>, R> {
    public HttpListSubscriber(OnResponseListener<List<T>> onResponseListener) {
        super(onResponseListener);
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }
}
