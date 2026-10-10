package io.rong.rtlog.upload;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
class FullUploadTaskScheduleCenter {
    private String appKey;
    private String deviceId;
    private RtLogCache logCache;
    private String logCacheDir;
    private String version;
    private LinkedList<FullUploadLogTask> taskQueue = new LinkedList<>();
    private int retryTaskTimes = 0;
    private LimitAliveSingleTaskExecutor executor = new LimitAliveSingleTaskExecutor();

    FullUploadTaskScheduleCenter(String str, String str2, String str3, RtLogCache rtLogCache, String str4) {
        this.version = str;
        this.deviceId = str2;
        this.appKey = str3;
        this.logCache = rtLogCache;
        this.logCacheDir = str4;
    }

    private synchronized void executeTask(final FullUploadLogTask fullUploadLogTask, long j) {
        this.executor.execute(new Runnable() { // from class: io.rong.rtlog.upload.FullUploadTaskScheduleCenter.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                FullUploadTaskScheduleCenter.this.onTaskEnd(fullUploadLogTask, fullUploadLogTask.execute());
            }
        }, j * 1000);
    }

    private synchronized long getRetryDelayTime() {
        return ((long) Math.pow(2.0d, this.retryTaskTimes - 1)) * 5;
    }

    private synchronized void nextTask() {
        if (!this.taskQueue.isEmpty()) {
            executeTask(this.taskQueue.getLast(), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTaskEnd(FullUploadLogTask fullUploadLogTask, boolean z) {
        if (z) {
            this.logCache.removeFullUploadTaskCache(fullUploadLogTask.getLogId());
            this.taskQueue.remove(fullUploadLogTask);
            this.retryTaskTimes = 0;
            nextTask();
        } else if (this.retryTaskTimes < 2) {
            this.retryTaskTimes++;
            executeTask(fullUploadLogTask, getRetryDelayTime());
        } else {
            this.taskQueue.remove(fullUploadLogTask);
            this.retryTaskTimes = 0;
            nextTask();
        }
    }

    synchronized void addTask(String str, String str2, String str3, long j, long j2) {
        this.logCache.addFullUploadTaskCache(this.version, this.deviceId, this.appKey, str, str2, str3, j, j2);
        loadCacheTaskAndStart();
    }

    synchronized void endSchedule() {
        this.taskQueue.clear();
    }

    synchronized void loadCacheTaskAndStart() {
        this.taskQueue.clear();
        for (FullUploadLogCache fullUploadLogCache : this.logCache.loadFullUploadLogCacheList()) {
            this.taskQueue.add(new FullUploadLogTask(fullUploadLogCache.getVersion(), this.deviceId, this.appKey, fullUploadLogCache.getUri(), fullUploadLogCache.getUserId(), fullUploadLogCache.getLogId(), fullUploadLogCache.getStartTime(), fullUploadLogCache.getEndTime(), this.logCacheDir));
        }
        if (!this.executor.isExecutingTask()) {
            nextTask();
        }
    }
}
