package com.sandboxol.imchat.server.network.http;

/* JADX INFO: loaded from: classes4.dex */
public class HttpException extends Exception {
    private static final long serialVersionUID = 4010634120321127684L;

    public HttpException() {
    }

    public HttpException(String str, Throwable th) {
        super(str, th);
    }

    public HttpException(String str) {
        super(str);
    }

    public HttpException(Throwable th) {
        super(th);
    }
}
