package io.rong.imlib.typingmessage;

/* JADX INFO: loaded from: classes5.dex */
public class TypingStatus {
    private long sentTime;
    private String typingContentType;
    private String userId;

    public TypingStatus(String str, String str2, long j) {
        setUserId(str);
        setTypingContentType(str2);
        setSentTime(j);
    }

    public long getSentTime() {
        return this.sentTime;
    }

    public String getTypingContentType() {
        return this.typingContentType;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setSentTime(long j) {
        this.sentTime = j;
    }

    public void setTypingContentType(String str) {
        this.typingContentType = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
