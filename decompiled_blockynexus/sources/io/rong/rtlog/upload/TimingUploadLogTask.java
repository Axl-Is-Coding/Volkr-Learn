package io.rong.rtlog.upload;

import android.content.Context;
import io.rong.common.rlog.RLog;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.navigation.NavigationCacheHelper;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class TimingUploadLogTask extends UploadLogTask {
    private static final String TAG = "TimingUploadLogTask";
    private static final String TIMING_UPLOAD_URL_FORMAT = "%s?version=%s&appkey=%s&userId=%s&deviceId=%s&deviceInfo=%s&platform=Android";
    private String appKey;
    private Context context;
    private String deviceId;
    private String logCacheDir;
    private int queryEndRecordId;
    private String queryFromTable;
    private String queryToTable;
    private int uploadLevel;
    private String uploadResponse;
    private String uploadUrl;
    private String version;

    public TimingUploadLogTask(Context context, String str, String str2, String str3, int i, String str4, String str5) {
        this.context = context;
        this.version = str;
        this.deviceId = str2;
        this.appKey = str3;
        this.uploadLevel = i;
        this.uploadUrl = str4;
        this.logCacheDir = str5;
    }

    private String getLocalUserId() {
        return NavigationCacheHelper.getUserId(this.context);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getLogFile() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.rtlog.upload.TimingUploadLogTask.getLogFile():java.lang.String");
    }

    public boolean execute() throws Throwable {
        String logFile = getLogFile();
        if (logFile == null) {
            return false;
        }
        File file = new File(logFile);
        if (file.exists() && file.length() == 0) {
            if (!file.delete()) {
                return true;
            }
            RLog.d(TAG, "upload file is empty,so do not upload and delete it.");
            return true;
        }
        boolean zUpload = upload(logFile);
        if (zUpload) {
            RtLogNativeProxy.reportTimingUploadFinished(this.queryFromTable, this.queryToTable, this.queryEndRecordId, System.currentTimeMillis());
        }
        return zUpload;
    }

    public String getUploadResponse() {
        return this.uploadResponse;
    }

    @Override // io.rong.rtlog.upload.UploadLogTask
    protected String getUploadUrl() {
        return String.format(TIMING_UPLOAD_URL_FORMAT, this.uploadUrl, encodeParams(this.version), encodeParams(this.appKey), encodeParams(getLocalUserId()), encodeParams(this.deviceId), encodeParams(DeviceUtils.getDeviceBandModelVersion()));
    }

    @Override // io.rong.rtlog.upload.UploadLogTask
    protected void onUploadResponse(String str) {
        this.uploadResponse = str;
    }
}
