package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.imlib.MessageTag;

/* JADX INFO: loaded from: classes5.dex */
@MessageTag(flag = 0, value = "RC:RecNtf")
public class HasReceivedNotificationMessage extends NotificationMessage {
    public static final Parcelable.Creator<HasReceivedNotificationMessage> CREATOR = new Parcelable.Creator<HasReceivedNotificationMessage>() { // from class: io.rong.message.HasReceivedNotificationMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HasReceivedNotificationMessage createFromParcel(Parcel parcel) {
            return new HasReceivedNotificationMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HasReceivedNotificationMessage[] newArray(int i) {
            return new HasReceivedNotificationMessage[i];
        }
    };
    private boolean hasReceived;

    public HasReceivedNotificationMessage(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // io.rong.imlib.model.MessageContent
    public byte[] encode() {
        return new byte[0];
    }

    public boolean isHasReceived() {
        return this.hasReceived;
    }

    public void setHasReceived(boolean z) {
        this.hasReceived = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
