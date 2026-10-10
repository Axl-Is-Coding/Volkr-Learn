package io.rong.imlib.location.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:RLQuit")
public class RealTimeLocationQuitMessage extends MessageContent {
    public static final Parcelable.Creator<RealTimeLocationQuitMessage> CREATOR = new Parcelable.Creator<RealTimeLocationQuitMessage>() { // from class: io.rong.imlib.location.message.RealTimeLocationQuitMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationQuitMessage createFromParcel(Parcel parcel) {
            return new RealTimeLocationQuitMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationQuitMessage[] newArray(int i) {
            return new RealTimeLocationQuitMessage[i];
        }
    };
    private String content;

    public static RealTimeLocationQuitMessage obtain(String str) {
        return new RealTimeLocationQuitMessage(str);
    }

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
        parcel.writeString(this.content);
    }

    public RealTimeLocationQuitMessage(String str) {
        this.content = "";
        this.content = str;
    }

    public RealTimeLocationQuitMessage(byte[] bArr) {
        this.content = "";
    }

    private RealTimeLocationQuitMessage(Parcel parcel) {
        this.content = "";
        this.content = parcel.readString();
    }
}
