package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.flexbox.FlexboxLayoutManager;

/* JADX INFO: compiled from: FlexboxLayoutManager.java */
/* JADX INFO: loaded from: classes.dex */
class h implements Parcelable.Creator<FlexboxLayoutManager.LayoutParams> {
    h() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FlexboxLayoutManager.LayoutParams createFromParcel(Parcel parcel) {
        return new FlexboxLayoutManager.LayoutParams(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FlexboxLayoutManager.LayoutParams[] newArray(int i) {
        return new FlexboxLayoutManager.LayoutParams[i];
    }
}
