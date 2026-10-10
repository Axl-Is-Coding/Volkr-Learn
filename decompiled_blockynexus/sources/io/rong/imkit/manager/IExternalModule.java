package io.rong.imkit.manager;

import android.content.Context;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IExternalModule {
    List<IPluginModule> getPlugins(Conversation.ConversationType conversationType);

    void onConnected(String str);

    void onCreate(Context context);

    void onDisconnected();

    void onInitialized(String str);

    void onViewCreated();
}
