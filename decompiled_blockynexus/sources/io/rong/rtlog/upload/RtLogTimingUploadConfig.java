package io.rong.rtlog.upload;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.rong.common.rlog.RLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class RtLogTimingUploadConfig {
    private static final String TAG = "RtLogTimingUploadConfig";
    private boolean isUploadEnabled;
    private String uploadUrl = checkUploadHttpProtocol("logcollection.ronghub.com");
    private int logLevel = 1;
    private int intervalUploadTime = 30;
    private int maxDelayTimes = 5;
    private int currentDelayTimes = 1;

    RtLogTimingUploadConfig() {
    }

    private String checkUploadHttpProtocol(String str) {
        if (TextUtils.isEmpty(str) || str.toLowerCase().startsWith("http")) {
            return str;
        }
        return String.format((Build.VERSION.SDK_INT < 28 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) ? "http://%s/" : "https://%s/", str);
    }

    public int getCurrentDelayTimes() {
        return this.currentDelayTimes;
    }

    public int getIntervalUploadTime() {
        return this.intervalUploadTime;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public void increaseDelayTimes() {
        int i = this.currentDelayTimes;
        if (i < this.maxDelayTimes) {
            this.currentDelayTimes = i + 1;
        }
    }

    public boolean isUploadEnabled() {
        return this.isUploadEnabled;
    }

    void loadLogConfig(String str) {
        resetCurrentDelayTimes();
        if ("default_config".equals(str)) {
            this.isUploadEnabled = true;
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.isUploadEnabled = false;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.uploadUrl = checkUploadHttpProtocol(jSONObject.optString("url"));
            this.logLevel = jSONObject.optInt(FirebaseAnalytics.Param.LEVEL);
            this.intervalUploadTime = jSONObject.optInt("itv");
            this.maxDelayTimes = jSONObject.optInt("times");
            if (this.maxDelayTimes < 1) {
                this.maxDelayTimes = 1;
            }
            this.isUploadEnabled = true;
        } catch (JSONException e2) {
            RLog.e(TAG, "parseLogConfig error", e2);
        }
    }

    public void resetCurrentDelayTimes() {
        this.currentDelayTimes = 1;
    }

    public void setIntervalUploadTime(int i) {
        this.intervalUploadTime = i;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public void setMaxDelayTimes(int i) {
        this.maxDelayTimes = i;
    }

    public void setUploadEnabled(boolean z) {
        this.isUploadEnabled = z;
    }
}
