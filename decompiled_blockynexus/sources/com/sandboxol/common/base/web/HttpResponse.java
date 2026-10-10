package com.sandboxol.common.base.web;

/* JADX INFO: loaded from: classes3.dex */
public class HttpResponse<D> {
    private int code;
    private D data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public D getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isBusy() {
        return this.code == 2;
    }

    public boolean isFailed() {
        return this.code != 1;
    }

    public boolean isSuccess() {
        return this.code == 1;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(D d2) {
        this.data = d2;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
