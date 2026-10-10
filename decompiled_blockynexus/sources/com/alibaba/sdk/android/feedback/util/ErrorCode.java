package com.alibaba.sdk.android.feedback.util;

import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.web.http.HttpCode;

/* JADX INFO: loaded from: classes.dex */
public enum ErrorCode {
    NULL_ERROR(1001, true),
    CONFIG_ERROR(1002, true),
    UNREAD_ERROR(IntConstant.PERMISSION_STORAGE_DOWNLOAD, false),
    CAMERA_ERROR(1004, true),
    ALBUM_ERROR(1005, true),
    NETWORK_ERROR(HttpCode.PASSWORD_NOT_SET, false),
    DATA_PARSE_ERROR(HttpCode.THIRD_PART_ACCOUNT_ALREADY_BIND_OTHER_USER, false),
    CONTEXT_ERROR(1008, true),
    UNKNOWN_ERROR(1100, true);

    private int errorCode;
    private boolean isVisible;

    ErrorCode(int i, boolean z) {
        this.errorCode = i;
        this.isVisible = z;
    }

    public static ErrorCode getErrorCode(int i) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.getCode() == i) {
                return errorCode;
            }
        }
        return null;
    }

    public int getCode() {
        return this.errorCode;
    }

    public boolean getVisible() {
        return this.isVisible;
    }
}
