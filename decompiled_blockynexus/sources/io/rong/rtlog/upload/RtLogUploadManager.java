package io.rong.rtlog.upload;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.fwlog.FwLog;
import io.rong.common.rlog.RLog;
import io.rong.imlib.model.Message;
import io.rong.imlib.navigation.NavigationCacheHelper;
import io.rong.message.LogCmdMessage;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class RtLogUploadManager {
    private static final String FULL_UPLOAD_SENDER_USER_ID = "rongcloudsystem";
    private static final String TAG = "RtLogUploadManager";
    private Context context;
    private FullUploadTaskScheduleCenter fullUploadCenter;
    private long lastInBackgroundTimeMillis;
    private TimingUploadTaskScheduleCenter timingUploadCenter;
    private LimitAliveSingleTaskExecutor workExecutor;

    private static class SingletonHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final RtLogUploadManager instance = new RtLogUploadManager();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFullUploadTask(String str, String str2, String str3, long j, long j2) {
        FullUploadTaskScheduleCenter fullUploadTaskScheduleCenter = this.fullUploadCenter;
        if (fullUploadTaskScheduleCenter != null) {
            fullUploadTaskScheduleCenter.addTask(str, str2, str3, j, j2);
        } else {
            RLog.d(TAG, "addFullUploadTask - fullUploadCenter is null, may not init.");
        }
    }

    public static RtLogUploadManager getInstance() {
        return SingletonHolder.instance;
    }

    private String getSessionId() {
        UUID uuidRandomUUID = UUID.randomUUID();
        String string = uuidRandomUUID.toString();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(uuidRandomUUID.toString().getBytes());
            String str = new String(Base64.encode(messageDigest.digest(), 0));
            try {
                return str.replace("=", "").replace("+", "-").replace("/", "_").replace(UMCustomLogInfoBuilder.LINE_SEP, "");
            } catch (NoSuchAlgorithmException unused) {
                return str;
            }
        } catch (NoSuchAlgorithmException unused2) {
            return string;
        }
    }

    private String getUploadFileCacheDir() {
        Context context = this.context;
        if (context == null) {
            RLog.d(TAG, "getUploadFileCacheDir - context is null, may not init.");
            return null;
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        File cacheDir = this.context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getAbsolutePath();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalInit(Context context, String str, String str2, String str3) {
        this.context = context.getApplicationContext();
        FwLog.setLogConsolePrinter(new RtFwLogConsolePrinter(this.context));
        FwLog.listenUncaughtException(context);
        RtLogCache rtLogCache = new RtLogCache(this.context, str3);
        FullUploadTaskScheduleCenter fullUploadTaskScheduleCenter = this.fullUploadCenter;
        if (fullUploadTaskScheduleCenter != null) {
            fullUploadTaskScheduleCenter.endSchedule();
        }
        this.fullUploadCenter = new FullUploadTaskScheduleCenter(str, str2, str3, rtLogCache, getUploadFileCacheDir());
        this.fullUploadCenter.loadCacheTaskAndStart();
        File file = new File(context.getFilesDir() + File.separator + str3 + File.separator + "rclog");
        if (!file.exists() && !file.mkdirs()) {
            RLog.e(TAG, "create log db directory failed. Write log will not available.");
            return;
        }
        if (!RtLogNativeProxy.initialize(context, file.getAbsolutePath(), str3, getSessionId())) {
            RLog.e(TAG, "RtLogNative initialize failed. Write log will not available.");
        }
        FwLog.setDirectWriter(new RtFwLogWriter(context));
        TimingUploadTaskScheduleCenter timingUploadTaskScheduleCenter = this.timingUploadCenter;
        if (timingUploadTaskScheduleCenter != null) {
            timingUploadTaskScheduleCenter.endSchedule();
        }
        this.timingUploadCenter = new TimingUploadTaskScheduleCenter(context, str, str2, str3, rtLogCache, getUploadFileCacheDir());
        this.timingUploadCenter.setToBackgroundTime(this.lastInBackgroundTimeMillis);
    }

    public void createFullUploadTask(final Message message) {
        this.workExecutor.execute(new Runnable() { // from class: io.rong.rtlog.upload.RtLogUploadManager.5
            @Override // java.lang.Runnable
            public void run() {
                if ((message.getContent() instanceof LogCmdMessage) && RtLogUploadManager.FULL_UPLOAD_SENDER_USER_ID.equals(message.getSenderUserId())) {
                    LogCmdMessage logCmdMessage = (LogCmdMessage) message.getContent();
                    String platform = logCmdMessage.getPlatform();
                    String packageName = logCmdMessage.getPackageName();
                    if (platform == null || !platform.toLowerCase().contains("android")) {
                        return;
                    }
                    if (TextUtils.isEmpty(packageName) || RtLogUploadManager.this.context.getPackageName().toLowerCase().equals(packageName.toLowerCase())) {
                        String uri = logCmdMessage.getUri();
                        if (!TextUtils.isEmpty(uri) && !uri.toLowerCase().startsWith("http")) {
                            uri = String.format((Build.VERSION.SDK_INT < 28 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) ? "http://%s/" : "https://%s/", uri);
                        }
                        RtLogUploadManager rtLogUploadManager = RtLogUploadManager.this;
                        rtLogUploadManager.addFullUploadTask(uri, NavigationCacheHelper.getUserId(rtLogUploadManager.context), logCmdMessage.getLogId(), logCmdMessage.getStartTime(), logCmdMessage.getEndTime());
                    }
                }
            }
        });
    }

    public synchronized void init(final Context context, final String str, final String str2, final String str3) {
        if (context != null) {
            this.workExecutor.execute(new Runnable() { // from class: io.rong.rtlog.upload.RtLogUploadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    RtLogUploadManager.this.internalInit(context.getApplicationContext(), str, str2, str3);
                }
            });
        }
    }

    public void setIsBackgroundMode(final boolean z) {
        this.workExecutor.execute(new Runnable() { // from class: io.rong.rtlog.upload.RtLogUploadManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    RtLogUploadManager.this.lastInBackgroundTimeMillis = System.currentTimeMillis();
                } else {
                    RtLogUploadManager.this.lastInBackgroundTimeMillis = -1L;
                }
                if (RtLogUploadManager.this.timingUploadCenter != null) {
                    RtLogUploadManager.this.timingUploadCenter.setToBackgroundTime(RtLogUploadManager.this.lastInBackgroundTimeMillis);
                }
            }
        });
    }

    public void startTimingUploadTask() {
        if (this.timingUploadCenter != null) {
            this.workExecutor.execute(new Runnable() { // from class: io.rong.rtlog.upload.RtLogUploadManager.2
                @Override // java.lang.Runnable
                public void run() {
                    RtLogUploadManager.this.timingUploadCenter.startTask();
                }
            });
        } else {
            RLog.d(TAG, "startTimingUploadTask - timingUploadCenter is null, may not init.");
        }
    }

    public void updateTimingUploadConfig(final String str) {
        if (this.timingUploadCenter != null) {
            this.workExecutor.execute(new Runnable() { // from class: io.rong.rtlog.upload.RtLogUploadManager.4
                @Override // java.lang.Runnable
                public void run() {
                    RtLogUploadManager.this.timingUploadCenter.updateTimingUploadConfig(str);
                }
            });
        } else {
            RLog.d(TAG, "updateConfig - timingUploadCenter is null, may not init.");
        }
    }

    private RtLogUploadManager() {
        this.workExecutor = new LimitAliveSingleTaskExecutor();
        this.lastInBackgroundTimeMillis = -1L;
    }
}
