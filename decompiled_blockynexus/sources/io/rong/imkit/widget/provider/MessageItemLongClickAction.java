package io.rong.imkit.widget.provider;

import android.content.Context;
import io.rong.imkit.model.UIMessage;

/* JADX INFO: loaded from: classes5.dex */
public class MessageItemLongClickAction {
    public Filter filter;
    public MessageItemLongClickListener listener;
    public int priority;
    private String title;
    private int titleResId;

    public static class Builder {
        private Filter filter;
        private MessageItemLongClickListener listener;
        private int priority;
        private String title;
        private int titleResId;

        public Builder actionListener(MessageItemLongClickListener messageItemLongClickListener) {
            this.listener = messageItemLongClickListener;
            return this;
        }

        public MessageItemLongClickAction build() {
            MessageItemLongClickAction messageItemLongClickAction = new MessageItemLongClickAction(this.titleResId, this.title, this.listener, this.filter);
            messageItemLongClickAction.priority = this.priority;
            return messageItemLongClickAction;
        }

        public Builder priority(int i) {
            this.priority = i;
            return this;
        }

        public Builder showFilter(Filter filter) {
            this.filter = filter;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder titleResId(int i) {
            this.titleResId = i;
            return this;
        }
    }

    public interface Filter {
        boolean filter(UIMessage uIMessage);
    }

    public interface MessageItemLongClickListener {
        boolean onMessageItemLongClick(Context context, UIMessage uIMessage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MessageItemLongClickAction.class != obj.getClass()) {
            return false;
        }
        MessageItemLongClickAction messageItemLongClickAction = (MessageItemLongClickAction) obj;
        if (this.titleResId != messageItemLongClickAction.titleResId) {
            return false;
        }
        String str = this.title;
        return str != null ? str.equals(messageItemLongClickAction.title) : messageItemLongClickAction.title == null;
    }

    public boolean filter(UIMessage uIMessage) {
        Filter filter = this.filter;
        return filter == null || filter.filter(uIMessage);
    }

    public String getTitle(Context context) {
        return (context == null || this.titleResId <= 0) ? this.title : context.getResources().getString(this.titleResId);
    }

    public int hashCode() {
        String str = this.title;
        return ((str != null ? str.hashCode() : 0) * 31) + this.titleResId;
    }

    private MessageItemLongClickAction(int i, String str, MessageItemLongClickListener messageItemLongClickListener, Filter filter) {
        this.titleResId = i;
        this.title = str;
        this.listener = messageItemLongClickListener;
        this.filter = filter;
    }
}
