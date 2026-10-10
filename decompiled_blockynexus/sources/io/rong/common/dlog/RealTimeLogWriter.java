package io.rong.common.dlog;

import io.rong.common.dlog.DLog;
import java.util.Vector;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class RealTimeLogWriter implements LogWriter {
    private static final int Interval = 5;
    private static final int MAX_SIZE = 100;
    private ScheduledExecutorService executorService;
    private ScheduledFuture future;
    private Vector<String> lruLog = new Vector<>();
    private long startTime;
    private LogThresholdCallback thresholdCallback;

    public RealTimeLogWriter(ScheduledExecutorService scheduledExecutorService, LogThresholdCallback logThresholdCallback) {
        this.executorService = scheduledExecutorService;
        this.thresholdCallback = logThresholdCallback;
    }

    @Override // io.rong.common.dlog.LogWriter
    public void close() {
    }

    @Override // io.rong.common.dlog.LogWriter
    public void flush() {
    }

    @Override // io.rong.common.dlog.LogWriter
    public void flushAndReport(boolean z, LogReporter logReporter, DLog.ILogUploadCallback iLogUploadCallback) {
    }

    @Override // io.rong.common.dlog.LogWriter
    public void open() {
    }

    @Override // io.rong.common.dlog.LogWriter
    public void write(String str) {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
        this.lruLog.add(str);
        if (this.lruLog.size() > 100) {
            this.lruLog.remove(0);
        }
        ScheduledFuture scheduledFuture = this.future;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.future = this.executorService.schedule(new Runnable() { // from class: io.rong.common.dlog.RealTimeLogWriter.1
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    RealTimeLogWriter.this.thresholdCallback.onTimeout(RealTimeLogWriter.this.lruLog, RealTimeLogWriter.this.startTime + "", jCurrentTimeMillis + "");
                    RealTimeLogWriter.this.lruLog.clear();
                    RealTimeLogWriter.this.startTime = 0L;
                }
            }, 5L, TimeUnit.SECONDS);
        }
    }
}
