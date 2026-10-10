package io.rong.common.fwlog;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.rlog.RLog;
import io.rong.imlib.statistics.CrashDetails;
import java.lang.Thread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class FwLog {
    public static final int D = 4;
    public static final int E = 1;
    public static final int EXCEPTION_THROWN = -1000;
    public static final int F = 0;
    public static final int I = 3;
    public static final int IM = 1;
    private static final String LOG_PROCESS_THREAD_NAME = "thread_log_process";
    public static final int RTC = 2;
    private static final String TAG = "FwLog";
    public static final int W = 2;
    private static int consolePrintLevel;
    private static IFwLogWriter directWriter;
    private static IFwLogConsolePrinter logConsolePrinter;
    private static ILogListener logListener;
    private static Executor logProcessExecutor;
    private static IFwLogWriter proxyWriter;
    private static SparseArray<String> typeArray = new SparseArray<>();

    public interface ILogListener {
        void onLogEvent(String str);
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Level {
    }

    public enum LogTag {
        A_INIT_O("A-init-O"),
        L_INIT_O("L-init-O"),
        L_INIT_S("L-init-S"),
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
        A_REJOIN_CHATROOM_S("A-rejoin_chatroom-S"),
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
        L_DOH_T("L-DoH-T"),
        L_DNS_PARSE_F("L-dns_parse-F");

        private String tag;

        LogTag(String str) {
            this.tag = str;
        }

        public String getTag() {
            return this.tag;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    static {
        typeArray.put(1, "IM");
        typeArray.put(2, "RTC");
        logProcessExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: io.rong.common.fwlog.FwLog.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, FwLog.LOG_PROCESS_THREAD_NAME);
            }
        });
        consolePrintLevel = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatMetaJson(int i, long j, long j2, String str, Object... objArr) {
        String str2;
        int i2 = 0;
        String[] strArrSplit = str != null ? str.split("\\|") : new String[0];
        str2 = "*";
        if (strArrSplit.length == objArr.length) {
            try {
                JSONObject jSONObject = new JSONObject();
                while (i2 < strArrSplit.length) {
                    jSONObject.put(strArrSplit[i2], objArr[i2] != null ? objArr[i2] : "null");
                    i2++;
                }
                String strReplace = jSONObject.toString().replace("\\/", "/");
                StringBuilder sb = new StringBuilder();
                sb.append("{\"ptid\":\"");
                sb.append(i);
                sb.append("-");
                sb.append(j);
                if (j != j2) {
                    str2 = "";
                }
                sb.append(str2);
                sb.append("\"");
                sb.append(strArrSplit.length > 0 ? "," : "");
                sb.append(strReplace.substring(1));
                return sb.toString();
            } catch (JSONException e2) {
                RLog.e(TAG, "formatMetaJson", e2);
                return "";
            }
        }
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        while (i2 < length) {
            Object obj = objArr[i2];
            sb2.append(obj != null ? obj.toString() : "null");
            sb2.append("|");
            i2++;
        }
        if (objArr.length <= 0) {
            return "";
        }
        sb2.deleteCharAt(sb2.length() - 1);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("{\"ptid\":\"");
        sb3.append(i);
        sb3.append("-");
        sb3.append(j);
        sb3.append(j != j2 ? "" : "*");
        sb3.append("\",\"");
        sb3.append(str);
        sb3.append("\":\"");
        sb3.append((Object) sb2);
        sb3.append("\"}");
        return sb3.toString();
    }

    public static void listenUncaughtException(final Context context) {
        new Timer().schedule(new TimerTask() { // from class: io.rong.common.fwlog.FwLog.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.rong.common.fwlog.FwLog.4.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread, Throwable th) {
                        String string = th.toString();
                        if (!TextUtils.isEmpty(string) && string.contains(":")) {
                            string = string.substring(0, string.indexOf(":"));
                        }
                        FwLog.write(0, 1, LogTag.L_CRASH_MAIN_TRB_F.getTag(), "stack|reason|env", FwLog.stackToString(th), string, CrashDetails.getIMCrashData(context.getApplicationContext(), th.toString()));
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                        if (uncaughtExceptionHandler != null) {
                            uncaughtExceptionHandler.uncaughtException(thread, th);
                        }
                    }
                });
            }
        }, 2000L);
    }

    public static void onProtocolLog(String str, boolean z) {
        String[] strArrSplit = str.split(";;;");
        if (strArrSplit.length <= 0) {
            RLog.e(TAG, "[RC:" + LogTag.P_PARSE_ERROR_S.getTag() + "] content:" + str);
            return;
        }
        String str2 = strArrSplit[0];
        if (str2.equals(LogTag.P_CODE_C.getTag()) && strArrSplit.length == 3) {
            write(z ? 3 : 4, 1, str2, "action|code", strArrSplit[1], strArrSplit[2]);
            return;
        }
        if (str2.equals(LogTag.P_REASON_C.getTag()) && strArrSplit.length == 3) {
            write(z ? 3 : 4, 1, str2, "action|reason", strArrSplit[1], strArrSplit[2]);
            return;
        }
        if (str2.equals(LogTag.P_MORE_C.getTag()) && strArrSplit.length == 4) {
            write(z ? 3 : 4, 1, str2, "action|code|reason", strArrSplit[1], strArrSplit[2], strArrSplit[3]);
            return;
        }
        RLog.e(TAG, "[RC:" + LogTag.P_PARSE_ERROR_S.getTag() + "] content:" + str);
    }

    public static void setConsoleLogLevel(int i) {
        consolePrintLevel = i;
    }

    public static void setDirectWriter(IFwLogWriter iFwLogWriter) {
        directWriter = iFwLogWriter;
    }

    public static void setLogConsolePrinter(IFwLogConsolePrinter iFwLogConsolePrinter) {
        logConsolePrinter = iFwLogConsolePrinter;
    }

    public static synchronized void setLogListener(ILogListener iLogListener) {
        logListener = iLogListener;
    }

    public static synchronized void setProxyWriter(IFwLogWriter iFwLogWriter) {
        proxyWriter = iFwLogWriter;
    }

    public static String stackToString(Throwable th) {
        return Log.getStackTraceString(th).replaceAll(UMCustomLogInfoBuilder.LINE_SEP, "\\\\n");
    }

    public static void write(final int i, final int i2, final String str, final String str2, final Object... objArr) {
        final long id = Thread.currentThread().getId();
        logProcessExecutor.execute(new Runnable() { // from class: io.rong.common.fwlog.FwLog.2
            @Override // java.lang.Runnable
            public void run() {
                String metaJson = FwLog.formatMetaJson(Process.myPid(), id, Looper.getMainLooper().getThread().getId(), str2, objArr);
                String str3 = (String) FwLog.typeArray.get(i2);
                if (str3 == null) {
                    str3 = (String) FwLog.typeArray.get(1);
                }
                if (FwLog.logConsolePrinter != null) {
                    FwLog.logConsolePrinter.printLog(System.currentTimeMillis(), i, str3, str, metaJson, FwLog.consolePrintLevel);
                }
                FwLog.write(i, str3, str, metaJson, System.currentTimeMillis());
            }
        });
    }

    public static void write(final int i, final String str, final String str2, final String str3, final long j) {
        if (!LOG_PROCESS_THREAD_NAME.equals(Thread.currentThread().getName())) {
            logProcessExecutor.execute(new Runnable() { // from class: io.rong.common.fwlog.FwLog.3
                @Override // java.lang.Runnable
                public void run() {
                    FwLog.write(i, str, str2, str3, j);
                }
            });
            return;
        }
        IFwLogWriter iFwLogWriter = proxyWriter;
        if (iFwLogWriter != null) {
            iFwLogWriter.write(i, str, str2, str3, j);
            return;
        }
        ILogListener iLogListener = logListener;
        if (iLogListener != null) {
            iLogListener.onLogEvent("[RC:" + str2 + "]" + str3);
        }
        IFwLogWriter iFwLogWriter2 = directWriter;
        if (iFwLogWriter2 != null) {
            iFwLogWriter2.write(i, str, str2, str3, j);
        }
    }
}
