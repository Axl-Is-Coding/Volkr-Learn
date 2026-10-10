package io.rong.imkit.model;

import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationTypeFilter {
    private Level mLevel;
    private List<Conversation.ConversationType> mTypes;

    public enum Level {
        ALL,
        CONVERSATION_TYPE,
        NONE
    }

    private ConversationTypeFilter(Conversation.ConversationType... conversationTypeArr) {
        this.mTypes = new ArrayList();
        this.mTypes.addAll(Arrays.asList(conversationTypeArr));
        this.mLevel = Level.CONVERSATION_TYPE;
    }

    public static ConversationTypeFilter obtain(Conversation.ConversationType... conversationTypeArr) {
        return new ConversationTypeFilter(conversationTypeArr);
    }

    public List<Conversation.ConversationType> getConversationTypeList() {
        return this.mTypes;
    }

    public Level getLevel() {
        return this.mLevel;
    }

    public boolean hasFilter(Message message) {
        Level level = this.mLevel;
        if (level == Level.ALL) {
            return true;
        }
        if (level == Level.CONVERSATION_TYPE) {
            return this.mTypes.contains(message.getConversationType());
        }
        return false;
    }

    public static ConversationTypeFilter obtain(Level level) {
        return new ConversationTypeFilter(level);
    }

    public static ConversationTypeFilter obtain() {
        return new ConversationTypeFilter();
    }

    private ConversationTypeFilter() {
        this.mTypes = new ArrayList();
        this.mLevel = Level.ALL;
    }

    private ConversationTypeFilter(Level level) {
        this.mTypes = new ArrayList();
        this.mLevel = level;
    }
}
