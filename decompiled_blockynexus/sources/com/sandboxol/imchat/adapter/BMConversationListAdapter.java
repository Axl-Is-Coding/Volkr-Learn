package com.sandboxol.imchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.widget.NineGirdImageView;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.ProviderContainerView;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imlib.model.Conversation;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public class BMConversationListAdapter extends ConversationListAdapter {
    NineGridImageViewAdapter<String> adapter;
    LayoutInflater mInflater;

    protected class ViewHolder extends ConversationListAdapter.ViewHolder {
        public ImageView ivGroup;
        public NineGirdImageView<String> ivNineGird;
        public LinearLayout subLoadingView;

        protected ViewHolder() {
            super();
        }
    }

    public BMConversationListAdapter(Context context, NineGridImageViewAdapter nineGridImageViewAdapter) {
        super(context);
        this.mInflater = LayoutInflater.from(context);
        this.adapter = nineGridImageViewAdapter;
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void addCollection(Collection<UIConversation> collection) {
        super.addCollection(collection);
        notifyDataSetChanged();
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void clear() {
        super.clear();
        notifyDataSetChanged();
    }

    @Override // io.rong.imkit.widget.adapter.ConversationListAdapter, io.rong.imkit.widget.adapter.BaseAdapter
    protected View newView(Context context, int i, ViewGroup viewGroup) {
        View viewInflate = this.mInflater.inflate(R.layout.bm_item_conversation, (ViewGroup) null);
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
        viewHolder.ivGroup = (ImageView) findViewById(viewInflate, R.id.ivGroup);
        viewHolder.ivNineGird = (NineGirdImageView) findViewById(viewInflate, R.id.ivNineGird);
        viewHolder.ivNineGird.setAdapter(this.adapter);
        viewHolder.subLoadingView = (LinearLayout) findViewById(viewInflate, R.id.sub_loading);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void remove(int i) {
        super.remove(i);
        notifyDataSetChanged();
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void removeAll() {
        super.removeAll();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.rong.imkit.widget.adapter.ConversationListAdapter, io.rong.imkit.widget.adapter.BaseAdapter
    public void bindView(View view, int i, UIConversation uIConversation) {
        if (uIConversation != null && !uIConversation.getUIConversationTitle().equals("sub_loading_item")) {
            super.bindView(view, i, uIConversation);
        }
        if (uIConversation == null) {
            return;
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (uIConversation.getUIConversationTitle().equals("sub_loading_item")) {
            viewHolder.subLoadingView.setVisibility(0);
            return;
        }
        if (viewHolder.subLoadingView.getVisibility() == 0) {
            viewHolder.subLoadingView.setVisibility(8);
        }
        if (uIConversation.getNotificationStatus().equals(Conversation.ConversationNotificationStatus.NOTIFY)) {
            uIConversation.setUnreadType(UIConversation.UnreadRemindType.REMIND_WITH_COUNTING);
        } else {
            uIConversation.setUnreadType(UIConversation.UnreadRemindType.REMIND_ONLY);
        }
        viewHolder.ivGroup.setVisibility(8);
        boolean z = uIConversation.getConversationType() == Conversation.ConversationType.GROUP && GroupUtilsProxy.getInstance().isGroup(Long.valueOf(uIConversation.getConversationTargetId()).longValue());
        if (z) {
            viewHolder.ivGroup.setVisibility(GroupUtilsProxy.getInstance().isOfficial(Long.valueOf(uIConversation.getConversationTargetId()).longValue()) ? 0 : 8);
        }
        viewHolder.ivNineGird.setVisibility(z ? 0 : 8);
        viewHolder.ivNineGird.setImagesData(GroupUtilsProxy.getInstance().getUrls(Long.valueOf(uIConversation.getConversationTargetId()).longValue()));
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void add(UIConversation uIConversation) {
        super.add(uIConversation);
        notifyDataSetChanged();
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void add(UIConversation uIConversation, int i) {
        super.add(uIConversation, i);
        notifyDataSetChanged();
    }
}
