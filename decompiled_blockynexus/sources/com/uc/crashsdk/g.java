package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20563a = !g.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CustomInfo f20564b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static VersionInfo f20565c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f20566d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f20567e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f20568f = null;
    private static String g = null;
    private static String h = null;
    private static final Object i = new Object();

    static long A() {
        return f20564b.mMaxUploadBytesPerDay;
    }

    static int B() {
        return f20564b.mMaxUploadBuiltinLogCountPerDay;
    }

    static int C() {
        return f20564b.mMaxUploadCustomLogCountPerDay;
    }

    static int D() {
        return f20564b.mMaxCustomLogCountPerTypePerDay;
    }

    static int E() {
        return f20564b.mInfoUpdateInterval;
    }

    static int F() {
        return f20564b.mInfoSaveFrequency;
    }

    static int G() {
        return f20564b.mReservedJavaFileHandleCount;
    }

    static int H() {
        return f20564b.mFdDumpMinLimit;
    }

    static int I() {
        return f20564b.mThreadsDumpMinLimit;
    }

    static boolean J() {
        return f20564b.mAutoDetectLifeCycle;
    }

    static boolean K() {
        return f20564b.mMonitorBattery;
    }

    static int L() {
        return f20564b.mAnrTraceStrategy;
    }

    public static boolean M() {
        CustomInfo customInfo = f20564b;
        return customInfo == null || customInfo.mDebug;
    }

    static boolean N() {
        CustomInfo customInfo = f20564b;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean O() {
        return f20564b.mEnableStatReport;
    }

    public static boolean P() {
        return f20564b.mIsInternational;
    }

    public static boolean Q() {
        return f20564b.mAddPvForNewDay;
    }

    public static String R() {
        return com.uc.crashsdk.a.g.a(f20565c.mVersion) ? a.a() : a(f20565c.mVersion);
    }

    public static String S() {
        return com.uc.crashsdk.a.g.a(f20565c.mSubVersion) ? "release" : f20565c.mSubVersion;
    }

    public static String T() {
        return com.uc.crashsdk.a.g.a(f20565c.mBuildId) ? X() : a(f20565c.mBuildId);
    }

    public static String U() {
        if (f20568f == null) {
            f20568f = com.uc.crashsdk.a.g.b() + File.separatorChar + f20564b.mTagFilesFolderName + File.separatorChar;
        }
        return f20568f;
    }

    static String V() {
        if (g == null) {
            g = com.uc.crashsdk.a.g.b() + File.separatorChar + f20564b.mCrashLogsFolderName + File.separatorChar;
        }
        return g;
    }

    static String W() {
        String path;
        if (h == null) {
            if (!com.uc.crashsdk.a.g.a(f20564b.mLogsBackupPathName)) {
                String strTrim = f20564b.mLogsBackupPathName.trim();
                if (!strTrim.endsWith(File.separator)) {
                    strTrim = strTrim + File.separator;
                }
                h = strTrim;
            } else if (b.I()) {
                path = "/sdcard";
                h = path + File.separatorChar + f20564b.mCrashLogsFolderName + File.separatorChar;
            } else {
                try {
                    path = Environment.getExternalStorageDirectory().getPath();
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    path = "/sdcard";
                }
                h = path + File.separatorChar + f20564b.mCrashLogsFolderName + File.separatorChar;
            }
        }
        return h;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String X() throws java.lang.Throwable {
        /*
            java.lang.String r0 = com.uc.crashsdk.g.f20567e
            if (r0 == 0) goto L5
            return r0
        L5:
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
            java.lang.String r2 = com.uc.crashsdk.a.g.c()     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3f
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r1.getEntry(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            long r2 = r0.getCrc()     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            java.lang.String r0 = java.lang.Long.toHexString(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            com.uc.crashsdk.g.f20567e = r0     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            java.lang.String r2 = "version unique build id: "
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            java.lang.String r2 = com.uc.crashsdk.g.f20567e     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            r0.append(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0)     // Catch: java.lang.Throwable -> L38 java.lang.Throwable -> L50
        L34:
            r1.close()     // Catch: java.lang.Throwable -> L4d
            goto L4d
        L38:
            r0 = move-exception
            goto L43
        L3a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L51
        L3f:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L43:
            java.lang.String r2 = ""
            com.uc.crashsdk.g.f20567e = r2     // Catch: java.lang.Throwable -> L50
            com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L50
            if (r1 == 0) goto L4d
            goto L34
        L4d:
            java.lang.String r0 = com.uc.crashsdk.g.f20567e
            return r0
        L50:
            r0 = move-exception
        L51:
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.lang.Throwable -> L56
        L56:
            goto L58
        L57:
            throw r0
        L58:
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.g.X():java.lang.String");
    }

    private static void Y() {
        if (b.f20525d) {
            JNIBridge.nativeSet(24, 1L, a.f20479b, null);
        }
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        f20564b = customInfo2;
        c(customInfo2);
        f20565c = new VersionInfo(versionInfo);
        if (b.I()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, f20564b.mTagFilesFolderName);
        JNIBridge.set(105, f20564b.mCrashLogsFolderName);
        JNIBridge.set(106, W());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, R());
        JNIBridge.set(110, S());
        JNIBridge.set(111, T());
        JNIBridge.set(112, "200403192109");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.p());
        JNIBridge.set(5, f20564b.mCallNativeDefaultHandler);
        JNIBridge.set(6, f20564b.mDumpUserSolibBuildId);
        JNIBridge.set(7, f20564b.mReservedNativeMemoryBytes);
        JNIBridge.set(100, f20564b.mNativeCrashLogFileName);
        JNIBridge.set(101, f20564b.mUnexpCrashLogFileName);
        JNIBridge.set(102, f20564b.mAppId);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(".tmp")) {
            throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long jB = e.b();
        if (jB >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (jB >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (jB >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void d() {
        JNIBridge.set(23, f20564b.mIsInternational);
        if (b.E()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, f20564b.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, f20564b.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.y());
        JNIBridge.set(2, b.C());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.f20478a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, f20564b.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, a.c());
        Y();
        b.H();
        b.A();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return f20564b.mAppId;
    }

    static boolean f() {
        if (com.uc.crashsdk.a.g.b(f20564b.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(f20564b.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(f20564b.mUnexpCrashLogFileName);
    }

    static String g() {
        return f20564b.mJavaCrashLogFileName;
    }

    static int h() {
        return f20564b.mCrashRestartInterval;
    }

    static boolean i() {
        return f20564b.mCallJavaDefaultHandler;
    }

    static boolean j() {
        return f20564b.mDumpHprofDataForJavaOOM;
    }

    static boolean k() {
        return f20564b.mRenameFileToDefaultName;
    }

    static int l() {
        return f20564b.mMaxBuiltinLogFilesCount;
    }

    static int m() {
        return f20564b.mMaxCustomLogFilesCount;
    }

    static int n() {
        return f20564b.mMaxJavaLogcatLineCount;
    }

    static int o() {
        return f20564b.mUnexpDelayMillSeconds;
    }

    static int p() {
        return f20564b.mUnexpSubTypes;
    }

    static boolean q() {
        return f20564b.mBackupLogs;
    }

    public static boolean r() {
        return f20564b.mSyncUploadSetupCrashLogs;
    }

    static boolean s() {
        return f20564b.mSyncUploadLogs;
    }

    static boolean t() {
        return f20564b.mOmitJavaCrash;
    }

    static boolean u() {
        return f20564b.mAutoDeleteOldVersionStats;
    }

    static boolean v() {
        return f20564b.mZipLog;
    }

    static String w() {
        return f20564b.mZippedLogExtension;
    }

    static boolean x() {
        return f20564b.mEncryptLog;
    }

    static int y() {
        return f20564b.mLogMaxBytesLimit;
    }

    static int z() {
        return f20564b.mLogMaxUploadBytesLimit;
    }

    public static void a(CustomInfo customInfo) {
        if (!f20563a && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!f20563a && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f20566d) {
            f20565c = new VersionInfo(versionInfo);
            e.c();
            if (b.f20525d) {
                JNIBridge.set(109, R());
                JNIBridge.set(110, S());
                JNIBridge.set(111, T());
                JNIBridge.set(112, "200403192109");
                JNIBridge.cmd(2);
            }
        }
    }

    static void a() {
        b.v();
        b.u();
        if (f20564b.mBackupLogs) {
            File file = new File(W());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", "-");
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        synchronized (i) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (f20564b == null) {
                    f20564b = new CustomInfo();
                }
                CustomInfo customInfo2 = f20564b;
                boolean z3 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                    z = false;
                } else {
                    customInfo2.mAppId = customInfo.mAppId;
                    if (b.f20525d) {
                        JNIBridge.set(102, customInfo2.mAppId);
                    }
                    i3 = 1;
                    z = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i3++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    customInfo2.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
                    if (b.f20525d) {
                        JNIBridge.set(100, customInfo2.mNativeCrashLogFileName);
                    }
                    i3++;
                    z = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    customInfo2.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
                    if (b.f20525d) {
                        JNIBridge.set(101, customInfo2.mUnexpCrashLogFileName);
                    }
                    i3++;
                    z = true;
                }
                if (z) {
                    e.c();
                    if (b.f20525d) {
                        JNIBridge.cmd(2);
                    }
                }
                if (customInfo2.mPrintStackInfos != customInfo.mPrintStackInfos) {
                    customInfo2.mPrintStackInfos = customInfo.mPrintStackInfos;
                    if (b.f20525d) {
                        JNIBridge.set(11, customInfo2.mPrintStackInfos);
                    }
                    i3++;
                }
                if (customInfo2.mDebug != customInfo.mDebug) {
                    customInfo2.mDebug = customInfo.mDebug;
                    if (b.f20525d) {
                        JNIBridge.set(18, customInfo2.mDebug);
                    }
                    i3++;
                }
                if (customInfo2.mBackupLogs != customInfo.mBackupLogs) {
                    customInfo2.mBackupLogs = customInfo.mBackupLogs;
                    if (b.f20525d) {
                        JNIBridge.set(12, customInfo2.mBackupLogs);
                    }
                    i3++;
                }
                if (customInfo2.mOmitNativeCrash != customInfo.mOmitNativeCrash) {
                    customInfo2.mOmitNativeCrash = customInfo.mOmitNativeCrash;
                    if (b.f20525d) {
                        JNIBridge.set(21, customInfo2.mOmitNativeCrash);
                    }
                    i3++;
                }
                if (customInfo2.mCrashRestartInterval != customInfo.mCrashRestartInterval) {
                    customInfo2.mCrashRestartInterval = customInfo.mCrashRestartInterval;
                    if (b.f20525d) {
                        JNIBridge.set(13, customInfo2.mCrashRestartInterval);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.J();
                    }
                    i3++;
                }
                if (customInfo2.mMaxBuiltinLogFilesCount != customInfo.mMaxBuiltinLogFilesCount) {
                    customInfo2.mMaxBuiltinLogFilesCount = customInfo.mMaxBuiltinLogFilesCount;
                    if (b.f20525d) {
                        JNIBridge.set(14, customInfo2.mMaxBuiltinLogFilesCount);
                    }
                    i3++;
                }
                if (customInfo2.mMaxNativeLogcatLineCount != customInfo.mMaxNativeLogcatLineCount) {
                    customInfo2.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
                    if (b.f20525d) {
                        JNIBridge.set(15, customInfo2.mMaxNativeLogcatLineCount);
                    }
                    i3++;
                }
                if (customInfo2.mMaxJavaLogcatLineCount != customInfo.mMaxJavaLogcatLineCount) {
                    customInfo2.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
                    i3++;
                }
                if (customInfo2.mMaxUnexpLogcatLineCount != customInfo.mMaxUnexpLogcatLineCount) {
                    customInfo2.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
                    if (b.f20525d) {
                        JNIBridge.set(16, customInfo2.mMaxUnexpLogcatLineCount);
                    }
                    i3++;
                }
                if (customInfo2.mMaxAnrLogcatLineCount != customInfo.mMaxAnrLogcatLineCount) {
                    customInfo2.mMaxAnrLogcatLineCount = customInfo.mMaxAnrLogcatLineCount;
                    if (b.f20525d) {
                        JNIBridge.set(31, customInfo2.mMaxAnrLogcatLineCount);
                    }
                    i3++;
                }
                if (customInfo2.mZipLog != customInfo.mZipLog) {
                    customInfo2.mZipLog = customInfo.mZipLog;
                    i3++;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z3 = z2;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                }
                if (z3 && b.f20525d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                if (customInfo2.mLogMaxBytesLimit != customInfo.mLogMaxBytesLimit) {
                    customInfo2.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
                    if (b.f20525d) {
                        JNIBridge.set(4, customInfo2.mLogMaxBytesLimit);
                    }
                    i3++;
                }
                if (customInfo2.mEncryptLog != customInfo.mEncryptLog) {
                    customInfo2.mEncryptLog = customInfo.mEncryptLog;
                    i3++;
                }
                if (customInfo2.mSyncUploadSetupCrashLogs != customInfo.mSyncUploadSetupCrashLogs) {
                    customInfo2.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
                    i3++;
                }
                if (customInfo2.mSyncUploadLogs != customInfo.mSyncUploadLogs) {
                    customInfo2.mSyncUploadLogs = customInfo.mSyncUploadLogs;
                    i3++;
                }
                if (customInfo2.mMaxCustomLogFilesCount != customInfo.mMaxCustomLogFilesCount) {
                    customInfo2.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
                    i3++;
                }
                if (customInfo2.mOmitJavaCrash != customInfo.mOmitJavaCrash) {
                    customInfo2.mOmitJavaCrash = customInfo.mOmitJavaCrash;
                    i3++;
                }
                if (customInfo2.mLogMaxUploadBytesLimit != customInfo.mLogMaxUploadBytesLimit) {
                    customInfo2.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
                    i3++;
                }
                if (customInfo2.mMaxUploadBytesPerDay != customInfo.mMaxUploadBytesPerDay) {
                    customInfo2.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
                    i3++;
                }
                if (customInfo2.mMaxUploadBuiltinLogCountPerDay != customInfo.mMaxUploadBuiltinLogCountPerDay) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = customInfo.mMaxUploadBuiltinLogCountPerDay;
                    i3++;
                }
                if (customInfo2.mMaxUploadCustomLogCountPerDay != customInfo.mMaxUploadCustomLogCountPerDay) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
                    i3++;
                }
                if (customInfo2.mMaxCustomLogCountPerTypePerDay != customInfo.mMaxCustomLogCountPerTypePerDay) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
                    i3++;
                }
                if (customInfo2.mMaxAnrLogCountPerProcess != customInfo.mMaxAnrLogCountPerProcess) {
                    customInfo2.mMaxAnrLogCountPerProcess = customInfo.mMaxAnrLogCountPerProcess;
                    if (b.f20525d) {
                        JNIBridge.set(32, f20564b.mMaxAnrLogCountPerProcess);
                    }
                    i3++;
                }
                if (customInfo2.mCallJavaDefaultHandler != customInfo.mCallJavaDefaultHandler) {
                    customInfo2.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
                    i3++;
                }
                if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler) {
                    customInfo2.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
                    i3++;
                    if (b.f20525d) {
                        JNIBridge.set(5, f20564b.mCallNativeDefaultHandler);
                    }
                }
                if (customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                    customInfo2.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
                    i3++;
                    if (b.f20525d) {
                        JNIBridge.set(6, f20564b.mDumpUserSolibBuildId);
                    }
                }
                if (customInfo2.mDumpHprofDataForJavaOOM != customInfo.mDumpHprofDataForJavaOOM) {
                    customInfo2.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
                    i3++;
                }
                if (customInfo2.mRenameFileToDefaultName != customInfo.mRenameFileToDefaultName) {
                    customInfo2.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
                    i3++;
                }
                if (customInfo2.mAutoDeleteOldVersionStats != customInfo.mAutoDeleteOldVersionStats) {
                    customInfo2.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
                    i3++;
                }
                if (customInfo2.mFdDumpMinLimit != customInfo.mFdDumpMinLimit) {
                    customInfo2.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
                    if (b.f20525d) {
                        JNIBridge.set(10, customInfo2.mFdDumpMinLimit);
                    }
                    i3++;
                }
                if (customInfo2.mThreadsDumpMinLimit != customInfo.mThreadsDumpMinLimit) {
                    customInfo2.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
                    if (b.f20525d) {
                        JNIBridge.set(22, customInfo2.mThreadsDumpMinLimit);
                    }
                    i3++;
                }
                if (customInfo2.mInfoUpdateInterval != customInfo.mInfoUpdateInterval) {
                    if (customInfo2.mInfoUpdateInterval <= 0 && customInfo.mInfoUpdateInterval > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i3++;
                }
                if (customInfo2.mInfoSaveFrequency != customInfo.mInfoSaveFrequency) {
                    customInfo2.mInfoSaveFrequency = customInfo.mInfoSaveFrequency;
                    i3++;
                }
                if (customInfo2.mDisableBackgroundSignals != customInfo.mDisableBackgroundSignals) {
                    customInfo2.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
                    if (b.f20525d) {
                        JNIBridge.set(9, customInfo2.mDisableBackgroundSignals);
                    }
                    i3++;
                }
                if (customInfo2.mEnableStatReport != customInfo.mEnableStatReport) {
                    customInfo2.mEnableStatReport = customInfo.mEnableStatReport;
                    if (customInfo2.mEnableStatReport) {
                        e.B();
                    }
                    i3++;
                }
                if (customInfo2.mIsInternational != customInfo.mIsInternational) {
                    customInfo2.mIsInternational = customInfo.mIsInternational;
                    if (b.f20525d) {
                        JNIBridge.set(23, customInfo2.mIsInternational);
                    }
                    i3++;
                }
                if (customInfo2.mAutoDetectLifeCycle != customInfo.mAutoDetectLifeCycle) {
                    customInfo2.mAutoDetectLifeCycle = customInfo.mAutoDetectLifeCycle;
                    if (customInfo2.mAutoDetectLifeCycle) {
                        b.z();
                    }
                    i3++;
                }
                if (customInfo2.mMonitorBattery != customInfo.mMonitorBattery) {
                    customInfo2.mMonitorBattery = customInfo.mMonitorBattery;
                    e.c(b.y());
                    i3++;
                }
                if (customInfo2.mUnexpSubTypes != customInfo.mUnexpSubTypes) {
                    customInfo2.mUnexpSubTypes = customInfo.mUnexpSubTypes;
                    i3++;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = f20564b;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static void c() {
        JNIBridge.set(11, N());
        JNIBridge.set(12, f20564b.mBackupLogs);
        JNIBridge.set(13, f20564b.mCrashRestartInterval);
        JNIBridge.set(14, f20564b.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, f20564b.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, f20564b.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, f20564b.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, M());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, f20564b.mOmitNativeCrash);
        JNIBridge.set(32, f20564b.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, f20564b.mDisableSignals);
        JNIBridge.set(9, f20564b.mDisableBackgroundSignals);
        JNIBridge.nativeSet(3, f20564b.mZipLog ? 1L : 0L, f20564b.mZippedLogExtension, null);
        JNIBridge.set(4, f20564b.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = f20565c;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.f20479b = string4;
            Y();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
