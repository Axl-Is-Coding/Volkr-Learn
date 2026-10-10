package io.rong.rtlog.upload;

import io.rong.imlib.common.DeviceUtils;

/* JADX INFO: loaded from: classes5.dex */
class FullUploadLogTask extends UploadLogTask {
    private static final String FULL_UPLOAD_URL_FORMAT = "%s?version=%s&appkey=%s&userId=%s&logId=%s&deviceId=%s&deviceInfo=%s&platform=Android";
    private static final String MODULE_NOT_INIT_CONTENT = "no log module ";
    private static final String NO_DATA_LOG_CONTENT = "no data";
    private static final String TAG = "FullUploadLogTask";
    private String appKey;
    private String deviceId;
    private long endTime;
    private String logCacheDir;
    private String logId;
    private long startTime;
    private String uploadUrl;
    private String userId;
    private String version;

    public FullUploadLogTask(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2, String str7) {
        this.version = str;
        this.deviceId = str2;
        this.appKey = str3;
        this.uploadUrl = str4;
        this.userId = str5;
        this.logId = str6;
        this.startTime = j;
        this.endTime = j2;
        this.logCacheDir = str7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082 A[EXC_TOP_SPLITTER, PHI: r5
      0x0082: PHI (r5v8 java.io.FileOutputStream) = (r5v7 java.io.FileOutputStream), (r5v9 java.io.FileOutputStream) binds: [B:30:0x0094, B:24:0x0080] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getLogFile() throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "getLogFile"
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch
            r2 = 1
            r1.<init>(r2)
            java.lang.String r2 = r10.logCacheDir
            r3 = 0
            if (r2 != 0) goto Le
            return r3
        Le:
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "f_"
            r5.append(r6)
            long r6 = java.lang.System.currentTimeMillis()
            r5.append(r6)
            java.lang.String r6 = "_log_cache"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r2, r5)
            java.io.File r2 = r4.getParentFile()
            boolean r2 = r2.exists()
            if (r2 != 0) goto L48
            java.io.File r2 = r4.getParentFile()
            boolean r2 = r2.mkdirs()
            if (r2 != 0) goto L48
            java.lang.String r2 = io.rong.rtlog.upload.FullUploadLogTask.TAG
            java.lang.String r5 = "getLogFile mkdirs return false"
            io.rong.common.rlog.RLog.d(r2, r5)
        L48:
            java.util.concurrent.atomic.AtomicLong r2 = new java.util.concurrent.atomic.AtomicLong
            r5 = 0
            r2.<init>(r5)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L79 java.lang.InterruptedException -> L86
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L79 java.lang.InterruptedException -> L86
            io.rong.rtlog.upload.FullUploadLogTask$1 r6 = new io.rong.rtlog.upload.FullUploadLogTask$1     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            r6.<init>()     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            io.rong.rtlog.upload.RtLogNativeProxy.setQueryFullLogListener(r6)     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            r2 = 4
            long r6 = r10.startTime     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            long r8 = r10.endTime     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            io.rong.rtlog.upload.RtLogNativeProxy.queryFullLog(r2, r6, r8)     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            r1.await()     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            r5.flush()     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            java.lang.String r0 = r4.getAbsolutePath()     // Catch: java.io.IOException -> L72 java.lang.InterruptedException -> L74 java.lang.Throwable -> L98
            r5.close()     // Catch: java.io.IOException -> L71
        L71:
            return r0
        L72:
            r1 = move-exception
            goto L7b
        L74:
            r1 = move-exception
            goto L88
        L76:
            r0 = move-exception
            r5 = r3
            goto L99
        L79:
            r1 = move-exception
            r5 = r3
        L7b:
            java.lang.String r2 = io.rong.rtlog.upload.FullUploadLogTask.TAG     // Catch: java.lang.Throwable -> L98
            io.rong.common.rlog.RLog.e(r2, r0, r1)     // Catch: java.lang.Throwable -> L98
            if (r5 == 0) goto L97
        L82:
            r5.close()     // Catch: java.io.IOException -> L97
            goto L97
        L86:
            r1 = move-exception
            r5 = r3
        L88:
            java.lang.String r2 = io.rong.rtlog.upload.FullUploadLogTask.TAG     // Catch: java.lang.Throwable -> L98
            io.rong.common.rlog.RLog.e(r2, r0, r1)     // Catch: java.lang.Throwable -> L98
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L98
            r0.interrupt()     // Catch: java.lang.Throwable -> L98
            if (r5 == 0) goto L97
            goto L82
        L97:
            return r3
        L98:
            r0 = move-exception
        L99:
            if (r5 == 0) goto L9e
            r5.close()     // Catch: java.io.IOException -> L9e
        L9e:
            goto La0
        L9f:
            throw r0
        La0:
            goto L9f
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.rtlog.upload.FullUploadLogTask.getLogFile():java.lang.String");
    }

    public boolean equals(Object obj) {
        if (obj instanceof FullUploadLogTask) {
            FullUploadLogTask fullUploadLogTask = (FullUploadLogTask) obj;
            if (fullUploadLogTask.getLogId() != null && fullUploadLogTask.getLogId().equals(getLogId())) {
                return true;
            }
        }
        return super.equals(obj);
    }

    public boolean execute() throws Throwable {
        String logFile = getLogFile();
        if (logFile == null) {
            return false;
        }
        return upload(logFile);
    }

    public String getLogId() {
        return this.logId;
    }

    @Override // io.rong.rtlog.upload.UploadLogTask
    protected String getUploadUrl() {
        return String.format(FULL_UPLOAD_URL_FORMAT, this.uploadUrl, encodeParams(this.version), encodeParams(this.appKey), encodeParams(this.userId), encodeParams(this.logId), encodeParams(this.deviceId), encodeParams(DeviceUtils.getDeviceBandModelVersion()));
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // io.rong.rtlog.upload.UploadLogTask
    protected void onUploadResponse(String str) {
    }
}
