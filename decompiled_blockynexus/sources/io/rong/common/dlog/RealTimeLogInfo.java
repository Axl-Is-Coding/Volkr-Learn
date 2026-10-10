package io.rong.common.dlog;

/* JADX INFO: loaded from: classes5.dex */
public class RealTimeLogInfo {
    int code;
    String method;
    int nativeCode;
    int seqId;
    String sessionId;
    String tag;
    String type;

    public int getCode() {
        return this.code;
    }

    public String getMethod() {
        return this.method;
    }

    public int getNativeCode() {
        return this.nativeCode;
    }

    public int getSeqId() {
        return this.seqId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTag() {
        return this.tag;
    }

    public String getType() {
        return this.type;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setNativeCode(int i) {
        this.nativeCode = i;
    }

    public void setSeqId(int i) {
        this.seqId = i;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
