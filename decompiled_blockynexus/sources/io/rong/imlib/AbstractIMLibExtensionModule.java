package io.rong.imlib;

import android.content.Context;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractIMLibExtensionModule implements IMLibExtensionModule {
    @Override // io.rong.imlib.IMLibExtensionModule
    public List<Class<? extends MessageContent>> getCmdMessageContentList() {
        return null;
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public List<Class<? extends MessageContent>> getMessageContentList() {
        return null;
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onConnectStatusChanged(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onCreate(Context context, String str) {
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onDestroy() {
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onLogin(String str, String str2) {
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onLogout() {
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public boolean onReceiveMessage(Message message, int i, boolean z, int i2) {
        return false;
    }
}
