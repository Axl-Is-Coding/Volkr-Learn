package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: CoordinatorLayout.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Parcelable.ClassLoaderCreator<CoordinatorLayout.f> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    public CoordinatorLayout.f[] newArray(int i) {
        return new CoordinatorLayout.f[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public CoordinatorLayout.f createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.f(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public CoordinatorLayout.f createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.f(parcel, null);
    }
}
