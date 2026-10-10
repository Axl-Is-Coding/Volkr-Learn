package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class SendMessageOption implements Parcelable {
    public static final Parcelable.Creator<SendMessageOption> CREATOR = new Parcelable.Creator<SendMessageOption>() { // from class: io.rong.imlib.model.SendMessageOption.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SendMessageOption createFromParcel(Parcel parcel) {
            return new SendMessageOption(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SendMessageOption[] newArray(int i) {
            return new SendMessageOption[i];
        }
    };
    private boolean isVoIPPush;

    public SendMessageOption(Parcel parcel) {
        this.isVoIPPush = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isVoIPPush() {
        return this.isVoIPPush;
    }

    public void setVoIPPush(boolean z) {
        this.isVoIPPush = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isVoIPPush ? (byte) 1 : (byte) 0);
    }

    public SendMessageOption() {
    }
}
