package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomappbar.BottomAppBar;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements Parcelable.ClassLoaderCreator<BottomAppBar.b> {
    k() {
    }

    @Override // android.os.Parcelable.Creator
    public BottomAppBar.b[] newArray(int i) {
        return new BottomAppBar.b[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public BottomAppBar.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomAppBar.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public BottomAppBar.b createFromParcel(Parcel parcel) {
        return new BottomAppBar.b(parcel, null);
    }
}
