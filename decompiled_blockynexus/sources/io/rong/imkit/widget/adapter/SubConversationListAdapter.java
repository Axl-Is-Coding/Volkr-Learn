package io.rong.imkit.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.ProviderContainerView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public class SubConversationListAdapter extends ConversationListAdapter {
    private Context mContext;
    private LayoutInflater mInflater;

    class ViewHolder {
        ProviderContainerView contentView;
        View layout;
        View leftImageLayout;
        AsyncImageView leftImageView;
        View leftUnReadView;
        View rightImageLayout;
        AsyncImageView rightImageView;
        View rightUnReadView;
        TextView unReadMsgCount;
        ImageView unReadMsgCountIcon;
        TextView unReadMsgCountRight;
        ImageView unReadMsgCountRightIcon;

        ViewHolder() {
        }
    }

    public SubConversationListAdapter(Context context) {
        super(context);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    @Override // io.rong.imkit.widget.adapter.ConversationListAdapter, android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) == null) {
            return 0L;
        }
        return r3.hashCode();
    }

    @Override // io.rong.imkit.widget.adapter.ConversationListAdapter, io.rong.imkit.widget.adapter.BaseAdapter
    protected View newView(Context context, int i, ViewGroup viewGroup) {
        View viewInflate = this.mInflater.inflate(R.layout.rc_item_conversation, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.layout = findViewById(viewInflate, R.id.rc_item_conversation);
        viewHolder.leftImageLayout = findViewById(viewInflate, R.id.rc_item1);
        viewHolder.rightImageLayout = findViewById(viewInflate, R.id.rc_item2);
        viewHolder.leftUnReadView = findViewById(viewInflate, R.id.rc_unread_view_left);
        viewHolder.rightUnReadView = findViewById(viewInflate, R.id.rc_unread_view_right);
        viewHolder.leftImageView = (AsyncImageView) findViewById(viewInflate, R.id.rc_left);
        viewHolder.rightImageView = (AsyncImageView) findViewById(viewInflate, R.id.rc_right);
        viewHolder.contentView = (ProviderContainerView) findViewById(viewInflate, R.id.rc_content);
        viewHolder.unReadMsgCount = (TextView) findViewById(viewInflate, R.id.rc_unread_message);
        viewHolder.unReadMsgCountRight = (TextView) findViewById(viewInflate, R.id.rc_unread_message_right);
        viewHolder.unReadMsgCountIcon = (ImageView) findViewById(viewInflate, R.id.rc_unread_message_icon);
        viewHolder.unReadMsgCountRightIcon = (ImageView) findViewById(viewInflate, R.id.rc_unread_message_icon_right);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.rong.imkit.widget.adapter.ConversationListAdapter, io.rong.imkit.widget.adapter.BaseAdapter
    public void bindView(View view, int i, UIConversation uIConversation) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        IContainerItemProvider.ConversationProvider conversationTemplate = RongContext.getInstance().getConversationTemplate(uIConversation.getConversationType().getName());
        conversationTemplate.bindView(viewHolder.contentView.inflate(conversationTemplate), i, uIConversation);
        if (uIConversation.isTop()) {
            viewHolder.layout.setBackgroundColor(this.mContext.getResources().getColor(R.color.rc_conversation_top_bg));
        } else {
            viewHolder.layout.setBackgroundColor(this.mContext.getResources().getColor(R.color.rc_text_color_primary_inverse));
        }
        ConversationProviderTag conversationProviderTag = RongContext.getInstance().getConversationProviderTag(uIConversation.getConversationType().getName());
        int i2 = uIConversation.getConversationType() == Conversation.ConversationType.GROUP ? R.drawable.rc_default_group_portrait : uIConversation.getConversationType() == Conversation.ConversationType.DISCUSSION ? R.drawable.rc_default_discussion_portrait : R.drawable.rc_default_portrait;
        if (conversationProviderTag.portraitPosition() == 1) {
            viewHolder.leftImageLayout.setVisibility(0);
            if (uIConversation.getIconUrl() != null) {
                viewHolder.leftImageView.setAvatar(uIConversation.getIconUrl().toString(), i2);
            } else {
                viewHolder.leftImageView.setAvatar(null, i2);
            }
            if (uIConversation.getUnReadMessageCount() > 0) {
                viewHolder.unReadMsgCountIcon.setVisibility(0);
                setUnReadViewLayoutParams(viewHolder.leftUnReadView, uIConversation.getUnReadType());
                if (uIConversation.getUnReadType().equals(UIConversation.UnreadRemindType.REMIND_WITH_COUNTING)) {
                    viewHolder.unReadMsgCount.setVisibility(0);
                    if (uIConversation.getUnReadMessageCount() > 99) {
                        viewHolder.unReadMsgCount.setText(this.mContext.getResources().getString(R.string.rc_message_unread_count));
                    } else {
                        viewHolder.unReadMsgCount.setText(Integer.toString(uIConversation.getUnReadMessageCount()));
                    }
                    viewHolder.unReadMsgCountIcon.setImageResource(R.drawable.rc_unread_count_bg);
                } else {
                    viewHolder.unReadMsgCount.setVisibility(8);
                    viewHolder.unReadMsgCountIcon.setImageResource(R.drawable.rc_unread_remind_without_count);
                }
            } else {
                viewHolder.unReadMsgCountIcon.setVisibility(8);
                viewHolder.unReadMsgCount.setVisibility(8);
            }
            viewHolder.rightImageLayout.setVisibility(8);
            return;
        }
        if (conversationProviderTag.portraitPosition() != 2) {
            if (conversationProviderTag.portraitPosition() != 3) {
                throw new IllegalArgumentException("the portrait position is wrong!");
            }
            viewHolder.rightImageLayout.setVisibility(8);
            viewHolder.leftImageLayout.setVisibility(8);
            return;
        }
        viewHolder.rightImageLayout.setVisibility(0);
        if (uIConversation.getIconUrl() != null) {
            viewHolder.rightImageView.setAvatar(uIConversation.getIconUrl().toString(), i2);
        } else {
            viewHolder.rightImageView.setAvatar(null, i2);
        }
        if (uIConversation.getUnReadMessageCount() > 0) {
            viewHolder.unReadMsgCountRight.setVisibility(0);
            viewHolder.unReadMsgCountIcon.setVisibility(0);
            setUnReadViewLayoutParams(viewHolder.rightUnReadView, uIConversation.getUnReadType());
            if (uIConversation.getUnReadType().equals(UIConversation.UnreadRemindType.REMIND_WITH_COUNTING)) {
                if (uIConversation.getUnReadMessageCount() > 99) {
                    viewHolder.unReadMsgCountRight.setText(this.mContext.getResources().getString(R.string.rc_message_unread_count));
                } else {
                    viewHolder.unReadMsgCountRight.setText(Integer.toString(uIConversation.getUnReadMessageCount()));
                }
                viewHolder.unReadMsgCountIcon.setImageResource(R.drawable.rc_unread_count_bg);
            } else {
                viewHolder.unReadMsgCountIcon.setImageResource(R.drawable.rc_unread_remind_without_count);
            }
        }
        viewHolder.leftImageLayout.setVisibility(8);
    }
}
