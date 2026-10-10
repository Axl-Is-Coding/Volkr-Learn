package io.rong.imkit;

import io.rong.imkit.emoticon.IEmoticonTab;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IExtensionModule {
    List<IEmoticonTab> getEmoticonTabs();

    List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType);

    void onAttachedToExtension(RongExtension rongExtension);

    void onConnect(String str);

    void onDetachedFromExtension();

    void onDisconnect();

    void onInit(String str);

    void onReceivedMessage(Message message);
}
