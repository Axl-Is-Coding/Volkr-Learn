package io.rong.common.rlog;

import io.rong.common.dlog.LogThreadPool;

/* JADX INFO: loaded from: classes5.dex */
public class RLogReporter {
    private static final String BOUNDARY = "03297e90-eed0-4cec-b18b-92d2574b9331";
    LogThreadPool mLogThreadPool = new LogThreadPool(1);
    private UploadCallback mUploadCallback;

    public interface IUploadListener {
        void onUploadFinish(boolean z, String str);
    }

    public interface UploadCallback {
        public static final int FILE_EMPTY = -3;
        public static final int FILE_NOT_FOUND = -4;
        public static final int HTTP_ERROR = -5;
        public static final int PARAMS_ERROR = -1;
        public static final int SERVER_ERROR = -2;

        void fail(int i, String str, Throwable th);

        void success();
    }

    public static class UploadConfig {
        private String appKey;
        private String endTime;
        private String filePath;
        private String sdkVer;
        private String startTime;
        private String uploadUrl;
        private String userId;

        public UploadConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.uploadUrl = str;
            this.filePath = str2;
            this.startTime = str3;
            this.endTime = str4;
            this.sdkVer = str5;
            this.appKey = str6;
            this.userId = str7;
        }

        public String getAppKey() {
            return this.appKey;
        }

        public String getEndTime() {
            return this.endTime;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public String getSdkVer() {
            return this.sdkVer;
        }

        public String getStartTime() {
            return this.startTime;
        }

        public String getUploadUrl() {
            return this.uploadUrl;
        }

        public String getUserId() {
            return this.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:(3:144|21|22)|(3:146|23|(5:151|24|25|148|26))|(12:27|(1:29)(1:153)|75|129|81|(1:83)|(1:85)|(2:133|87)|(2:127|92)|(2:97|135)|98|99)|30|150|31|(2:32|(1:34)(1:154))|35|(3:37|(1:39)|40)(2:41|(1:43))|(1:45)|125|46|(2:140|51)|55|135|98|99) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:144|21|22|146|23|(5:151|24|25|148|26)|(12:27|(1:29)(1:153)|75|129|81|(1:83)|(1:85)|(2:133|87)|(2:127|92)|(2:97|135)|98|99)|30|150|31|(2:32|(1:34)(1:154))|35|(3:37|(1:39)|40)(2:41|(1:43))|(1:45)|125|46|(2:140|51)|55|135|98|99) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0177, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0178, code lost:
    
        io.rong.common.rlog.RLog.e("RongLog", "uploadFile", r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0190, code lost:
    
        r14 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0193, code lost:
    
        r14 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bb A[Catch: all -> 0x01e5, TRY_LEAVE, TryCatch #4 {all -> 0x01e5, blocks: (B:81:0x01b4, B:83:0x01bb), top: B:129:0x01b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01dc A[Catch: IOException -> 0x018a, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x018a, blocks: (B:55:0x0185, B:97:0x01dc), top: B:136:0x0066 }] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x018b -> B:135:0x01df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean uploadFile(io.rong.common.rlog.RLogReporter.UploadConfig r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.common.rlog.RLogReporter.uploadFile(io.rong.common.rlog.RLogReporter$UploadConfig):boolean");
    }

    public void report(final UploadConfig uploadConfig, final IUploadListener iUploadListener) {
        this.mLogThreadPool.getExecutorService().submit(new Runnable() { // from class: io.rong.common.rlog.RLogReporter.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                boolean zUploadFile = RLogReporter.this.uploadFile(uploadConfig);
                IUploadListener iUploadListener2 = iUploadListener;
                if (iUploadListener2 != null) {
                    iUploadListener2.onUploadFinish(zUploadFile, uploadConfig.getFilePath());
                }
            }
        });
    }

    public void setUploadCallback(UploadCallback uploadCallback) {
        this.mUploadCallback = uploadCallback;
    }

    public void report(UploadConfig uploadConfig) {
        report(uploadConfig, null);
    }
}
