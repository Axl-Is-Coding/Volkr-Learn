package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: compiled from: StaggeredGridLayoutManager.java */
/* JADX INFO: loaded from: classes.dex */
class da implements Parcelable.Creator<StaggeredGridLayoutManager.b.a> {
    da() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.b.a createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.b.a(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.b.a[] newArray(int i) {
        return new StaggeredGridLayoutManager.b.a[i];
    }
}
