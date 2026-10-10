package io.rong.imlib.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import io.rong.common.RLog;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.LibHandlerStub;
import io.rong.imlib.statistics.CrashDetails;
import java.lang.Thread;

/* JADX INFO: loaded from: classes5.dex */
public class RongService extends Service implements Thread.UncaughtExceptionHandler {
    private final String TAG = RongService.class.getSimpleName();
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        RLog.d(this.TAG, "onBind, pid=" + Process.myPid());
        return new LibHandlerStub(this, intent.getStringExtra("appKey"), intent.getStringExtra("deviceId"));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        RLog.d(this.TAG, "onCreate, pid=" + Process.myPid());
        this.defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        RLog.d(this.TAG, "onDestroy, pid=" + Process.myPid());
        Process.killProcess(Process.myPid());
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        RLog.d(this.TAG, "onUnbind, pid=" + Process.myPid());
        return super.onUnbind(intent);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String string = th.toString();
        if (!TextUtils.isEmpty(string) && string.contains(":")) {
            string = string.substring(0, string.indexOf(":"));
        }
        FwLog.write(0, 1, FwLog.LogTag.L_CRASH_IPC_TRB_F.getTag(), "stacks|reason|env", FwLog.stackToString(th), string, CrashDetails.getIMCrashData(getApplicationContext(), th.toString()));
        this.defaultExceptionHandler.uncaughtException(thread, th);
    }
}
