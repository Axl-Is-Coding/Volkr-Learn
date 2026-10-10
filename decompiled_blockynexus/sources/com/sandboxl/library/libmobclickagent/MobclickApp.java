package com.sandboxl.library.libmobclickagent;

import android.app.Application;
import com.sandboxol.center.router.module_application.IModuleInit;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class MobclickApp implements IModuleInit {
    private ReportMobclickAgent reportMobclickAgent = new ReportMobclickAgent();

    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onCreate(Application application) {
        ReportDataAdapter.registerReportAdapter(application, this.reportMobclickAgent);
    }

    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onDestroy(Application application) {
        ReportDataAdapter.unRegisterReportAdapter(this.reportMobclickAgent);
    }
}
