package io.rong.push.platform.vivo;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import io.rong.push.PushErrorCode;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;

/* JADX INFO: loaded from: classes5.dex */
public class VivoPush implements IPush {
    private final String TAG = VivoPush.class.getSimpleName();

    @Override // io.rong.push.platform.IPush
    public void register(final Context context, PushConfig pushConfig) {
        PushClient.getInstance(context.getApplicationContext()).initialize();
        PushClient.getInstance(context.getApplicationContext()).turnOnPush(new IPushActionListener() { // from class: io.rong.push.platform.vivo.VivoPush.1
            public void onStateChanged(int i) {
                RLog.d(VivoPush.this.TAG, "Vivo push onStateChanged:" + i);
                if (i == 0) {
                    PushManager pushManager = PushManager.getInstance();
                    Context context2 = context;
                    pushManager.onReceiveToken(context2, PushType.VIVO, PushClient.getInstance(context2.getApplicationContext()).getRegId());
                } else if (i == 101) {
                    PushManager.getInstance().onErrorResponse(context, PushType.VIVO, PushConst.PUSH_ACTION_REQUEST_TOKEN, PushErrorCode.NOT_SUPPORT_BY_OFFICIAL_PUSH.getCode());
                } else {
                    PushManager.getInstance().onErrorResponse(context, PushType.VIVO, PushConst.PUSH_ACTION_REQUEST_TOKEN, i);
                }
            }
        });
    }
}
