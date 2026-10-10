package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: AppBarLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.b> {
    d() {
    }

    @Override // android.os.Parcelable.Creator
    public AppBarLayout.BaseBehavior.b[] newArray(int i) {
        return new AppBarLayout.BaseBehavior.b[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public AppBarLayout.BaseBehavior.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout.BaseBehavior.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public AppBarLayout.BaseBehavior.b createFromParcel(Parcel parcel) {
        return new AppBarLayout.BaseBehavior.b(parcel, null);
    }
}
