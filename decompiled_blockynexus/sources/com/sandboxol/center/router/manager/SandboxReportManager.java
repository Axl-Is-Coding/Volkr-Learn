package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.ISandboxReportService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes.dex */
public class SandboxReportManager {
    private static ISandboxReportService sandboxReportService = (ISandboxReportService) RouteServiceManager.provide(RouterServicePath.EventSandboxReport.SANDBOX_REPORT);

    public static int getReportInternal() {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            return iSandboxReportService.getReportInternal();
        }
        return -1;
    }

    public static void onCreate(Context context, String str) {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            iSandboxReportService.onCreate(context, str);
        }
    }

    public static void onDestroy() {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            iSandboxReportService.onDestroy();
        }
    }

    public static void onEvent(String str) {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            iSandboxReportService.onEvent(str);
        }
    }

    public static void setReportInternal(int i) {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            iSandboxReportService.setReportInternal(i);
        }
    }

    public static void onEvent(String str, String str2) {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            iSandboxReportService.onEvent(str, str2);
        }
    }

    public static void onEvent(String str, String str2, String str3) {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            iSandboxReportService.onEvent(str, str2, str3);
        }
    }

    public static void onEvent(String str, String str2, String str3, String str4) {
        ISandboxReportService iSandboxReportService = sandboxReportService;
        if (iSandboxReportService != null) {
            iSandboxReportService.onEvent(str, str2, str3, str4);
        }
    }
}
