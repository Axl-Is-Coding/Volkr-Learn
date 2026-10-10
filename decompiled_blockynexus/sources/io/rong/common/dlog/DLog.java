package io.rong.common.dlog;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DLog {
    public static final int APP = 1;
    public static final int CON = 16;
    public static final int CRM = 64;
    public static final int CRS = 2048;
    public static final int D = 5;
    public static final int DEB = 1024;
    public static final int DET = 8;
    public static final int E = 2;
    public static final int ENV = 4;
    public static final int EPT = 8192;
    public static final int EXCEPTION_THROWN = -1000;
    public static final int F = 1;
    public static final int I = 4;
    public static final int LOG = 512;
    public static final int MED = 256;
    public static final int MSG = 128;
    public static final int NONE = 0;
    public static final int PTC = 2;
    public static final int RCO = 32;
    public static final int RTC = 4096;
    static final String TAG = "FwLog";
    public static final int V = 6;
    public static final int W = 3;
    private static DLogImp instance;
    private static ILogEventCallback logEventCallback;
    private static ILogListener logListener;
    private static Vector<LogEntry> lruLogCache = new Vector<>();

    public interface ILogEventCallback {
        int onGetProtocolLogStatus();

        void onLogEventFromSubProcess(long j, int i, int i2, String str, String str2);

        void onRtLogEventFromSubProcess(long j, int i, int i2, String str, String str2);

        void onSetLogMonitorEventFromSubProcess(int i);

        void onSetLogServer(String str, String str2);

        void onSetTokenEventFromSubProcess(String str);

        void onSetUserIdEventFromSubProcess(String str);
    }

    public interface ILogListener {
        void onLogEvent(String str);
    }

    public interface ILogUploadCallback {
        void onLogUploaded(int i);
    }

    static class LogEntry {
        int level;
        String metaJson;
        String tag;
        long timestamp;
        int type;

        LogEntry() {
        }

        public int getLevel() {
            return this.level;
        }

        public String getMetaJson() {
            return this.metaJson;
        }

        public String getTag() {
            return this.tag;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public int getType() {
            return this.type;
        }

        public void setLevel(int i) {
            this.level = i;
        }

        public void setMetaJson(String str) {
            this.metaJson = str;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public enum LogTag {
        A_INIT_O("A-init-O"),
        L_INIT_O("L-init-O"),
        A_APP_VER_S("A-app_ver-S"),
        A_SET_SERVER_O("A-set_server-O"),
        A_SET_STATISTIC_SERVER_O("A-set_statistic_server-O"),
        BIND_SERVICE_S("2-bind_service-S"),
        A_CONNECT_T("A-connect-T"),
        A_CONNECT_R("A-connect-R"),
        A_CONNECT_S("A-connect-S"),
        A_DISCONNECT_O("A-disconnect-O"),
        L_CONNECT_T("L-connect-T"),
        L_CONNECT_R("L-connect-R"),
        L_CONNECT_S("L-connect-S"),
        L_APP_STATE_S("L-app_state-S"),
        A_DELETE_MESSAGES_S("A-delete_messages-S"),
        L_DELETE_MESSAGES_S("L-delete_messages-S"),
        L_DECODE_MSG_E("L-decode_msg-E"),
        L_REGTYPE_E("L-regtype-E"),
        A_RECONNECT_T("A-reconnect-T"),
        A_RECONNECT_R("A-reconnect-R"),
        A_RECONNECT_S("A-reconnect-S"),
        L_RECONNECT_T("L-reconnect-T"),
        L_RECONNECT_R("L-reconnect-R"),
        L_RECONNECT_S("L-reconnect-S"),
        L_GET_NAVI_T("L-get_navi-T"),
        L_GET_NAVI_R("L-get_navi-R"),
        L_GET_NAVI_S("L-get_navi-S"),
        L_ENV_S("L-Env-S"),
        L_DECODE_NAVI_S("L-decode_navi-S"),
        P_CONNECT_T("P-connect-T"),
        P_CONNECT_R("P-connect-R"),
        P_CONNECT_S("P-connect-S"),
        P_CONNECT_ENTRY_S("P-connect_entry-S"),
        P_SEND_MSG_S("P-send_msg-S"),
        P_DELETE_MSG_S("P-delete_msg-S"),
        P_PARSE_ERROR_S("P-parse_error-S"),
        P_RTCON_E("P-rtcon-E"),
        P_RTMSG_E("P-rtmsg-E"),
        P_RTTCP_E("P-rttcp-E"),
        P_CODE_C("P-code-C"),
        P_REASON_C("P-reason-C"),
        P_MORE_C("P-more-C"),
        L_NETWORK_CHANGED_S("L-network_changed-S"),
        L_PING_S("L-ping-S"),
        A_JOIN_CHATROOM_T("A-join_chatroom-T"),
        A_JOIN_CHATROOM_R("A-join_chatroom-R"),
        L_JOIN_CHATROOM_T("L-join_chatroom-T"),
        L_JOIN_CHATROOM_R("L-join_chatroom-R"),
        A_QUIT_CHATROOM_T("A-quit_chatroom-T"),
        A_QUIT_CHATROOM_R("A-quit_chatroom-R"),
        L_QUIT_CHATROOM_T("L-quit_chatroom-T"),
        L_QUIT_CHATROOM_R("L-quit_chatroom-R"),
        A_REJOIN_CHATROOM_T("A-rejoin_chatroom-T"),
        A_REJOIN_CHATROOM_R("A-rejoin_chatroom-R"),
        L_REJOIN_CHATROOM_T("L-rejoin_chatroom-T"),
        L_REJOIN_CHATROOM_R("L-rejoin_chatroom-R"),
        L_MEDIA_S("L-media-S"),
        L_CRASH_MAIN_TRB_F("L-crash_main_trb-F"),
        L_CRASH_MAIN_EPT_F("L-crash_main_ept-F"),
        L_CRASH_MAIN_EPT_E("L-crash_main_ept-E"),
        L_CRASH_IPC_TRB_F("L-crash_ipc_trb-F"),
        L_CRASH_IPC_EPT_F("L-crash_ipc_ept-F"),
        L_CRASH_IPC_RTM_F("L-crash_ipc_rtm-F"),
        L_CRASH_IPC_RMT_E("L-crash_ipc_rmt-E"),
        G_CRASH_E("G-crash-E"),
        G_GET_UPLOAD_CACHE_E("G-get_upload_cache-E"),
        G_UPLOAD_LOG_S("G-upload_log-S"),
        G_UPLOAD_LOG_E("G-upload_log-E"),
        G_UPLOAD_LOG_F("G-upload_log-F"),
        G_DROP_LOG_E("G-drop_log-E"),
        L_DOH_R("L-DoH-R"),
        L_DOH_T("L-DoH-T");

        private String tag;

        LogTag(String str) {
            this.tag = str;
        }

        public String getTag() {
            return this.tag;
        }
    }

    protected DLog() {
    }

    private static void cacheLog(long j, int i, int i2, String str, String str2) {
        LogEntry logEntry = new LogEntry();
        logEntry.setTimestamp(j);
        logEntry.setLevel(i);
        logEntry.setType(i2);
        logEntry.setTag(str);
        logEntry.setMetaJson(str2);
        lruLogCache.add(logEntry);
    }

    protected static String formatMetaJson(boolean z, int i, long j, long j2, String str, Object... objArr) {
        String str2;
        String string;
        int i2 = 0;
        String[] strArrSplit = str != null ? str.split("\\|") : new String[0];
        str2 = "*";
        if (strArrSplit.length != objArr.length) {
            StringBuilder sb = new StringBuilder();
            int length = objArr.length;
            while (i2 < length) {
                Object obj = objArr[i2];
                sb.append(obj != null ? obj.toString() : "null");
                sb.append("|");
                i2++;
            }
            if (objArr.length <= 0) {
                return "";
            }
            sb.deleteCharAt(sb.length() - 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{\"ptid\":\"");
            sb2.append(i);
            sb2.append("-");
            sb2.append(j);
            sb2.append(j != j2 ? "" : "*");
            sb2.append("\",\"");
            sb2.append(str);
            sb2.append("\":\"");
            sb2.append((Object) sb);
            sb2.append("\"}");
            return sb2.toString();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            while (i2 < strArrSplit.length) {
                jSONObject.put(strArrSplit[i2], objArr[i2] != null ? objArr[i2] : "null");
                i2++;
            }
            String strReplace = jSONObject.toString().replace("\\/", "/");
            if (z) {
                string = "{" + strReplace.substring(1);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("{\"ptid\":\"");
                sb3.append(i);
                sb3.append("-");
                sb3.append(j);
                if (j != j2) {
                    str2 = "";
                }
                sb3.append(str2);
                sb3.append("\"");
                sb3.append(strArrSplit.length > 0 ? "," : "");
                sb3.append(strReplace.substring(1));
                string = sb3.toString();
            }
            return string;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int getProtocolLogStatus() {
        if (instance == null) {
            ILogEventCallback iLogEventCallback = logEventCallback;
            if (iLogEventCallback != null) {
                return iLogEventCallback.onGetProtocolLogStatus();
            }
        } else {
            if (LogEntity.getInstance().getLogMode() != 0 || LogEntity.getInstance().getMonitorLevel() == 6) {
                return 2;
            }
            if (LogEntity.getInstance().getMonitorLevel() >= 1 && LogEntity.getInstance().getMonitorLevel() <= 5) {
                return 1;
            }
        }
        return 0;
    }

    public static void init(Context context, String str, String str2) {
        instance = new DLogImp(context, str, str2);
        synchronized (DLog.class) {
            LogEntity.getInstance().setLogListener(logListener);
        }
    }

    public static void onProtocolLog(String str, boolean z) {
        String[] strArrSplit = str.split(";;;");
        if (strArrSplit.length <= 0) {
            write(1, 2, LogTag.P_PARSE_ERROR_S.getTag(), "content", str);
            return;
        }
        String str2 = strArrSplit[0];
        if (str2.equals(LogTag.P_CODE_C.getTag()) && strArrSplit.length == 3) {
            write(z ? 4 : 5, 2, str2, "action|code", strArrSplit[1], strArrSplit[2]);
            return;
        }
        if (str2.equals(LogTag.P_REASON_C.getTag()) && strArrSplit.length == 3) {
            write(z ? 4 : 5, 2, str2, "action|reason", strArrSplit[1], strArrSplit[2]);
        } else if (str2.equals(LogTag.P_MORE_C.getTag()) && strArrSplit.length == 4) {
            write(z ? 4 : 5, 2, str2, "action|code|reason", strArrSplit[1], strArrSplit[2], strArrSplit[3]);
        } else {
            write(1, 2, LogTag.P_PARSE_ERROR_S.getTag(), "content", str);
        }
    }

    public static void rtWrite(int i, int i2, String str, String str2, Object... objArr) {
        rtWrite(System.currentTimeMillis(), i, i2, str, formatMetaJson(true, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2, objArr));
    }

    public static void setCallbackInSubProcess(Context context, ILogEventCallback iLogEventCallback) {
        logEventCallback = iLogEventCallback;
    }

    public static void setConsoleLogLevel(int i) {
        if (instance == null) {
            throw new RuntimeException("Cannot be set in sub process.");
        }
        LogEntity.getInstance().setConsoleLogLevel(i);
    }

    public static synchronized void setLogListener(ILogListener iLogListener) {
        if (instance != null) {
            LogEntity.getInstance().setLogListener(iLogListener);
        } else {
            logListener = iLogListener;
        }
    }

    public static void setLogMonitor(int i) {
        if (instance == null) {
            ILogEventCallback iLogEventCallback = logEventCallback;
            if (iLogEventCallback != null) {
                iLogEventCallback.onSetLogMonitorEventFromSubProcess(i);
                return;
            }
            return;
        }
        Log.d(TAG, "setLogMonitor = " + i);
        if (i == 1) {
            i = 1610611711;
        } else if (i == 2) {
            i = 1879048191;
        }
        LogEntity.getInstance().setMonitorLevel(i >> 28);
        LogEntity.getInstance().setMonitorType(i & 268435455);
    }

    public static void setLogServer(String str, String str2) {
        if (instance == null) {
            ILogEventCallback iLogEventCallback = logEventCallback;
            if (iLogEventCallback != null) {
                iLogEventCallback.onSetLogServer(str, str2);
                return;
            }
            return;
        }
        if (str2 != null) {
            LogEntity.getInstance().setOfflineLogServer(str2);
        }
        if (str != null) {
            LogEntity.getInstance().setOnlineLogServer(str);
        }
    }

    public static void setToken(String str) {
        if (str == null) {
            return;
        }
        if (instance != null) {
            LogEntity.getInstance().setToken(str);
            return;
        }
        ILogEventCallback iLogEventCallback = logEventCallback;
        if (iLogEventCallback != null) {
            iLogEventCallback.onSetTokenEventFromSubProcess(str);
        }
    }

    public static void setUserId(String str) {
        if (str == null) {
            return;
        }
        if (instance != null) {
            LogEntity.getInstance().setUserId(str);
            return;
        }
        ILogEventCallback iLogEventCallback = logEventCallback;
        if (iLogEventCallback != null) {
            iLogEventCallback.onSetUserIdEventFromSubProcess(str);
        }
    }

    public static String stackToString(Throwable th) {
        return Log.getStackTraceString(th).replaceAll(UMCustomLogInfoBuilder.LINE_SEP, "\\\\n");
    }

    public static void upload(ILogUploadCallback iLogUploadCallback) {
        DLogImp dLogImp = instance;
        if (dLogImp != null) {
            dLogImp.uploadLog(iLogUploadCallback);
        } else {
            Log.e(TAG, "call upload() failed. instance == null");
        }
    }

    public static void write(int i, int i2, String str, String str2, Object... objArr) {
        write(System.currentTimeMillis(), i, i2, str, formatMetaJson(false, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2, objArr));
    }

    private static void writeIPCLogFromCache() {
        if (lruLogCache.size() > 0) {
            for (LogEntry logEntry : lruLogCache) {
                logEventCallback.onLogEventFromSubProcess(logEntry.getTimestamp(), logEntry.getLevel(), logEntry.getType(), logEntry.getTag(), logEntry.getMetaJson());
            }
            lruLogCache.clear();
        }
    }

    private static void writeLogFromCache() {
        if (lruLogCache.size() > 0) {
            for (LogEntry logEntry : lruLogCache) {
                instance.writeLog(logEntry.getTimestamp(), logEntry.getLevel(), logEntry.getType(), logEntry.getTag(), logEntry.getMetaJson());
            }
            lruLogCache.clear();
        }
    }

    public static void rtWrite(long j, int i, int i2, String str, String str2) {
        if (instance != null) {
            if (TextUtils.isEmpty(LogEntity.getInstance().getOnlineLogServer())) {
                return;
            }
            instance.writeRtLog(j, i, i2, str, str2);
        } else {
            ILogEventCallback iLogEventCallback = logEventCallback;
            if (iLogEventCallback != null) {
                iLogEventCallback.onRtLogEventFromSubProcess(j, i, i2, str, str2);
            }
        }
    }

    public static void write(long j, int i, int i2, String str, String str2) {
        if (instance == null && logEventCallback == null) {
            cacheLog(j, i, i2, str, str2);
        }
        if (instance != null) {
            writeLogFromCache();
            instance.writeLog(j, i, i2, str, str2);
        } else if (logEventCallback != null) {
            writeIPCLogFromCache();
            logEventCallback.onLogEventFromSubProcess(j, i, i2, str, str2);
        }
    }
}
