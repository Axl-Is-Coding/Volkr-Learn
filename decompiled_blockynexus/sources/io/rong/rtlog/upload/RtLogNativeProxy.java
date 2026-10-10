package io.rong.rtlog.upload;

import android.annotation.SuppressLint;
import android.content.Context;
import io.rong.common.rlog.RLog;
import io.rong.rtlog.RtCronListener;
import io.rong.rtlog.RtFullListener;
import io.rong.rtlog.RtLogNative;

/* JADX INFO: loaded from: classes5.dex */
class RtLogNativeProxy {
    private static final String TAG = "RtLogNativeProxy";
    private RtLogNative nativeObject;

    private static class SingletonHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final RtLogNativeProxy instance = new RtLogNativeProxy();

        private SingletonHolder() {
        }
    }

    public static RtLogNativeProxy getInstance() {
        return SingletonHolder.instance;
    }

    public static boolean initialize(Context context, String str, String str2, String str3) {
        try {
            return SingletonHolder.instance.nativeObject.initialize(str, str2, str3) == 0;
        } catch (Exception e2) {
            RLog.d(TAG, "initialize - native call exception :" + e2.toString());
            return false;
        }
    }

    public static boolean queryFullLog(int i, long j, long j2) {
        try {
            return SingletonHolder.instance.nativeObject.queryFullMessage(i, j, j2, true) == 0;
        } catch (Exception e2) {
            RLog.d(TAG, "queryFullLog - native call exception :" + e2.toString());
            return false;
        }
    }

    public static boolean queryTimingLog(int i) {
        try {
            return SingletonHolder.instance.nativeObject.queryCronMessage(i, false) == 0;
        } catch (Exception e2) {
            RLog.d(TAG, "queryTimingLog - native call exception :" + e2.toString());
            return false;
        }
    }

    public static boolean reportTimingUploadFinished(String str, String str2, int i, long j) {
        try {
            return SingletonHolder.instance.nativeObject.updateCronUploadTime(str, str2, i, j) == 0;
        } catch (Exception e2) {
            RLog.d(TAG, "reportTimingUploadFinished - native call exception :" + e2.toString());
            return false;
        }
    }

    public static void setQueryFullLogListener(RtFullListener rtFullListener) {
        try {
            SingletonHolder.instance.nativeObject.setFullListener(rtFullListener);
        } catch (Exception e2) {
            RLog.d(TAG, "setQueryFullLogListener - native call exception :" + e2.toString());
        }
    }

    public static void setQueryTimingLogListener(RtCronListener rtCronListener) {
        try {
            SingletonHolder.instance.nativeObject.setCronListener(rtCronListener);
        } catch (Exception e2) {
            RLog.d(TAG, "setQueryTimingLogListener - native call exception :" + e2.toString());
        }
    }

    public static void writeLog(int i, String str, String str2, String str3, long j) {
        try {
            SingletonHolder.instance.nativeObject.writeMessage(i, str, str2, str3, j);
        } catch (Exception e2) {
            RLog.d(TAG, "writeLog - native call exception :" + e2.toString());
        }
    }

    private RtLogNativeProxy() {
        this.nativeObject = new RtLogNative();
    }
}
