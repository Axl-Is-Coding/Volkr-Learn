package com.sandboxol.center.utils;

import android.content.Context;
import android.text.TextUtils;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.DownloadAnalyseData;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class ReportUtils {
    public static void aloneGameDownloadReport(Context context, String str, String str2, boolean z) {
        ReportDataAdapter.onEvent(context, "alone_game_" + str, str2);
        gameSilentDownloadReport(context, str, z);
    }

    public static void cdnDownloadMapNumReport(DownloadAnalyseData downloadAnalyseData) {
        cdnDownloadReport(ReportEvent.CDN_DOWNLOAD_MAP_NUM, downloadAnalyseData);
    }

    public static void cdnDownloadMapTimeReport(DownloadAnalyseData downloadAnalyseData) {
        cdnDownloadReport(ReportEvent.CDN_DOWNLOAD_MAP_TIME, downloadAnalyseData);
    }

    public static void cdnDownloadNumReport(DownloadAnalyseData downloadAnalyseData) {
        cdnDownloadReport(ReportEvent.CDN_DOWNLOAD_NUM, downloadAnalyseData);
    }

    private static void cdnDownloadReport(String str, DownloadAnalyseData downloadAnalyseData) {
        SandboxReportManager.onEvent(str, ReportEventType.CDN_DOWNLOAD_BEHAVIOR, "android", new com.google.gson.j().a(downloadAnalyseData));
    }

    public static void cdnDownloadSpeedReport(DownloadAnalyseData downloadAnalyseData) {
        cdnDownloadReport(ReportEvent.CDN_DOWNLOAD_SPEED, downloadAnalyseData);
    }

    public static void commonDownloadReport(Context context, String str, String str2, boolean z) {
        ReportDataAdapter.onEvent(context, "common_" + str, str2);
        gameSilentDownloadReport(context, str, z);
    }

    public static void commonGameDownloadReport(Context context, String str, String str2, boolean z) {
        ReportDataAdapter.onEvent(context, "common_game_" + str, str2);
        gameSilentDownloadReport(context, str, z);
    }

    public static void downloadErrorReport(Context context, Throwable th) {
        ReportDataAdapter.onError(context, th);
    }

    private static void gameSilentDownloadReport(Context context, String str, boolean z) {
        if (z) {
            if (str.equals(EventConstant.DOWNLOAD_GAME_START)) {
                ReportDataAdapter.onEvent(context, EventConstant.GAME_SILENT_DOWNLOAD);
            }
            if (str.equals(EventConstant.DOWNLOAD_GAME_ERROR) || str.equals(EventConstant.CHECK_MD_5_ERROR) || str.equals(EventConstant.UNZIP_GAME_ERROR)) {
                ReportDataAdapter.onEvent(context, EventConstant.GAME_SILENT_DOWNLOAD_FAIL);
            }
            if (str.equals(EventConstant.UNZIP_GAME_SUCCESS)) {
                ReportDataAdapter.onEvent(context, EventConstant.GAME_SILENT_DOWNLOAD_SUC);
            }
        }
    }

    public static void resDownloadReport(Context context, String str, String str2) {
        resDownloadReport(context, str, str2, null);
    }

    public static void resDownloadReport(Context context, String str, String str2, String str3) {
        if (str == null) {
            return;
        }
        if (str.startsWith("g1")) {
            str2 = "old_" + str2;
        }
        if (str.startsWith("g2")) {
            str2 = "new_" + str2;
        }
        if (str3 == null) {
            ReportDataAdapter.onEvent(context, str2);
        } else {
            ReportDataAdapter.onEvent(context, str2, str3);
        }
        if (!str.startsWith("g2") || CommonUtils.isNewEngineCommonGame(str)) {
            return;
        }
        if (str3 == null) {
            ReportDataAdapter.onEvent(context, str2 + "_" + str);
            return;
        }
        ReportDataAdapter.onEvent(context, str2 + "_" + str, str3);
    }

    public static void resDownloadReport(int i, Context context, String str, String str2, boolean z) {
        if (i != 1) {
            ReportDataAdapter.onEvent(context, (i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "map" : "common_" : "alone_game_" : "common_game_") + str, str2);
            gameSilentDownloadReport(context, str, z);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ReportDataAdapter.onEvent(context, str, str2);
    }
}
