package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

/* JADX INFO: compiled from: SlidingPaneLayout.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Parcelable.ClassLoaderCreator<SlidingPaneLayout.e> {
    a() {
    }

    @Override // android.os.Parcelable.Creator
    public SlidingPaneLayout.e[] newArray(int i) {
        return new SlidingPaneLayout.e[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public SlidingPaneLayout.e createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SlidingPaneLayout.e(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public SlidingPaneLayout.e createFromParcel(Parcel parcel) {
        return new SlidingPaneLayout.e(parcel, null);
    }
}
