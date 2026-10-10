package io.rong.common.dlog;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import io.rong.common.dlog.DLog;
import io.rong.imlib.common.RongLibConst;
import io.rong.imlib.common.SavePathUtils;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class LogEntity {
    public static final String CrashLogFileName = "rong_sdk_crash.log";
    private static final String LOG_DIR = "rong_log";
    public static final String LogFileName = "rong_sdk.log";
    private static final String Log_Default_Url = "https://feedback.cn.ronghub.com";
    public static final int MODE_DEBUG = 1;
    public static final int MODE_RELEASE = 0;
    public static final int MODE_TEST = 2;
    private static final String SP_APP_KEY = "APP_KEY";
    private static final String SP_MONITOR_LEVEL = "MONITOR_LEVEL";
    private static final String SP_MONITOR_TYPE = "MONITOR_TYPE";
    private static final String SP_NAME = "FwLog";
    private static final String SP_OFFLINE_LOG_SERVER = "OFFLINE_LOG_SERVER";
    private static final String SP_ONLINE_LOG_SERVER = "ONLINE_LOG_SERVER";
    private static final String SP_SDK_VER = "SDK_VER";
    private static final String SP_START_LOG_TIME = "START_LOG_TIME";
    private static final String SP_TOKEN = "TOKEN";
    private static final String SP_UPLOAD_CACHE_LIST = "UPLOAD_CACHE_LIST";
    private static final String SP_USER_ID = "USER_ID";
    private static LogEntity instance;
    private String appKey;
    private int consoleLogLevel;
    private boolean isDebugMode;
    private String logDir;
    private DLog.ILogListener logListener;
    private int monitorLevel;
    private int monitorType;
    private String offlineLogServer = null;
    private String onlineLogServer = null;
    private String sdkVer;
    private SharedPreferences sharedPreferences;
    private long startLogTime;
    private String token;
    private String userId;

    private LogEntity(Context context) {
        File externalFilesDir = null;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        this.isDebugMode = (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
        this.sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
        if (!SavePathUtils.isSavePathEmpty()) {
            this.logDir = SavePathUtils.getSavePath() + File.separator + LOG_DIR;
            File file = new File(this.logDir);
            if (file.exists()) {
                return;
            }
            file.mkdirs();
            return;
        }
        try {
            externalFilesDir = context.getExternalFilesDir(LOG_DIR);
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
        if (externalFilesDir != null) {
            this.logDir = externalFilesDir.getAbsolutePath();
            return;
        }
        try {
            this.logDir = context.getFilesDir().getAbsoluteFile() + File.separator + LOG_DIR;
        } catch (Exception e3) {
            DLog.write(1, 512, DLog.LogTag.L_CRASH_MAIN_EPT_E.getTag(), "stacks", DLog.stackToString(e3));
        }
    }

    public static LogEntity getInstance() {
        LogEntity logEntity = instance;
        if (logEntity != null) {
            return logEntity;
        }
        throw new RuntimeException("LogEntity.init() has not been called.");
    }

    static void init(Context context) {
        if (instance == null) {
            instance = new LogEntity(context);
        }
    }

    void addLogStamp(String str) {
        JSONArray uploadCacheList = getUploadCacheList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filename", str);
            jSONObject.put("sdkVer", getInstance().getSdkVer());
            jSONObject.put("appKey", getInstance().getAppKey());
            jSONObject.put("userId", getInstance().getUserId());
            jSONObject.put(RongLibConst.KEY_TOKEN, getInstance().getToken());
            uploadCacheList.put(jSONObject);
        } catch (JSONException e2) {
            DLog.write(1, 512, DLog.LogTag.G_CRASH_E.getTag(), "stacks", DLog.stackToString(e2));
            e2.printStackTrace();
        }
        setUploadCacheList(uploadCacheList);
    }

    public void deleteUploadCacheList(int i) {
        synchronized (this.sharedPreferences) {
            JSONArray uploadCacheList = getUploadCacheList();
            if (uploadCacheList != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    uploadCacheList.remove(i);
                }
                this.sharedPreferences.edit().putString(SP_UPLOAD_CACHE_LIST, uploadCacheList.toString()).apply();
            }
        }
    }

    String getAppKey() {
        if (this.appKey == null) {
            this.appKey = this.sharedPreferences.getString(SP_APP_KEY, null);
        }
        return this.appKey;
    }

    int getConsoleLogLevel() {
        return this.consoleLogLevel;
    }

    long getFileMaxSize() {
        return getLogMode() == 2 ? 51200L : 1048576L;
    }

    String getLogDir() {
        return this.logDir;
    }

    DLog.ILogListener getLogListener() {
        return this.logListener;
    }

    int getLogMode() {
        return this.isDebugMode ? 1 : 0;
    }

    int getMonitorLevel() {
        if (this.monitorLevel == 0) {
            this.monitorLevel = this.sharedPreferences.getInt(SP_MONITOR_LEVEL, 0);
        }
        return this.monitorLevel;
    }

    int getMonitorType() {
        if (this.monitorType == 0) {
            this.monitorType = this.sharedPreferences.getInt(SP_MONITOR_TYPE, 0);
        }
        return this.monitorType;
    }

    String getOfflineLogServer() {
        if (this.offlineLogServer == null) {
            this.offlineLogServer = this.sharedPreferences.getString(SP_OFFLINE_LOG_SERVER, Log_Default_Url);
        }
        return this.offlineLogServer;
    }

    String getOnlineLogServer() {
        if (this.onlineLogServer == null) {
            this.onlineLogServer = this.sharedPreferences.getString(SP_ONLINE_LOG_SERVER, "");
        }
        return this.onlineLogServer;
    }

    long getOutDateTime() {
        return getLogMode() == 2 ? 300000L : 259200000L;
    }

    String getSdkVer() {
        if (this.sdkVer == null) {
            this.sdkVer = this.sharedPreferences.getString(SP_SDK_VER, null);
        }
        return this.sdkVer;
    }

    long getStartLogTime() {
        if (this.startLogTime == 0) {
            this.startLogTime = this.sharedPreferences.getLong(SP_START_LOG_TIME, 0L);
        }
        return this.startLogTime;
    }

    String getToken() {
        if (this.token == null) {
            this.token = this.sharedPreferences.getString(SP_TOKEN, null);
        }
        return this.token;
    }

    public JSONArray getUploadCacheList() {
        String string = this.sharedPreferences.getString(SP_UPLOAD_CACHE_LIST, null);
        try {
            return string == null ? new JSONArray() : new JSONArray(string);
        } catch (JSONException e2) {
            DLog.write(1, 512, DLog.LogTag.G_GET_UPLOAD_CACHE_E.getTag(), "cache", string);
            e2.printStackTrace();
            return new JSONArray();
        }
    }

    long getUploadTimeInterval() {
        return getLogMode() == 2 ? 120000L : 1200000L;
    }

    public String getUploadUrl() {
        return getOfflineLogServer();
    }

    public String getUserId() {
        if (this.userId == null) {
            this.userId = this.sharedPreferences.getString(SP_USER_ID, null);
        }
        return this.userId;
    }

    void setAppKey(String str) {
        this.sharedPreferences.edit().putString(SP_APP_KEY, str).apply();
        this.appKey = str;
    }

    void setConsoleLogLevel(int i) {
        this.consoleLogLevel = i;
    }

    void setLogListener(DLog.ILogListener iLogListener) {
        this.logListener = iLogListener;
    }

    void setMonitorLevel(int i) {
        if (getLogMode() == 2) {
            i = 6;
        }
        this.sharedPreferences.edit().putInt(SP_MONITOR_LEVEL, i).apply();
        this.monitorLevel = i;
    }

    void setMonitorType(int i) {
        if (getLogMode() == 2) {
            i = 268435455;
        }
        this.sharedPreferences.edit().putInt(SP_MONITOR_TYPE, i).apply();
        this.monitorType = i;
    }

    void setOfflineLogServer(String str) {
        this.sharedPreferences.edit().putString(SP_OFFLINE_LOG_SERVER, str).apply();
        this.offlineLogServer = str;
    }

    void setOnlineLogServer(String str) {
        this.sharedPreferences.edit().putString(SP_ONLINE_LOG_SERVER, str).apply();
        this.onlineLogServer = str;
    }

    void setSdkVer(String str) {
        this.sharedPreferences.edit().putString(SP_SDK_VER, str).apply();
        this.sdkVer = str;
    }

    void setStartLogTime(long j) {
        this.sharedPreferences.edit().putLong(SP_START_LOG_TIME, j).apply();
        this.startLogTime = j;
    }

    void setToken(String str) {
        this.sharedPreferences.edit().putString(SP_TOKEN, str).apply();
        this.token = str;
    }

    void setUploadCacheList(JSONArray jSONArray) {
        synchronized (this.sharedPreferences) {
            if (jSONArray != null) {
                this.sharedPreferences.edit().putString(SP_UPLOAD_CACHE_LIST, jSONArray.toString()).apply();
            }
        }
    }

    void setUserId(String str) {
        this.sharedPreferences.edit().putString(SP_USER_ID, str).apply();
        this.userId = str;
    }
}
