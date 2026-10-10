package io.rong.imkit.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.model.ConversationProviderTag;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.ProviderContainerView;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationListAdapter extends BaseAdapter<UIConversation> {
    private static final String TAG = "ConversationListAdapter";
    Context mContext;
    LayoutInflater mInflater;
    private OnPortraitItemClick mOnPortraitItemClick;

    public interface OnPortraitItemClick {
        void onPortraitItemClick(View view, UIConversation uIConversation);

        boolean onPortraitItemLongClick(View view, UIConversation uIConversation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public class ViewHolder {
        public ProviderContainerView contentView;
        public View layout;
        public View leftImageLayout;
        public AsyncImageView leftImageView;
        public View leftUnReadView;
        public View rightImageLayout;
        public AsyncImageView rightImageView;
        public View rightUnReadView;
        public TextView unReadMsgCount;
        public ImageView unReadMsgCountIcon;
        public TextView unReadMsgCountRight;
        public ImageView unReadMsgCountRightIcon;

        protected ViewHolder() {
        }
    }

    public ConversationListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public int findGatheredItem(Conversation.ConversationType conversationType) {
        int count = getCount();
        while (true) {
            int i = count - 1;
            if (count <= 0) {
                return -1;
            }
            if (getItem(i).getConversationType().equals(conversationType)) {
                return i;
            }
            count = i;
        }
    }

    public int findPosition(Conversation.ConversationType conversationType, String str) {
        int count = getCount();
        while (true) {
            int i = count - 1;
            if (count <= 0) {
                return -1;
            }
            if (getItem(i).getConversationType().equals(conversationType) && getItem(i).getConversationTargetId().equals(str)) {
                return i;
            }
            count = i;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) == null) {
            return 0L;
        }
        return r3.hashCode();
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    protected View newView(Context context, int i, ViewGroup viewGroup) {
        View viewInflate = this.mInflater.inflate(R.layout.rc_item_conversation, (ViewGroup) null);
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

    public void setOnPortraitItemClick(OnPortraitItemClick onPortraitItemClick) {
        this.mOnPortraitItemClick = onPortraitItemClick;
    }

    protected void setUnReadViewLayoutParams(View view, UIConversation.UnreadRemindType unreadRemindType) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        Context context = view.getContext();
        if (unreadRemindType == UIConversation.UnreadRemindType.REMIND_WITH_COUNTING) {
            marginLayoutParams.width = (int) context.getResources().getDimension(R.dimen.rc_dimen_size_18);
            marginLayoutParams.height = (int) context.getResources().getDimension(R.dimen.rc_dimen_size_18);
            marginLayoutParams.leftMargin = (int) this.mContext.getResources().getDimension(R.dimen.rc_dimen_size_44);
            marginLayoutParams.topMargin = (int) context.getResources().getDimension(R.dimen.rc_dimen_size_5);
        } else {
            marginLayoutParams.width = (int) context.getResources().getDimension(R.dimen.rc_dimen_size_9);
            marginLayoutParams.height = (int) context.getResources().getDimension(R.dimen.rc_dimen_size_9);
            marginLayoutParams.leftMargin = (int) context.getResources().getDimension(R.dimen.rc_dimen_size_50);
            marginLayoutParams.topMargin = (int) context.getResources().getDimension(R.dimen.rc_dimen_size_7);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void bindView(View view, int i, final UIConversation uIConversation) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIConversation == null) {
            return;
        }
        IContainerItemProvider.ConversationProvider conversationTemplate = RongContext.getInstance().getConversationTemplate(uIConversation.getConversationType().getName());
        if (conversationTemplate == null) {
            RLog.e(TAG, "provider is null");
            return;
        }
        conversationTemplate.bindView(viewHolder.contentView.inflate(conversationTemplate), i, uIConversation);
        if (uIConversation.isTop()) {
            viewHolder.layout.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.rc_item_top_list_selector));
        } else {
            viewHolder.layout.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.rc_item_list_selector));
        }
        ConversationProviderTag conversationProviderTag = RongContext.getInstance().getConversationProviderTag(uIConversation.getConversationType().getName());
        int i2 = uIConversation.getConversationType().equals(Conversation.ConversationType.GROUP) ? R.drawable.rc_default_group_portrait : uIConversation.getConversationType().equals(Conversation.ConversationType.DISCUSSION) ? R.drawable.rc_default_discussion_portrait : R.drawable.rc_default_portrait;
        if (conversationProviderTag.portraitPosition() == 1) {
            viewHolder.leftImageLayout.setVisibility(0);
            viewHolder.leftImageLayout.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.adapter.ConversationListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConversationListAdapter.this.mOnPortraitItemClick != null) {
                        ConversationListAdapter.this.mOnPortraitItemClick.onPortraitItemClick(view2, uIConversation);
                    }
                }
            });
            viewHolder.leftImageLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.widget.adapter.ConversationListAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (ConversationListAdapter.this.mOnPortraitItemClick == null) {
                        return true;
                    }
                    ConversationListAdapter.this.mOnPortraitItemClick.onPortraitItemLongClick(view2, uIConversation);
                    return true;
                }
            });
            if (uIConversation.getConversationGatherState() || uIConversation.getIconUrl() == null) {
                viewHolder.leftImageView.setAvatar(null, i2);
            } else {
                viewHolder.leftImageView.setAvatar(uIConversation.getIconUrl().toString(), i2);
            }
            if (uIConversation.getUnReadMessageCount() > 0) {
                viewHolder.unReadMsgCountIcon.setVisibility(0);
                setUnReadViewLayoutParams(viewHolder.leftUnReadView, uIConversation.getUnReadType());
                if (uIConversation.getUnReadType().equals(UIConversation.UnreadRemindType.REMIND_WITH_COUNTING)) {
                    if (uIConversation.getUnReadMessageCount() > 99) {
                        viewHolder.unReadMsgCount.setText(this.mContext.getResources().getString(R.string.rc_message_unread_count));
                    } else {
                        viewHolder.unReadMsgCount.setText(Integer.toString(uIConversation.getUnReadMessageCount()));
                    }
                    viewHolder.unReadMsgCount.setVisibility(0);
                    viewHolder.unReadMsgCountIcon.setImageResource(R.drawable.rc_unread_count_bg);
                } else {
                    viewHolder.unReadMsgCount.setVisibility(8);
                    viewHolder.unReadMsgCountIcon.setImageResource(R.drawable.rc_unread_remind_list_count);
                }
            } else {
                viewHolder.unReadMsgCountIcon.setVisibility(8);
                viewHolder.unReadMsgCount.setVisibility(8);
            }
            viewHolder.rightImageLayout.setVisibility(8);
        } else if (conversationProviderTag.portraitPosition() == 2) {
            viewHolder.rightImageLayout.setVisibility(0);
            viewHolder.rightImageLayout.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.adapter.ConversationListAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConversationListAdapter.this.mOnPortraitItemClick != null) {
                        ConversationListAdapter.this.mOnPortraitItemClick.onPortraitItemClick(view2, uIConversation);
                    }
                }
            });
            viewHolder.rightImageLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.widget.adapter.ConversationListAdapter.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (ConversationListAdapter.this.mOnPortraitItemClick == null) {
                        return true;
                    }
                    ConversationListAdapter.this.mOnPortraitItemClick.onPortraitItemLongClick(view2, uIConversation);
                    return true;
                }
            });
            if (uIConversation.getConversationGatherState() || uIConversation.getIconUrl() == null) {
                viewHolder.rightImageView.setAvatar(null, i2);
            } else {
                viewHolder.rightImageView.setAvatar(uIConversation.getIconUrl().toString(), i2);
            }
            if (uIConversation.getUnReadMessageCount() > 0) {
                viewHolder.unReadMsgCountRightIcon.setVisibility(0);
                setUnReadViewLayoutParams(viewHolder.rightUnReadView, uIConversation.getUnReadType());
                if (uIConversation.getUnReadType().equals(UIConversation.UnreadRemindType.REMIND_WITH_COUNTING)) {
                    viewHolder.unReadMsgCount.setVisibility(0);
                    if (uIConversation.getUnReadMessageCount() > 99) {
                        viewHolder.unReadMsgCountRight.setText(this.mContext.getResources().getString(R.string.rc_message_unread_count));
                    } else {
                        viewHolder.unReadMsgCountRight.setText(Integer.toString(uIConversation.getUnReadMessageCount()));
                    }
                    viewHolder.unReadMsgCountRightIcon.setImageResource(R.drawable.rc_unread_count_bg);
                } else {
                    viewHolder.unReadMsgCount.setVisibility(8);
                    viewHolder.unReadMsgCountRightIcon.setImageResource(R.drawable.rc_unread_remind_without_count);
                }
            } else {
                viewHolder.unReadMsgCountIcon.setVisibility(8);
                viewHolder.unReadMsgCount.setVisibility(8);
            }
            viewHolder.leftImageLayout.setVisibility(8);
        } else {
            if (conversationProviderTag.portraitPosition() != 3) {
                throw new IllegalArgumentException("the portrait position is wrong!");
            }
            viewHolder.rightImageLayout.setVisibility(8);
            viewHolder.leftImageLayout.setVisibility(8);
        }
        MessageContent messageContent = uIConversation.getMessageContent();
        if (messageContent == null || !messageContent.isDestruct()) {
            return;
        }
        RongIMClient.getInstance().getMessage(uIConversation.getLatestMessageId(), new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.widget.adapter.ConversationListAdapter.5
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Message message) {
                if (message == null) {
                    EventBus.getDefault().post(new Event.MessageDeleteEvent(uIConversation.getLatestMessageId()));
                }
            }
        });
    }
}
