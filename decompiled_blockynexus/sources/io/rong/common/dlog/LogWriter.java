package io.rong.common.dlog;

import io.rong.common.dlog.DLog;

/* JADX INFO: loaded from: classes5.dex */
public interface LogWriter {
    void close();

    void flush();

    void flushAndReport(boolean z, LogReporter logReporter, DLog.ILogUploadCallback iLogUploadCallback);

    void open();

    void write(String str);
}
