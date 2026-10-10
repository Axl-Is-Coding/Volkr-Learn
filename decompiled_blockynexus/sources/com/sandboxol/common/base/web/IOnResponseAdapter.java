package com.sandboxol.common.base.web;

/* JADX INFO: loaded from: classes3.dex */
public interface IOnResponseAdapter<D> {
    void onResponse(HttpResponse<D> httpResponse, OnResponseListener<D> onResponseListener);
}
