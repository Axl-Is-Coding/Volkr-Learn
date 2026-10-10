package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.C2230b;

/* JADX INFO: renamed from: com.google.android.material.datepicker.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CalendarConstraints.java */
/* JADX INFO: loaded from: classes2.dex */
class C2229a implements Parcelable.Creator<C2230b> {
    C2229a() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C2230b createFromParcel(Parcel parcel) {
        return new C2230b((u) parcel.readParcelable(u.class.getClassLoader()), (u) parcel.readParcelable(u.class.getClassLoader()), (u) parcel.readParcelable(u.class.getClassLoader()), (C2230b.a) parcel.readParcelable(C2230b.a.class.getClassLoader()), null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C2230b[] newArray(int i) {
        return new C2230b[i];
    }
}
