package io.rong.imkit.widget.provider;

import android.net.Uri;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.provider.IContainerItemProvider;

/* JADX INFO: loaded from: classes5.dex */
@ConversationProviderTag(conversationType = "discussion", portraitPosition = 1)
public class DiscussionConversationProvider extends PrivateConversationProvider implements IContainerItemProvider.ConversationProvider<UIConversation> {
    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public Uri getPortraitUri(String str) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public String getTitle(String str) {
        return RongUserInfoManager.getInstance().getDiscussionInfo(str) == null ? RongIM.getInstance().getApplicationContext().getResources().getString(R.string.rc_conversation_list_default_discussion_name) : RongUserInfoManager.getInstance().getDiscussionInfo(str).getName();
    }
}
