package com.sandboxol.center.router.manager;

import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.INewSandboxReportService;
import com.sandboxol.center.router.path.RouterServicePath;

/* JADX INFO: loaded from: classes3.dex */
public class NewSandboxReportManager {
    private static INewSandboxReportService newSandboxReportService = (INewSandboxReportService) RouteServiceManager.provide(RouterServicePath.EventSandboxReport.NEW_SANDBOX_REPORT);

    public static int getReportInternal() {
        INewSandboxReportService iNewSandboxReportService = newSandboxReportService;
        if (iNewSandboxReportService != null) {
            return iNewSandboxReportService.getReportInternal();
        }
        return -1;
    }

    public static void onAppEvent(String str, String str2) {
        INewSandboxReportService iNewSandboxReportService = newSandboxReportService;
        if (iNewSandboxReportService != null) {
            iNewSandboxReportService.onAppEvent(str, str2);
        }
    }

    public static void onCreate(Context context) {
        INewSandboxReportService iNewSandboxReportService = newSandboxReportService;
        if (iNewSandboxReportService != null) {
            iNewSandboxReportService.onCreate(context);
        }
    }

    public static void onDestroy() {
        INewSandboxReportService iNewSandboxReportService = newSandboxReportService;
        if (iNewSandboxReportService != null) {
            iNewSandboxReportService.onDestroy();
        }
    }

    public static void onGameEvent(String str, String str2, String str3) {
        INewSandboxReportService iNewSandboxReportService = newSandboxReportService;
        if (iNewSandboxReportService != null) {
            iNewSandboxReportService.onGameEvent(str, str2, str3);
        }
    }

    public static void setReportInternal(int i) {
        INewSandboxReportService iNewSandboxReportService = newSandboxReportService;
        if (iNewSandboxReportService != null) {
            iNewSandboxReportService.setReportInternal(i);
        }
    }
}
