package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class RTCStatusDate implements Parcelable {
    public static final Parcelable.Creator<RTCStatusDate> CREATOR = new Parcelable.Creator<RTCStatusDate>() { // from class: io.rong.imlib.model.RTCStatusDate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RTCStatusDate createFromParcel(Parcel parcel) {
            return new RTCStatusDate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RTCStatusDate[] newArray(int i) {
            return new RTCStatusDate[i];
        }
    };
    boolean autoDelete;
    String key;
    boolean overwrite;
    String value;

    public RTCStatusDate() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isAutoDelete() {
        return this.autoDelete;
    }

    public boolean isOverwrite() {
        return this.overwrite;
    }

    public void setAutoDelete(boolean z) {
        this.autoDelete = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOverwrite(boolean z) {
        this.overwrite = z;
    }

    public void setValue(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeByte(this.autoDelete ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.overwrite ? (byte) 1 : (byte) 0);
    }

    protected RTCStatusDate(Parcel parcel) {
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.autoDelete = parcel.readByte() != 0;
        this.overwrite = parcel.readByte() != 0;
    }
}
