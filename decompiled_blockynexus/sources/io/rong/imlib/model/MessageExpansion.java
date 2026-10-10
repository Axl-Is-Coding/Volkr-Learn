package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class MessageExpansion implements Parcelable {
    public static final Parcelable.Creator<MessageExpansion> CREATOR = new Parcelable.Creator<MessageExpansion>() { // from class: io.rong.imlib.model.MessageExpansion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageExpansion createFromParcel(Parcel parcel) {
            return new MessageExpansion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageExpansion[] newArray(int i) {
            return new MessageExpansion[i];
        }
    };
    private long ts;
    private String value;

    public MessageExpansion(String str, long j) {
        this.value = str;
        this.ts = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getTs() {
        return this.ts;
    }

    public String getValue() {
        return this.value;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public void setValue(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.value);
        parcel.writeLong(this.ts);
    }

    protected MessageExpansion(Parcel parcel) {
        this.value = parcel.readString();
        this.ts = parcel.readLong();
    }
}
