package com.sandboxol.imchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.imchat.R;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.ProviderContainerView;
import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.RecallNotificationMessage;

/* JADX INFO: loaded from: classes4.dex */
public class ConversationAdapterEX extends MessageListAdapter {
    private Context context;
    LayoutInflater mInflater;

    protected class ViewHolder extends MessageListAdapter.ViewHolder {
        public TextView tvIdentity;

        protected ViewHolder() {
            super();
        }
    }

    public ConversationAdapterEX(Context context) {
        super(context);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    private String judgeIdentity(long j, long j2) {
        return GroupUtilsProxy.getInstance().judgeOwner(j, j2) ? BaseApplication.getContext().getString(R.string.group_owner_text) : GroupUtilsProxy.getInstance().judgeAdmin(j, j2) ? BaseApplication.getContext().getString(R.string.group_admin_text) : "";
    }

    @Override // io.rong.imkit.widget.adapter.MessageListAdapter, io.rong.imkit.widget.adapter.BaseAdapter
    protected View newView(Context context, int i, ViewGroup viewGroup) {
        View viewInflate = this.mInflater.inflate(R.layout.bm_item_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.leftIconView = (AsyncImageView) findViewById(viewInflate, R.id.rc_left);
        viewHolder.rightIconView = (AsyncImageView) findViewById(viewInflate, R.id.rc_right);
        viewHolder.nameView = (TextView) findViewById(viewInflate, R.id.rc_title);
        viewHolder.contentView = (ProviderContainerView) findViewById(viewInflate, R.id.rc_content);
        viewHolder.layout = (ViewGroup) findViewById(viewInflate, R.id.rc_layout);
        viewHolder.progressBar = (ProgressBar) findViewById(viewInflate, R.id.rc_progress);
        viewHolder.warning = (ImageView) findViewById(viewInflate, R.id.rc_warning);
        viewHolder.readReceipt = (TextView) findViewById(viewInflate, R.id.rc_read_receipt);
        viewHolder.readReceiptRequest = (TextView) findViewById(viewInflate, R.id.rc_read_receipt_request);
        viewHolder.readReceiptStatus = (TextView) findViewById(viewInflate, R.id.rc_read_receipt_status);
        viewHolder.message_check = (CheckBox) findViewById(viewInflate, R.id.message_check);
        viewHolder.checkboxLayout = (LinearLayout) findViewById(viewInflate, R.id.ll_message_check);
        viewHolder.time = (TextView) findViewById(viewInflate, R.id.rc_time);
        viewHolder.sentStatus = (TextView) findViewById(viewInflate, R.id.rc_sent_status);
        viewHolder.layoutItem = (RelativeLayout) findViewById(viewInflate, R.id.rc_layout_item_message);
        viewHolder.tvIdentity = (TextView) findViewById(viewInflate, R.id.rc_identity);
        viewHolder.tvIdentity.setVisibility(8);
        if (viewHolder.time.getVisibility() == 8) {
            this.timeGone = true;
        } else {
            this.timeGone = false;
        }
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.rong.imkit.widget.adapter.MessageListAdapter, io.rong.imkit.widget.adapter.BaseAdapter
    public void bindView(View view, int i, UIMessage uIMessage) {
        super.bindView(view, i, uIMessage);
        if (uIMessage == null) {
            return;
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.tvIdentity.setVisibility(8);
        if (uIMessage.getConversationType() == Conversation.ConversationType.GROUP && GroupUtilsProxy.getInstance().isGroup(Long.valueOf(uIMessage.getTargetId()).longValue()) && uIMessage.getMessageDirection() == Message.MessageDirection.RECEIVE && !(uIMessage.getContent() instanceof RecallNotificationMessage)) {
            String strJudgeIdentity = judgeIdentity(Long.valueOf(uIMessage.getTargetId()).longValue(), Long.valueOf(uIMessage.getSenderUserId()).longValue());
            viewHolder.tvIdentity.setText(strJudgeIdentity);
            if (strJudgeIdentity.equals(BaseApplication.getContext().getString(R.string.group_owner_text))) {
                viewHolder.tvIdentity.setBackground(this.context.getResources().getDrawable(R.drawable.bg_group_identiy_owner));
            } else {
                viewHolder.tvIdentity.setBackground(this.context.getResources().getDrawable(R.drawable.bg_group_identity_admin));
            }
            if (strJudgeIdentity.equals("")) {
                viewHolder.tvIdentity.setVisibility(8);
            } else {
                viewHolder.tvIdentity.setVisibility(0);
            }
        }
    }
}
