package com.bytedance.sdk.adnet.core;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Header> f5459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InputStream f5461d;

    public HttpResponse(int i, List<Header> list) {
        this(i, list, -1, null);
    }

    public final InputStream getContent() {
        return this.f5461d;
    }

    public final int getContentLength() {
        return this.f5460c;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.f5459b);
    }

    public final int getStatusCode() {
        return this.f5458a;
    }

    public HttpResponse(int i, List<Header> list, int i2, InputStream inputStream) {
        this.f5458a = i;
        this.f5459b = list;
        this.f5460c = i2;
        this.f5461d = inputStream;
    }
}
