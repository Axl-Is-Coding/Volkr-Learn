package com.squareup.okhttp.internal.http;

import io.grpc.internal.GrpcUtil;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String str) {
        return str.equals(GrpcUtil.HTTP_METHOD) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE");
    }

    public static boolean permitsRequestBody(String str) {
        return requiresRequestBody(str) || str.equals("DELETE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals(GrpcUtil.HTTP_METHOD) || str.equals("PUT") || str.equals("PATCH");
    }
}
