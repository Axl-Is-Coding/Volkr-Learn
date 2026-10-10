package io.rong.imlib.location.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:RLJoin")
public class RealTimeLocationJoinMessage extends MessageContent {
    public static final Parcelable.Creator<RealTimeLocationJoinMessage> CREATOR = new Parcelable.Creator<RealTimeLocationJoinMessage>() { // from class: io.rong.imlib.location.message.RealTimeLocationJoinMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationJoinMessage createFromParcel(Parcel parcel) {
            return new RealTimeLocationJoinMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeLocationJoinMessage[] newArray(int i) {
            return new RealTimeLocationJoinMessage[i];
        }
    };
    private String content;

    public static RealTimeLocationJoinMessage obtain(String str) {
        return new RealTimeLocationJoinMessage(str);
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

    public RealTimeLocationJoinMessage(String str) {
        this.content = "";
        this.content = str;
    }

    public RealTimeLocationJoinMessage(byte[] bArr) {
        this.content = "";
    }

    private RealTimeLocationJoinMessage(Parcel parcel) {
        this.content = "";
        this.content = parcel.readString();
    }
}
