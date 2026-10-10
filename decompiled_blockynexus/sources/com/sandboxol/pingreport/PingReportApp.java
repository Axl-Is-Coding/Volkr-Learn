package com.sandboxol.pingreport;

import android.app.Application;
import com.sandboxol.center.router.manager.PingReportManager;
import com.sandboxol.center.router.module_application.IModuleInit;

/* JADX INFO: loaded from: classes4.dex */
public class PingReportApp implements IModuleInit {
    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onCreate(Application application) {
        PingReportManager.initService(application);
    }

    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onDestroy(Application application) {
    }
}
