package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class PublicServiceProfileList implements Parcelable {
    public static final Parcelable.Creator<PublicServiceProfileList> CREATOR = new Parcelable.Creator<PublicServiceProfileList>() { // from class: io.rong.imlib.model.PublicServiceProfileList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceProfileList createFromParcel(Parcel parcel) {
            return new PublicServiceProfileList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublicServiceProfileList[] newArray(int i) {
            return new PublicServiceProfileList[i];
        }
    };
    private ArrayList<PublicServiceProfile> mList;

    public PublicServiceProfileList() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<PublicServiceProfile> getPublicServiceData() {
        return this.mList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeListToParcel(parcel, this.mList);
    }

    public PublicServiceProfileList(ArrayList<PublicServiceProfile> arrayList) {
        this.mList = arrayList;
    }

    public PublicServiceProfileList(Parcel parcel) {
        this.mList = ParcelUtils.readListFromParcel(parcel, PublicServiceProfile.class);
    }
}
