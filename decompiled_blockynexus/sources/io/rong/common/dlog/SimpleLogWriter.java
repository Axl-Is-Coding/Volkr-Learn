package io.rong.common.dlog;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.dlog.DLog;
import io.rong.common.rlog.RLogConfig;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleLogWriter implements LogWriter {
    private FileWriter fileWriter;
    private File logFile;
    protected String logPath;
    private LogThresholdCallback sizeCallback;
    private Handler writeHandler;

    public SimpleLogWriter(String str) {
        this.logPath = str;
        open();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushAndStamp() {
        this.logFile = new File(this.logPath);
        if (!this.logFile.exists() || this.logFile.length() == 0) {
            Log.e("FwLog", "file not exist " + this.logPath);
            return;
        }
        close();
        long startLogTime = LogEntity.getInstance().getStartLogTime();
        long jLastModified = this.logFile.lastModified();
        if (jLastModified == 0) {
            jLastModified = System.currentTimeMillis();
        }
        String str = startLogTime + "_" + jLastModified + getZipFileSuffix();
        if (LogZipper.gzipFile(this.logFile.getAbsolutePath(), LogEntity.getInstance().getLogDir() + File.separator + str)) {
            this.logFile.delete();
            open();
            LogEntity.getInstance().addLogStamp(str);
        }
        LogEntity.getInstance().setStartLogTime(System.currentTimeMillis());
        Log.e("FwLog", "zip file logPath = " + this.logPath);
    }

    @Override // io.rong.common.dlog.LogWriter
    public void close() {
        try {
            if (this.fileWriter != null) {
                this.fileWriter.close();
            }
        } catch (IOException e2) {
            Log.e("FwLog", "close file error " + this.logPath);
            e2.printStackTrace();
        }
    }

    @Override // io.rong.common.dlog.LogWriter
    public void flush() {
        this.writeHandler.post(new Runnable() { // from class: io.rong.common.dlog.SimpleLogWriter.2
            @Override // java.lang.Runnable
            public void run() {
                SimpleLogWriter.this.flushAndStamp();
            }
        });
    }

    @Override // io.rong.common.dlog.LogWriter
    public void flushAndReport(final boolean z, final LogReporter logReporter, final DLog.ILogUploadCallback iLogUploadCallback) {
        if (LogEntity.getInstance().getUserId() != null) {
            this.writeHandler.post(new Runnable() { // from class: io.rong.common.dlog.SimpleLogWriter.3
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        SimpleLogWriter.this.flushAndStamp();
                    }
                    logReporter.reportFileLog(iLogUploadCallback);
                }
            });
        } else if (iLogUploadCallback != null) {
            iLogUploadCallback.onLogUploaded(-1);
        }
    }

    protected String getZipFileSuffix() {
        return RLogConfig.ZIP_SUFFIX;
    }

    protected final void internalWrite(String str) {
        try {
            if (this.fileWriter != null) {
                this.fileWriter.write(str + UMCustomLogInfoBuilder.LINE_SEP);
                this.fileWriter.flush();
            }
        } catch (IOException e2) {
            Log.e("FwLog", "write file error " + this.logPath);
            e2.printStackTrace();
        }
        LogThresholdCallback logThresholdCallback = this.sizeCallback;
        if (logThresholdCallback != null) {
            logThresholdCallback.onSize(this.logFile.length());
        }
    }

    @Override // io.rong.common.dlog.LogWriter
    public void open() {
        this.logFile = new File(this.logPath);
        try {
            this.fileWriter = new FileWriter(this.logFile, true);
        } catch (IOException e2) {
            Log.e("FwLog", "open file error " + this.logPath);
            e2.printStackTrace();
        }
    }

    @Override // io.rong.common.dlog.LogWriter
    public void write(final String str) {
        if (Thread.currentThread().getName().equals("cn.rongcloud.fwLogWriter")) {
            internalWrite(str);
        } else {
            this.writeHandler.post(new Runnable() { // from class: io.rong.common.dlog.SimpleLogWriter.1
                @Override // java.lang.Runnable
                public void run() {
                    SimpleLogWriter.this.internalWrite(str);
                }
            });
        }
    }

    protected SimpleLogWriter(String str, LogThresholdCallback logThresholdCallback) {
        HandlerThread handlerThread = new HandlerThread("cn.rongcloud.fwLogWriter");
        handlerThread.start();
        this.writeHandler = new Handler(handlerThread.getLooper());
        this.sizeCallback = logThresholdCallback;
        this.logPath = str;
        open();
    }
}
