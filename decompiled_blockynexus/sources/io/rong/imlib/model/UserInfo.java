package io.rong.imlib.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class UserInfo implements Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() { // from class: io.rong.imlib.model.UserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    };
    private String extra;
    private String id;
    private String name;
    private Uri portraitUri;

    public UserInfo(Parcel parcel) {
        setUserId(ParcelUtils.readFromParcel(parcel));
        setName(ParcelUtils.readFromParcel(parcel));
        setPortraitUri((Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
        setExtra(ParcelUtils.readFromParcel(parcel));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getName() {
        return this.name;
    }

    public Uri getPortraitUri() {
        return this.portraitUri;
    }

    public String getUserId() {
        if (TextUtils.isEmpty(this.id)) {
            throw new NullPointerException("userId  is null");
        }
        return this.id;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortraitUri(Uri uri) {
        this.portraitUri = uri;
    }

    public void setUserId(String str) {
        this.id = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getUserId());
        ParcelUtils.writeToParcel(parcel, getName());
        ParcelUtils.writeToParcel(parcel, getPortraitUri());
        ParcelUtils.writeToParcel(parcel, getExtra());
    }

    public UserInfo(String str, String str2, Uri uri) {
        if (!TextUtils.isEmpty(str)) {
            this.id = str;
            this.name = str2;
            this.portraitUri = uri;
            return;
        }
        throw new NullPointerException("userId is null");
    }
}
