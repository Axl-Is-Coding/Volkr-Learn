package io.rong.imkit.model;

import android.text.SpannableStringBuilder;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.ReadReceiptInfo;
import io.rong.imlib.model.UserInfo;

/* JADX INFO: loaded from: classes5.dex */
public class UIMessage {
    private SpannableStringBuilder contentSpannable;
    public boolean continuePlayAudio;
    private CustomServiceConfig csConfig;
    private boolean isChecked;
    private boolean isListening;
    private Message mMessage;
    private boolean mNickName;
    private int mProgress;
    private UserInfo mUserInfo;
    private SpannableStringBuilder referenceContentSpannable;
    private String unDestructTime;
    private boolean evaluated = false;
    private boolean isHistoryMessage = true;

    public static UIMessage obtain(Message message) {
        UIMessage uIMessage = new UIMessage();
        uIMessage.mMessage = message;
        uIMessage.continuePlayAudio = false;
        return uIMessage;
    }

    public MessageContent getContent() {
        return this.mMessage.getContent();
    }

    public SpannableStringBuilder getContentSpannable() {
        return this.contentSpannable;
    }

    public Conversation.ConversationType getConversationType() {
        return this.mMessage.getConversationType();
    }

    public CustomServiceConfig getCsConfig() {
        return this.csConfig;
    }

    public boolean getEvaluated() {
        return this.evaluated;
    }

    public String getExtra() {
        return this.mMessage.getExtra();
    }

    public boolean getIsHistoryMessage() {
        return this.isHistoryMessage;
    }

    public Message getMessage() {
        return this.mMessage;
    }

    public Message.MessageDirection getMessageDirection() {
        return this.mMessage.getMessageDirection();
    }

    public int getMessageId() {
        return this.mMessage.getMessageId();
    }

    public String getObjectName() {
        return this.mMessage.getObjectName();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public ReadReceiptInfo getReadReceiptInfo() {
        return this.mMessage.getReadReceiptInfo();
    }

    public Message.ReceivedStatus getReceivedStatus() {
        return this.mMessage.getReceivedStatus();
    }

    public long getReceivedTime() {
        return this.mMessage.getReceivedTime();
    }

    public SpannableStringBuilder getReferenceContentSpannable() {
        return this.referenceContentSpannable;
    }

    public String getSenderUserId() {
        return this.mMessage.getSenderUserId();
    }

    public Message.SentStatus getSentStatus() {
        return this.mMessage.getSentStatus();
    }

    public long getSentTime() {
        return this.mMessage.getSentTime();
    }

    public String getTargetId() {
        return this.mMessage.getTargetId();
    }

    public String getUId() {
        return this.mMessage.getUId();
    }

    public String getUnDestructTime() {
        return this.unDestructTime;
    }

    public UserInfo getUserInfo() {
        return this.mUserInfo;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isListening() {
        return this.isListening;
    }

    public boolean isNickName() {
        return this.mNickName;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setContent(MessageContent messageContent) {
        this.mMessage.setContent(messageContent);
    }

    public void setContentSpannable(SpannableStringBuilder spannableStringBuilder) {
        this.contentSpannable = spannableStringBuilder;
    }

    public void setCsConfig(CustomServiceConfig customServiceConfig) {
        this.csConfig = customServiceConfig;
    }

    public void setEvaluated(boolean z) {
        this.evaluated = z;
    }

    public void setExtra(String str) {
        this.mMessage.setExtra(str);
    }

    public void setIsHistoryMessage(boolean z) {
        this.isHistoryMessage = z;
    }

    public void setListening(boolean z) {
        this.isListening = z;
    }

    public void setMessage(Message message) {
        this.mMessage = message;
    }

    public void setNickName(boolean z) {
        this.mNickName = z;
    }

    public void setProgress(int i) {
        this.mProgress = i;
    }

    public void setReadReceiptInfo(ReadReceiptInfo readReceiptInfo) {
        this.mMessage.setReadReceiptInfo(readReceiptInfo);
    }

    public void setReceivedStatus(Message.ReceivedStatus receivedStatus) {
        this.mMessage.setReceivedStatus(receivedStatus);
    }

    public void setReceivedTime(long j) {
        this.mMessage.setReceivedTime(j);
    }

    public void setReferenceContentSpannable(SpannableStringBuilder spannableStringBuilder) {
        this.referenceContentSpannable = spannableStringBuilder;
    }

    public void setSenderUserId(String str) {
        this.mMessage.setSenderUserId(str);
    }

    public void setSentStatus(Message.SentStatus sentStatus) {
        this.mMessage.setSentStatus(sentStatus);
    }

    public void setSentTime(long j) {
        this.mMessage.setSentTime(j);
    }

    public void setUnDestructTime(String str) {
        this.unDestructTime = str;
    }

    public void setUserInfo(UserInfo userInfo) {
        Message message;
        if (userInfo == null || (message = this.mMessage) == null || message.getSenderUserId() == null) {
            this.mUserInfo = userInfo;
        } else if (this.mMessage.getSenderUserId().equals(userInfo.getUserId())) {
            this.mUserInfo = userInfo;
        }
    }
}
