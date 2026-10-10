package io.rong.imkit;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.Toast;
import io.rong.common.RLog;
import io.rong.imkit.manager.AudioPlayManager;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imkit.widget.provider.MessageItemLongClickAction;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.location.message.RealTimeLocationStartMessage;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UnknownMessage;
import io.rong.imlib.model.UserInfo;
import io.rong.message.HandshakeMessage;
import io.rong.message.NotificationMessage;
import io.rong.message.PublicServiceMultiRichContentMessage;
import io.rong.message.PublicServiceRichContentMessage;
import io.rong.message.RecallNotificationMessage;
import io.rong.message.ReferenceMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RongMessageItemLongClickActionManager {
    private static final String TAG = "RongMessageItemLongClickActionManager";
    private OptionsPopupDialog mDialog;
    private Message mLongClickMessage;
    private List<MessageItemLongClickAction> messageItemLongClickActions;

    private static class Holder {
        static RongMessageItemLongClickActionManager instance = new RongMessageItemLongClickActionManager();

        private Holder() {
        }
    }

    public static RongMessageItemLongClickActionManager getInstance() {
        return Holder.instance;
    }

    private String getPushContent(Context context, UIMessage uIMessage) {
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(uIMessage.getSenderUserId());
        return context.getString(R.string.rc_user_recalled_message, userInfo != null ? userInfo.getName() : "");
    }

    private void initCommonMessageItemLongClickActions() {
        addMessageItemLongClickAction(new MessageItemLongClickAction.Builder().titleResId(R.string.rc_dialog_item_message_copy).actionListener(new MessageItemLongClickAction.MessageItemLongClickListener() { // from class: io.rong.imkit.RongMessageItemLongClickActionManager.3
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.MessageItemLongClickListener
            public boolean onMessageItemLongClick(Context context, UIMessage uIMessage) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                if (uIMessage.getContent() instanceof RecallNotificationMessage) {
                    return false;
                }
                if (uIMessage.getContent() instanceof TextMessage) {
                    if (clipboardManager == null) {
                        return true;
                    }
                    clipboardManager.setText(((TextMessage) uIMessage.getContent()).getContent());
                    return true;
                }
                if (!(uIMessage.getContent() instanceof ReferenceMessage)) {
                    return true;
                }
                ReferenceMessage referenceMessage = (ReferenceMessage) uIMessage.getContent();
                if (referenceMessage == null) {
                    return false;
                }
                if (clipboardManager == null) {
                    return true;
                }
                clipboardManager.setText(referenceMessage.getEditSendText());
                return true;
            }
        }).showFilter(new MessageItemLongClickAction.Filter() { // from class: io.rong.imkit.RongMessageItemLongClickActionManager.2
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.Filter
            public boolean filter(UIMessage uIMessage) {
                return ((!(uIMessage.getContent() instanceof TextMessage) && !(uIMessage.getContent() instanceof ReferenceMessage)) || uIMessage.getConversationType().equals(Conversation.ConversationType.ENCRYPTED) || uIMessage.getContent().isDestruct()) ? false : true;
            }
        }).build());
        addMessageItemLongClickAction(new MessageItemLongClickAction.Builder().titleResId(R.string.rc_dialog_item_message_delete).actionListener(new MessageItemLongClickAction.MessageItemLongClickListener() { // from class: io.rong.imkit.RongMessageItemLongClickActionManager.4
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.MessageItemLongClickListener
            public boolean onMessageItemLongClick(Context context, UIMessage uIMessage) {
                if (uIMessage.getMessage().getContent() instanceof VoiceMessage) {
                    Uri uri = ((VoiceMessage) uIMessage.getMessage().getContent()).getUri();
                    Uri playingUri = AudioPlayManager.getInstance().getPlayingUri();
                    if (playingUri != null && playingUri == uri) {
                        AudioPlayManager.getInstance().stopPlay();
                    }
                }
                RongIM.getInstance().deleteMessages(new int[]{uIMessage.getMessageId()}, null);
                return true;
            }
        }).build());
        addMessageItemLongClickAction(new MessageItemLongClickAction.Builder().titleResId(R.string.rc_dialog_item_message_recall).actionListener(new MessageItemLongClickAction.MessageItemLongClickListener() { // from class: io.rong.imkit.RongMessageItemLongClickActionManager.6
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.MessageItemLongClickListener
            public boolean onMessageItemLongClick(Context context, UIMessage uIMessage) {
                if (RongIM.getInstance().getCurrentConnectionStatus() == RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE) {
                    Toast.makeText(context, context.getResources().getString(R.string.rc_recall_failed_for_network_unavailable), 0).show();
                    return true;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - RongIM.getInstance().getDeltaTime();
                int integer = -1;
                try {
                    integer = context.getResources().getInteger(R.integer.rc_message_recall_interval);
                } catch (Resources.NotFoundException e2) {
                    RLog.e(RongMessageItemLongClickActionManager.TAG, "rc_message_recall_interval not configure in rc_config.xml");
                    e2.printStackTrace();
                }
                if (jCurrentTimeMillis - uIMessage.getSentTime() <= ((long) (integer * 1000))) {
                    RongIM.getInstance().recallMessage(uIMessage.getMessage(), null);
                } else {
                    new AlertDialog.Builder(context).setMessage(R.string.rc_recall_overtime).setPositiveButton(R.string.rc_confirm, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
                    RLog.e(RongMessageItemLongClickActionManager.TAG, "撤回消息失败");
                }
                return true;
            }
        }).showFilter(new MessageItemLongClickAction.Filter() { // from class: io.rong.imkit.RongMessageItemLongClickActionManager.5
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.Filter
            public boolean filter(UIMessage uIMessage) {
                boolean z;
                if ((uIMessage.getContent() instanceof NotificationMessage) || (uIMessage.getContent() instanceof HandshakeMessage) || (uIMessage.getContent() instanceof PublicServiceRichContentMessage) || (uIMessage.getContent() instanceof RealTimeLocationStartMessage) || (uIMessage.getContent() instanceof UnknownMessage) || (uIMessage.getContent() instanceof PublicServiceMultiRichContentMessage) || uIMessage.getSentStatus().equals(Message.SentStatus.CANCELED) || uIMessage.getConversationType().equals(Conversation.ConversationType.ENCRYPTED)) {
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - RongIM.getInstance().getDeltaTime();
                int integer = -1;
                boolean z2 = (uIMessage.getSentStatus().equals(Message.SentStatus.SENDING) || uIMessage.getSentStatus().equals(Message.SentStatus.FAILED)) ? false : true;
                try {
                    z = RongIM.getInstance().getApplicationContext().getResources().getBoolean(R.bool.rc_enable_message_recall);
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                }
                try {
                    integer = RongIM.getInstance().getApplicationContext().getResources().getInteger(R.integer.rc_message_recall_interval);
                } catch (Exception e3) {
                    e = e3;
                    RLog.e(RongMessageItemLongClickActionManager.TAG, "rc_message_recall_interval not configure in rc_config.xml");
                    e.printStackTrace();
                }
                return (!z2 || !z || jCurrentTimeMillis - uIMessage.getSentTime() > ((long) (integer * 1000)) || !uIMessage.getSenderUserId().equals(RongIM.getInstance().getCurrentUserId()) || uIMessage.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) || uIMessage.getConversationType().equals(Conversation.ConversationType.APP_PUBLIC_SERVICE) || uIMessage.getConversationType().equals(Conversation.ConversationType.PUBLIC_SERVICE) || uIMessage.getConversationType().equals(Conversation.ConversationType.SYSTEM) || uIMessage.getConversationType().equals(Conversation.ConversationType.CHATROOM)) ? false : true;
            }
        }).build());
    }

    public void addMessageItemLongClickAction(MessageItemLongClickAction messageItemLongClickAction) {
        addMessageItemLongClickAction(messageItemLongClickAction, -1);
    }

    public OptionsPopupDialog getLongClickDialog() {
        return this.mDialog;
    }

    public Message getLongClickMessage() {
        return this.mLongClickMessage;
    }

    public List<MessageItemLongClickAction> getMessageItemLongClickActions() {
        return this.messageItemLongClickActions;
    }

    public void init() {
        if (this.messageItemLongClickActions.size() == 0) {
            initCommonMessageItemLongClickActions();
        }
    }

    public void removeMessageItemLongClickAction(MessageItemLongClickAction messageItemLongClickAction) {
        this.messageItemLongClickActions.remove(messageItemLongClickAction);
    }

    public void setLongClickDialog(OptionsPopupDialog optionsPopupDialog) {
        this.mDialog = optionsPopupDialog;
    }

    public void setLongClickMessage(Message message) {
        this.mLongClickMessage = message;
    }

    private RongMessageItemLongClickActionManager() {
        this.messageItemLongClickActions = new ArrayList();
    }

    public void addMessageItemLongClickAction(MessageItemLongClickAction messageItemLongClickAction, int i) {
        if (this.messageItemLongClickActions.contains(messageItemLongClickAction)) {
            this.messageItemLongClickActions.remove(messageItemLongClickAction);
        }
        if (i < 0) {
            this.messageItemLongClickActions.add(messageItemLongClickAction);
        } else {
            this.messageItemLongClickActions.add(i, messageItemLongClickAction);
        }
    }

    public List<MessageItemLongClickAction> getMessageItemLongClickActions(UIMessage uIMessage) {
        ArrayList arrayList = new ArrayList();
        for (MessageItemLongClickAction messageItemLongClickAction : this.messageItemLongClickActions) {
            if (messageItemLongClickAction.filter(uIMessage)) {
                arrayList.add(messageItemLongClickAction);
            }
        }
        Collections.sort(arrayList, new Comparator<MessageItemLongClickAction>() { // from class: io.rong.imkit.RongMessageItemLongClickActionManager.1
            @Override // java.util.Comparator
            public int compare(MessageItemLongClickAction messageItemLongClickAction2, MessageItemLongClickAction messageItemLongClickAction3) {
                int i = messageItemLongClickAction2.priority;
                int i2 = messageItemLongClickAction3.priority;
                if (i > i2) {
                    return 1;
                }
                return i == i2 ? 0 : -1;
            }
        });
        return arrayList;
    }
}
