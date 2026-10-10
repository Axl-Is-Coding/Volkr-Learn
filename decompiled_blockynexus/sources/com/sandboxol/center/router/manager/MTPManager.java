package com.sandboxol.center.router.manager;

import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IMtpService;
import com.sandboxol.center.router.path.RouterServicePath;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class MTPManager {
    public static final String TAG = "MTP";
    private static IMtpService mtpService = (IMtpService) RouteServiceManager.provide(RouterServicePath.EventMtp.MTP_SERVICE);

    public static void addReceiver() {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.addReceiver();
        }
    }

    public static String getApkSignMd5Str() {
        IMtpService iMtpService = mtpService;
        return iMtpService != null ? iMtpService.getApkSignMd5Str() : "";
    }

    public static String getDescriptionById(String str) {
        IMtpService iMtpService = mtpService;
        return iMtpService != null ? iMtpService.getDescriptionById(str) : "";
    }

    public static String getMtpMd5(String str) {
        IMtpService iMtpService = mtpService;
        return iMtpService != null ? iMtpService.getMtpMd5(str) : "";
    }

    public static void initGameMTP(int i, String str, Action0 action0) {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.initGameMTP(i, str, action0);
        }
    }

    public static Boolean isInBlackList(String str) {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            return iMtpService.isInBlackList(str);
        }
        return false;
    }

    public static void isOpenMtp(Action1<Boolean> action1) {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.isOpenMtp(action1);
        }
    }

    public static void loginGameMTP(int i, int i2, String str, String str2) {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.loginGameMTP(i, i2, str, str2);
        }
    }

    public static void onAppPause() {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.onAppPause();
        }
    }

    public static void onAppResume() {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.onAppResume();
        }
    }

    public static void setOpenMtp(boolean z) {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.setOpenMtp(z);
        }
    }

    public static void testConfig() {
        IMtpService iMtpService = mtpService;
        if (iMtpService != null) {
            iMtpService.testConfig();
        }
    }
}
