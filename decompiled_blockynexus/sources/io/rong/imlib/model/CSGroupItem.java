package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CSGroupItem implements Parcelable {
    public static final Parcelable.Creator<CSGroupItem> CREATOR = new Parcelable.Creator<CSGroupItem>() { // from class: io.rong.imlib.model.CSGroupItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSGroupItem createFromParcel(Parcel parcel) {
            return new CSGroupItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSGroupItem[] newArray(int i) {
            return new CSGroupItem[i];
        }
    };
    private String id;
    private String name;
    private boolean online;

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

    public boolean getOnline() {
        return this.online;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.id);
        ParcelUtils.writeToParcel(parcel, this.name);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.online ? 1 : 0));
    }

    public CSGroupItem(String str, String str2, boolean z) {
        this.id = str;
        this.name = str2;
        this.online = z;
    }

    private CSGroupItem(Parcel parcel) {
        this.id = ParcelUtils.readFromParcel(parcel);
        this.name = ParcelUtils.readFromParcel(parcel);
        this.online = ParcelUtils.readIntFromParcel(parcel).intValue() == 1;
    }
}
