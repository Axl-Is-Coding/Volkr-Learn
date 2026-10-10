package io.rong.push.platform.hms;

import android.text.TextUtils;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class HMSPushService extends HmsMessageService {
    private static final String TAG = "HMSPushService";

    /* JADX WARN: Multi-variable type inference failed */
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        RLog.d(TAG, "onPushMsg");
        if (remoteMessage == null) {
            RLog.e(TAG, "pRemoteMessage is empty");
        } else if (TextUtils.isEmpty(remoteMessage.getData())) {
            RLog.e(TAG, "pRemoteMessage.getData is empty");
        } else {
            PushManager.getInstance().onPushRawData(this, PushType.HUAWEI, remoteMessage.getData());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewToken(String str) {
        super.onNewToken(str);
        PushManager.getInstance().onReceiveToken(this, PushType.HUAWEI, str);
    }
}
