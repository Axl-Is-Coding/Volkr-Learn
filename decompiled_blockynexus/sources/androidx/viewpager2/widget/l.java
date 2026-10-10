package androidx.viewpager2.widget;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: ViewPager2.java */
/* JADX INFO: loaded from: classes.dex */
class l implements Parcelable.ClassLoaderCreator<ViewPager2.j> {
    l() {
    }

    @Override // android.os.Parcelable.Creator
    public ViewPager2.j[] newArray(int i) {
        return new ViewPager2.j[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public ViewPager2.j createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 ? new ViewPager2.j(parcel, classLoader) : new ViewPager2.j(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ViewPager2.j createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
