package io.rong.imkit.model;

import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public final class ConversationKey {
    private static final String SEPARATOR = "#@6RONG_CLOUD9@#";
    private String key;
    private String targetId;
    private Conversation.ConversationType type;

    private ConversationKey() {
    }

    public static ConversationKey obtain(String str, Conversation.ConversationType conversationType) {
        if (TextUtils.isEmpty(str) || conversationType == null) {
            return null;
        }
        ConversationKey conversationKey = new ConversationKey();
        conversationKey.setTargetId(str);
        conversationKey.setType(conversationType);
        conversationKey.setKey(str + SEPARATOR + conversationType.getValue());
        return conversationKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public Conversation.ConversationType getType() {
        return this.type;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    public void setType(Conversation.ConversationType conversationType) {
        this.type = conversationType;
    }

    public static ConversationKey obtain(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(SEPARATOR)) {
            ConversationKey conversationKey = new ConversationKey();
            if (str.contains(SEPARATOR)) {
                String[] strArrSplit = str.split(SEPARATOR);
                conversationKey.setTargetId(strArrSplit[0]);
                try {
                    conversationKey.setType(Conversation.ConversationType.setValue(Integer.parseInt(strArrSplit[1])));
                    return conversationKey;
                } catch (NumberFormatException unused) {
                    RLog.e("ConversationKey ", "NumberFormatException");
                }
            }
        }
        return null;
    }
}
