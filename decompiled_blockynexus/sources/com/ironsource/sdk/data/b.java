package com.ironsource.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: AdUnitsState.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Parcelable.Creator<c> {
    b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public c createFromParcel(Parcel parcel) {
        return new c(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public c[] newArray(int i) {
        return new c[i];
    }
}
