package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: TextInputLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class F implements Parcelable.ClassLoaderCreator<TextInputLayout.d> {
    F() {
    }

    @Override // android.os.Parcelable.Creator
    public TextInputLayout.d[] newArray(int i) {
        return new TextInputLayout.d[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public TextInputLayout.d createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout.d(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public TextInputLayout.d createFromParcel(Parcel parcel) {
        return new TextInputLayout.d(parcel, null);
    }
}
