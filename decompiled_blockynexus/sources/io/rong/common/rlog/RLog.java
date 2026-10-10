package io.rong.common.rlog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.rlog.RLogReporter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class RLog {
    public static final int D = 5;
    public static final int E = 2;
    public static final int F = 1;
    public static final int I = 4;
    public static final int NONE = 0;
    static final String TAG = "RongLog";
    public static final int V = 6;
    public static final int W = 3;
    private static IRlogOtherProgressCallback mCallback;
    private static RLogConfig mConfig;
    private static RLogReporter mReporter;
    private static RLogReporter.UploadCallback mUploadCallback;
    private static RLogFileProcessor mWriter;
    private static ArrayList<String> levelArray = new ArrayList<>();
    private static int mLogLevel = 0;
    private static long mFileMaxSize = 1048576;
    private static long mZipMaxSize = 1048576;
    private static boolean isSetLevel = false;
    private static boolean isSetFileMaxSize = false;
    private static boolean isSetZipMaxSize = false;
    private static boolean isReleaseMode = false;

    public interface IRlogOtherProgressCallback {
        void setLogLevel(int i);

        void uploadRLog();

        void write(String str, int i);
    }

    static {
        levelArray.add("None");
        levelArray.add("F");
        levelArray.add("E");
        levelArray.add("W");
        levelArray.add("I");
        levelArray.add("D");
        levelArray.add("V");
    }

    public static void callbackWrite(String str, int i) {
        RLogConfig rLogConfig;
        if (mWriter == null || (rLogConfig = mConfig) == null || rLogConfig.getLogLevel() < i) {
            return;
        }
        mWriter.write(str);
    }

    public static int d(String str, String str2) {
        return write(5, TAG, "[ " + str + " ] " + str2);
    }

    public static int e(String str, String str2) {
        return write(2, TAG, "[ " + str + " ] " + str2);
    }

    public static int f(String str, String str2) {
        return write(1, TAG, "[ " + str + " ] " + str2);
    }

    protected static String formatJson(int i, long j, long j2, long j3, int i2, String str, String str2) {
        String strValueOf;
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("-");
            sb.append(j);
            sb.append(j == j2 ? "*" : "");
            jSONObject.put("ptid", sb.toString());
            if (mConfig == null || !mConfig.isDebugMode()) {
                strValueOf = String.valueOf(j3);
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("gmt"));
                strValueOf = simpleDateFormat.format(new Date(j3));
            }
            jSONObject.put("time", strValueOf);
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, levelArray.get(i2));
            jSONObject.put("tag", str);
            jSONObject.put("msg", str2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int i(String str, String str2) {
        return write(4, TAG, "[ " + str + " ] " + str2);
    }

    public static void init(Context context, String str, String str2) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        isReleaseMode = applicationInfo == null || (applicationInfo.flags & 2) == 0;
        mConfig = new RLogConfig(context, str, str2);
        if (isSetLevel) {
            mConfig.setLogLevel(mLogLevel);
            isSetLevel = false;
        }
        if (isSetFileMaxSize) {
            mConfig.setFileMaxSize(mFileMaxSize);
            isSetFileMaxSize = false;
        }
        if (isSetZipMaxSize) {
            mConfig.setZipMaxSize(mZipMaxSize);
        }
        mWriter = RLogFileProcessor.init(mConfig);
        mReporter = new RLogReporter();
        RLogReporter.UploadCallback uploadCallback = mUploadCallback;
        if (uploadCallback != null) {
            mReporter.setUploadCallback(uploadCallback);
            mUploadCallback = null;
        }
    }

    public static void setFileMaxSize(long j) {
        RLogConfig rLogConfig = mConfig;
        if (rLogConfig != null) {
            mFileMaxSize = j;
            rLogConfig.setFileMaxSize(j);
        } else {
            isSetFileMaxSize = true;
            mFileMaxSize = j;
        }
    }

    public static void setLogLevel(int i) {
        setLogLevel(i, true);
    }

    public static void setRlogOtherProgressCallBack(IRlogOtherProgressCallback iRlogOtherProgressCallback) {
        mCallback = iRlogOtherProgressCallback;
    }

    public static void setUploadCallback(RLogReporter.UploadCallback uploadCallback) {
        mUploadCallback = uploadCallback;
    }

    public static void setUploadUrl(String str) {
        RLogConfig rLogConfig = mConfig;
        if (rLogConfig != null) {
            rLogConfig.setUploadUrl(str);
        }
    }

    public static void setUserId(String str) {
        RLogConfig rLogConfig = mConfig;
        if (rLogConfig != null) {
            rLogConfig.setUserId(str);
        }
    }

    public static void setZipMaxSize(long j) {
        RLogConfig rLogConfig = mConfig;
        if (rLogConfig != null) {
            mZipMaxSize = j;
            rLogConfig.setFileMaxSize(j);
        } else {
            isSetZipMaxSize = true;
            mZipMaxSize = j;
        }
    }

    public static void uploadRLog() {
        uploadRLog(true);
    }

    public static int v(String str, String str2) {
        return write(6, TAG, "[ " + str + " ] " + str2);
    }

    public static int w(String str, String str2) {
        return write(3, TAG, "[ " + str + " ] " + str2);
    }

    private static int write(int i, String str, String str2) {
        return write(i, str, str2, null);
    }

    private static void writeFile(int i, String str, String str2, Throwable th) {
        String str3 = formatJson(Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), System.currentTimeMillis(), i, str, str2) + UMCustomLogInfoBuilder.LINE_SEP;
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(th.toString() + UMCustomLogInfoBuilder.LINE_SEP);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int iMin = Math.min(9, stackTrace.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                sb.append(stackTrace[i2].toString() + UMCustomLogInfoBuilder.LINE_SEP);
            }
            str3 = str3 + sb.toString();
        }
        IRlogOtherProgressCallback iRlogOtherProgressCallback = mCallback;
        if (iRlogOtherProgressCallback != null) {
            iRlogOtherProgressCallback.write(str3, i);
        } else {
            callbackWrite(str3, i);
        }
    }

    public static int e(String str, String str2, Throwable th) {
        return write(2, TAG, "[ " + str + " ] " + str2, th);
    }

    public static void setLogLevel(int i, boolean z) {
        if (!z) {
            IRlogOtherProgressCallback iRlogOtherProgressCallback = mCallback;
            if (iRlogOtherProgressCallback != null) {
                iRlogOtherProgressCallback.setLogLevel(i);
                return;
            }
            return;
        }
        RLogConfig rLogConfig = mConfig;
        if (rLogConfig != null) {
            mLogLevel = i;
            rLogConfig.setLogLevel(i);
        } else {
            isSetLevel = true;
            mLogLevel = i;
        }
    }

    public static void uploadRLog(boolean z) {
        RLogFileProcessor rLogFileProcessor;
        if (!z) {
            IRlogOtherProgressCallback iRlogOtherProgressCallback = mCallback;
            if (iRlogOtherProgressCallback != null) {
                iRlogOtherProgressCallback.uploadRLog();
                return;
            }
            return;
        }
        if (mReporter == null || (rLogFileProcessor = mWriter) == null) {
            e(TAG, "No initialization");
        } else {
            rLogFileProcessor.upload();
        }
    }

    private static int write(int i, String str, String str2, Throwable th) {
        int iE = -1;
        if (isReleaseMode && mLogLevel < i) {
            return -1;
        }
        switch (i) {
            case 1:
                iE = Log.e(TAG, "[" + str + "]" + str2);
                break;
            case 2:
                iE = th != null ? Log.e(TAG, "[" + str + "]" + str2, th) : Log.e(TAG, "[" + str + "]" + str2);
                break;
            case 3:
                iE = Log.w(TAG, "[" + str + "]" + str2);
                break;
            case 4:
                iE = Log.i(TAG, "[" + str + "]" + str2);
                break;
            case 5:
                iE = Log.d(TAG, "[" + str + "]" + str2);
                break;
            case 6:
                iE = Log.v(TAG, "[" + str + "]" + str2);
                break;
        }
        writeFile(i, str, str2, th);
        return iE;
    }
}
