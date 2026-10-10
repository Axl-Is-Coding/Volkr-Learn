package io.rong.imlib.navigation;

/* JADX INFO: loaded from: classes5.dex */
public class LocationConfig {
    private boolean configure;
    private int[] conversationTypes;
    private int distanceFilter;
    private int maxParticipant;
    private int refreshInterval;

    public int[] getConversationTypes() {
        return this.conversationTypes;
    }

    public int getDistanceFilter() {
        return this.distanceFilter;
    }

    int getMaxParticipant() {
        return this.maxParticipant;
    }

    public int getRefreshInterval() {
        return this.refreshInterval;
    }

    public boolean isConfigure() {
        return this.configure;
    }

    public void setConfigure(boolean z) {
        this.configure = z;
    }

    public void setConversationTypes(int[] iArr) {
        this.conversationTypes = iArr;
    }

    void setDistanceFilter(int i) {
        this.distanceFilter = i;
    }

    void setMaxParticipant(int i) {
        this.maxParticipant = i;
    }

    void setRefreshInterval(int i) {
        this.refreshInterval = i;
    }
}
