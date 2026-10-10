package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* JADX INFO: compiled from: BottomNavigationView.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements Parcelable.ClassLoaderCreator<BottomNavigationView.c> {
    f() {
    }

    @Override // android.os.Parcelable.Creator
    public BottomNavigationView.c[] newArray(int i) {
        return new BottomNavigationView.c[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public BottomNavigationView.c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomNavigationView.c(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public BottomNavigationView.c createFromParcel(Parcel parcel) {
        return new BottomNavigationView.c(parcel, null);
    }
}
