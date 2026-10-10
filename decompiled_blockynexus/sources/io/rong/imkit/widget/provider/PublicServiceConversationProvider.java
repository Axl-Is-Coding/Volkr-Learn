package io.rong.imkit.widget.provider;

import android.net.Uri;
import android.view.View;
import io.rong.imkit.RongContext;
import io.rong.imkit.model.ConversationKey;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.PublicServiceProfile;

/* JADX INFO: loaded from: classes5.dex */
@ConversationProviderTag(conversationType = "public_service", portraitPosition = 1)
public class PublicServiceConversationProvider extends PrivateConversationProvider implements IContainerItemProvider.ConversationProvider<UIConversation> {
    private ConversationKey mKey;

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public Uri getPortraitUri(String str) {
        this.mKey = ConversationKey.obtain(str, Conversation.ConversationType.PUBLIC_SERVICE);
        PublicServiceProfile publicServiceInfoFromCache = this.mKey != null ? RongContext.getInstance().getPublicServiceInfoFromCache(this.mKey.getKey()) : null;
        if (publicServiceInfoFromCache != null) {
            return publicServiceInfoFromCache.getPortraitUri();
        }
        return null;
    }

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider.ConversationProvider
    public String getTitle(String str) {
        this.mKey = ConversationKey.obtain(str, Conversation.ConversationType.PUBLIC_SERVICE);
        PublicServiceProfile publicServiceInfoFromCache = this.mKey != null ? RongContext.getInstance().getPublicServiceInfoFromCache(this.mKey.getKey()) : null;
        return publicServiceInfoFromCache != null ? publicServiceInfoFromCache.getName() : "";
    }

    @Override // io.rong.imkit.widget.provider.PrivateConversationProvider, io.rong.imkit.widget.provider.IContainerItemProvider
    public void bindView(View view, int i, UIConversation uIConversation) {
        super.bindView(view, i, uIConversation);
    }
}
