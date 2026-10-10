package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class MessageConfig implements Parcelable {
    public static final Parcelable.Creator<MessageConfig> CREATOR = new Parcelable.Creator<MessageConfig>() { // from class: io.rong.imlib.model.MessageConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageConfig createFromParcel(Parcel parcel) {
            return new MessageConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageConfig[] newArray(int i) {
            return new MessageConfig[i];
        }
    };
    private static final String TAG = "MessageConfig";
    private boolean disableNotification;

    public static class Builder {
        private boolean disableNotification;

        public MessageConfig build() {
            MessageConfig messageConfig = new MessageConfig();
            messageConfig.disableNotification = this.disableNotification;
            return messageConfig;
        }

        public Builder setDisableNotification(boolean z) {
            this.disableNotification = z;
            return this;
        }
    }

    public MessageConfig() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isDisableNotification() {
        return this.disableNotification;
    }

    public void setDisableNotification(boolean z) {
        this.disableNotification = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.disableNotification ? (byte) 1 : (byte) 0);
    }

    protected MessageConfig(Parcel parcel) {
        this.disableNotification = parcel.readByte() != 0;
    }
}
