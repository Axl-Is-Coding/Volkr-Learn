package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.b> {
    e() {
    }

    @Override // android.os.Parcelable.Creator
    public BottomSheetBehavior.b[] newArray(int i) {
        return new BottomSheetBehavior.b[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public BottomSheetBehavior.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public BottomSheetBehavior.b createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.b(parcel, (ClassLoader) null);
    }
}
