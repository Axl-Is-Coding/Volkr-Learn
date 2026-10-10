package io.rong.push.rongpush;

import android.content.Context;
import android.content.Intent;
import io.rong.imlib.common.DeviceUtils;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;

/* JADX INFO: loaded from: classes5.dex */
public class RongPush implements IPush {
    private static final String TAG = "RongPush";

    @Override // io.rong.push.platform.IPush
    public void register(Context context, PushConfig pushConfig) {
        try {
            Intent intent = new Intent(context, (Class<?>) PushService.class);
            intent.setAction(PushConst.ACTION_INIT_PUSH);
            intent.putExtra("deviceId", DeviceUtils.getDeviceId(context, pushConfig.getAppKey()));
            intent.putExtra("appKey", pushConfig.getAppKey());
            intent.putExtra(PushConst.PushDomain, pushConfig.getPushDomain());
            PushService.enqueueWork(context, intent);
        } catch (SecurityException e2) {
            RLog.e(TAG, "start PushService. " + e2.getMessage());
        }
    }
}
