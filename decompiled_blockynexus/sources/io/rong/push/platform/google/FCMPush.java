package io.rong.push.platform.google;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.core.PushUtils;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;

/* JADX INFO: loaded from: classes5.dex */
public class FCMPush implements IPush {
    @Override // io.rong.push.platform.IPush
    public void register(Context context, PushConfig pushConfig) {
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        long jCheckPlayServices = PushUtils.checkPlayServices(context);
        if (jCheckPlayServices != 0) {
            PushManager.getInstance().onErrorResponse(context, PushType.GOOGLE_FCM, PushConst.PUSH_ACTION_CHECK_PLAYER_SERVICE, jCheckPlayServices);
        }
    }
}
