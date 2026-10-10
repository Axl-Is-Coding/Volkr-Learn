package com.sandboxol.feedback;

import android.app.Application;
import com.sandboxol.center.router.module_application.IModuleInit;
import com.sandboxol.center.utils.AppUtils;

/* JADX INFO: loaded from: classes3.dex */
public class FeedBackApp implements IModuleInit {
    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onCreate(Application application) {
        if (AppUtils.isMainProcess()) {
            FeedBackUtils.newInstant().init(application);
        }
    }

    @Override // com.sandboxol.center.router.module_application.IModuleInit
    public void onDestroy(Application application) {
    }
}
