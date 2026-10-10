package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;

/* JADX INFO: renamed from: androidx.fragment.app.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Fragment.java */
/* JADX INFO: loaded from: classes.dex */
class C0331i implements Parcelable.ClassLoaderCreator<Fragment.c> {
    C0331i() {
    }

    @Override // android.os.Parcelable.Creator
    public Fragment.c[] newArray(int i) {
        return new Fragment.c[i];
    }

    @Override // android.os.Parcelable.Creator
    public Fragment.c createFromParcel(Parcel parcel) {
        return new Fragment.c(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public Fragment.c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Fragment.c(parcel, classLoader);
    }
}
