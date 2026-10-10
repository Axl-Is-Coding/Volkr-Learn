package com.disabngo.blockynexus.utils.logic;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.messenger.Messenger;
import io.rong.push.PushType;
import io.rong.push.RongPushClient;
import io.rong.push.pushconfig.PushConfig;
import rx.functions.Action0;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements Action0 {
    w() {
    }

    @Override // rx.functions.Action0
    public void call() {
        if (!com.disabngo.blockynexus.e.f9060d.booleanValue()) {
            try {
                RongPushClient.setPushConfig(new PushConfig.Builder().enableFCM(true).build());
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (NoClassDefFoundError e3) {
                e3.printStackTrace();
            }
        }
        try {
            N.d(BaseApplication.getApp());
        } catch (Exception e4) {
            e4.printStackTrace();
        } catch (NoClassDefFoundError e5) {
            e5.printStackTrace();
        }
        try {
            if (RongPushClient.getCurrentPushType(BaseApplication.getApp()).equals(PushType.GOOGLE_FCM)) {
                FirebaseAnalytics.getInstance(BaseApplication.getContext()).setAnalyticsCollectionEnabled(true);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        } catch (NoClassDefFoundError e7) {
            e7.printStackTrace();
        }
        Messenger.getDefault().unregister(N.class);
    }
}
