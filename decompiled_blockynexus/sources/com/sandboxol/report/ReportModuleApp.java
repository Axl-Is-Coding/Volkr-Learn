package com.sandboxol.report;

import android.app.Application;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.NewReportEvent;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.router.module_application.IModuleInit;
import com.sandboxol.center.utils.AppUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ReportModuleApp implements IModuleInit {
    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onCreate(Application application) {
        if (AppUtils.isMainProcess()) {
            SandboxReportManager.onCreate(application, BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
            NewSandboxReportManager.onCreate(application);
            NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_APP_NUMBER, NewReportEvent.APP_START);
            NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, "new_app_start");
            SandboxReportManager.onEvent("new_app_start", ReportEventType.NEW_USER_BEHAVIOR, "app");
        }
    }

    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onDestroy(Application application) {
        NewSandboxReportManager.onDestroy();
        SandboxReportManager.onDestroy();
    }
}
