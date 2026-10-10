package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: FragmentManagerState.java */
/* JADX INFO: loaded from: classes.dex */
class w implements Parcelable.Creator<x> {
    w() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public x createFromParcel(Parcel parcel) {
        return new x(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public x[] newArray(int i) {
        return new x[i];
    }
}
