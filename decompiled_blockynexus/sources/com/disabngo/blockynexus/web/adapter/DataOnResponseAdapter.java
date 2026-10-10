package com.disabngo.blockynexus.web.adapter;

import com.disabngo.blockynexus.web.response.DataOnResponseListener;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.IOnResponseAdapter;
import com.sandboxol.common.base.web.OnResponseListener;

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
