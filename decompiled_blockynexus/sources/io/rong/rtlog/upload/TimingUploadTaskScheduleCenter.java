package io.rong.rtlog.upload;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.rong.common.rlog.RLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class TimingUploadTaskScheduleCenter {
    private static final String TAG = "TimingUploadTaskScheduleCenter";
    private String appKey;
    private RtLogCache cache;
    private Context context;
    private String deviceId;
    private String logCacheDir;
    private String version;
    private LimitAliveSingleTaskExecutor executor = new LimitAliveSingleTaskExecutor();
    private boolean isStartSchedule = false;
    private long inBackgroundTime = -1;
    private boolean isStopInBackground = false;
    private RtLogTimingUploadConfig config = new RtLogTimingUploadConfig();

    TimingUploadTaskScheduleCenter(Context context, String str, String str2, String str3, RtLogCache rtLogCache, String str4) {
        this.context = context;
        this.version = str;
        this.deviceId = str2;
        this.appKey = str3;
        this.cache = rtLogCache;
        this.logCacheDir = str4;
        this.config.loadLogConfig(this.cache.loadTimingUploadConfigCache());
    }

    private synchronized void executeTask(final TimingUploadLogTask timingUploadLogTask, long j, final boolean z) {
        this.executor.execute(new Runnable() { // from class: io.rong.rtlog.upload.TimingUploadTaskScheduleCenter.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                TimingUploadTaskScheduleCenter.this.onTaskEnd(timingUploadLogTask, timingUploadLogTask.execute(), z);
            }
        }, j * 1000);
    }

    private synchronized long getDelayTime() {
        return ((long) this.config.getIntervalUploadTime()) * ((long) Math.pow(2.0d, this.config.getCurrentDelayTimes() - 1));
    }

    private synchronized void nextTask(long j, boolean z) {
        if (shouldStopInBackground()) {
            this.isStopInBackground = true;
            return;
        }
        if (this.isStartSchedule && this.config.isUploadEnabled()) {
            executeTask(obtainTask(), j, z);
        }
    }

    private synchronized TimingUploadLogTask obtainTask() {
        return new TimingUploadLogTask(this.context, this.version, this.deviceId, this.appKey, this.config.getLogLevel(), this.config.getUploadUrl(), this.logCacheDir);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTaskEnd(TimingUploadLogTask timingUploadLogTask, boolean z, boolean z2) {
        if (z) {
            try {
                if (!TextUtils.isEmpty(timingUploadLogTask.getUploadResponse())) {
                    try {
                        JSONObject jSONObject = new JSONObject(timingUploadLogTask.getUploadResponse());
                        int iOptInt = jSONObject.optInt("nextTime");
                        int iOptInt2 = jSONObject.optInt(FirebaseAnalytics.Param.LEVEL);
                        if (jSONObject.optInt("logSwitch") == 1) {
                            this.config.setUploadEnabled(true);
                            this.config.setIntervalUploadTime(iOptInt);
                            this.config.resetCurrentDelayTimes();
                            this.config.setLogLevel(iOptInt2);
                        } else {
                            this.config.setUploadEnabled(false);
                        }
                    } catch (JSONException e2) {
                        RLog.e(TAG, "onTaskEnd", e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            this.config.increaseDelayTimes();
        }
        nextTask(getDelayTime(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean shouldStopInBackground() {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.inBackgroundTime     // Catch: java.lang.Throwable -> L1c
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L19
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1c
            long r2 = r5.inBackgroundTime     // Catch: java.lang.Throwable -> L1c
            long r0 = r0 - r2
            r2 = 300000(0x493e0, double:1.482197E-318)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            monitor-exit(r5)
            return r0
        L1c:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.rtlog.upload.TimingUploadTaskScheduleCenter.shouldStopInBackground():boolean");
    }

    synchronized void endSchedule() {
        this.isStartSchedule = false;
    }

    synchronized void setToBackgroundTime(long j) {
        if (j > 0) {
            this.inBackgroundTime = j;
        } else {
            this.inBackgroundTime = -1L;
            if (this.isStopInBackground) {
                this.isStopInBackground = false;
                nextTask(getDelayTime(), true);
            }
        }
    }

    synchronized void startTask() {
        if (this.isStartSchedule) {
            return;
        }
        this.isStartSchedule = true;
        nextTask(30L, false);
    }

    synchronized void updateTimingUploadConfig(String str) {
        this.config.loadLogConfig(str);
        this.cache.saveTimingUploadConfig(str);
    }
}
