package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: NavigationView.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements Parcelable.ClassLoaderCreator<NavigationView.b> {
    c() {
    }

    @Override // android.os.Parcelable.Creator
    public NavigationView.b[] newArray(int i) {
        return new NavigationView.b[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public NavigationView.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new NavigationView.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public NavigationView.b createFromParcel(Parcel parcel) {
        return new NavigationView.b(parcel, null);
    }
}
