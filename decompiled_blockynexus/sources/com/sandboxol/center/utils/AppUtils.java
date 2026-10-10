package com.sandboxol.center.utils;

import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public class AppUtils {
    public static boolean isMainProcess() {
        return BaseApplication.getApp().getPackageName().equals(com.sandboxol.messager.b.a.a(BaseApplication.getApp()));
    }
}
