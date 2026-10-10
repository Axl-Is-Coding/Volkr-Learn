package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.flexbox.FlexboxLayoutManager;

/* JADX INFO: compiled from: FlexboxLayoutManager.java */
/* JADX INFO: loaded from: classes.dex */
class i implements Parcelable.Creator<FlexboxLayoutManager.c> {
    i() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FlexboxLayoutManager.c createFromParcel(Parcel parcel) {
        return new FlexboxLayoutManager.c(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public FlexboxLayoutManager.c[] newArray(int i) {
        return new FlexboxLayoutManager.c[i];
    }
}
