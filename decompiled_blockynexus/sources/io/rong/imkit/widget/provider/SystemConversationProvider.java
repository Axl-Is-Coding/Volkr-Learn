package io.rong.imkit.widget.provider;

import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.provider.IContainerItemProvider;

/* JADX INFO: loaded from: classes5.dex */
@ConversationProviderTag(conversationType = "system", portraitPosition = 1)
public class SystemConversationProvider extends PrivateConversationProvider implements IContainerItemProvider.ConversationProvider<UIConversation> {
    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public String getTitle(String str) {
        return RongUserInfoManager.getInstance().getUserInfo(str) == null ? str : RongUserInfoManager.getInstance().getUserInfo(str).getName();
    }
}
