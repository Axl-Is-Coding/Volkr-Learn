package cn.qqtheme.framework.util;

import android.os.Debug;
import android.os.Environment;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public final class LogUtils {
    private static final int MAX_STACK_TRACE_SIZE = 131071;
    private static final int METHOD_COUNT = 2;
    private static final int MIN_STACK_OFFSET = 3;
    private static String debugTag = "liyujiang";
    private static boolean isDebug;

    private static String _getSimpleClassName(String str) {
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    private static int _getStackOffset(StackTraceElement[] stackTraceElementArr) {
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            if (!stackTraceElementArr[i].getClassName().equals(LogUtils.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void debug(String str) {
        debug("", str);
    }

    public static void error(Throwable th) {
        error(toStackTraceString(th));
    }

    public static String getDebugTag() {
        return debugTag;
    }

    private static String getTraceElement() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i_getStackOffset = _getStackOffset(stackTrace);
            StringBuilder sb = new StringBuilder();
            String str = "    ";
            for (int length = i_getStackOffset + 2 > stackTrace.length ? (stackTrace.length - i_getStackOffset) - 1 : 2; length > 0; length--) {
                int i = length + i_getStackOffset;
                if (i < stackTrace.length) {
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                    sb.append(str);
                    sb.append(_getSimpleClassName(stackTrace[i].getClassName()));
                    sb.append(Consts.DOT);
                    sb.append(stackTrace[i].getMethodName());
                    sb.append(" ");
                    sb.append("(");
                    sb.append(stackTrace[i].getFileName());
                    sb.append(":");
                    sb.append(stackTrace[i].getLineNumber());
                    sb.append(")");
                    str = str + "    ";
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            Log.w(debugTag, e2);
            return "";
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setDebugTag(String str) {
        debugTag = str;
    }

    public static void setIsDebug(boolean z) {
        isDebug = z;
    }

    public static void startMethodTracing() {
        if (isDebug) {
            Debug.startMethodTracing(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + debugTag + ".trace");
        }
    }

    public static void stopMethodTracing() {
        if (isDebug) {
            Debug.stopMethodTracing();
        }
    }

    public static String toStackTraceString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        if (string.length() > MAX_STACK_TRACE_SIZE) {
            string = string.substring(0, 131047) + " [stack trace too large]";
        }
        printWriter.close();
        return string;
    }

    public static void verbose(String str) {
        verbose("", str);
    }

    public static void warn(Throwable th) {
        warn(toStackTraceString(th));
    }

    public static void debug(Object obj, String str) {
        debug(obj.getClass().getSimpleName(), str);
    }

    public static void error(String str) {
        error("", str);
    }

    public static void verbose(Object obj, String str) {
        verbose(obj.getClass().getSimpleName(), str);
    }

    public static void warn(String str) {
        warn("", str);
    }

    public static void debug(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            sb.append((str == null || str.trim().length() == 0) ? "" : "-");
            sb.append(str);
            Log.d(sb.toString(), str2 + getTraceElement());
        }
    }

    public static void error(Object obj, String str) {
        error(obj.getClass().getSimpleName(), str);
    }

    public static void verbose(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            sb.append((str == null || str.trim().length() == 0) ? "" : "-");
            sb.append(str);
            Log.v(sb.toString(), str2 + getTraceElement());
        }
    }

    public static void warn(Object obj, String str) {
        warn(obj.getClass().getSimpleName(), str);
    }

    public static void error(Object obj, Throwable th) {
        error(obj.getClass().getSimpleName(), toStackTraceString(th));
    }

    public static void warn(Object obj, Throwable th) {
        warn(obj.getClass().getSimpleName(), toStackTraceString(th));
    }

    public static void error(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            sb.append((str == null || str.trim().length() == 0) ? "" : "-");
            sb.append(str);
            Log.e(sb.toString(), str2 + getTraceElement());
        }
    }

    public static void warn(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            sb.append((str == null || str.trim().length() == 0) ? "" : "-");
            sb.append(str);
            Log.w(sb.toString(), str2 + getTraceElement());
        }
    }
}
