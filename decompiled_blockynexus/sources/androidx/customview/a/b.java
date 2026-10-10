package androidx.customview.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: AbsSavedState.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Parcelable.ClassLoaderCreator<c> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    public c[] newArray(int i) {
        return new c[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return c.f1310a;
        }
        throw new IllegalStateException("superState must be null");
    }

    @Override // android.os.Parcelable.Creator
    public c createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
