package io.rong.common.dlog;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import io.rong.common.dlog.DLog;
import io.rong.imlib.statistics.CrashDetails;
import java.io.File;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
class DLogImp extends DLog {
    private static ArrayList<String> levelArray = new ArrayList<>();
    private static SparseArray<String> typeArray = new SparseArray<>();
    private Context context;
    private LogWriter crashLogWriter;
    private LogWriter fileLogWriter;
    private LogReporter logReporter;
    private LogWriter realTimeLogWriter;
    private LogThreadPool threadPool = new LogThreadPool(3);

    static {
        levelArray.add("N");
        levelArray.add("F");
        levelArray.add("E");
        levelArray.add("W");
        levelArray.add("I");
        levelArray.add("D");
        levelArray.add("V");
        typeArray.put(1, "APP");
        typeArray.put(2, "PTC");
        typeArray.put(4, "ENV");
        typeArray.put(8, "DET");
        typeArray.put(16, "CON");
        typeArray.put(32, "RCO");
        typeArray.put(64, "CRM");
        typeArray.put(128, "MSG");
        typeArray.put(256, "MED");
        typeArray.put(512, "LOG");
        typeArray.put(1024, "DEB");
        typeArray.put(DLog.CRS, "CRS");
        typeArray.put(4096, "RTC");
        typeArray.put(8192, "EPT");
    }

    public DLogImp(final Context context, String str, String str2) {
        this.context = context;
        LogEntity.init(context);
        this.fileLogWriter = new SimpleLogWriter(LogEntity.getInstance().getLogDir() + File.separator + LogEntity.LogFileName, new LogThresholdCallback() { // from class: io.rong.common.dlog.DLogImp.1
            @Override // io.rong.common.dlog.LogThresholdCallback
            public void onSize(long j) {
                if (j > LogEntity.getInstance().getFileMaxSize()) {
                    DLogImp.this.fileLogWriter.flush();
                }
            }
        });
        this.crashLogWriter = new CrashLogWriter(LogEntity.getInstance().getLogDir());
        this.realTimeLogWriter = new RealTimeLogWriter(this.threadPool.getExecutorService(), new LogThresholdCallback() { // from class: io.rong.common.dlog.DLogImp.2
            @Override // io.rong.common.dlog.LogThresholdCallback
            void onTimeout(Vector<String> vector, String str3, String str4) {
                DLogImp.this.logReporter.reportLruLog(vector, str3, str4);
            }
        });
        this.logReporter = new LogReporter(this.threadPool);
        Timer timer = new Timer();
        if (LogEntity.getInstance().getLogMode() != 1 && LogEntity.getInstance().getMonitorLevel() > 0 && LogEntity.getInstance().getMonitorType() > 0) {
            timer.schedule(new TimerTask() { // from class: io.rong.common.dlog.DLogImp.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    DLogImp.this.fileLogWriter.flushAndReport(true, DLogImp.this.logReporter, null);
                }
            }, LogEntity.getInstance().getUploadTimeInterval(), LogEntity.getInstance().getUploadTimeInterval());
        }
        Log.i("FwLog", "init FwLog: LogMode = " + LogEntity.getInstance().getLogMode() + ", monitorLevel = " + LogEntity.getInstance().getMonitorLevel() + ", monitorType = " + LogEntity.getInstance().getMonitorType());
        if (LogEntity.getInstance().getLogMode() != 1 && LogEntity.getInstance().getMonitorLevel() > 0 && LogEntity.getInstance().getMonitorType() > 0) {
            Log.d("FwLog", "upload the last log");
            this.fileLogWriter.flushAndReport(true, this.logReporter, null);
        }
        writeLogHeader();
        LogEntity.getInstance().setAppKey(str);
        LogEntity.getInstance().setSdkVer(str2);
        timer.schedule(new TimerTask() { // from class: io.rong.common.dlog.DLogImp.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.rong.common.dlog.DLogImp.4.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread, Throwable th) {
                        String string = th.toString();
                        if (!TextUtils.isEmpty(string) && string.contains(":")) {
                            string = string.substring(0, string.indexOf(":"));
                        }
                        DLog.write(1, DLog.CRS, DLog.LogTag.L_CRASH_MAIN_TRB_F.getTag(), "stack|reason|env", DLog.stackToString(th), string, CrashDetails.getIMCrashData(context, th.toString()));
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                        if (uncaughtExceptionHandler != null) {
                            uncaughtExceptionHandler.uncaughtException(thread, th);
                        }
                    }
                });
            }
        }, 2000L);
    }

    private boolean isNetworkOnline() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    private static void showConsoleLog(int i, String str, String str2) {
        String str3 = "[RC:" + str + "]";
        switch (i) {
            case 1:
                Log.wtf(str3, str2);
                break;
            case 2:
                Log.e(str3, str2);
                break;
            case 3:
                Log.w(str3, str2);
                break;
            case 4:
                Log.i(str3, str2);
                break;
            case 5:
                Log.d(str3, str2);
                break;
            case 6:
                Log.v(str3, str2);
                break;
        }
    }

    private void writeLogHeader() {
        writeLog(System.currentTimeMillis(), 4, 512, "Log-Opened", DLog.formatMetaJson(false, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), null, new Object[0]));
    }

    public String formatLog(long j, int i, int i2, String str, String str2) {
        if (LogEntity.getInstance().getLogMode() != 0 || i <= LogEntity.getInstance().getConsoleLogLevel()) {
            showConsoleLog(i, str, str2);
            if (LogEntity.getInstance().getLogListener() != null) {
                LogEntity.getInstance().getLogListener().onLogEvent("[RC:" + str + "]" + str2);
            }
        }
        if (LogEntity.getInstance().getLogMode() == 0 && (i > LogEntity.getInstance().getMonitorLevel() || (LogEntity.getInstance().getMonitorType() & i2) == 0)) {
            return null;
        }
        if (LogEntity.getInstance().getLogMode() != 1) {
            return "{\"time\":" + j + ",\"level\":\"" + levelArray.get(i) + "\",\"type\":\"" + typeArray.get(i2) + "\",\"tag\":\"" + str + "\",\"meta\":" + str2 + "}";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("gmt"));
        return "{\"time\":\"" + simpleDateFormat.format(new Date(j)) + "\",\"level\":\"" + levelArray.get(i) + "\",\"type\":\"" + typeArray.get(i2) + "\",\"tag\":\"" + str + "\",\"meta\":" + str2 + "}";
    }

    public String formatRtLog(long j, int i, int i2, String str, String str2) {
        return "{\"time\":" + j + ",\"level\":\"" + levelArray.get(i) + "\",\"type\":\"" + typeArray.get(i2) + "\",\"tag\":\"" + str + "\",\"meta\":" + str2 + "}";
    }

    public void uploadLog(DLog.ILogUploadCallback iLogUploadCallback) {
        this.fileLogWriter.flushAndReport(true, this.logReporter, iLogUploadCallback);
    }

    public void writeLog(long j, int i, int i2, String str, String str2) {
        String log = formatLog(j, i, i2, str, str2);
        if (log != null) {
            if (i2 == 2048) {
                this.crashLogWriter.write(log);
            } else {
                this.fileLogWriter.write(log);
            }
        }
    }

    public void writeRtLog(long j, int i, int i2, String str, String str2) {
        String rtLog;
        if (LogEntity.getInstance().getLogMode() == 0 && isNetworkOnline() && (rtLog = formatRtLog(j, i, i2, str, str2)) != null) {
            this.realTimeLogWriter.write(rtLog);
        }
    }
}
