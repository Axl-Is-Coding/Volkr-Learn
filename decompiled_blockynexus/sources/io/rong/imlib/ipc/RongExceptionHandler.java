package io.rong.imlib.ipc;

import android.content.Context;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.common.rlog.RLogConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class RongExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "RongExceptionHandler";
    private Context mContext;

    public RongExceptionHandler(Context context) {
        this.mContext = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws Throwable {
        FileOutputStream fileOutputStream;
        File file = new File(FileUtils.getCachePath(this.mContext, "crashlog") + "/crash_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + RLogConfig.LOG_SUFFIX);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (!file.createNewFile()) {
                        RLog.e(TAG, "crashFile.createNewFile() failed");
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            RLog.e(TAG, "uncaughtException", e3);
        }
        try {
            PrintStream printStream = new PrintStream(fileOutputStream);
            th.printStackTrace(printStream);
            printStream.close();
            fileOutputStream.close();
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            RLog.e(TAG, "uncaughtException", e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            RLog.e(TAG, "uncaughtException", th);
            System.exit(2);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    RLog.e(TAG, "uncaughtException", e5);
                }
            }
            throw th;
        }
        RLog.e(TAG, "uncaughtException", th);
        System.exit(2);
    }
}
