package com.sandboxol.common.base.dao;

/* JADX INFO: loaded from: classes3.dex */
public class DaoException extends Exception {
    private int code;

    public DaoException(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public DaoException(int i, String str) {
        super(str);
        this.code = i;
    }
}
