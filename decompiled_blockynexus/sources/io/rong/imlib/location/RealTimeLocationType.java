package io.rong.imlib.location;

/* JADX INFO: loaded from: classes5.dex */
public enum RealTimeLocationType {
    UNKNOWN(0),
    WGS84(1),
    GCJ02(2),
    BD09(3);

    int value;

    RealTimeLocationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RealTimeLocationType valueOf(int i) {
        for (RealTimeLocationType realTimeLocationType : values()) {
            if (i == realTimeLocationType.ordinal()) {
                return realTimeLocationType;
            }
        }
        return UNKNOWN;
    }
}
