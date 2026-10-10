package io.rong.push.platform.google;

import android.content.Context;
import com.google.android.gms.iid.InstanceID;
import io.rong.push.PushErrorCode;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.core.PushUtils;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class GCMPush implements IPush {
    private final String TAG = GCMPush.class.getSimpleName();

    @Override // io.rong.push.platform.IPush
    public void register(Context context, PushConfig pushConfig) {
        long jCheckPlayServices = PushUtils.checkPlayServices(context);
        if (jCheckPlayServices != 0) {
            PushManager.getInstance().onErrorResponse(context, PushType.GOOGLE_GCM, PushConst.PUSH_ACTION_CHECK_PLAYER_SERVICE, jCheckPlayServices);
            return;
        }
        try {
            PushManager.getInstance().onReceiveToken(context, PushType.GOOGLE_GCM, InstanceID.getInstance(context).getToken(context.getResources().getString(context.getResources().getIdentifier("gcm_defaultSenderId", "string", context.getPackageName())), "GCM", null));
        } catch (IOException e2) {
            RLog.e(this.TAG, e2.getMessage());
            PushManager.getInstance().onErrorResponse(context, PushType.GOOGLE_GCM, PushConst.PUSH_ACTION_CHECK_PLAYER_SERVICE, PushErrorCode.IO_EXCEPTION.getCode());
        }
    }
}
