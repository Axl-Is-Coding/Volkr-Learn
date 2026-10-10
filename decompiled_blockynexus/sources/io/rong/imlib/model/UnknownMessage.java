package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:UnknownMsg")
public class UnknownMessage extends MessageContent {
    public static final Parcelable.Creator<UnknownMessage> CREATOR = new Parcelable.Creator<UnknownMessage>() { // from class: io.rong.imlib.model.UnknownMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnknownMessage createFromParcel(Parcel parcel) {
            return new UnknownMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UnknownMessage[] newArray(int i) {
            return new UnknownMessage[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return new byte[0];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, (Integer) 0);
    }

    public UnknownMessage(byte[] bArr) {
    }

    public UnknownMessage() {
    }

    private UnknownMessage(Parcel parcel) {
        ParcelUtils.readIntFromParcel(parcel);
    }
}
