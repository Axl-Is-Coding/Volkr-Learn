package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteHistoryMsgOption implements Parcelable {
    private static final int ASCEND = 1;
    public static final Parcelable.Creator<RemoteHistoryMsgOption> CREATOR = new Parcelable.Creator<RemoteHistoryMsgOption>() { // from class: io.rong.imlib.model.RemoteHistoryMsgOption.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteHistoryMsgOption createFromParcel(Parcel parcel) {
            return new RemoteHistoryMsgOption(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteHistoryMsgOption[] newArray(int i) {
            return new RemoteHistoryMsgOption[i];
        }
    };
    private static final int DESCEND = 0;
    private static final int PULL_MAX_COUNT = 20;
    private static final int PULL_MIN_COUNT = 0;
    private int count;
    private long dataTime;
    private boolean includeLocalExistMessage;
    private int pullOrder;

    public RemoteHistoryMsgOption() {
        this(0L, 5, 1, false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCount() {
        return this.count;
    }

    public long getDataTime() {
        return this.dataTime;
    }

    public int getOrder() {
        return this.pullOrder;
    }

    public boolean isIncludeLocalExistMessage() {
        return this.includeLocalExistMessage;
    }

    public void setCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 20) {
            i = 20;
        }
        this.count = i;
    }

    public void setDataTime(long j) {
        this.dataTime = j;
    }

    public void setIncludeLocalExistMessage(boolean z) {
        this.includeLocalExistMessage = z;
    }

    public void setOrder(int i) {
        this.pullOrder = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Long.valueOf(getDataTime()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getCount()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getOrder()));
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isIncludeLocalExistMessage() ? 1 : 0));
    }

    public RemoteHistoryMsgOption(long j, int i, int i2, boolean z) {
        this.dataTime = j;
        this.count = i;
        this.pullOrder = i2;
        this.includeLocalExistMessage = z;
    }

    protected RemoteHistoryMsgOption(Parcel parcel) {
        setDataTime(ParcelUtils.readLongFromParcel(parcel).longValue());
        setCount(ParcelUtils.readIntFromParcel(parcel).intValue());
        setOrder(ParcelUtils.readIntFromParcel(parcel).intValue());
        setIncludeLocalExistMessage(ParcelUtils.readIntFromParcel(parcel).intValue() == 1);
    }
}
