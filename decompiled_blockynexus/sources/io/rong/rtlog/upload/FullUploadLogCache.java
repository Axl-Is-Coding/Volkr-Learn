package io.rong.rtlog.upload;

import android.text.TextUtils;
import io.rong.common.rlog.RLog;

/* JADX INFO: loaded from: classes5.dex */
class FullUploadLogCache {
    private static final String COMMA = ",";
    private static final String TAG = "FullUploadLogCache";
    private String appKey;
    private String deviceId;
    private long endTime;
    private String logId;
    private long startTime;
    private String uri;
    private String userId;
    private String version;

    FullUploadLogCache(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
        this.version = str;
        this.deviceId = str2;
        this.appKey = str3;
        this.uri = str4;
        this.userId = str5;
        this.logId = str6;
        this.startTime = j;
        this.endTime = j2;
    }

    static FullUploadLogCache parseFromCSV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(COMMA);
            return new FullUploadLogCache(strArrSplit[0], strArrSplit[1], strArrSplit[2], strArrSplit[3], strArrSplit[4], strArrSplit[5], Long.parseLong(strArrSplit[6]), Long.parseLong(strArrSplit[7]));
        } catch (Exception e2) {
            RLog.e(TAG, "parseFromCSV", e2);
            return null;
        }
    }

    String getAppKey() {
        return this.appKey;
    }

    String getDeviceId() {
        return this.deviceId;
    }

    long getEndTime() {
        return this.endTime;
    }

    String getLogId() {
        return this.logId;
    }

    long getStartTime() {
        return this.startTime;
    }

    String getUri() {
        return this.uri;
    }

    String getUserId() {
        return this.userId;
    }

    String getVersion() {
        return this.version;
    }

    String toCSV() {
        return this.version + COMMA + this.deviceId + COMMA + this.appKey + COMMA + this.uri + COMMA + this.userId + COMMA + this.logId + COMMA + this.startTime + COMMA + this.endTime;
    }
}
