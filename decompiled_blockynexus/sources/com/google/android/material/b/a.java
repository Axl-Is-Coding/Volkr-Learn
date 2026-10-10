package com.google.android.material.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.b.b;

/* JADX INFO: compiled from: BadgeDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements Parcelable.Creator<b.a> {
    a() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public b.a createFromParcel(Parcel parcel) {
        return new b.a(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public b.a[] newArray(int i) {
        return new b.a[i];
    }
}
