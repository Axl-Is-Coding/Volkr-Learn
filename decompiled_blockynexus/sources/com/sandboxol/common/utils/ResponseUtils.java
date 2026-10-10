package com.sandboxol.common.utils;

import com.sandboxol.common.base.web.HttpResponse;

/* JADX INFO: loaded from: classes3.dex */
public class ResponseUtils {
    public static <D> HttpResponse<D> create(int i, String str, D d2) {
        HttpResponse<D> httpResponse = new HttpResponse<>();
        httpResponse.setCode(i);
        httpResponse.setMessage(str);
        httpResponse.setData(d2);
        return httpResponse;
    }

    public static <D> HttpResponse<D> failed(String str) {
        return create(2, str, null);
    }

    public static <D> HttpResponse<D> success(D d2) {
        return create(1, null, d2);
    }
}
