package io.rong.push.platform.meizu;

import android.content.Context;
import android.text.TextUtils;
import io.rong.push.PushErrorCode;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;

/* JADX INFO: loaded from: classes5.dex */
public class MeizuPush implements IPush {
    private final String TAG = MeizuPush.class.getSimpleName();

    @Override // io.rong.push.platform.IPush
    public void register(Context context, PushConfig pushConfig) {
        if (TextUtils.isEmpty(pushConfig.getMzAppId()) || TextUtils.isEmpty(pushConfig.getMzAppKey())) {
            RLog.e(this.TAG, "appId or appKey can't be empty!");
            PushManager.getInstance().onErrorResponse(context, PushType.MEIZU, PushConst.PUSH_ACTION_REQUEST_TOKEN, PushErrorCode.PARAMETER_ERROR.getCode());
            return;
        }
        String pushId = com.meizu.cloud.pushsdk.PushManager.getPushId(context);
        if (TextUtils.isEmpty(pushId)) {
            com.meizu.cloud.pushsdk.PushManager.register(context, pushConfig.getMzAppId(), pushConfig.getMzAppKey());
        } else {
            PushManager.getInstance().onReceiveToken(context, PushType.MEIZU, pushId);
        }
    }
}
