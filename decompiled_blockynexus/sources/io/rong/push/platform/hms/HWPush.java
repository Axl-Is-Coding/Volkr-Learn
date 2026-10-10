package io.rong.push.platform.hms;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;

/* JADX INFO: loaded from: classes5.dex */
public class HWPush implements IPush {
    private static final String TAG = "HWPush";

    public void action(Context context) {
        RLog.d(TAG, "HMS start get token");
        try {
            String token = HmsInstanceId.getInstance(context).getToken(AGConnectServicesConfig.fromContext(context).getString("client/app_id"), "HCM");
            if (TextUtils.isEmpty(token)) {
                return;
            }
            PushManager.getInstance().onReceiveToken(context, PushType.HUAWEI, token);
        } catch (ApiException e2) {
            PushManager.getInstance().onErrorResponse(context, PushType.HUAWEI, PushConst.PUSH_ACTION_REQUEST_TOKEN, e2.getStatusCode());
            RLog.i(TAG, "getToken failed, " + e2);
        }
    }

    @Override // io.rong.push.platform.IPush
    public void register(final Context context, PushConfig pushConfig) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            action(context);
        } else {
            new Thread(new Runnable() { // from class: io.rong.push.platform.hms.HWPush.1
                @Override // java.lang.Runnable
                public void run() {
                    HWPush.this.action(context);
                }
            }).start();
        }
    }
}
