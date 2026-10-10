package com.google.android.material.m;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: ExtendableSavedState.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements Parcelable.ClassLoaderCreator<b> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    public b[] newArray(int i) {
        return new b[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new b(parcel, classLoader, null);
    }

    @Override // android.os.Parcelable.Creator
    public b createFromParcel(Parcel parcel) {
        return new b(parcel, null, null);
    }
}
