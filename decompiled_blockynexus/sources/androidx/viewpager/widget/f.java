package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: ViewPager.java */
/* JADX INFO: loaded from: classes.dex */
class f implements Parcelable.ClassLoaderCreator<ViewPager.h> {
    f() {
    }

    @Override // android.os.Parcelable.Creator
    public ViewPager.h[] newArray(int i) {
        return new ViewPager.h[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public ViewPager.h createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.h(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public ViewPager.h createFromParcel(Parcel parcel) {
        return new ViewPager.h(parcel, null);
    }
}
