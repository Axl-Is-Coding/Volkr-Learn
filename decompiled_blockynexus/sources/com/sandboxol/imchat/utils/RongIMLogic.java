package com.sandboxol.imchat.utils;

import android.content.Context;
import android.view.View;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.entity.UserMessage;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.GIFMessage;
import io.rong.message.ImageMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;

/* JADX INFO: loaded from: classes4.dex */
public class RongIMLogic {

    /* JADX INFO: renamed from: com.sandboxol.imchat.utils.RongIMLogic$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$imlib$model$Conversation$ConversationType = new int[Conversation.ConversationType.values().length];

        static {
            try {
                $SwitchMap$io$rong$imlib$model$Conversation$ConversationType[Conversation.ConversationType.CHATROOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void initSendMessageListener(final Context context) {
        RongIM.getInstance().setSendMessageListener(new RongIM.OnSendMessageListener() { // from class: com.sandboxol.imchat.utils.RongIMLogic.1
            @Override // io.rong.imkit.RongIM.OnSendMessageListener
            public Message onSend(Message message) {
                String string;
                if (AnonymousClass3.$SwitchMap$io$rong$imlib$model$Conversation$ConversationType[message.getConversationType().ordinal()] == 1) {
                    ReportDataAdapter.onEvent(context, EventConstant.PARTY_CLICK_SEND);
                    if (message.getContent() instanceof TextMessage) {
                        String strEmojiChange = EmojiUtils.emojiChange(((TextMessage) message.getContent()).getContent(), "[Emoji]");
                        UserMessage userMessage = new UserMessage();
                        userMessage.setMessage(strEmojiChange);
                        userMessage.setUserId(String.valueOf(AccountCenter.newInstance().userId.get()));
                        userMessage.setSentTime(message.getSentTime() == 0 ? System.currentTimeMillis() : message.getSentTime());
                        Messenger.getDefault().send(userMessage, CommonMessageToken.SEND_RONG_MESSAGE);
                        ReportDataAdapter.onEvent(context, EventConstant.SEND_FREE_MES, strEmojiChange);
                    } else {
                        if (message.getContent() instanceof ImageMessage) {
                            string = context.getString(R.string.imchat_party_image);
                            ReportDataAdapter.onEvent(context, EventConstant.SEND_FREE_MES, "[Image]");
                        } else if (message.getContent() instanceof VoiceMessage) {
                            string = context.getString(R.string.imchat_party_voice);
                            ReportDataAdapter.onEvent(context, EventConstant.SEND_FREE_MES, "[Voice]");
                        } else {
                            if (!(message.getContent() instanceof GIFMessage)) {
                                ReportDataAdapter.onEvent(context, EventConstant.SEND_FREE_MES, "Other");
                                return message;
                            }
                            string = context.getString(R.string.imchat_party_gif);
                            ReportDataAdapter.onEvent(context, EventConstant.SEND_FREE_MES, "[GIF]");
                        }
                        UserMessage userMessage2 = new UserMessage();
                        userMessage2.setMessage(string);
                        userMessage2.setUserId(String.valueOf(AccountCenter.newInstance().userId.get()));
                        userMessage2.setSentTime(message.getSentTime() == 0 ? System.currentTimeMillis() : message.getSentTime());
                        Messenger.getDefault().send(userMessage2, CommonMessageToken.SEND_RONG_MESSAGE);
                    }
                }
                return message;
            }

            @Override // io.rong.imkit.RongIM.OnSendMessageListener
            public boolean onSent(Message message, RongIM.SentMessageErrorCode sentMessageErrorCode) {
                return false;
            }
        });
    }

    public static void initUserPortraitClick() {
        RongIM.setConversationClickListener(new RongIM.ConversationClickListener() { // from class: com.sandboxol.imchat.utils.RongIMLogic.2
            @Override // io.rong.imkit.RongIM.ConversationClickListener
            public boolean onMessageClick(Context context, View view, Message message) {
                return false;
            }

            @Override // io.rong.imkit.RongIM.ConversationClickListener
            public boolean onMessageLinkClick(Context context, String str, Message message) {
                return false;
            }

            @Override // io.rong.imkit.RongIM.ConversationClickListener
            public boolean onMessageLongClick(Context context, View view, Message message) {
                return false;
            }

            @Override // io.rong.imkit.RongIM.ConversationClickListener
            public boolean onUserPortraitClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo, String str) {
                if (userInfo == null) {
                    return true;
                }
                try {
                    if (userInfo.getUserId() != null && !"".equals(userInfo.getUserId()) && !"0".equals(userInfo.getUserId()) && !userInfo.getUserId().equals(String.valueOf(32L)) && !userInfo.getUserId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
                        long jValueOf = 0L;
                        try {
                            jValueOf = Long.valueOf(Long.parseLong(userInfo.getUserId()));
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                        Messenger.getDefault().send(jValueOf, ChatMessageToken.START_PARTY_FRIEND_INFO_DIALOG);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return true;
            }

            @Override // io.rong.imkit.RongIM.ConversationClickListener
            public boolean onUserPortraitLongClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo, String str) {
                return false;
            }
        });
    }
}
