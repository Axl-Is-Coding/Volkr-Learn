package com.sandboxol.center.router;

import android.text.TextUtils;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: classes3.dex */
public class RouteServiceManager {
    private static final String TAG = "RouteServiceManager";

    public static <T extends IProvider> T provide(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (T) ARouter.getInstance().build(str).navigation();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
