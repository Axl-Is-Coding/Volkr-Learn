package io.rong.imlib.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Group implements Parcelable {
    public static final Parcelable.Creator<Group> CREATOR = new Parcelable.Creator<Group>() { // from class: io.rong.imlib.model.Group.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Group createFromParcel(Parcel parcel) {
            return new Group(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Group[] newArray(int i) {
            return new Group[i];
        }
    };
    private String id;
    private String name;
    private Uri portraitUri;

    public Group(Parcel parcel) {
        this(ParcelUtils.readFromParcel(parcel), ParcelUtils.readFromParcel(parcel), (Uri) ParcelUtils.readFromParcel(parcel, Uri.class));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Uri getPortraitUri() {
        return this.portraitUri;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortraitUri(Uri uri) {
        this.portraitUri = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getId());
        ParcelUtils.writeToParcel(parcel, getName());
        ParcelUtils.writeToParcel(parcel, getPortraitUri());
    }

    public Group(String str, String str2, Uri uri) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("groupId is null");
        }
        this.id = str;
        this.name = str2;
        this.portraitUri = uri;
    }
}
