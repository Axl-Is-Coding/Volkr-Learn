package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: CheckableImageButton.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Parcelable.ClassLoaderCreator<CheckableImageButton.a> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    public CheckableImageButton.a[] newArray(int i) {
        return new CheckableImageButton.a[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public CheckableImageButton.a createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CheckableImageButton.a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public CheckableImageButton.a createFromParcel(Parcel parcel) {
        return new CheckableImageButton.a(parcel, null);
    }
}
