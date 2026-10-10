package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class RTCUser implements Parcelable {
    public static final Parcelable.Creator<RTCUser> CREATOR = new Parcelable.Creator<RTCUser>() { // from class: io.rong.imlib.model.RTCUser.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RTCUser createFromParcel(Parcel parcel) {
            return new RTCUser(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RTCUser[] newArray(int i) {
            return new RTCUser[i];
        }
    };
    private HashMap<String, String> data;
    private String uid;

    public RTCUser() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HashMap<String, String> getData() {
        return this.data;
    }

    public String getUid() {
        return this.uid;
    }

    public void setData(HashMap<String, String> map) {
        this.data = map;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeSerializable(this.data);
    }

    protected RTCUser(Parcel parcel) {
        this.uid = parcel.readString();
        this.data = (HashMap) parcel.readSerializable();
    }
}
