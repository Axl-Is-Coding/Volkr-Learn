package io.rong.imlib;

import android.content.Context;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.HardwareResource;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IMLibExtensionModule {
    List<Class<? extends MessageContent>> getCmdMessageContentList();

    List<Class<? extends MessageContent>> getMessageContentList();

    void onConnectStatusChanged(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus);

    void onCreate(Context context, String str);

    void onDestroy();

    void onLogin(String str, String str2);

    void onLogout();

    boolean onReceiveMessage(Message message, int i, boolean z, int i2);

    boolean onRequestHardwareResource(HardwareResource.ResourceType resourceType);
}
