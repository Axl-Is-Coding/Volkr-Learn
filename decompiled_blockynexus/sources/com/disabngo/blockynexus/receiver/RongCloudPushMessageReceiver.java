package com.disabngo.blockynexus.receiver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.imchat.config.BroadcastConstant;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.push.PushType;
import io.rong.push.notification.PushMessageReceiver;
import io.rong.push.notification.PushNotificationMessage;

/* JADX INFO: loaded from: classes2.dex */
public class RongCloudPushMessageReceiver extends PushMessageReceiver {
    private final String REQUEST_FRIEND = "requestFriend";
    private final String REQUEST_CLAN = "requestClan";

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoActivity(PushNotificationMessage pushNotificationMessage, Context context) {
        String pushData = pushNotificationMessage.getPushData();
        if (pushData != null) {
            byte b2 = -1;
            int iHashCode = pushData.hashCode();
            if (iHashCode != 1029145101) {
                if (iHashCode == 1149577605 && pushData.equals("requestClan")) {
                    b2 = 1;
                }
            } else if (pushData.equals("requestFriend")) {
                b2 = 0;
            }
            if (b2 == 0) {
                context.sendBroadcast(new Intent(BroadcastConstant.RongCloudPushRequestFriend));
            } else if (b2 != 1) {
                startChatActivity(context, pushNotificationMessage);
            } else {
                context.sendBroadcast(new Intent(BroadcastConstant.RongCloudPushRequestClan));
            }
        }
    }

    private void startChatActivity(Context context, PushNotificationMessage pushNotificationMessage) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        Uri.Builder builderBuildUpon = Uri.parse("rong://" + context.getPackageName()).buildUpon();
        builderBuildUpon.appendPath("conversation").appendPath(pushNotificationMessage.getConversationType().getName()).appendQueryParameter("targetId", pushNotificationMessage.getTargetId()).appendQueryParameter("title", pushNotificationMessage.getTargetUserName());
        intent.setData(builderBuildUpon.build());
        context.startActivity(intent);
    }

    @Override // io.rong.push.notification.PushMessageReceiver
    public boolean onNotificationMessageArrived(Context context, PushType pushType, PushNotificationMessage pushNotificationMessage) {
        return false;
    }

    @Override // io.rong.push.notification.PushMessageReceiver
    public boolean onNotificationMessageClicked(Context context, PushType pushType, PushNotificationMessage pushNotificationMessage) {
        try {
            if (RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED.getMessage().equals(RongIM.getInstance().getCurrentConnectionStatus().getMessage())) {
                RongIM.connect(SharedUtils.getString(context, StringConstant.RONG_CHAT_TOKEN, ""), new a(this, pushNotificationMessage, context));
            } else if (RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED.getMessage().equals(RongIM.getInstance().getCurrentConnectionStatus().getMessage())) {
                gotoActivity(pushNotificationMessage, context);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
