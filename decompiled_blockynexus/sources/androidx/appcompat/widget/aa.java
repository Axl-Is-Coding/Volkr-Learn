package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class aa implements Parcelable.ClassLoaderCreator<SearchView.e> {
    aa() {
    }

    @Override // android.os.Parcelable.Creator
    public SearchView.e[] newArray(int i) {
        return new SearchView.e[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public SearchView.e createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SearchView.e(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public SearchView.e createFromParcel(Parcel parcel) {
        return new SearchView.e(parcel, null);
    }
}
