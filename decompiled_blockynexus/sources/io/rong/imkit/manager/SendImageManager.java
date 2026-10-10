package io.rong.imkit.manager;

import android.net.Uri;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.message.GIFMessage;
import io.rong.message.ImageMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class SendImageManager {
    private static final String TAG = "SendImageManager";
    private ExecutorService executorService;
    private UploadController uploadController;

    static class SingletonHolder {
        static SendImageManager sInstance = new SendImageManager();

        SingletonHolder() {
        }
    }

    private ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory());
        }
        return this.executorService;
    }

    public static SendImageManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private ThreadFactory threadFactory() {
        return new ThreadFactory() { // from class: io.rong.imkit.manager.SendImageManager.3
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "Rong SendMediaManager");
                thread.setDaemon(false);
                return thread;
            }
        };
    }

    public void cancelSendingImage(Conversation.ConversationType conversationType, String str, int i) {
        UploadController uploadController;
        RLog.d(TAG, "cancelSendingImages");
        if (conversationType == null || str == null || (uploadController = this.uploadController) == null || i <= 0) {
            return;
        }
        uploadController.cancel(conversationType, str, i);
    }

    public void cancelSendingImages(Conversation.ConversationType conversationType, String str) {
        UploadController uploadController;
        RLog.d(TAG, "cancelSendingImages");
        if (conversationType == null || str == null || (uploadController = this.uploadController) == null) {
            return;
        }
        uploadController.cancel(conversationType, str);
    }

    public void reset() {
        this.uploadController.reset();
    }

    public void sendImages(Conversation.ConversationType conversationType, String str, List<Uri> list, boolean z) {
        sendImages(conversationType, str, list, z, false, 0L);
    }

    private SendImageManager() {
        this.executorService = getExecutorService();
        this.uploadController = new UploadController();
    }

    public void sendImages(Conversation.ConversationType conversationType, String str, List<Uri> list, boolean z, boolean z2, long j) {
        RLog.d(TAG, "sendImages " + list.size());
        for (Uri uri : list) {
            if (!TextUtils.isEmpty(uri.getPath()) && new File(uri.getPath()).exists() && uri.getPath() != null) {
                MessageContent messageContentObtain = uri.getPath().endsWith("gif") ? GIFMessage.obtain(uri) : ImageMessage.obtain(uri, uri, z);
                if (z2 && messageContentObtain != null) {
                    messageContentObtain.setDestructTime(j);
                }
                RongIM.OnSendMessageListener onSendMessageListener = RongContext.getInstance().getOnSendMessageListener();
                if (onSendMessageListener != null) {
                    Message messageOnSend = onSendMessageListener.onSend(Message.obtain(str, conversationType, messageContentObtain));
                    if (messageOnSend != null) {
                        RongIMClient.getInstance().insertOutgoingMessage(conversationType, str, null, messageOnSend.getContent(), new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.manager.SendImageManager.1
                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onError(RongIMClient.ErrorCode errorCode) {
                            }

                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onSuccess(Message message) {
                                message.setSentStatus(Message.SentStatus.SENDING);
                                RongIMClient.getInstance().setMessageSentStatus(message, null);
                                RongContext.getInstance().getEventBus().post(message);
                                SendImageManager.this.uploadController.execute(message);
                            }
                        });
                    }
                } else {
                    RongIMClient.getInstance().insertOutgoingMessage(conversationType, str, null, messageContentObtain, new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.manager.SendImageManager.2
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Message message) {
                            message.setSentStatus(Message.SentStatus.SENDING);
                            RongIMClient.getInstance().setMessageSentStatus(message, null);
                            RongContext.getInstance().getEventBus().post(message);
                            SendImageManager.this.uploadController.execute(message);
                        }
                    });
                }
            }
        }
    }

    private class UploadController implements Runnable {
        Message executingMessage;
        final List<Message> pendingMessages = new ArrayList();

        public UploadController() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void polling() {
            synchronized (this.pendingMessages) {
                RLog.d(SendImageManager.TAG, "polling " + this.pendingMessages.size());
                if (this.pendingMessages.size() > 0) {
                    this.executingMessage = this.pendingMessages.remove(0);
                    SendImageManager.this.executorService.submit(this);
                } else {
                    this.executingMessage = null;
                }
            }
        }

        public void cancel(Conversation.ConversationType conversationType, String str) {
            synchronized (this.pendingMessages) {
                Iterator<Message> it = this.pendingMessages.iterator();
                while (it.hasNext()) {
                    Message next = it.next();
                    if (next.getConversationType().equals(conversationType) && next.getTargetId().equals(str)) {
                        it.remove();
                    }
                }
                if (this.pendingMessages.size() == 0) {
                    this.executingMessage = null;
                }
            }
        }

        public void execute(Message message) {
            synchronized (this.pendingMessages) {
                this.pendingMessages.add(message);
                if (this.executingMessage == null) {
                    this.executingMessage = this.pendingMessages.remove(0);
                    SendImageManager.this.executorService.submit(this);
                }
            }
        }

        public void reset() {
            RLog.w(SendImageManager.TAG, "Rest Sending Images.");
            synchronized (this.pendingMessages) {
                for (Message message : this.pendingMessages) {
                    message.setSentStatus(Message.SentStatus.FAILED);
                    RongContext.getInstance().getEventBus().post(message);
                }
                this.pendingMessages.clear();
            }
            Message message2 = this.executingMessage;
            if (message2 != null) {
                message2.setSentStatus(Message.SentStatus.FAILED);
                RongContext.getInstance().getEventBus().post(this.executingMessage);
                this.executingMessage = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            RongIM.getInstance().sendImageMessage(this.executingMessage, this.executingMessage.getContent() != null ? this.executingMessage.getContent().isDestruct() : false ? RongIM.getInstance().getApplicationContext().getString(R.string.rc_message_content_burn) : null, null, false, new RongIMClient.SendImageMessageCallback() { // from class: io.rong.imkit.manager.SendImageManager.UploadController.1
                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onAttached(Message message) {
                }

                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                    UploadController.this.polling();
                }

                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onProgress(Message message, int i) {
                }

                @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                public void onSuccess(Message message) {
                    UploadController.this.polling();
                }
            });
        }

        public void cancel(Conversation.ConversationType conversationType, String str, int i) {
            synchronized (this.pendingMessages) {
                int size = this.pendingMessages.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Message message = this.pendingMessages.get(i2);
                    if (message.getConversationType().equals(conversationType) && message.getTargetId().equals(str) && message.getMessageId() == i) {
                        this.pendingMessages.remove(message);
                        break;
                    }
                    i2++;
                }
                if (this.pendingMessages.size() == 0) {
                    this.executingMessage = null;
                }
            }
        }
    }
}
