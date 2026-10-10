package io.rong.imkit.voiceMessageDownload;

import io.rong.imlib.model.Message;

/* JADX INFO: loaded from: classes5.dex */
public class AutoDownloadEntry {
    private Message message;
    private DownloadPriority priority;

    public enum DownloadPriority {
        NORMAL,
        HIGH
    }

    public AutoDownloadEntry(Message message, DownloadPriority downloadPriority) {
        this.message = message;
        this.priority = downloadPriority;
    }

    public Message getMessage() {
        return this.message;
    }

    DownloadPriority getPriority() {
        return this.priority;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
