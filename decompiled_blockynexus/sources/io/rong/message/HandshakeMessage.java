package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.imlib.MessageTag;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:HsMsg")
public class HandshakeMessage extends TextMessage {
    public static final Parcelable.Creator<HandshakeMessage> CREATOR = new Parcelable.Creator<HandshakeMessage>() { // from class: io.rong.message.HandshakeMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HandshakeMessage createFromParcel(Parcel parcel) {
            return new HandshakeMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HandshakeMessage[] newArray(int i) {
            return new HandshakeMessage[i];
        }
    };
    private int type;

    public HandshakeMessage() {
    }

    public static HandshakeMessage obtain(String str) {
        HandshakeMessage handshakeMessage = new HandshakeMessage();
        handshakeMessage.setContent(str);
        return handshakeMessage;
    }

    @Override // io.rong.message.TextMessage, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.message.TextMessage, io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return ("{\"type\":" + this.type + "}").getBytes();
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // io.rong.message.TextMessage, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public HandshakeMessage(byte[] bArr) {
    }

    public HandshakeMessage(Parcel parcel) {
        super(parcel);
    }
}
