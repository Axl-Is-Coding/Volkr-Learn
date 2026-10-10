package io.rong.imkit.model;

import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationInfo {
    private Conversation.ConversationType conversationType;
    private String targetId;

    ConversationInfo() {
    }

    public static ConversationInfo obtain(Conversation.ConversationType conversationType, String str) {
        ConversationInfo conversationInfo = new ConversationInfo();
        conversationInfo.conversationType = conversationType;
        conversationInfo.targetId = str;
        return conversationInfo;
    }

    public Conversation.ConversationType getConversationType() {
        return this.conversationType;
    }

    public String getTargetId() {
        return this.targetId;
    }
}
