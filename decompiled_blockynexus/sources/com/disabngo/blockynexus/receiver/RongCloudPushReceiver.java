package com.disabngo.blockynexus.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.e.b.Q.d;
import com.disabngo.blockynexus.view.activity.main.MainActivity;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.imchat.config.BroadcastConstant;

/* JADX INFO: loaded from: classes.dex */
public class RongCloudPushReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (BroadcastConstant.RongCloudChatOnLeft.equals(intent.getAction())) {
            if (A.a(context, "MainActivity")) {
                return;
            }
            context.startActivity(new Intent(context, (Class<?>) MainActivity.class).putExtra(StringConstant.RONGCLOUD_PUSH_SELECT_TYPE, StringConstant.RONGCLOUD_PUSH_SELECT_CHAT).addFlags(268435456));
        } else if (BroadcastConstant.RongCloudPushRequestFriend.equals(intent.getAction())) {
            TemplateUtils.startTemplateWithFlags(context, d.class, context.getString(R.string.chat_new_friend), 268435456);
        } else if (BroadcastConstant.RongCloudPushRequestClan.equals(intent.getAction())) {
            TemplateUtils.startTemplateWithFlags(context, com.disabngo.blockynexus.e.b.pa.d.class, context.getString(R.string.tribe_message), 268435456);
        }
    }
}
