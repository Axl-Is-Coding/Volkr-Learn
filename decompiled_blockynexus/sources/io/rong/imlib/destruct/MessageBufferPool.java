package io.rong.imlib.destruct;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.MD5;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.DestructionCmdMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class MessageBufferPool {
    private static final String RETRY_MESSAGES = "retry_messages_%s";
    private static final String SPLIT = "'''";
    private static Context mContext;
    private static MessageBufferPool sInstance = new MessageBufferPool();
    private Handler mHandler;
    private final Map<String, Message> mMessageList = new HashMap();
    private ExecutorService mSingleThreadPoolExecutor = Executors.newSingleThreadExecutor();
    private volatile boolean isActive = false;
    private Runnable mSendMessageTask = new Runnable() { // from class: io.rong.imlib.destruct.MessageBufferPool.4
        @Override // java.lang.Runnable
        public void run() {
            synchronized (MessageBufferPool.this.mMessageList) {
                Iterator it = MessageBufferPool.this.mMessageList.entrySet().iterator();
                while (it.hasNext()) {
                    MessageBufferPool.this.sendMessage((Message) ((Map.Entry) it.next()).getValue());
                }
                MessageBufferPool.this.mMessageList.clear();
                MessageBufferPool.this.isActive = false;
            }
        }
    };

    private MessageBufferPool() {
        HandlerThread handlerThread = new HandlerThread("message-buffer-pool");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheFailedMessage(final Message message) {
        this.mSingleThreadPoolExecutor.execute(new Runnable() { // from class: io.rong.imlib.destruct.MessageBufferPool.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences sharedPreferences = MessageBufferPool.mContext.getSharedPreferences(String.format(MessageBufferPool.RETRY_MESSAGES, MD5.encrypt(RongIMClient.getInstance().getCurrentUserId())), 0);
                String str = message.getTargetId() + MessageBufferPool.SPLIT + message.getConversationType().getValue();
                String string = sharedPreferences.getString(str, null);
                if (string == null) {
                    string = "";
                }
                StringBuilder sb = new StringBuilder(string);
                List<String> burnMessageUIds = ((DestructionCmdMessage) message.getContent()).getBurnMessageUIds();
                for (int i = 0; i < burnMessageUIds.size(); i++) {
                    sb.append(MessageBufferPool.SPLIT);
                    sb.append(burnMessageUIds.get(i));
                }
                sharedPreferences.edit().putString(str, sb.toString()).commit();
            }
        });
    }

    private List<Message> getAndClearFailedMessages() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(String.format(RETRY_MESSAGES, MD5.encrypt(RongIMClient.getInstance().getCurrentUserId())), 0);
        Map<String, ?> all = sharedPreferences.getAll();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String[] strArrSplit = entry.getKey().split(SPLIT);
            String str = strArrSplit[0];
            Conversation.ConversationType value = Conversation.ConversationType.setValue(Integer.valueOf(strArrSplit[1]).intValue());
            DestructionCmdMessage destructionCmdMessage = new DestructionCmdMessage();
            destructionCmdMessage.setBurnMessageUIds(new ArrayList(Arrays.asList(((String) entry.getValue()).replaceFirst(SPLIT, "").split(SPLIT))));
            arrayList.add(Message.obtain(str, value, destructionCmdMessage));
        }
        sharedPreferences.edit().clear().commit();
        return arrayList;
    }

    public static MessageBufferPool getInstance() {
        return sInstance;
    }

    public static void init(Context context) {
        mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(Message message) {
        RongIMClient.getInstance().sendMessage(message, null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.destruct.MessageBufferPool.3
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message2) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                if (errorCode == RongIMClient.ErrorCode.MSG_SEND_OVERFREQUENCY) {
                    MessageBufferPool.this.putMessageInBuffer(message2);
                } else {
                    MessageBufferPool.this.cacheFailedMessage(message2);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message2) {
            }
        });
    }

    public void putMessageInBuffer(final Message message) {
        if (message.getContent() instanceof DestructionCmdMessage) {
            this.mSingleThreadPoolExecutor.execute(new Runnable() { // from class: io.rong.imlib.destruct.MessageBufferPool.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (MessageBufferPool.this.mMessageList) {
                        Message message2 = (Message) MessageBufferPool.this.mMessageList.get(message.getTargetId());
                        if (message2 != null) {
                            ((DestructionCmdMessage) message2.getContent()).getBurnMessageUIds().addAll(((DestructionCmdMessage) message.getContent()).getBurnMessageUIds());
                        } else {
                            MessageBufferPool.this.mMessageList.put(message.getTargetId(), message);
                        }
                    }
                    if (MessageBufferPool.this.isActive) {
                        return;
                    }
                    MessageBufferPool.this.isActive = true;
                    MessageBufferPool.this.mHandler.postDelayed(MessageBufferPool.this.mSendMessageTask, 500L);
                }
            });
        }
    }

    public void retrySendMessages() {
        Iterator<Message> it = getAndClearFailedMessages().iterator();
        while (it.hasNext()) {
            putMessageInBuffer(it.next());
        }
    }
}
