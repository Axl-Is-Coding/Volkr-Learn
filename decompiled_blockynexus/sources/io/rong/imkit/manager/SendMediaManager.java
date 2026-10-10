package io.rong.imkit.manager;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imkit.utilities.KitStorageUtils;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imkit.utilities.videocompressor.VideoCompress;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.SightMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class SendMediaManager {
    private static final String TAG = "SendMediaManager";
    private ExecutorService executorService;
    private UploadController uploadController;

    static class SingletonHolder {
        static SendMediaManager sInstance = new SendMediaManager();

        SingletonHolder() {
        }
    }

    private ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory());
        }
        return this.executorService;
    }

    public static SendMediaManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private ThreadFactory threadFactory() {
        return new ThreadFactory() { // from class: io.rong.imkit.manager.SendMediaManager.3
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "Rong SendMediaManager");
                thread.setDaemon(false);
                return thread;
            }
        };
    }

    public void cancelSendingMedia(Conversation.ConversationType conversationType, String str) {
        UploadController uploadController;
        RLog.d(TAG, "cancel Sending media");
        if (conversationType == null || str == null || (uploadController = this.uploadController) == null) {
            return;
        }
        uploadController.cancel(conversationType, str);
    }

    public void reset() {
        this.uploadController.reset();
    }

    public void sendMedia(Conversation.ConversationType conversationType, String str, List<Uri> list, boolean z) {
        sendMedia(conversationType, str, list, z, false, 0L);
    }

    private SendMediaManager() {
        this.executorService = getExecutorService();
        this.uploadController = new UploadController();
    }

    public void sendMedia(Conversation.ConversationType conversationType, String str, List<Uri> list, boolean z, boolean z2, long j) {
        RLog.d(TAG, "The size of media is " + list.size());
        if (RongIM.getInstance().getApplicationContext() == null) {
            return;
        }
        for (Uri uri : list) {
            if (!TextUtils.isEmpty(uri.toString()) && FileUtils.isFileExistsWithUri(RongIM.getInstance().getApplicationContext(), uri)) {
                SightMessage sightMessageObtain = SightMessage.obtain(uri, RongUtils.getVideoDuration(RongIM.getInstance().getApplicationContext(), uri.toString()) / 1000);
                if (z2) {
                    sightMessageObtain.setDestructTime(j);
                }
                RongIM.OnSendMessageListener onSendMessageListener = RongContext.getInstance().getOnSendMessageListener();
                if (onSendMessageListener != null) {
                    Message messageOnSend = onSendMessageListener.onSend(Message.obtain(str, conversationType, sightMessageObtain));
                    if (messageOnSend != null) {
                        RongIMClient.getInstance().insertOutgoingMessage(conversationType, str, null, messageOnSend.getContent(), new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.manager.SendMediaManager.1
                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onError(RongIMClient.ErrorCode errorCode) {
                            }

                            @Override // io.rong.imlib.RongIMClient.ResultCallback
                            public void onSuccess(Message message) {
                                message.setSentStatus(Message.SentStatus.SENDING);
                                RongIMClient.getInstance().setMessageSentStatus(message, null);
                                RongContext.getInstance().getEventBus().post(message);
                                SendMediaManager.this.uploadController.execute(message);
                            }
                        });
                    }
                } else {
                    RongIMClient.getInstance().insertOutgoingMessage(conversationType, str, null, sightMessageObtain, new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.manager.SendMediaManager.2
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Message message) {
                            message.setSentStatus(Message.SentStatus.SENDING);
                            RongIMClient.getInstance().setMessageSentStatus(message, null);
                            RongContext.getInstance().getEventBus().post(message);
                            SendMediaManager.this.uploadController.execute(message);
                        }
                    });
                }
            }
        }
    }

    public void cancelSendingMedia(Conversation.ConversationType conversationType, String str, int i) {
        UploadController uploadController;
        RLog.d(TAG, "cancel Sending media");
        if (conversationType == null || str == null || (uploadController = this.uploadController) == null || i <= 0) {
            return;
        }
        uploadController.cancel(conversationType, str, i);
    }

    private class UploadController implements Runnable {
        Message executingMessage;
        final List<Message> pendingMessages = new ArrayList();

        public UploadController() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void polling() {
            synchronized (this.pendingMessages) {
                RLog.d(SendMediaManager.TAG, "polling " + this.pendingMessages.size());
                if (this.pendingMessages.size() > 0) {
                    this.executingMessage = this.pendingMessages.remove(0);
                    SendMediaManager.this.executorService.submit(this);
                } else {
                    this.executingMessage = null;
                }
            }
        }

        public void cancel(Conversation.ConversationType conversationType, String str) {
            synchronized (this.pendingMessages) {
                int size = this.pendingMessages.size();
                for (int i = 0; i < size; i++) {
                    Message message = this.pendingMessages.get(i);
                    if (message.getConversationType().equals(conversationType) && message.getTargetId().equals(str)) {
                        this.pendingMessages.remove(message);
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
                    SendMediaManager.this.executorService.submit(this);
                }
            }
        }

        public void reset() {
            RLog.w(SendMediaManager.TAG, "Reset Sending media.");
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
            final Event.OnReceiveMessageProgressEvent onReceiveMessageProgressEvent = new Event.OnReceiveMessageProgressEvent();
            onReceiveMessageProgressEvent.setMessage(this.executingMessage);
            String strSubstring = ((SightMessage) this.executingMessage.getContent()).getLocalPath().toString().substring(7);
            final String str = KitStorageUtils.getImageSavePath(RongIM.getInstance().getApplicationContext()) + File.separator + "VID_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date()) + ".mp4";
            VideoCompress.compressVideo(strSubstring, str, new VideoCompress.CompressListener() { // from class: io.rong.imkit.manager.SendMediaManager.UploadController.1
                @Override // io.rong.imkit.utilities.videocompressor.VideoCompress.CompressListener
                public void onFail() {
                    Toast.makeText(RongIM.getInstance().getApplicationContext(), RongIM.getInstance().getApplicationContext().getString(R.string.rc_picsel_video_corrupted), 0).show();
                    UploadController.this.polling();
                    RLog.d(SendMediaManager.TAG, "Compressing video file failed.");
                }

                @Override // io.rong.imkit.utilities.videocompressor.VideoCompress.CompressListener
                public void onProgress(float f2) {
                    RLog.d(SendMediaManager.TAG, "The progress of compressing video file is " + f2);
                }

                @Override // io.rong.imkit.utilities.videocompressor.VideoCompress.CompressListener
                public void onStart() {
                    RongContext.getInstance().getEventBus().post(onReceiveMessageProgressEvent);
                    RLog.d(SendMediaManager.TAG, "Compressing video file starts.");
                }

                @Override // io.rong.imkit.utilities.videocompressor.VideoCompress.CompressListener
                public void onSuccess() {
                    RLog.d(SendMediaManager.TAG, "Compressing video file successes.");
                    Message message = UploadController.this.executingMessage;
                    if (message == null) {
                        return;
                    }
                    ((SightMessage) message.getContent()).setLocalPath(Uri.parse("file://" + str));
                    boolean zIsDestruct = UploadController.this.executingMessage.getContent() != null ? UploadController.this.executingMessage.getContent().isDestruct() : false;
                    ((SightMessage) UploadController.this.executingMessage.getContent()).setSize(new File(Uri.parse("file://" + str).toString().substring(7)).length());
                    RongIM.getInstance().sendMediaMessage(UploadController.this.executingMessage, zIsDestruct ? RongIM.getInstance().getApplicationContext().getString(R.string.rc_message_content_burn) : null, (String) null, new IRongCallback.ISendMediaMessageCallback() { // from class: io.rong.imkit.manager.SendMediaManager.UploadController.1.1
                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onAttached(Message message2) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                        public void onCanceled(Message message2) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                            UploadController.this.polling();
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                        public void onProgress(Message message2, int i) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onSuccess(Message message2) {
                            UploadController.this.polling();
                        }
                    });
                    RLog.d(SendMediaManager.TAG, "Compressing video file successes.");
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
