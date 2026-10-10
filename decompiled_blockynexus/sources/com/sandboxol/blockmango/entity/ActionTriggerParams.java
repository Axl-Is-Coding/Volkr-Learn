package com.sandboxol.blockmango.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ActionTriggerParams<T> {
    private int code;
    private T data;
    private String functionName;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setFunctionName(String str) {
        this.functionName = str;
    }
}
