package io.rong.push.common;

/* JADX INFO: loaded from: classes5.dex */
public class RLog {
    private static final boolean DEBUG = true;

    public static void d(String str, String str2) {
        log(str, str2, 'd');
    }

    public static void e(String str, String str2) {
        log(str, str2, 'e');
    }

    public static void i(String str, String str2) {
        log(str, str2, 'i');
    }

    private static void log(String str, String str2, char c2) {
        String str3 = "RongLog-Push[" + str + "]";
        if ('e' == c2) {
            io.rong.common.rlog.RLog.e(str3, str2);
            return;
        }
        if ('w' == c2) {
            io.rong.common.rlog.RLog.w(str3, str2);
            return;
        }
        if ('d' == c2) {
            io.rong.common.rlog.RLog.d(str3, str2);
        } else if ('i' == c2) {
            io.rong.common.rlog.RLog.i(str3, str2);
        } else {
            io.rong.common.rlog.RLog.v(str3, str2);
        }
    }

    public static void v(String str, String str2) {
        log(str, str2, 'v');
    }
}
