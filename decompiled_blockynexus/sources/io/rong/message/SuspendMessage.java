package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:SpMsg")
public class SuspendMessage extends MessageContent {
    public static final Parcelable.Creator<SuspendMessage> CREATOR = new Parcelable.Creator<SuspendMessage>() { // from class: io.rong.message.SuspendMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuspendMessage createFromParcel(Parcel parcel) {
            return new SuspendMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuspendMessage[] newArray(int i) {
            return new SuspendMessage[i];
        }
    };

    public SuspendMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return "{\"type\":1}".getBytes();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public SuspendMessage(byte[] bArr) {
    }

    public SuspendMessage(Parcel parcel) {
    }
}
