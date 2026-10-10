package io.rong.push.platform.oppo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import io.rong.push.PushErrorCode;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;

/* JADX INFO: loaded from: classes5.dex */
public class OppoPush implements IPush {
    private final String TAG = OppoPush.class.getSimpleName();

    @Override // io.rong.push.platform.IPush
    public void register(final Context context, PushConfig pushConfig) {
        NotificationManager notificationManager;
        HeytapPushManager.init(context, true);
        if (!HeytapPushManager.isSupportPush()) {
            RLog.e(this.TAG, "the phone is not support oppo push!");
            PushManager.getInstance().onErrorResponse(context, PushType.OPPO, PushConst.PUSH_ACTION_REQUEST_TOKEN, PushErrorCode.NOT_SUPPORT_BY_OFFICIAL_PUSH.getCode());
            return;
        }
        RLog.d(this.TAG, "Oppo push start to register");
        HeytapPushManager.register(context.getApplicationContext(), pushConfig.getOppoAppKey(), pushConfig.getOppoAppSecret(), new ICallBackResultService() { // from class: io.rong.push.platform.oppo.OppoPush.1
            public void onGetNotificationStatus(int i, int i2) {
                RLog.d(OppoPush.this.TAG, "OPPO Push onGetNotificationStatus - responseCode:" + i + ",status:" + i2);
            }

            public void onGetPushStatus(int i, int i2) {
                RLog.d(OppoPush.this.TAG, "OPPO Push onGetPushStatus - responseCode:" + i + ",status:" + i2);
            }

            public void onRegister(int i, String str) {
                RLog.d(OppoPush.this.TAG, "Oppo Push onRegister responseCode " + String.valueOf(i) + ",registerID:" + str);
                if (i == 0) {
                    PushManager.getInstance().onReceiveToken(context, PushType.OPPO, str);
                } else {
                    PushManager.getInstance().onErrorResponse(context, PushType.OPPO, PushConst.PUSH_ACTION_REQUEST_TOKEN, i);
                }
            }

            public void onSetPushTime(int i, String str) {
                RLog.d(OppoPush.this.TAG, "OPPO Push onSetPushTime - responseCode:" + i + ",pushTime:" + str);
            }

            public void onUnRegister(int i) {
                RLog.d(OppoPush.this.TAG, "OPPO Push onUnRegister - responseCode:" + i);
            }
        });
        if (Build.VERSION.SDK_INT < 26 || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel("rc_notification_id", context.getResources().getString(context.getResources().getIdentifier("rc_notification_channel_name", "string", context.getPackageName())), 3);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationManager.createNotificationChannel(notificationChannel);
    }
}
