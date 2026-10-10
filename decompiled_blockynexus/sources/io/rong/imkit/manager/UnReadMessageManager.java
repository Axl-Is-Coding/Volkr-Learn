package io.rong.imkit.manager;

import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.model.Event;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class UnReadMessageManager {
    private static final String TAG = "UnReadMessageManager";
    private int left;
    private final List<MultiConversationUnreadMsgInfo> mMultiConversationUnreadInfos;

    private class MultiConversationUnreadMsgInfo {
        Conversation.ConversationType[] conversationTypes;
        int count;
        IUnReadMessageObserver observer;

        private MultiConversationUnreadMsgInfo() {
        }
    }

    private static class SingletonHolder {
        static UnReadMessageManager sInstance = new UnReadMessageManager();

        private SingletonHolder() {
        }
    }

    public static UnReadMessageManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private void syncUnreadCount(Message message, int i) {
        for (final MultiConversationUnreadMsgInfo multiConversationUnreadMsgInfo : this.mMultiConversationUnreadInfos) {
            if (i == 0 || this.left == 0) {
                RongIMClient.getInstance().getUnreadCount(multiConversationUnreadMsgInfo.conversationTypes, new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.manager.UnReadMessageManager.1
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(RongIMClient.ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(Integer num) {
                        RLog.d(UnReadMessageManager.TAG, "get result: " + num);
                        multiConversationUnreadMsgInfo.count = num.intValue();
                        multiConversationUnreadMsgInfo.observer.onCountChanged(num.intValue());
                    }
                });
            }
        }
    }

    public void addObserver(Conversation.ConversationType[] conversationTypeArr, IUnReadMessageObserver iUnReadMessageObserver) {
        synchronized (this.mMultiConversationUnreadInfos) {
            final MultiConversationUnreadMsgInfo multiConversationUnreadMsgInfo = new MultiConversationUnreadMsgInfo();
            multiConversationUnreadMsgInfo.conversationTypes = conversationTypeArr;
            multiConversationUnreadMsgInfo.observer = iUnReadMessageObserver;
            this.mMultiConversationUnreadInfos.add(multiConversationUnreadMsgInfo);
            RongIMClient.getInstance().getUnreadCount(conversationTypeArr, new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.manager.UnReadMessageManager.4
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Integer num) {
                    multiConversationUnreadMsgInfo.count = num.intValue();
                    multiConversationUnreadMsgInfo.observer.onCountChanged(num.intValue());
                }
            });
        }
    }

    public void clearObserver() {
        synchronized (this.mMultiConversationUnreadInfos) {
            this.mMultiConversationUnreadInfos.clear();
        }
    }

    public void onEventMainThread(Event.OnReceiveMessageEvent onReceiveMessageEvent) {
        this.left = onReceiveMessageEvent.getLeft();
        if (onReceiveMessageEvent.getLeft() == 0) {
            syncUnreadCount(onReceiveMessageEvent.getMessage(), onReceiveMessageEvent.getLeft());
        }
    }

    public void onMessageReceivedStatusChanged() {
        syncUnreadCount(null, 0);
    }

    public void removeObserver(IUnReadMessageObserver iUnReadMessageObserver) {
        synchronized (this.mMultiConversationUnreadInfos) {
            MultiConversationUnreadMsgInfo multiConversationUnreadMsgInfo = null;
            Iterator<MultiConversationUnreadMsgInfo> it = this.mMultiConversationUnreadInfos.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MultiConversationUnreadMsgInfo next = it.next();
                if (next.observer == iUnReadMessageObserver) {
                    multiConversationUnreadMsgInfo = next;
                    break;
                }
            }
            if (multiConversationUnreadMsgInfo != null) {
                this.mMultiConversationUnreadInfos.remove(multiConversationUnreadMsgInfo);
            }
        }
    }

    private UnReadMessageManager() {
        this.mMultiConversationUnreadInfos = new ArrayList();
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(Event.MessageLeftEvent messageLeftEvent) {
        RLog.d(TAG, "MessageLeftEvent " + messageLeftEvent.left);
        syncUnreadCount(null, messageLeftEvent.left);
    }

    public void onEventMainThread(Event.ConnectEvent connectEvent) {
        syncUnreadCount(null, 0);
    }

    public void onEventMainThread(Event.ConversationRemoveEvent conversationRemoveEvent) {
        Conversation.ConversationType type = conversationRemoveEvent.getType();
        for (final MultiConversationUnreadMsgInfo multiConversationUnreadMsgInfo : this.mMultiConversationUnreadInfos) {
            Conversation.ConversationType[] conversationTypeArr = multiConversationUnreadMsgInfo.conversationTypes;
            int length = conversationTypeArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (conversationTypeArr[i].equals(type)) {
                    RongIMClient.getInstance().getUnreadCount(multiConversationUnreadMsgInfo.conversationTypes, new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.manager.UnReadMessageManager.2
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Integer num) {
                            multiConversationUnreadMsgInfo.count = num.intValue();
                            multiConversationUnreadMsgInfo.observer.onCountChanged(num.intValue());
                        }
                    });
                    break;
                }
                i++;
            }
        }
    }

    public void onEventMainThread(Message message) {
        syncUnreadCount(message, 0);
    }

    public void onEventMainThread(Event.ConversationUnreadEvent conversationUnreadEvent) {
        Conversation.ConversationType type = conversationUnreadEvent.getType();
        for (final MultiConversationUnreadMsgInfo multiConversationUnreadMsgInfo : this.mMultiConversationUnreadInfos) {
            Conversation.ConversationType[] conversationTypeArr = multiConversationUnreadMsgInfo.conversationTypes;
            int length = conversationTypeArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (conversationTypeArr[i].equals(type)) {
                    RongIMClient.getInstance().getUnreadCount(multiConversationUnreadMsgInfo.conversationTypes, new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.manager.UnReadMessageManager.3
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Integer num) {
                            multiConversationUnreadMsgInfo.count = num.intValue();
                            multiConversationUnreadMsgInfo.observer.onCountChanged(num.intValue());
                        }
                    });
                    break;
                }
                i++;
            }
        }
    }

    public void onEventMainThread(Event.SyncReadStatusEvent syncReadStatusEvent) {
        RLog.d(TAG, "SyncReadStatusEvent " + this.left);
        if (this.left == 0) {
            Conversation.ConversationType conversationType = syncReadStatusEvent.getConversationType();
            for (final MultiConversationUnreadMsgInfo multiConversationUnreadMsgInfo : this.mMultiConversationUnreadInfos) {
                Conversation.ConversationType[] conversationTypeArr = multiConversationUnreadMsgInfo.conversationTypes;
                int length = conversationTypeArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (conversationTypeArr[i].equals(conversationType)) {
                        RongIMClient.getInstance().getUnreadCount(multiConversationUnreadMsgInfo.conversationTypes, new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.manager.UnReadMessageManager.5
                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onError(RongIMClient.ErrorCode errorCode) {
                            }

                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onSuccess(Integer num) {
                                multiConversationUnreadMsgInfo.count = num.intValue();
                                multiConversationUnreadMsgInfo.observer.onCountChanged(num.intValue());
                            }
                        });
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public void onEventMainThread(Event.RemoteMessageRecallEvent remoteMessageRecallEvent) {
        RLog.d(TAG, "SyncReadStatusEvent " + this.left);
        if (this.left == 0) {
            Conversation.ConversationType conversationType = remoteMessageRecallEvent.getConversationType();
            for (final MultiConversationUnreadMsgInfo multiConversationUnreadMsgInfo : this.mMultiConversationUnreadInfos) {
                Conversation.ConversationType[] conversationTypeArr = multiConversationUnreadMsgInfo.conversationTypes;
                int length = conversationTypeArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (conversationTypeArr[i].equals(conversationType)) {
                        RongIMClient.getInstance().getUnreadCount(multiConversationUnreadMsgInfo.conversationTypes, new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.manager.UnReadMessageManager.6
                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onError(RongIMClient.ErrorCode errorCode) {
                            }

                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onSuccess(Integer num) {
                                multiConversationUnreadMsgInfo.count = num.intValue();
                                multiConversationUnreadMsgInfo.observer.onCountChanged(num.intValue());
                            }
                        });
                        break;
                    }
                    i++;
                }
            }
        }
    }
}
