package com.sandboxol.common.base.web;

/* JADX INFO: loaded from: classes3.dex */
public class OnResponseAdapter<D> implements IOnResponseAdapter<D> {
    @Override // com.sandboxol.common.base.web.IOnResponseAdapter
    public void onResponse(HttpResponse<D> httpResponse, OnResponseListener<D> onResponseListener) {
        if (onResponseListener != null) {
            if (httpResponse.getCode() == 1) {
                onResponseListener.onSuccess(httpResponse.getData());
            } else {
                onResponseListener.onError(httpResponse.getCode(), httpResponse.getMessage());
            }
        }
    }
}
