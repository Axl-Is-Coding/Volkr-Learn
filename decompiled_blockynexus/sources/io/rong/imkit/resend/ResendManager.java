package io.rong.imkit.resend;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.RongIM;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.ImageMessage;
import io.rong.message.LocationMessage;
import io.rong.message.MediaMessageContent;
import io.rong.message.ReferenceMessage;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes5.dex */
public class ResendManager {
    private static final int TIME_DELAY = 300;
    private final String TAG;
    private volatile boolean mIsProcessing;
    private Hashtable<Integer, Message> mMessageMap;
    private ConcurrentLinkedQueue<Integer> mMessageQueue;
    private Handler mResendHandler;

    public interface AddResendMessageCallBack {
        void onComplete(Message message, RongIMClient.ErrorCode errorCode);
    }

    private static class ResendManagerHolder {
        private static ResendManager instance = new ResendManager();

        private ResendManagerHolder() {
        }
    }

    public static ResendManager getInstance() {
        return ResendManagerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loopResendMessage() {
        this.mResendHandler.postDelayed(new Runnable() { // from class: io.rong.imkit.resend.ResendManager.5
            @Override // java.lang.Runnable
            public void run() {
                final Integer num = (Integer) ResendManager.this.mMessageQueue.peek();
                RLog.d("ResendManager", "beginResend: messageId = " + num);
                if (num == null || RongIM.getInstance().getCurrentConnectionStatus() != RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED) {
                    ResendManager.this.mIsProcessing = false;
                } else {
                    ResendManager resendManager = ResendManager.this;
                    resendManager.resendMessage((Message) resendManager.mMessageMap.get(num), new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.resend.ResendManager.5.1
                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onAttached(Message message) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                            RLog.i("ResendManager", "resendMessage error messageId = " + message.getMessageId());
                            if (ResendManager.this.isResendErrorCode(errorCode)) {
                                ResendManager.this.loopResendMessage();
                            } else {
                                ResendManager.this.removeResendMessage(num.intValue());
                                ResendManager.this.loopResendMessage();
                            }
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onSuccess(Message message) {
                            RLog.i("ResendManager", "resendMessage success messageId = " + message.getMessageId());
                            ResendManager.this.removeResendMessage(num.intValue());
                            ResendManager.this.loopResendMessage();
                        }
                    });
                }
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resendMessage(Message message, final IRongCallback.ISendMessageCallback iSendMessageCallback) {
        if (message == null) {
            RLog.i("ResendManager", "resendMessage: Message is Null");
            return;
        }
        if (TextUtils.isEmpty(message.getTargetId()) || message.getContent() == null) {
            RLog.e("ResendManager", "targetId or messageContent is Null");
            removeResendMessage(message.getMessageId());
            return;
        }
        if (message.getContent() instanceof ImageMessage) {
            ImageMessage imageMessage = (ImageMessage) message.getContent();
            if (imageMessage.getRemoteUri() == null || imageMessage.getRemoteUri().toString().startsWith(LibStorageUtils.FILE)) {
                RongIM.getInstance().sendImageMessage(message, (String) null, (String) null, new RongIMClient.SendImageMessageCallback() { // from class: io.rong.imkit.resend.ResendManager.6
                    @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                    public void onAttached(Message message2) {
                    }

                    @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                    public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                        iSendMessageCallback.onError(message2, errorCode);
                    }

                    @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                    public void onProgress(Message message2, int i) {
                    }

                    @Override // io.rong.imlib.RongIMClient.SendImageMessageCallback
                    public void onSuccess(Message message2) {
                        iSendMessageCallback.onSuccess(message2);
                    }
                });
                return;
            } else {
                RongIM.getInstance().sendMessage(message, null, null, iSendMessageCallback);
                return;
            }
        }
        if (message.getContent() instanceof LocationMessage) {
            RongIM.getInstance().sendLocationMessage(message, null, null, iSendMessageCallback);
            return;
        }
        if (message.getContent() instanceof ReferenceMessage) {
            RongIM.getInstance().sendMessage(message, null, null, iSendMessageCallback);
            return;
        }
        if (!(message.getContent() instanceof MediaMessageContent)) {
            RongIM.getInstance().sendMessage(message, null, null, iSendMessageCallback);
        } else if (((MediaMessageContent) message.getContent()).getMediaUrl() != null) {
            RongIM.getInstance().sendMessage(message, null, null, iSendMessageCallback);
        } else {
            RongIM.getInstance().sendMediaMessage(message, (String) null, (String) null, new IRongCallback.ISendMediaMessageCallback() { // from class: io.rong.imkit.resend.ResendManager.7
                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onAttached(Message message2) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                public void onCanceled(Message message2) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                    iSendMessageCallback.onError(message2, errorCode);
                }

                @Override // io.rong.imlib.IRongCallback.ISendMediaMessageCallback
                public void onProgress(Message message2, int i) {
                }

                @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                public void onSuccess(Message message2) {
                    iSendMessageCallback.onSuccess(message2);
                }
            });
        }
    }

    public void addResendMessage(final Message message, final RongIMClient.ErrorCode errorCode, final AddResendMessageCallBack addResendMessageCallBack) {
        this.mResendHandler.post(new Runnable() { // from class: io.rong.imkit.resend.ResendManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (ResendManager.this.isResendErrorCode(errorCode) && !ResendManager.this.mMessageMap.containsKey(Integer.valueOf(message.getMessageId()))) {
                    RLog.d("ResendManager", "addResendMessage : id=" + message.getMessageId());
                    if (ResendManager.this.mMessageMap != null && ResendManager.this.mMessageQueue != null) {
                        ResendManager.this.mMessageMap.put(Integer.valueOf(message.getMessageId()), message);
                        ResendManager.this.mMessageQueue.add(Integer.valueOf(message.getMessageId()));
                        ResendManager.this.beginResend();
                        message.setSentStatus(Message.SentStatus.SENDING);
                    }
                }
                addResendMessageCallBack.onComplete(message, errorCode);
            }
        });
    }

    public void beginResend() {
        this.mResendHandler.post(new Runnable() { // from class: io.rong.imkit.resend.ResendManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (ResendManager.this.mMessageMap == null || ResendManager.this.mMessageMap.size() == 0) {
                    RLog.i("ResendManager", "beginResend onChanged no message need resend");
                    ResendManager.this.mIsProcessing = false;
                } else if (ResendManager.this.mIsProcessing) {
                    RLog.i("ResendManager", "beginResend ConnectionStatus is resending");
                } else {
                    ResendManager.this.mIsProcessing = true;
                    ResendManager.this.loopResendMessage();
                }
            }
        });
    }

    public boolean isResendErrorCode(RongIMClient.ErrorCode errorCode) {
        return errorCode.equals(RongIMClient.ErrorCode.RC_NET_CHANNEL_INVALID) || errorCode.equals(RongIMClient.ErrorCode.RC_NET_UNAVAILABLE) || errorCode.equals(RongIMClient.ErrorCode.RC_MSG_RESP_TIMEOUT);
    }

    public boolean needResend(int i) {
        Hashtable<Integer, Message> hashtable = this.mMessageMap;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(Integer.valueOf(i));
    }

    public void removeAllResendMessage() {
        this.mResendHandler.post(new Runnable() { // from class: io.rong.imkit.resend.ResendManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (ResendManager.this.mMessageMap != null) {
                    ResendManager.this.mMessageMap.clear();
                    ResendManager.this.mMessageQueue.clear();
                    ResendManager.this.mIsProcessing = false;
                }
            }
        });
    }

    public void removeResendMessage(final int i) {
        this.mResendHandler.post(new Runnable() { // from class: io.rong.imkit.resend.ResendManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (ResendManager.this.mMessageMap != null) {
                    ResendManager.this.mMessageMap.remove(Integer.valueOf(i));
                    ResendManager.this.mMessageQueue.remove(Integer.valueOf(i));
                }
            }
        });
    }

    private ResendManager() {
        this.TAG = "ResendManager";
        this.mIsProcessing = false;
        this.mMessageMap = new Hashtable<>();
        this.mMessageQueue = new ConcurrentLinkedQueue<>();
        HandlerThread handlerThread = new HandlerThread("RESEND_WORK");
        handlerThread.start();
        this.mResendHandler = new Handler(handlerThread.getLooper());
    }
}
