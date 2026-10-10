package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: Toolbar.java */
/* JADX INFO: loaded from: classes.dex */
class la implements Parcelable.ClassLoaderCreator<Toolbar.b> {
    la() {
    }

    @Override // android.os.Parcelable.Creator
    public Toolbar.b[] newArray(int i) {
        return new Toolbar.b[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public Toolbar.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public Toolbar.b createFromParcel(Parcel parcel) {
        return new Toolbar.b(parcel, null);
    }
}
