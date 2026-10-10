package io.rong.imlib.model;

/* JADX INFO: loaded from: classes5.dex */
public class FileInfo {
    private String fileName;
    private long finished;
    private long length;
    private int messageId;
    private String url;
    private boolean isStop = false;
    private boolean isDownLoading = false;

    public FileInfo() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFinished() {
        return this.finished;
    }

    public long getLength() {
        return this.length;
    }

    public int getMessageId() {
        return this.messageId;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isDownLoading() {
        return this.isDownLoading;
    }

    public boolean isStop() {
        return this.isStop;
    }

    public void setDownLoading(boolean z) {
        this.isDownLoading = z;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setMessageId(int i) {
        this.messageId = i;
    }

    public void setStop(boolean z) {
        this.isStop = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public FileInfo(String str, String str2) {
        this.fileName = str;
        this.url = str2;
    }
}
