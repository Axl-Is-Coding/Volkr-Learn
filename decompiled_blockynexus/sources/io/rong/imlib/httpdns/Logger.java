package io.rong.imlib.httpdns;

import io.rong.common.rlog.RLog;

/* JADX INFO: loaded from: classes5.dex */
final class Logger {
    private static final String TAG = "RongLog";
    private static boolean isDebug;

    private Logger() {
    }

    static void printLog(String str, Object... objArr) {
        if (isDebug) {
            RLog.v(TAG, String.format(str, objArr));
        }
    }

    static void setLogEnable(boolean z) {
        isDebug = z;
    }
}
