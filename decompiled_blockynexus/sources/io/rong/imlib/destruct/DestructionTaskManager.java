package io.rong.imlib.destruct;

import io.rong.common.RLog;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.DestructionCmdMessage;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class DestructionTaskManager {
    private static final String TAG = "DestructionTaskManager";
    private Map<String, DestructCountDownTimer> mCountDownTimers;

    private static class DestructionTaskManagerHolder {
        private static DestructionTaskManager instance = new DestructionTaskManager();

        private DestructionTaskManagerHolder() {
        }
    }

    private void cancelCountDown(String str) {
        if (this.mCountDownTimers.containsKey(str)) {
            DestructCountDownTimer destructCountDownTimer = this.mCountDownTimers.get(str);
            if (destructCountDownTimer != null) {
                destructCountDownTimer.cancel();
            }
            this.mCountDownTimers.remove(str);
        }
    }

    public static DestructionTaskManager getInstance() {
        return DestructionTaskManagerHolder.instance;
    }

    private void resetReadTime(Message message) {
        RongIMClient.getInstance().setMessageReadTime(message.getMessageId(), 0L, null);
        message.setReadTime(0L);
    }

    private void sendDestructingMsg(Message message) {
        if (message.getReadTime() <= 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            RongIMClient.getInstance().setMessageReadTime(message.getMessageId(), jCurrentTimeMillis, null);
            message.setReadTime(jCurrentTimeMillis);
            DestructionCmdMessage destructionCmdMessage = new DestructionCmdMessage();
            destructionCmdMessage.addBurnMessageUId(message.getUId());
            MessageBufferPool.getInstance().putMessageInBuffer(Message.obtain(message.getTargetId(), message.getConversationType(), destructionCmdMessage));
        }
    }

    private void startCountDown(final Message message, final RongIMClient.DestructCountDownTimerListener destructCountDownTimerListener) {
        long destructTime;
        DestructCountDownTimer destructCountDownTimer;
        if (this.mCountDownTimers.containsKey(message.getUId())) {
            destructCountDownTimer = this.mCountDownTimers.get(message.getUId());
        } else {
            if (message.getReadTime() <= 0) {
                destructTime = message.getContent().getDestructTime() * 1000;
            } else {
                destructTime = (message.getContent().getDestructTime() * 1000) - (System.currentTimeMillis() - message.getReadTime());
                if (destructTime <= 0) {
                    destructTime = 0;
                }
            }
            DestructCountDownTimer destructCountDownTimer2 = new DestructCountDownTimer(message.getUId(), new RongIMClient.DestructCountDownTimerListener() { // from class: io.rong.imlib.destruct.DestructionTaskManager.1
                @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
                public void onStop(String str) {
                    destructCountDownTimerListener.onStop(str);
                    DestructionTaskManager.this.mCountDownTimers.remove(str);
                }

                @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
                public void onTick(long j, String str) {
                    destructCountDownTimerListener.onTick(j, str);
                    if (j <= 0) {
                        DestructionTaskManager.this.deleteMessage(message);
                        DestructionTaskManager.this.mCountDownTimers.remove(str);
                    }
                }
            }, destructTime);
            this.mCountDownTimers.put(message.getUId(), destructCountDownTimer2);
            destructCountDownTimer = destructCountDownTimer2;
        }
        destructCountDownTimer.start();
    }

    public void BeginDestruct(Message message, RongIMClient.DestructCountDownTimerListener destructCountDownTimerListener) {
        if (message == null || message.getContent() == null || destructCountDownTimerListener == null) {
            RLog.e(TAG, "BeginDestruct pMessage or content or pListener should not be null!");
        } else if (message.getContent().isDestruct() && message.getMessageDirection() == Message.MessageDirection.RECEIVE) {
            startCountDown(message, destructCountDownTimerListener);
            sendDestructingMsg(message);
        }
    }

    public void deleteMessage(Message message) {
        if (message != null) {
            RongIMClient.getInstance().deleteRemoteMessages(message.getConversationType(), message.getTargetId(), new Message[]{message}, null);
            RongIMClient.getInstance().deleteMessages(new int[]{message.getMessageId()}, null);
        }
    }

    public void deleteMessages(Conversation.ConversationType conversationType, String str, Message[] messageArr) {
        if (messageArr == null || messageArr.length <= 0 || conversationType == null || str == null) {
            return;
        }
        int[] iArr = new int[messageArr.length];
        for (int i = 0; i < messageArr.length; i++) {
            if (messageArr[i] != null) {
                iArr[i] = messageArr[i].getMessageId();
            }
        }
        RongIMClient.getInstance().deleteMessages(iArr, null);
        RongIMClient.getInstance().deleteRemoteMessages(conversationType, str, messageArr, null);
    }

    public void messageStopDestruct(Message message) {
        if (message == null || message.getContent() == null) {
            RLog.e(TAG, "messageStopDestruct pMessage or content should not be null!");
        } else if (message.getContent().isDestruct() && message.getMessageDirection() == Message.MessageDirection.RECEIVE) {
            cancelCountDown(message.getUId());
            resetReadTime(message);
        }
    }

    private DestructionTaskManager() {
        this.mCountDownTimers = new HashMap();
    }
}
