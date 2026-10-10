package io.rong.common.rlog;

import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class LogFileWriter {
    private String mFilePath;
    private FileWriter mFileWriter;
    private IWriterListener mListener;
    private File mLogFile;
    private int openRetry;
    ExecutorService pool;
    private long timestamp;

    interface IWriterListener {
        void onFileCreate(long j);

        void onWriteFinish(long j, String str);
    }

    interface IWriterOnStopListener {
        void onStopWrite(String str);
    }

    public LogFileWriter(String str) {
        this(str, null);
    }

    private boolean validateOpen() {
        if (this.openRetry >= 3) {
            return false;
        }
        return this.timestamp == 0 || System.currentTimeMillis() - this.timestamp >= 5000;
    }

    public void close() {
        FileWriter fileWriter = this.mFileWriter;
        if (fileWriter != null) {
            try {
                fileWriter.close();
                this.mFileWriter = null;
            } catch (IOException e2) {
                Log.e("RongLog", "RLogFileProcessor close error", e2);
            }
        }
    }

    public boolean open() {
        if (!validateOpen()) {
            return false;
        }
        try {
            this.mLogFile = new File(this.mFilePath);
            if (!this.mLogFile.exists() && this.mListener != null) {
                this.mListener.onFileCreate(System.currentTimeMillis());
            }
            File parentFile = this.mLogFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            this.mFileWriter = new FileWriter(this.mLogFile, true);
            this.openRetry = 0;
            this.timestamp = 0L;
            return true;
        } catch (IOException e2) {
            Log.e("RongLog", "open file error " + this.mFilePath, e2);
            this.openRetry = this.openRetry + 1;
            this.timestamp = System.currentTimeMillis();
            return false;
        }
    }

    public void stopWrite(final IWriterOnStopListener iWriterOnStopListener) {
        this.pool.submit(new Runnable() { // from class: io.rong.common.rlog.LogFileWriter.2
            @Override // java.lang.Runnable
            public void run() {
                iWriterOnStopListener.onStopWrite(LogFileWriter.this.mFilePath);
            }
        });
    }

    public void write(final String str) {
        this.pool.submit(new Runnable() { // from class: io.rong.common.rlog.LogFileWriter.1
            @Override // java.lang.Runnable
            public void run() {
                if (LogFileWriter.this.mFileWriter != null || LogFileWriter.this.open()) {
                    try {
                        LogFileWriter.this.mFileWriter.write(str);
                        LogFileWriter.this.mFileWriter.flush();
                        if (LogFileWriter.this.mListener != null) {
                            LogFileWriter.this.mListener.onWriteFinish(LogFileWriter.this.mLogFile.length(), LogFileWriter.this.mLogFile.getAbsolutePath());
                        }
                    } catch (Exception e2) {
                        Log.e("RongLog", "write file error " + LogFileWriter.this.mFilePath, e2);
                    }
                }
            }
        });
    }

    public LogFileWriter(String str, IWriterListener iWriterListener) {
        this.openRetry = 0;
        this.timestamp = 0L;
        this.pool = Executors.newSingleThreadExecutor();
        this.mFilePath = str;
        this.mListener = iWriterListener;
    }
}
