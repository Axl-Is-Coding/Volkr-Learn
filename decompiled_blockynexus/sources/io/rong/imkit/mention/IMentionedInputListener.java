package io.rong.imkit.mention;

import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public interface IMentionedInputListener {
    boolean onMentionedInput(Conversation.ConversationType conversationType, String str);
}
