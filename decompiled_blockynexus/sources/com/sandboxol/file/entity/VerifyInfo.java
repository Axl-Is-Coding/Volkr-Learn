package com.sandboxol.file.entity;

/* JADX INFO: loaded from: classes3.dex */
public class VerifyInfo<T> {
    private String code;
    private String fileDir;
    private String fileName;
    private T t;
    private String type;
    private String url = "";

    public String getCode() {
        return this.code;
    }

    public String getFileDir() {
        return this.fileDir;
    }

    public String getFileName() {
        return this.fileName;
    }

    public T getT() {
        return this.t;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public VerifyInfo setCode(String str) {
        this.code = str;
        return this;
    }

    public VerifyInfo setFileDir(String str) {
        this.fileDir = str;
        return this;
    }

    public VerifyInfo setFileName(String str) {
        this.fileName = str;
        return this;
    }

    public VerifyInfo setT(T t) {
        this.t = t;
        return this;
    }

    public VerifyInfo setType(String str) {
        this.type = str;
        return this;
    }

    public VerifyInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
