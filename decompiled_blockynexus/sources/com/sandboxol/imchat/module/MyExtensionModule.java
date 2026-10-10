package com.sandboxol.imchat.module;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.ImagePlugin;
import io.rong.imlib.model.Conversation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MyExtensionModule extends DefaultExtensionModule {
    @Override // io.rong.imkit.DefaultExtensionModule, io.rong.imkit.IExtensionModule
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ImagePlugin());
        if (conversationType == Conversation.ConversationType.GROUP || conversationType == Conversation.ConversationType.PRIVATE) {
            arrayList.add(new GroupCardPlugin());
            arrayList.add(new ScrapCardPlugin());
        }
        return arrayList;
    }
}
