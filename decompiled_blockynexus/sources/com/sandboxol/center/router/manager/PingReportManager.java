package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IPingReportService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
public class PingReportManager {
    private static IPingReportService pingReportService = (IPingReportService) RouteServiceManager.provide(RouterServicePath.EventPing.PING_REPORT);

    public static int getReportInternal() {
        IPingReportService iPingReportService = pingReportService;
        if (iPingReportService != null) {
            return iPingReportService.getReportInternal();
        }
        return -1;
    }

    public static void initService(Context context) {
        IPingReportService iPingReportService = pingReportService;
        if (iPingReportService != null) {
            iPingReportService.initService(context);
        }
    }

    public static void onFpsEvent(String str, int i) {
        IPingReportService iPingReportService = pingReportService;
        if (iPingReportService != null) {
            iPingReportService.onFpsEvent(str, i);
        }
    }

    public static void onNetPingEvent(String str, int i) {
        IPingReportService iPingReportService = pingReportService;
        if (iPingReportService != null) {
            iPingReportService.onNetPingEvent(str, i);
        }
    }

    public static void onPingEvent(String str, int i) {
        IPingReportService iPingReportService = pingReportService;
        if (iPingReportService != null) {
            iPingReportService.onPingEvent(str, i);
        }
    }

    public static void setReportInternal(int i) {
        IPingReportService iPingReportService = pingReportService;
        if (iPingReportService != null) {
            iPingReportService.setReportInternal(i);
        }
    }
}
