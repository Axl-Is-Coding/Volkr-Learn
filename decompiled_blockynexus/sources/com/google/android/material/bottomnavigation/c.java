package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;

/* JADX INFO: compiled from: BottomNavigationPresenter.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements Parcelable.Creator<BottomNavigationPresenter.a> {
    c() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BottomNavigationPresenter.a createFromParcel(Parcel parcel) {
        return new BottomNavigationPresenter.a(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BottomNavigationPresenter.a[] newArray(int i) {
        return new BottomNavigationPresenter.a[i];
    }
}
