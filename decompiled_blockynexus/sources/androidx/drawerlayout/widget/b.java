package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: DrawerLayout.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Parcelable.ClassLoaderCreator<DrawerLayout.d> {
    b() {
    }

    @Override // android.os.Parcelable.Creator
    public DrawerLayout.d[] newArray(int i) {
        return new DrawerLayout.d[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public DrawerLayout.d createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.d(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public DrawerLayout.d createFromParcel(Parcel parcel) {
        return new DrawerLayout.d(parcel, null);
    }
}
