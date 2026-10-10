package com.google.android.material.m;

import a.a.i;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.a.c;

/* JADX INFO: compiled from: ExtendableSavedState.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends c {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<String, Bundle> f13574c;

    /* synthetic */ b(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f13574c + "}";
    }

    @Override // androidx.customview.a.c, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f13574c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f13574c.b(i2);
            bundleArr[i2] = this.f13574c.d(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public b(Parcelable parcelable) {
        super(parcelable);
        this.f13574c = new i<>();
    }

    private b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f13574c = new i<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.f13574c.put(strArr[i2], bundleArr[i2]);
        }
    }
}
