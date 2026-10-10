package com.alibaba.sdk.android.feedback.util;

import android.app.Application;
import android.content.Context;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;

/* JADX INFO: loaded from: classes.dex */
public class n {
    public static void a() {
        try {
            UTAnalytics.getInstance().turnOnDebug();
        } catch (Throwable unused) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("UTWrapper", "turnOnDebug not found monitor sdk");
        }
    }

    public static void a(String str, String str2) {
        try {
            AppMonitor.Counter.commit("feedback", str, str2, 0.0d);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, Application application, int i) {
        if (i == 2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.c("UTWrapper", "用户自行初始化ut_analytics");
            return;
        }
        if (i == 1) {
            try {
                if (a(application)) {
                    a();
                }
                UTAnalytics.getInstance().setContext(application);
                UTAnalytics.getInstance().setAppApplicationInstance(application);
                UTAnalytics.getInstance().setRequestAuthentication(new UTBaseRequestAuthentication(str, str2));
            } catch (Throwable unused) {
                com.alibaba.sdk.android.feedback.xblink.i.g.e("UTWrapper", "utInit not found monitor sdk");
            }
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b() {
        try {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("80001");
            uTCustomHitBuilder.setProperty("model", "feedback");
            uTCustomHitBuilder.setProperty("version", "3.1.8");
            UTAnalytics.getInstance().getTracker(VipSubscribeStatus.SUBSCRIPTION_ON_HOLD).send(uTCustomHitBuilder.build());
        } catch (Throwable unused) {
        }
    }
}
