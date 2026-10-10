package io.rong.message;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CSHumanEvaluateItem implements Parcelable {
    public static final Parcelable.Creator<CSHumanEvaluateItem> CREATOR = new Parcelable.Creator<CSHumanEvaluateItem>() { // from class: io.rong.message.CSHumanEvaluateItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSHumanEvaluateItem createFromParcel(Parcel parcel) {
            return new CSHumanEvaluateItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSHumanEvaluateItem[] newArray(int i) {
            return new CSHumanEvaluateItem[i];
        }
    };
    private String description;
    private int value;

    public CSHumanEvaluateItem(int i, String str) {
        this.value = i;
        this.description = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public int getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.value));
        ParcelUtils.writeToParcel(parcel, this.description);
    }

    public CSHumanEvaluateItem(Parcel parcel) {
        this.value = ParcelUtils.readIntFromParcel(parcel).intValue();
        this.description = ParcelUtils.readFromParcel(parcel);
    }
}
