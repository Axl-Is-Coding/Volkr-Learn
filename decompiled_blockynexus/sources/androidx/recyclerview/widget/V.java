package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class V implements Parcelable.ClassLoaderCreator<RecyclerView.r> {
    V() {
    }

    @Override // android.os.Parcelable.Creator
    public RecyclerView.r[] newArray(int i) {
        return new RecyclerView.r[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public RecyclerView.r createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.r(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public RecyclerView.r createFromParcel(Parcel parcel) {
        return new RecyclerView.r(parcel, null);
    }
}
