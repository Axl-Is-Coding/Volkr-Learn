package io.rong.imkit.widget.provider;

import android.net.Uri;
import io.rong.imkit.RongContext;
import io.rong.imkit.model.ConversationKey;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.PublicServiceProfile;

/* JADX INFO: loaded from: classes5.dex */
@ConversationProviderTag(conversationType = "app_public_service", portraitPosition = 1)
public class AppServiceConversationProvider extends PrivateConversationProvider implements IContainerItemProvider.ConversationProvider<UIConversation> {
    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public Uri getPortraitUri(String str) {
        ConversationKey conversationKeyObtain = ConversationKey.obtain(str, Conversation.ConversationType.APP_PUBLIC_SERVICE);
        PublicServiceProfile publicServiceInfoFromCache = conversationKeyObtain != null ? RongContext.getInstance().getPublicServiceInfoFromCache(conversationKeyObtain.getKey()) : null;
        if (publicServiceInfoFromCache != null) {
            return publicServiceInfoFromCache.getPortraitUri();
        }
        return null;
    }

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public String getTitle(String str) {
        ConversationKey conversationKeyObtain = ConversationKey.obtain(str, Conversation.ConversationType.APP_PUBLIC_SERVICE);
        PublicServiceProfile publicServiceInfoFromCache = conversationKeyObtain != null ? RongContext.getInstance().getPublicServiceInfoFromCache(conversationKeyObtain.getKey()) : null;
        return publicServiceInfoFromCache != null ? publicServiceInfoFromCache.getName() : "";
    }
}
