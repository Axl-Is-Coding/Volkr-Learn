package com.sandboxol.common.web.adapter;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.IOnResponseAdapter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.response.DataOnResponseListener;

/* JADX INFO: loaded from: classes3.dex */
public class DataOnResponseAdapter<D> implements IOnResponseAdapter<D> {
    @Override // com.sandboxol.common.base.web.IOnResponseAdapter
    public void onResponse(HttpResponse<D> httpResponse, OnResponseListener<D> onResponseListener) {
        if (onResponseListener != null) {
            if (httpResponse.getCode() == 1) {
                onResponseListener.onSuccess(httpResponse.getData());
                return;
            }
            if (!(onResponseListener instanceof DataOnResponseListener)) {
                onResponseListener.onError(httpResponse.getCode(), httpResponse.getMessage());
            } else if (httpResponse.getData() != null) {
                ((DataOnResponseListener) onResponseListener).onErrorWithData(httpResponse.getCode(), httpResponse.getMessage(), httpResponse.getData());
            } else {
                onResponseListener.onError(httpResponse.getCode(), httpResponse.getMessage());
            }
        }
    }
}
