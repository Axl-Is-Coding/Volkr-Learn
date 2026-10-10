package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: Month.java */
/* JADX INFO: loaded from: classes2.dex */
class t implements Parcelable.Creator<u> {
    t() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public u createFromParcel(Parcel parcel) {
        return u.a(parcel.readInt(), parcel.readInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public u[] newArray(int i) {
        return new u[i];
    }
}
