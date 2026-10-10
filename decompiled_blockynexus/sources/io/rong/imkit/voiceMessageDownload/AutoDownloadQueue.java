package io.rong.imkit.voiceMessageDownload;

import io.rong.imkit.voiceMessageDownload.AutoDownloadEntry;
import io.rong.imlib.model.Message;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes5.dex */
class AutoDownloadQueue {
    private static final int MAX_QUEUE_COUNT = 100;
    private ConcurrentLinkedQueue<AutoDownloadEntry> highPriority = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<AutoDownloadEntry> normalPriority = new ConcurrentLinkedQueue<>();
    private HashMap<String, AutoDownloadEntry> autoDownloadEntryHashMap = new HashMap<>();

    AutoDownloadQueue() {
    }

    Message dequeue() {
        if (!this.highPriority.isEmpty()) {
            return this.highPriority.poll().getMessage();
        }
        if (this.normalPriority.isEmpty()) {
            return null;
        }
        return this.normalPriority.poll().getMessage();
    }

    void enqueue(AutoDownloadEntry autoDownloadEntry) {
        Message message = autoDownloadEntry.getMessage();
        if (autoDownloadEntry.getPriority() == AutoDownloadEntry.DownloadPriority.NORMAL) {
            this.normalPriority.add(autoDownloadEntry);
        } else if (autoDownloadEntry.getPriority() == AutoDownloadEntry.DownloadPriority.HIGH) {
            this.highPriority.add(autoDownloadEntry);
        }
        if (!this.autoDownloadEntryHashMap.containsKey(message.getUId())) {
            this.autoDownloadEntryHashMap.put(message.getUId(), autoDownloadEntry);
        }
        if (this.normalPriority.size() + this.highPriority.size() > 100) {
            if (!this.normalPriority.isEmpty()) {
                this.autoDownloadEntryHashMap.remove(this.normalPriority.poll().getMessage().getUId());
                return;
            }
            AutoDownloadEntry autoDownloadEntryPoll = this.highPriority.poll();
            if (autoDownloadEntryPoll != null) {
                this.autoDownloadEntryHashMap.remove(autoDownloadEntryPoll.getMessage().getUId());
            }
        }
    }

    HashMap<String, AutoDownloadEntry> getAutoDownloadEntryHashMap() {
        return this.autoDownloadEntryHashMap;
    }

    boolean ifMsgInHashMap(Message message) {
        return this.autoDownloadEntryHashMap.containsKey(message.getUId());
    }

    public boolean isEmpty() {
        return this.highPriority.isEmpty() && this.normalPriority.isEmpty();
    }
}
