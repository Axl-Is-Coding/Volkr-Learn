package com.google.firebase.crashlytics.internal.network;

import java.io.IOException;
import okhttp3.H;
import okhttp3.u;

/* JADX INFO: loaded from: classes2.dex */
public class HttpResponse {
    private String body;
    private int code;
    private u headers;

    HttpResponse(int i, String str, u uVar) {
        this.code = i;
        this.body = str;
        this.headers = uVar;
    }

    static HttpResponse create(H h) throws IOException {
        return new HttpResponse(h.g(), h.b() == null ? null : h.b().string(), h.o());
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }

    public String header(String str) {
        return this.headers.b(str);
    }
}
