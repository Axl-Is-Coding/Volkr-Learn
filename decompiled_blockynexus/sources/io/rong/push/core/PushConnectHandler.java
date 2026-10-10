package io.rong.push.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import io.rong.imlib.common.DeviceUtils;
import io.rong.push.PushErrorCode;
import io.rong.push.core.PushClient;
import io.rong.push.pushconfig.IResultCallback;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class PushConnectHandler extends Handler {
    private final String IP_SPLIT;
    private final String TAG;
    private String appKey;
    private IResultCallback<String> callback;
    private Context context;
    private int index;
    private ArrayList<String> ipList;
    private PushClient pushClient;

    public PushConnectHandler(Looper looper) {
        super(looper);
        this.TAG = PushConnectHandler.class.getSimpleName();
        this.IP_SPLIT = ":";
    }

    public void connect(Context context, PushClient pushClient, ArrayList<String> arrayList, String str, IResultCallback<String> iResultCallback) {
        this.pushClient = pushClient;
        this.ipList = arrayList;
        this.appKey = str;
        this.callback = iResultCallback;
        this.context = context;
        sendEmptyMessage(0);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.index = message.what;
        if (TextUtils.isEmpty(this.ipList.get(this.index))) {
            return;
        }
        String[] strArrSplit = this.ipList.get(this.index).split(":");
        this.pushClient.connect(strArrSplit[0], Integer.parseInt(strArrSplit[1]), DeviceUtils.getDeviceId(this.context, this.appKey), new PushClient.ConnectStatusCallback() { // from class: io.rong.push.core.PushConnectHandler.1
            @Override // io.rong.push.core.PushClient.ConnectStatusCallback
            public void onConnected() {
                PushConnectHandler.this.callback.onSuccess("");
            }

            @Override // io.rong.push.core.PushClient.ConnectStatusCallback
            public void onError() {
                PushConnectHandler.this.pushClient.reset();
                if (PushConnectHandler.this.index >= PushConnectHandler.this.ipList.size() - 1) {
                    PushConnectHandler.this.callback.onError(PushErrorCode.IO_EXCEPTION);
                } else {
                    PushConnectHandler pushConnectHandler = PushConnectHandler.this;
                    pushConnectHandler.sendEmptyMessage(pushConnectHandler.index + 1);
                }
            }
        });
    }
}
