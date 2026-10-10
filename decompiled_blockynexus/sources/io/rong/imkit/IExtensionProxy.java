package io.rong.imkit;

import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IExtensionProxy {
    IExtensionModule onPreLoadEmoticons(Conversation.ConversationType conversationType, String str, IExtensionModule iExtensionModule);

    void onPreLoadPlugins(Conversation.ConversationType conversationType, String str, List<IPluginModule> list);
}
