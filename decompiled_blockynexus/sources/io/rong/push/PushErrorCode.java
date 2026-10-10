package io.rong.push;

/* JADX INFO: loaded from: classes5.dex */
public enum PushErrorCode {
    UNKNOWN(-1, "unknown code"),
    IO_EXCEPTION(50001, "IOException"),
    PARAMETER_ERROR(50002, "the parameter is error."),
    NOT_REGISTER_IN_ADMIN(50003, "haven't registered the third party push from your admin"),
    SERVER_DISCONNECTED(50004, "the socket is disconnect."),
    NOT_SUPPORT_BY_OFFICIAL_PUSH(50005, "this device is not support by official push.");

    private int code;
    private String msg;

    PushErrorCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }
}
