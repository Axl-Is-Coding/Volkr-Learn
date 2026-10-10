package io.rong.imkit.widget.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.message.HandshakeMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, hide = true, messageContent = HandshakeMessage.class, showPortrait = false)
public class HandshakeMessageItemProvider extends IContainerItemProvider.MessageProvider<HandshakeMessage> {
    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, HandshakeMessage handshakeMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(HandshakeMessage handshakeMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, HandshakeMessage handshakeMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, HandshakeMessage handshakeMessage) {
        if (handshakeMessage == null || handshakeMessage.getContent() == null) {
            return null;
        }
        return new SpannableString(AndroidEmoji.ensure(handshakeMessage.getContent()));
    }
}
