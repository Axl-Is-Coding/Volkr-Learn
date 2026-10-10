package io.rong.rtlog;

/* JADX INFO: loaded from: classes5.dex */
public class RtLogNative {
    public static final int D = 4;
    public static final int E = 1;
    public static final int F = 0;
    public static final int I = 3;
    public static final int W = 2;
    public static final int rt_debug = 1;
    public static final int rt_error = 4;
    public static final int rt_info = 2;
    public static final int rt_none = 5;
    public static final int rt_warning = 3;

    public native void dispose();

    public native int initialize(String str, String str2, String str3);

    public native int queryCronMessage(int i, boolean z);

    public native int queryFullMessage(int i, long j, long j2, boolean z);

    public native int setCronListener(RtCronListener rtCronListener);

    public native int setFullListener(RtFullListener rtFullListener);

    public native int setRtLogDebugLevel(int i);

    public native int setRtLogListener(RtLogListener rtLogListener);

    public native int updateCronUploadTime(String str, String str2, int i, long j);

    public native void writeMessage(int i, String str, String str2, String str3, long j);
}
