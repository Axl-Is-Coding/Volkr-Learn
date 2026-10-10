package com.sandboxol.center.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class SecurityVerifyResponse implements Parcelable {
    public static final Parcelable.Creator<SecurityVerifyResponse> CREATOR = new Parcelable.Creator<SecurityVerifyResponse>() { // from class: com.sandboxol.center.entity.SecurityVerifyResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SecurityVerifyResponse createFromParcel(Parcel parcel) {
            return new SecurityVerifyResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SecurityVerifyResponse[] newArray(int i) {
            return new SecurityVerifyResponse[i];
        }
    };
    private String authCode;
    private boolean flag;

    protected SecurityVerifyResponse(Parcel parcel) {
        this.authCode = parcel.readString();
        this.flag = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setFlag(boolean z) {
        this.flag = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.authCode);
        parcel.writeByte(this.flag ? (byte) 1 : (byte) 0);
    }
}
