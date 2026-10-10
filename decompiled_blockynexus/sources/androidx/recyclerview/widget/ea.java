package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: compiled from: StaggeredGridLayoutManager.java */
/* JADX INFO: loaded from: classes.dex */
class ea implements Parcelable.Creator<StaggeredGridLayoutManager.c> {
    ea() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.c createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.c(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.c[] newArray(int i) {
        return new StaggeredGridLayoutManager.c[i];
    }
}
