package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: compiled from: FlexboxLayout.java */
/* JADX INFO: loaded from: classes.dex */
class f implements Parcelable.Creator<FlexboxLayout.LayoutParams> {
    f() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FlexboxLayout.LayoutParams createFromParcel(Parcel parcel) {
        return new FlexboxLayout.LayoutParams(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FlexboxLayout.LayoutParams[] newArray(int i) {
        return new FlexboxLayout.LayoutParams[i];
    }
}
