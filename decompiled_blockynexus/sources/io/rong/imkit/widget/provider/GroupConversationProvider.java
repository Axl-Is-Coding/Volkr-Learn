package io.rong.imkit.widget.provider;

import android.net.Uri;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Group;

/* JADX INFO: loaded from: classes5.dex */
@ConversationProviderTag(conversationType = "group", portraitPosition = 1)
public class GroupConversationProvider extends PrivateConversationProvider implements IContainerItemProvider.ConversationProvider<UIConversation> {
    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public Uri getPortraitUri(String str) {
        if (RongUserInfoManager.getInstance().getGroupInfo(str) == null) {
            return null;
        }
        return RongUserInfoManager.getInstance().getGroupInfo(str).getPortraitUri();
    }

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public String getTitle(String str) {
        Group groupInfo = RongUserInfoManager.getInstance().getGroupInfo(str);
        return groupInfo == null ? "" : groupInfo.getName();
    }
}
