package io.rong.push.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import io.rong.push.PushErrorCode;
import io.rong.push.PushType;
import io.rong.push.RongPushClient;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.notification.PushNotificationMessage;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    private static final String TAG = "PushMessageReceiver";

    private void handleNotificationClickEvent(Context context, boolean z, PushNotificationMessage pushNotificationMessage) {
        String str = (pushNotificationMessage.getSourceType().equals(PushNotificationMessage.PushSourceType.FROM_OFFLINE_MESSAGE) || pushNotificationMessage.getSourceType().equals(PushNotificationMessage.PushSourceType.FROM_ADMIN)) ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        Intent intent = new Intent();
        intent.setFlags(268435456);
        Uri.Builder builderBuildUpon = Uri.parse("rong://" + context.getPackageName()).buildUpon();
        if (pushNotificationMessage.getSourceType().equals(PushNotificationMessage.PushSourceType.FROM_ADMIN)) {
            builderBuildUpon.appendPath("push_message").appendQueryParameter("targetId", pushNotificationMessage.getTargetId()).appendQueryParameter("pushContent", pushNotificationMessage.getPushContent()).appendQueryParameter("pushData", pushNotificationMessage.getPushData()).appendQueryParameter("extra", pushNotificationMessage.getExtra()).appendQueryParameter("isFromPush", str);
        } else if (z) {
            builderBuildUpon.appendPath("conversationlist").appendQueryParameter("isFromPush", str);
        } else {
            builderBuildUpon.appendPath("conversation").appendPath(pushNotificationMessage.getConversationType().getName()).appendQueryParameter("targetId", pushNotificationMessage.getTargetId()).appendQueryParameter("title", TextUtils.isEmpty(pushNotificationMessage.getPushTitle()) ? pushNotificationMessage.getTargetUserName() : pushNotificationMessage.getPushTitle()).appendQueryParameter("isFromPush", str);
        }
        intent.setData(builderBuildUpon.build());
        intent.setPackage(context.getPackageName());
        context.startActivity(intent);
    }

    public boolean handleVoIPNotification(Context context, PushNotificationMessage pushNotificationMessage, String str) {
        String objectName = pushNotificationMessage.getObjectName();
        if (objectName == null || !objectName.equals("RC:VCInvite")) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 29) {
            RLog.d(TAG, "handle VoIP event.");
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setData(Uri.parse("rong://" + context.getPackageName()).buildUpon().appendPath("conversationlist").appendQueryParameter("isFromPush", "false").build());
            intent.setPackage(context.getPackageName());
            context.startActivity(intent);
            return true;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(context.getPackageName());
        intent2.putExtra("message", pushNotificationMessage);
        if (PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED.equals(str)) {
            intent2.setAction(PushConst.PUSH_ACTION_VOIP_CALLINVITEMESSAGE);
            context.sendBroadcast(intent2);
            return true;
        }
        if (!PushConst.ACTION_NOTIFICATION_MESSAGE_CLICKED.equals(str)) {
            return false;
        }
        intent2.setAction(PushConst.PUSH_ACTION_VOIP_CALLINVITEMESSAGE_CLICKED);
        context.sendBroadcast(intent2);
        return true;
    }

    public abstract boolean onNotificationMessageArrived(Context context, PushType pushType, PushNotificationMessage pushNotificationMessage);

    public abstract boolean onNotificationMessageClicked(Context context, PushType pushType, PushNotificationMessage pushNotificationMessage);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        RLog.d(TAG, "onReceive.action:" + intent.getAction());
        if (intent.getAction() == null) {
            RLog.e(TAG, "the intent action is null, return directly. ");
            return;
        }
        String stringExtra = intent.getStringExtra(PushConst.PUSH_TYPE);
        int intExtra = intent.getIntExtra("left", 0);
        PushNotificationMessage pushNotificationMessage = (PushNotificationMessage) intent.getParcelableExtra("message");
        if (pushNotificationMessage == null && !intent.getAction().equals(PushConst.ACTION_THIRD_PARTY_PUSH_STATE)) {
            RLog.e(TAG, "message is null. Return directly!");
            return;
        }
        PushType type = PushType.getType(stringExtra);
        String action = intent.getAction();
        byte b2 = -1;
        int iHashCode = action.hashCode();
        if (iHashCode != -1691742143) {
            if (iHashCode != -253124277) {
                if (iHashCode == 1008493703 && action.equals(PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED)) {
                    b2 = 0;
                }
            } else if (action.equals(PushConst.ACTION_THIRD_PARTY_PUSH_STATE)) {
                b2 = 2;
            }
        } else if (action.equals(PushConst.ACTION_NOTIFICATION_MESSAGE_CLICKED)) {
            b2 = 1;
        }
        if (b2 == 0) {
            if (onNotificationMessageArrived(context, type, pushNotificationMessage)) {
                return;
            }
            if ((!type.equals(PushType.RONG) && !type.equals(PushType.GOOGLE_FCM) && !type.equals(PushType.GOOGLE_GCM)) || pushNotificationMessage == null || handleVoIPNotification(context, pushNotificationMessage, intent.getAction())) {
                return;
            }
            RongNotificationInterface.sendNotification(context, pushNotificationMessage, intExtra);
            return;
        }
        if (b2 != 1) {
            if (b2 != 2) {
                RLog.e(TAG, "Unknown action, do nothing!");
                return;
            } else {
                onThirdPartyPushState(type, intent.getStringExtra("action"), intent.getLongExtra(PushConst.RESULT_CODE, PushErrorCode.UNKNOWN.getCode()));
                return;
            }
        }
        if (pushNotificationMessage != null && !TextUtils.isEmpty(pushNotificationMessage.getPushId())) {
            RongPushClient.recordNotificationEvent(pushNotificationMessage);
        }
        if (onNotificationMessageClicked(context, type, pushNotificationMessage) || pushNotificationMessage == null || handleVoIPNotification(context, pushNotificationMessage, intent.getAction())) {
            return;
        }
        handleNotificationClickEvent(context, intent.getBooleanExtra(PushConst.IS_MULTI, false), pushNotificationMessage);
    }

    public void onThirdPartyPushState(PushType pushType, String str, long j) {
        RLog.e(TAG, "onThirdPartyPushState pushType: " + pushType + " action: " + str + " resultCode: " + j);
    }
}
