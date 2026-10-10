package io.rong.push.platform.mi;

import android.content.Context;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.core.PushUtils;
import io.rong.push.notification.PushNotificationMessage;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MiMessageReceiver extends PushMessageReceiver {
    private static final String TAG = "MiMessageReceiver";

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        RLog.v(TAG, "onCommandResult is called. " + miPushCommandMessage.toString());
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        RLog.v(TAG, "onNotificationMessageArrived is called. " + miPushMessage.toString());
        PushNotificationMessage pushNotificationMessageTransformToPushMessage = PushUtils.transformToPushMessage(miPushMessage.getContent());
        if (pushNotificationMessageTransformToPushMessage != null) {
            PushManager.getInstance().onNotificationMessageArrived(context, PushType.XIAOMI, pushNotificationMessageTransformToPushMessage);
        }
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        RLog.v(TAG, "onNotificationMessageClicked is called. " + miPushMessage.toString());
        PushManager.getInstance().onNotificationMessageClicked(context, PushType.XIAOMI, PushUtils.transformToPushMessage(miPushMessage.getContent()));
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        RLog.v(TAG, "onReceivePassThroughMessage is called. " + miPushMessage.toString());
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String command = miPushCommandMessage.getCommand();
        List commandArguments = miPushCommandMessage.getCommandArguments();
        String str = null;
        String str2 = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            str = (String) commandArguments.get(1);
        }
        RLog.d(TAG, "onReceiveRegisterResult. cmdArg1: " + str2 + "; cmdArg2:" + str);
        if ("register".equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                PushManager.getInstance().onReceiveToken(context, PushType.XIAOMI, str2);
            } else {
                PushManager.getInstance().onErrorResponse(context, PushType.XIAOMI, PushConst.PUSH_ACTION_REQUEST_TOKEN, miPushCommandMessage.getResultCode());
            }
        }
    }
}
