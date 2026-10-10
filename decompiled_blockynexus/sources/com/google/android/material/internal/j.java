package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: ParcelableSparseArray.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements Parcelable.ClassLoaderCreator<k> {
    j() {
    }

    @Override // android.os.Parcelable.Creator
    public k[] newArray(int i) {
        return new k[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public k createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new k(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public k createFromParcel(Parcel parcel) {
        return new k(parcel, null);
    }
}
