package com.sandboxol.imchat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.entity.UserMessage;
import io.rong.imkit.RongIM;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QuickChatAdapter extends RecyclerView.a<ViewHolder> {
    public static int TYPE_QUICK_CHAT_LIST = 1;
    public static int TYPE_QUICK_CHAT_PAGE = 2;
    private Context context;
    private List<String> data;
    private String lastMessageText;
    private long lastMessageTime;
    private String targetId;
    private int type;

    public class ViewHolder extends RecyclerView.w {
        private TextView name;

        public ViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.tv_default_text);
        }
    }

    public QuickChatAdapter(Context context, String str, int i) {
        this.context = context;
        this.targetId = str;
        this.type = i;
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeListWay(String str) {
        this.data.remove(str);
        this.data.add(0, str);
        AppInfoCenter.newInstance().setQuickInText(this.data);
        AppSharedUtils.newInstance().putAllQuickInText(this.data);
    }

    private void initData() {
        this.data = new ArrayList();
        if (this.context == null) {
            return;
        }
        List<String> quickInText = AppInfoCenter.newInstance().getQuickInText();
        if (quickInText != null && quickInText.size() != 0) {
            this.data.addAll(quickInText);
            return;
        }
        List<String> allQuickInText = AppSharedUtils.newInstance().getAllQuickInText();
        if (allQuickInText != null && allQuickInText.size() != 0) {
            this.data.addAll(allQuickInText);
            AppInfoCenter.newInstance().setQuickInText(this.data);
            return;
        }
        this.data.add(this.context.getString(R.string.imchat_party_default_text_1));
        this.data.add(this.context.getString(R.string.imchat_party_default_text_2));
        this.data.add(this.context.getString(R.string.imchat_party_default_text_3));
        this.data.add(this.context.getString(R.string.imchat_party_default_text_4));
        this.data.add(this.context.getString(R.string.imchat_party_default_text_5));
        this.data.add(this.context.getString(R.string.imchat_party_default_text_6));
        this.data.add(this.context.getString(R.string.imchat_party_default_text_7));
        AppInfoCenter.newInstance().setQuickInText(this.data);
        AppSharedUtils.newInstance().putAllQuickInText(this.data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.data.size();
    }

    public void notifyChange(int i) {
        List<String> list = this.data;
        if (list != null && list.size() != 0) {
            changeListWay(this.data.get(i));
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        if (this.data == null) {
            return;
        }
        viewHolder.name.setText(this.data.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.adapter.QuickChatAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (System.currentTimeMillis() - QuickChatAdapter.this.lastMessageTime <= 3000) {
                    AppToastUtils.showShortNegativeTipToast(QuickChatAdapter.this.context, R.string.imchat_party_save_time);
                    return;
                }
                if (TextUtils.equals(QuickChatAdapter.this.lastMessageText, (CharSequence) QuickChatAdapter.this.data.get(i))) {
                    AppToastUtils.showShortNegativeTipToast(QuickChatAdapter.this.context, R.string.imchat_party_same_text);
                    return;
                }
                QuickChatAdapter.this.lastMessageTime = System.currentTimeMillis();
                QuickChatAdapter quickChatAdapter = QuickChatAdapter.this;
                quickChatAdapter.lastMessageText = (String) quickChatAdapter.data.get(i);
                Message messageObtain = Message.obtain(String.valueOf(QuickChatAdapter.this.targetId), Conversation.ConversationType.CHATROOM, TextMessage.obtain((String) QuickChatAdapter.this.data.get(i)));
                UserMessage userMessage = new UserMessage();
                userMessage.setMessage((String) QuickChatAdapter.this.data.get(i));
                userMessage.setUserId(String.valueOf(AccountCenter.newInstance().userId.get()));
                userMessage.setSentTime(System.currentTimeMillis());
                Messenger.getDefault().send(userMessage, CommonMessageToken.SEND_RONG_MESSAGE);
                ReportDataAdapter.onEvent(QuickChatAdapter.this.context, EventConstant.SEND_QUICK_MES, String.valueOf(i + 1));
                QuickChatAdapter quickChatAdapter2 = QuickChatAdapter.this;
                quickChatAdapter2.changeListWay((String) quickChatAdapter2.data.get(i));
                if (QuickChatAdapter.this.type == QuickChatAdapter.TYPE_QUICK_CHAT_LIST) {
                    QuickChatAdapter.this.notifyDataSetChanged();
                } else {
                    Messenger.getDefault().send(Integer.valueOf(i), MessageToken.REFRESH_QUICK_IN_TEXT);
                }
                RongIM.getInstance().sendMessage(messageObtain, null, null, new IRongCallback.ISendMessageCallback() { // from class: com.sandboxol.imchat.adapter.QuickChatAdapter.1.1
                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onAttached(Message message) {
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                    public void onSuccess(Message message) {
                    }
                });
                if (QuickChatAdapter.this.type == QuickChatAdapter.TYPE_QUICK_CHAT_PAGE) {
                    Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_CLOSE_PARTY_DIALOG);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.type == TYPE_QUICK_CHAT_LIST ? LayoutInflater.from(this.context).inflate(R.layout.item_party_list_default_text, viewGroup, false) : LayoutInflater.from(this.context).inflate(R.layout.item_party_default_text, viewGroup, false));
    }
}
