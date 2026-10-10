package io.rong.imlib.typingmessage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import io.rong.common.RLog;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.MessageTag;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class TypingMessageManager {
    private static int DISAPPEAR_INTERVAL = 6000;
    private static final String SEPARATOR = ";;;";
    private static final String TAG = "TypingMessageManager";
    private boolean isShowMessageTyping;
    private Handler mHandler;
    private HashMap<String, Long> mSendingConversation;
    private HashMap<String, LinkedHashMap<String, TypingStatus>> mTypingMap;
    private RongIMClient.TypingStatusListener sTypingStatusListener;

    private static class SingletonHolder {
        static TypingMessageManager sInstance = new TypingMessageManager();

        private SingletonHolder() {
        }
    }

    public static TypingMessageManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private void onReceiveOtherMessage(Message message) {
        MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
        if (messageTag == null || (messageTag.flag() & 1) != 1) {
            return;
        }
        Conversation.ConversationType conversationType = message.getConversationType();
        String targetId = message.getTargetId();
        String senderUserId = message.getSenderUserId();
        String str = conversationType.getName() + SEPARATOR + targetId;
        if (this.mTypingMap.containsKey(str)) {
            LinkedHashMap<String, TypingStatus> linkedHashMap = this.mTypingMap.get(str);
            if (linkedHashMap.get(senderUserId) != null) {
                linkedHashMap.remove(senderUserId);
                RongIMClient.TypingStatusListener typingStatusListener = this.sTypingStatusListener;
                if (typingStatusListener != null) {
                    typingStatusListener.onTypingStatusChanged(conversationType, targetId, linkedHashMap.values());
                }
                if (linkedHashMap.isEmpty()) {
                    this.mTypingMap.remove(str);
                }
            }
        }
    }

    private void onReceiveTypingMessage(Message message) {
        if (message.getSenderUserId().equals(RongIMClient.getInstance().getCurrentUserId())) {
            return;
        }
        final Conversation.ConversationType conversationType = message.getConversationType();
        final String targetId = message.getTargetId();
        String typingContentType = ((TypingStatusMessage) message.getContent()).getTypingContentType();
        if (typingContentType == null) {
            return;
        }
        final String senderUserId = message.getSenderUserId();
        final String str = conversationType.getName() + SEPARATOR + targetId;
        if (!this.mTypingMap.containsKey(str)) {
            LinkedHashMap<String, TypingStatus> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(senderUserId, new TypingStatus(senderUserId, typingContentType, message.getSentTime()));
            RongIMClient.TypingStatusListener typingStatusListener = this.sTypingStatusListener;
            if (typingStatusListener != null) {
                typingStatusListener.onTypingStatusChanged(conversationType, targetId, linkedHashMap.values());
            }
            this.mTypingMap.put(str, linkedHashMap);
            this.mHandler.postDelayed(new Runnable() { // from class: io.rong.imlib.typingmessage.TypingMessageManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TypingMessageManager.this.mTypingMap.containsKey(str)) {
                        LinkedHashMap linkedHashMap2 = (LinkedHashMap) TypingMessageManager.this.mTypingMap.get(str);
                        if (linkedHashMap2.get(senderUserId) != null) {
                            linkedHashMap2.remove(senderUserId);
                            if (TypingMessageManager.this.sTypingStatusListener != null) {
                                TypingMessageManager.this.sTypingStatusListener.onTypingStatusChanged(conversationType, targetId, linkedHashMap2.values());
                            }
                            if (linkedHashMap2.isEmpty()) {
                                TypingMessageManager.this.mTypingMap.remove(str);
                            }
                        }
                    }
                }
            }, DISAPPEAR_INTERVAL);
            return;
        }
        LinkedHashMap<String, TypingStatus> linkedHashMap2 = this.mTypingMap.get(str);
        if (linkedHashMap2 == null || linkedHashMap2.get(senderUserId) != null) {
            return;
        }
        linkedHashMap2.put(senderUserId, new TypingStatus(senderUserId, typingContentType, message.getSentTime()));
        RongIMClient.TypingStatusListener typingStatusListener2 = this.sTypingStatusListener;
        if (typingStatusListener2 != null) {
            typingStatusListener2.onTypingStatusChanged(conversationType, targetId, linkedHashMap2.values());
        }
    }

    public Collection<TypingStatus> getTypingUserListFromConversation(Conversation.ConversationType conversationType, String str) {
        String str2 = conversationType.getName() + SEPARATOR + str;
        if (this.mTypingMap.get(str2) == null) {
            return null;
        }
        return this.mTypingMap.get(str2).values();
    }

    public void init(Context context) {
        try {
            Resources resources = context.getResources();
            this.isShowMessageTyping = resources.getBoolean(resources.getIdentifier("rc_typing_status", "bool", context.getPackageName()));
        } catch (Resources.NotFoundException e2) {
            RLog.e(TAG, "getTypingStatus rc_typing_status not configure in rc_configuration.xml");
            e2.printStackTrace();
        }
    }

    public boolean isShowMessageTyping() {
        return this.isShowMessageTyping;
    }

    public boolean onReceiveMessage(Message message) {
        if ((message.getContent() instanceof TypingStatusMessage) && this.isShowMessageTyping) {
            getInstance().onReceiveTypingMessage(message);
            return true;
        }
        getInstance().onReceiveOtherMessage(message);
        return false;
    }

    public void sendTypingMessage(Conversation.ConversationType conversationType, String str, String str2) {
        if (conversationType == null) {
            RLog.e(TAG, "sendTypingMessage conversationType should not be null!");
            return;
        }
        final String str3 = conversationType.getName() + SEPARATOR + str;
        if (conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            if (this.mSendingConversation.containsKey(str3)) {
                RLog.d(TAG, "sendTypingStatus typing message in this conversation is sending");
                return;
            }
            TypingStatusMessage typingStatusMessage = new TypingStatusMessage(str2, null);
            this.mSendingConversation.put(str3, 0L);
            RongIMClient.getInstance().sendMessage(conversationType, str, typingStatusMessage, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.typingmessage.TypingMessageManager.1
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message) {
                    TypingMessageManager.this.mHandler.postDelayed(new Runnable() { // from class: io.rong.imlib.typingmessage.TypingMessageManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TypingMessageManager.this.mSendingConversation.remove(str3);
                        }
                    }, TypingMessageManager.DISAPPEAR_INTERVAL);
                }
            });
        }
    }

    public void setTypingEnd(Conversation.ConversationType conversationType, String str) {
        String str2 = conversationType.getName() + SEPARATOR + str;
        if (conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            this.mSendingConversation.remove(str2);
        }
    }

    public void setTypingMessageStatusListener(RongIMClient.TypingStatusListener typingStatusListener) {
        this.sTypingStatusListener = typingStatusListener;
    }

    private TypingMessageManager() {
        this.isShowMessageTyping = false;
        this.mTypingMap = new HashMap<>();
        this.mSendingConversation = new HashMap<>();
        this.mHandler = new Handler(Looper.getMainLooper());
    }
}
